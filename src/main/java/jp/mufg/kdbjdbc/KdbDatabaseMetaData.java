package jp.mufg.kdbjdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.RowIdLifetime;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import jp.mufg.slf4j.FileLogger;
import jp.mufg.kdbjdbc.SqlExprs.TypeContext;

public class KdbDatabaseMetaData implements DatabaseMetaData, TypeContext {
    private static final org.slf4j.Logger logger = FileLogger.getLogger(KdbDatabaseMetaData.class);
    private final Connection conn;

    KdbDatabaseMetaData(Connection conn) {
    	this.conn = conn;
    }

    //implementation for TypeContext
    @Override
    public char getType(String tableName, String columnName) {
        try {
            ColumnAndType c = getColumnAndType(tableName).get(columnName);
            if(c != null)
                return c.type;
            throw new IllegalArgumentException("No type found for " + tableName + "." + columnName);
        }
        catch(SQLException ex) {
            throw new IllegalArgumentException(ex);
        }
    }
    //TypeContext

    @Override
	public String getDatabaseProductName() throws SQLException {
        throw new UnsupportedOperationException("getDatabaseProductName is not support");
	}

	@Override
	public String getDatabaseProductVersion() throws SQLException {
        return "12.3 (Debian 12.3-1.pgdg100+1)";
	}

	@Override
	public String getDriverName() throws SQLException {
        return "PostgreSQL JDBC Driver";
	}

	@Override
	public String getDriverVersion() throws SQLException {
        return "42.2.14";
	}

	@Override
	public ResultSet getTableTypes() throws SQLException {
        logger.info("getTableTypes");
		ResultSetMetaDataImpl meta = new ResultSetMetaDataImpl(
				new ColumnInfo("TABLE_TYPE", "text", false, 1)
		);
		List<Object[]> rows = new ArrayList<Object[]>();
		rows.add(new Object[] {"FOREIGN TABLE"});//1
		rows.add(new Object[] {"INDEX"});//2
		rows.add(new Object[] {"MATERIALIZED VIEW"});//3
		rows.add(new Object[] {"PARTITIONED TABLE"});//4
		rows.add(new Object[] {"SEQUENCE"});//5
		rows.add(new Object[] {"SYSTEM INDEX"});//6
		rows.add(new Object[] {"SYSTEM TABLE"});//7
		rows.add(new Object[] {"SYSTEM TOAST INDEX"});//8
		rows.add(new Object[] {"SYSTEM TOAST TABLE"});//8
		rows.add(new Object[] {"SYSTEM VIEW"});//8
		rows.add(new Object[] {"TABLE"});//8
		rows.add(new Object[] {"TEMPORARY INDEX"});//8
		rows.add(new Object[] {"TEMPORARY SEQUENCE"});//8
		rows.add(new Object[] {"TEMPORARY TABLE"});//8
		rows.add(new Object[] {"TEMPORARY VIEW"});//8
		rows.add(new Object[] {"TYPE"});//8
		rows.add(new Object[] {"VIEW"});//8
		return new ResultSetImpl(meta, rows);
	}
	
	/**
     * See https://docs.oracle.com/javase/7/docs/api/java/sql/DatabaseMetaData.html
     */
	@Override
	public ResultSet getTables(final String catalog, final String schemaPattern, final String tableNamePattern, final String[] types)
			throws SQLException {                
		ResultSetMetaDataImpl meta = new ResultSetMetaDataImpl(
				new ColumnInfo("table_cat"  , "text", true , 1),//1
				new ColumnInfo("table_schem", "name", false, 2),//2
				new ColumnInfo("table_name" , "name", false, 3),//3
				new ColumnInfo("table_type"	, "text", true , 4),//4
				new ColumnInfo("remarks"	, "text", true , 5),//5
				new ColumnInfo("type_cat"	, "text", true , 6),//6
				new ColumnInfo("type_schem"	, "text", true , 7),//7
				new ColumnInfo("type_name"	, "text", true , 8),//8
				new ColumnInfo("self_referencing_col_name"	, "text", true, 9),//9
				new ColumnInfo("ref_generation"	, "text", true, 10)//10
        );
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("q) flip ( `table_name`dummy ! (tables[]; tables[] ) )");
        List<Object[]> rows = new ArrayList<Object[]>();
        while(rs.next()) {
            String tblname = rs.getString(1);
                                //1table_cat 2table_schem 3table_name 4table_type  5remarks  6type_cat   7type_schem  8type_name  9selfref 10refgen
            rows.add(new Object[] {  null     , "public"  , tblname   , "TABLE"    , null    , ""        , ""         , ""         , ""     , ""   });
        }
		return new ResultSetImpl(meta, rows);
    }
    
    public static class ColumnAndType {
        public final String name;
        public final char type;

        ColumnAndType(String name, char type) {
            this.name = name;
            this.type = type;
        }
    }

    private final Map<String, LinkedHashMap<String, ColumnAndType>> coltypecache = new HashMap<String, LinkedHashMap<String, ColumnAndType>>();
    public LinkedHashMap<String, ColumnAndType> getColumnAndType(String table) throws SQLException {
        LinkedHashMap<String, ColumnAndType> cols = coltypecache.get(table);
        if(cols != null)
            return cols;
        String q = "q)flip (`column_name`column_type)!(cols " + table + "; (value meta " + table + ")[;`t])";
        logger.info("getColumnAndType..." + q);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(q);
        cols = new LinkedHashMap<String, ColumnAndType>();
        while(rs.next()) {
            String colname = rs.getString(1);
            Character ctypeobj = (Character) rs.getObject(2);
            logger.info("column->coltype:" + colname + "->" + ctypeobj + ":" + (ctypeobj == null ? "null" : ctypeobj.getClass().getSimpleName()));
            char ctype = ctypeobj == null ? ' ' : ((char) ctypeobj);
            cols.put(colname, new ColumnAndType(colname, ctype));
        }
        rs.close();
        stmt.close();
        coltypecache.put(table, cols);
        return cols;
    }

    @Override
	public ResultSet getColumns(final String catalog, final String schemaPattern, final String tableNamePattern, final String columnNamePattern) throws SQLException {
		ResultSetMetaDataImpl meta = new ResultSetMetaDataImpl(
				new ColumnInfo("TABLE_CAT"		, "text", true , 1), //1
				new ColumnInfo("TABLE_SCHEM"	, "name", false, 2), //2
				new ColumnInfo("TABLE_NAME" 	, "name", false, 3),//3
				new ColumnInfo("COLUMN_NAME"	, "text", true , 4),//4
				new ColumnInfo("DATA_TYPE"		, "text", true , 5),//5
				new ColumnInfo("TYPE_NAME"		, "text", true , 6),//6
				new ColumnInfo("COLUMN_SIZE"	, "int4", true , 7),//7
				new ColumnInfo("BUFFER_LENGTH"	, "int4", true , 8),//8
				new ColumnInfo("DECIMAL_DIGITS"	, "int4", true , 9),//9
				new ColumnInfo("NUM_PREC_RADIX"	, "int4", true ,10),//10
				new ColumnInfo("NULLABLE"		, "int4", true ,11),//11
				new ColumnInfo("REMARKS"		, "text", true ,12),//12
				new ColumnInfo("COLUMN_DEF"		, "text", true ,13),//13
				new ColumnInfo("SQL_DATA_TYPE"	, "text", true ,14),//14
				new ColumnInfo("SQL_DATETIME_SUB"	, "text", true, 15),//15
				new ColumnInfo("CHAR_OCTET_LENGTH"	, "int4", true, 16),//16
				new ColumnInfo("ORDINAL_POSITION"	, "int4", true, 17),//17
				new ColumnInfo("IS_NULLABLE"		, "text", true, 18),//18
				new ColumnInfo("SCOPE_CATALOG"		, "text", true, 19),//19
				new ColumnInfo("SCOPE_SCHEMA"		, "text", true, 20),//20
				new ColumnInfo("SCOPE_TABLE"		, "text", true, 21),//21
				new ColumnInfo("SOURCE_DATA_TYPE"	, "text", true, 22),//22
				new ColumnInfo("IS_AUTO_INCREMENT"	, "text", true, 23),//23
				new ColumnInfo("IS_GENERATED_COLUMN", "text", true, 24) //24
		);
        
        String tbl = tableNamePattern;
		final int MAX = ResultSetMetaDataImpl.MAX;
        List<Object[]> rows = new ArrayList<Object[]>();
        LinkedHashMap<String, ColumnAndType> colnametype = getColumnAndType(tbl);
        int pos = 1;
        for(ColumnAndType e : colnametype.values()) {
            final String colname = e.name;
            final char ctype = e.type;

            //default
            String typename = "text";
            int colsize = MAX;
            int sqltype = 12;
            int octetlen = MAX;
            switch(ctype) {
                case 'b':
                    typename = "bit";
                    colsize = 10;
                    sqltype = Types.BIT;
                    octetlen = 10;
                    break;
                case 'x':
                    typename = "byte";
                    colsize = 10;
                    sqltype = Types.TINYINT;
                    octetlen = 10;
                    break;
                case 'h':
                    typename = "short";
                    colsize = 10;
                    sqltype = Types.SMALLINT;
                    octetlen = 10;
                    break;
                case 'i': //int
                    typename    = "int4";
                    colsize = 10;
                    sqltype = Types.INTEGER;
                    octetlen = 10;
                    break;
                case 'j':  
                    typename = "long";
                    colsize = 10;
                    sqltype = Types.BIGINT;
                    octetlen = 10;
                    break;
                case 'e': //real
                    typename    = "real";
                    colsize = 10;
                    sqltype = Types.REAL;
                    octetlen = 10;
                    break;
                case 'f': //float
                    typename    = "float";
                    colsize = 10;
                    sqltype = Types.FLOAT;
                    octetlen = 10;
                    break;
                case 'p': //timestamp
                    typename    = "timestamp";
                    colsize = 10;
                    sqltype = Types.TIMESTAMP;
                    octetlen = 10;
                    break;
                case 'd': //date
                    typename    = "date";
                    colsize = 10;
                    sqltype = Types.DATE;
                    octetlen = 10;
                    break;
            }
            logger.info("adding column info. column=" + colname + " typename=" + typename);
                                //1TABLE_CAT 2TABLE_SCHEM 3TABLE_NAME 4COLUMN_NAME 5DATA_TYPE 6TYPE_NAME  7COLUMN_SIZE  8BUF   9 DECIMAL  10 RADIX  11 NULLABLE  12 REMARKS 13COLUMN_DEF  14SQL_DATA_TYPE  15SQL_DATETIME_SUB  16 CHAR_OCTET_LEN 17 ORDINAL POS  18 IS_NULLABLE 19 SCOPE_CATALOG  20 SCOPE_SCHEMA  21 SCOPE_TABLE  22 SOURCE_DATA_TYPE 23 IS_Autoinc  24 IS_gen
            rows.add(new Object[] {  null     , "public"  , tbl      , colname    , sqltype , typename     , colsize   , null , 0         , 10      , 1           , null     , null        , null           , null              , octetlen        , pos++        , "YES"         , null            , null           , null         , null                , "NO"        , "" });
//          rows.add(new Object[] {  null     , "public"  , "t2"     , "id"       , 4       , "int4"       , 10        , null , 0         , 10      , 1           , null     , null        , null           , null              , 10              , pos++        , "YES"         , null            , null           , null         , null                , "NO"        , "" });
//          rows.add(new Object[] {  null     , "public"  , "t2"     , "name"     , 12      , "text"       , MAX       , null , 0         , 10      , 1           , null     , null        , null           , null              , MAX             , pos++        , "YES"         , null            , null           , null         , null                , "NO"        , "" });
        }
		return new ResultSetImpl(meta, rows);
	}
    
	@Override
	public ResultSet getImportedKeys(String catalog, String schema, String table) throws SQLException {
		ResultSetMetaDataImpl meta = new ResultSetMetaDataImpl(
				new ColumnInfo("pktable_cat"	, "text", true , 1), //1
				new ColumnInfo("pktable_schem"	, "name", false, 2), //2
				new ColumnInfo("pktable_name" 	, "name", false, 3),//3
				new ColumnInfo("pkcolumn_name"	, "name", false, 4),//4
				new ColumnInfo("fktable_cat"	, "text", true , 5),//5
				new ColumnInfo("fktable_schem"	, "name", false, 6),//6
				new ColumnInfo("fktable_name"	, "name", false, 7),//7
				new ColumnInfo("fkcolumn_name"	, "name", false, 8),//8
				new ColumnInfo("key_seq"		, "int4", true , 9),//9
				new ColumnInfo("update_rule"	, "int4", true ,10),//10
				new ColumnInfo("delete_rule"	, "int4", true ,11),//11
				new ColumnInfo("fk_name"		, "name", false,12),//12
				new ColumnInfo("pk_name"		, "name", false,13),//13
				new ColumnInfo("deferrability"	, "int4", true ,14) //14
		);
		return new ResultSetImpl(meta);
	}

	@Override
	public ResultSet getPrimaryKeys(String catalog, String schema, String table) throws SQLException {
		ResultSetMetaDataImpl meta = new ResultSetMetaDataImpl(
				new ColumnInfo("table_cat"     	, "text", true , 1), //1
				new ColumnInfo("table_schem"	, "name", false, 2), //2
				new ColumnInfo("table_name" 	, "name", false, 3),//3
				new ColumnInfo("column_name"	, "name", false, 4),//4
				new ColumnInfo("key_seq"		, "int4", true , 5),//5
				new ColumnInfo("pk_name"		, "name", false, 6)//6
		);
		return new ResultSetImpl(meta);
	}


	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		logger.info("unwrap");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.unwrap is not supported");
		
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		logger.info("isWrapperFor");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.isWrapperFor is not supported");
		
	}




	@Override
	public boolean allProceduresAreCallable() throws SQLException {
		logger.info("allProceduresAreCallable");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.allProceduresAreCallable is not supported");
		
	}




	@Override
	public boolean allTablesAreSelectable() throws SQLException {
		logger.info("allTablesAreSelectable");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.allTablesAreSelectable is not supported");
		
	}

    @Override
	public String getURL() throws SQLException {
		logger.info("getURL");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getURL is not supported");
		
	}

	@Override
	public String getUserName() throws SQLException {
		logger.info("getUserName");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getUserName is not supported");
		
	}

	@Override
	public boolean isReadOnly() throws SQLException {
		logger.info("isReadOnly");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.isReadOnly is not supported");
		
	}

	@Override
	public boolean nullsAreSortedHigh() throws SQLException {
		logger.info("nullsAreSortedHigh");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.nullsAreSortedHigh is not supported");
		
	}

	@Override
	public boolean nullsAreSortedLow() throws SQLException {
		logger.info("nullsAreSortedLow");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.nullsAreSortedLow is not supported");
		
	}

	@Override
	public boolean nullsAreSortedAtStart() throws SQLException {
		logger.info("nullsAreSortedAtStart");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.nullsAreSortedAtStart is not supported");
		
	}

	@Override
	public boolean nullsAreSortedAtEnd() throws SQLException {
		logger.info("nullsAreSortedAtEnd");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.nullsAreSortedAtEnd is not supported");
		
	}

	@Override
	public ResultSet getSchemas() throws SQLException {
        throw new UnsupportedOperationException("getSchemas");
        // return conn.createStatement().executeQuery("q) flip ( `TABLE_SCHEM`TABLE_CATALOG ! ( 1#(enlist `schema1); 1#(enlist `catalog1) ) )");
	}

	@Override
	public ResultSet getCatalogs() throws SQLException {
        // return conn.createStatement().executeQuery("q) flip ( `TABLE_CATALOG`dummy ! ( 1#(enlist `catalog1); 1#(enlist `dummy) ) )");
        throw new UnsupportedOperationException("getCatalogs");
	}

	@Override
	public int getDriverMajorVersion() {
		logger.info("getDriverMajorVersion");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getDriverMajorVersion is not supported");
		
	}

	@Override
	public int getDriverMinorVersion() {
		logger.info("getDriverMinorVersion");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getDriverMinorVersion is not supported");
		
	}

	@Override
	public boolean usesLocalFiles() throws SQLException {
		logger.info("usesLocalFiles");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.usesLocalFiles is not supported");
		
	}

	@Override
	public boolean usesLocalFilePerTable() throws SQLException {
		logger.info("usesLocalFilePerTable");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.usesLocalFilePerTable is not supported");
		
	}

	@Override
	public boolean supportsMixedCaseIdentifiers() throws SQLException {
		logger.info("supportsMixedCaseIdentifiers");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsMixedCaseIdentifiers is not supported");
		
	}

	@Override
	public boolean storesUpperCaseIdentifiers() throws SQLException {
		logger.info("storesUpperCaseIdentifiers");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.storesUpperCaseIdentifiers is not supported");
		
	}

	@Override
	public boolean storesLowerCaseIdentifiers() throws SQLException {
		logger.info("storesLowerCaseIdentifiers");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.storesLowerCaseIdentifiers is not supported");
		
	}

	@Override
	public boolean storesMixedCaseIdentifiers() throws SQLException {
		logger.info("storesMixedCaseIdentifiers");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.storesMixedCaseIdentifiers is not supported");
		
	}

	@Override
	public boolean supportsMixedCaseQuotedIdentifiers() throws SQLException {
		logger.info("supportsMixedCaseQuotedIdentifiers");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsMixedCaseQuotedIdentifiers is not supported");
		
	}

	@Override
	public boolean storesUpperCaseQuotedIdentifiers() throws SQLException {
		logger.info("storesUpperCaseQuotedIdentifiers");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.storesUpperCaseQuotedIdentifiers is not supported");
		
	}

	@Override
	public boolean storesLowerCaseQuotedIdentifiers() throws SQLException {
		logger.info("storesLowerCaseQuotedIdentifiers");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.storesLowerCaseQuotedIdentifiers is not supported");
		
	}

	@Override
	public boolean storesMixedCaseQuotedIdentifiers() throws SQLException {
		logger.info("storesMixedCaseQuotedIdentifiers");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.storesMixedCaseQuotedIdentifiers is not supported");
		
	}

	@Override
	public String getIdentifierQuoteString() throws SQLException {
		logger.info("getIdentifierQuoteString");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getIdentifierQuoteString is not supported");
		
	}

	@Override
	public String getSQLKeywords() throws SQLException {
		logger.info("getSQLKeywords");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getSQLKeywords is not supported");
		
	}

	@Override
	public String getNumericFunctions() throws SQLException {
		logger.info("getNumericFunctions");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getNumericFunctions is not supported");
		
	}

	@Override
	public String getStringFunctions() throws SQLException {
		logger.info("getStringFunctions");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getStringFunctions is not supported");
		
	}

	@Override
	public String getSystemFunctions() throws SQLException {
		logger.info("getSystemFunctions");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getSystemFunctions is not supported");
		
	}

	@Override
	public String getTimeDateFunctions() throws SQLException {
		logger.info("getTimeDateFunctions");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getTimeDateFunctions is not supported");
		
	}

	@Override
	public String getSearchStringEscape() throws SQLException {
		logger.info("getSearchStringEscape");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getSearchStringEscape is not supported");
		
	}

	@Override
	public String getExtraNameCharacters() throws SQLException {
		logger.info("getExtraNameCharacters");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getExtraNameCharacters is not supported");
		
	}

	@Override
	public boolean supportsAlterTableWithAddColumn() throws SQLException {
		logger.info("supportsAlterTableWithAddColumn");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsAlterTableWithAddColumn is not supported");
		
	}

	@Override
	public boolean supportsAlterTableWithDropColumn() throws SQLException {
		logger.info("supportsAlterTableWithDropColumn");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsAlterTableWithDropColumn is not supported");
		
	}

	@Override
	public boolean supportsColumnAliasing() throws SQLException {
		logger.info("supportsColumnAliasing");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsColumnAliasing is not supported");
		
	}

	@Override
	public boolean nullPlusNonNullIsNull() throws SQLException {
		logger.info("nullPlusNonNullIsNull");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.nullPlusNonNullIsNull is not supported");
		
	}

	@Override
	public boolean supportsConvert() throws SQLException {
		logger.info("supportsConvert");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsConvert is not supported");
		
	}

	@Override
	public boolean supportsConvert(int fromType, int toType) throws SQLException {
		logger.info("supportsConvert");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsConvert is not supported");
		
	}

	@Override
	public boolean supportsTableCorrelationNames() throws SQLException {
		logger.info("supportsTableCorrelationNames");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsTableCorrelationNames is not supported");
		
	}

	@Override
	public boolean supportsDifferentTableCorrelationNames() throws SQLException {
		logger.info("supportsDifferentTableCorrelationNames");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsDifferentTableCorrelationNames is not supported");
		
	}

	@Override
	public boolean supportsExpressionsInOrderBy() throws SQLException {
		logger.info("supportsExpressionsInOrderBy");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsExpressionsInOrderBy is not supported");
		
	}

	@Override
	public boolean supportsOrderByUnrelated() throws SQLException {
		logger.info("supportsOrderByUnrelated");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsOrderByUnrelated is not supported");
		
	}

	@Override
	public boolean supportsGroupBy() throws SQLException {
		logger.info("supportsGroupBy");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsGroupBy is not supported");
		
	}

	@Override
	public boolean supportsGroupByUnrelated() throws SQLException {
		logger.info("supportsGroupByUnrelated");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsGroupByUnrelated is not supported");
		
	}

	@Override
	public boolean supportsGroupByBeyondSelect() throws SQLException {
		logger.info("supportsGroupByBeyondSelect");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsGroupByBeyondSelect is not supported");
		
	}

	@Override
	public boolean supportsLikeEscapeClause() throws SQLException {
		logger.info("supportsLikeEscapeClause");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsLikeEscapeClause is not supported");
		
	}

	@Override
	public boolean supportsMultipleResultSets() throws SQLException {
		logger.info("supportsMultipleResultSets");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsMultipleResultSets is not supported");
		
	}

	@Override
	public boolean supportsMultipleTransactions() throws SQLException {
		logger.info("supportsMultipleTransactions");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsMultipleTransactions is not supported");
		
	}

	@Override
	public boolean supportsNonNullableColumns() throws SQLException {
		logger.info("supportsNonNullableColumns");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsNonNullableColumns is not supported");
		
	}

	@Override
	public boolean supportsMinimumSQLGrammar() throws SQLException {
		logger.info("supportsMinimumSQLGrammar");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsMinimumSQLGrammar is not supported");
		
	}

	@Override
	public boolean supportsCoreSQLGrammar() throws SQLException {
		logger.info("supportsCoreSQLGrammar");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsCoreSQLGrammar is not supported");
		
	}

	@Override
	public boolean supportsExtendedSQLGrammar() throws SQLException {
		logger.info("supportsExtendedSQLGrammar");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsExtendedSQLGrammar is not supported");
		
	}

	@Override
	public boolean supportsANSI92EntryLevelSQL() throws SQLException {
		logger.info("supportsANSI92EntryLevelSQL");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsANSI92EntryLevelSQL is not supported");
		
	}

	@Override
	public boolean supportsANSI92IntermediateSQL() throws SQLException {
		logger.info("supportsANSI92IntermediateSQL");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsANSI92IntermediateSQL is not supported");
		
	}

	@Override
	public boolean supportsANSI92FullSQL() throws SQLException {
		logger.info("supportsANSI92FullSQL");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsANSI92FullSQL is not supported");
		
	}

	@Override
	public boolean supportsIntegrityEnhancementFacility() throws SQLException {
		logger.info("supportsIntegrityEnhancementFacility");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsIntegrityEnhancementFacility is not supported");
		
	}

	@Override
	public boolean supportsOuterJoins() throws SQLException {
		logger.info("supportsOuterJoins");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsOuterJoins is not supported");
		
	}

	@Override
	public boolean supportsFullOuterJoins() throws SQLException {
		logger.info("supportsFullOuterJoins");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsFullOuterJoins is not supported");
		
	}

	@Override
	public boolean supportsLimitedOuterJoins() throws SQLException {
		logger.info("supportsLimitedOuterJoins");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsLimitedOuterJoins is not supported");
		
	}

	@Override
	public String getSchemaTerm() throws SQLException {
		logger.info("getSchemaTerm");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getSchemaTerm is not supported");
		
	}

	@Override
	public String getProcedureTerm() throws SQLException {
		logger.info("getProcedureTerm");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getProcedureTerm is not supported");
		
	}

	@Override
	public String getCatalogTerm() throws SQLException {
		logger.info("getCatalogTerm");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getCatalogTerm is not supported");
		
	}

	@Override
	public boolean isCatalogAtStart() throws SQLException {
		logger.info("isCatalogAtStart");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.isCatalogAtStart is not supported");
		
	}

	@Override
	public String getCatalogSeparator() throws SQLException {
		logger.info("getCatalogSeparator");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getCatalogSeparator is not supported");
		
	}

	@Override
	public boolean supportsSchemasInDataManipulation() throws SQLException {
		logger.info("supportsSchemasInDataManipulation");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsSchemasInDataManipulation is not supported");
		
	}

	@Override
	public boolean supportsSchemasInProcedureCalls() throws SQLException {
		logger.info("supportsSchemasInProcedureCalls");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsSchemasInProcedureCalls is not supported");
		
	}

	@Override
	public boolean supportsSchemasInTableDefinitions() throws SQLException {
		logger.info("supportsSchemasInTableDefinitions");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsSchemasInTableDefinitions is not supported");
		
	}

	@Override
	public boolean supportsSchemasInIndexDefinitions() throws SQLException {
		logger.info("supportsSchemasInIndexDefinitions");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsSchemasInIndexDefinitions is not supported");
		
	}

	@Override
	public boolean supportsSchemasInPrivilegeDefinitions() throws SQLException {
		logger.info("supportsSchemasInPrivilegeDefinitions");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsSchemasInPrivilegeDefinitions is not supported");
		
	}

	@Override
	public boolean supportsCatalogsInDataManipulation() throws SQLException {
		logger.info("supportsCatalogsInDataManipulation");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsCatalogsInDataManipulation is not supported");
		
	}

	@Override
	public boolean supportsCatalogsInProcedureCalls() throws SQLException {
		logger.info("supportsCatalogsInProcedureCalls");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsCatalogsInProcedureCalls is not supported");
		
	}

	@Override
	public boolean supportsCatalogsInTableDefinitions() throws SQLException {
		logger.info("supportsCatalogsInTableDefinitions");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsCatalogsInTableDefinitions is not supported");
		
	}

	@Override
	public boolean supportsCatalogsInIndexDefinitions() throws SQLException {
		logger.info("supportsCatalogsInIndexDefinitions");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsCatalogsInIndexDefinitions is not supported");
		
	}

	@Override
	public boolean supportsCatalogsInPrivilegeDefinitions() throws SQLException {
		logger.info("supportsCatalogsInPrivilegeDefinitions");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsCatalogsInPrivilegeDefinitions is not supported");
		
	}

	@Override
	public boolean supportsPositionedDelete() throws SQLException {
		logger.info("supportsPositionedDelete");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsPositionedDelete is not supported");
		
	}

	@Override
	public boolean supportsPositionedUpdate() throws SQLException {
		logger.info("supportsPositionedUpdate");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsPositionedUpdate is not supported");
		
	}

	@Override
	public boolean supportsSelectForUpdate() throws SQLException {
		logger.info("supportsSelectForUpdate");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsSelectForUpdate is not supported");
		
	}

	@Override
	public boolean supportsStoredProcedures() throws SQLException {
		logger.info("supportsStoredProcedures");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsStoredProcedures is not supported");
		
	}

	@Override
	public boolean supportsSubqueriesInComparisons() throws SQLException {
		logger.info("supportsSubqueriesInComparisons");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsSubqueriesInComparisons is not supported");
		
	}

	@Override
	public boolean supportsSubqueriesInExists() throws SQLException {
		logger.info("supportsSubqueriesInExists");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsSubqueriesInExists is not supported");
		
	}

	@Override
	public boolean supportsSubqueriesInIns() throws SQLException {
		logger.info("supportsSubqueriesInIns");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsSubqueriesInIns is not supported");
		
	}

	@Override
	public boolean supportsSubqueriesInQuantifieds() throws SQLException {
		logger.info("supportsSubqueriesInQuantifieds");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsSubqueriesInQuantifieds is not supported");
		
	}

	@Override
	public boolean supportsCorrelatedSubqueries() throws SQLException {
		logger.info("supportsCorrelatedSubqueries");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsCorrelatedSubqueries is not supported");
		
	}

	@Override
	public boolean supportsUnion() throws SQLException {
		logger.info("supportsUnion");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsUnion is not supported");
		
	}

	@Override
	public boolean supportsUnionAll() throws SQLException {
		logger.info("supportsUnionAll");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsUnionAll is not supported");
		
	}

	@Override
	public boolean supportsOpenCursorsAcrossCommit() throws SQLException {
		logger.info("supportsOpenCursorsAcrossCommit");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsOpenCursorsAcrossCommit is not supported");
		
	}

	@Override
	public boolean supportsOpenCursorsAcrossRollback() throws SQLException {
		logger.info("supportsOpenCursorsAcrossRollback");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsOpenCursorsAcrossRollback is not supported");
		
	}

	@Override
	public boolean supportsOpenStatementsAcrossCommit() throws SQLException {
		logger.info("supportsOpenStatementsAcrossCommit");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsOpenStatementsAcrossCommit is not supported");
		
	}

	@Override
	public boolean supportsOpenStatementsAcrossRollback() throws SQLException {
		logger.info("supportsOpenStatementsAcrossRollback");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsOpenStatementsAcrossRollback is not supported");
		
	}

	@Override
	public int getMaxBinaryLiteralLength() throws SQLException {
		logger.info("getMaxBinaryLiteralLength");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getMaxBinaryLiteralLength is not supported");
		
	}

	@Override
	public int getMaxCharLiteralLength() throws SQLException {
		logger.info("getMaxCharLiteralLength");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getMaxCharLiteralLength is not supported");
		
	}

	@Override
	public int getMaxColumnNameLength() throws SQLException {
		logger.info("getMaxColumnNameLength");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getMaxColumnNameLength is not supported");
		
	}

	@Override
	public int getMaxColumnsInGroupBy() throws SQLException {
		logger.info("getMaxColumnsInGroupBy");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getMaxColumnsInGroupBy is not supported");
		
	}

	@Override
	public int getMaxColumnsInIndex() throws SQLException {
		logger.info("getMaxColumnsInIndex");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getMaxColumnsInIndex is not supported");
		
	}

	@Override
	public int getMaxColumnsInOrderBy() throws SQLException {
		logger.info("getMaxColumnsInOrderBy");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getMaxColumnsInOrderBy is not supported");
		
	}

	@Override
	public int getMaxColumnsInSelect() throws SQLException {
		logger.info("getMaxColumnsInSelect");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getMaxColumnsInSelect is not supported");
		
	}

	@Override
	public int getMaxColumnsInTable() throws SQLException {
		logger.info("getMaxColumnsInTable");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getMaxColumnsInTable is not supported");
		
	}

	@Override
	public int getMaxConnections() throws SQLException {
		logger.info("getMaxConnections");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getMaxConnections is not supported");
		
	}

	@Override
	public int getMaxCursorNameLength() throws SQLException {
		logger.info("getMaxCursorNameLength");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getMaxCursorNameLength is not supported");
		
	}

	@Override
	public int getMaxIndexLength() throws SQLException {
		logger.info("getMaxIndexLength");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getMaxIndexLength is not supported");
		
	}

	@Override
	public int getMaxSchemaNameLength() throws SQLException {
		logger.info("getMaxSchemaNameLength");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getMaxSchemaNameLength is not supported");
		
	}

	@Override
	public int getMaxProcedureNameLength() throws SQLException {
		logger.info("getMaxProcedureNameLength");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getMaxProcedureNameLength is not supported");
		
	}

	@Override
	public int getMaxCatalogNameLength() throws SQLException {
		logger.info("getMaxCatalogNameLength");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getMaxCatalogNameLength is not supported");
		
	}

	@Override
	public int getMaxRowSize() throws SQLException {
		logger.info("getMaxRowSize");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getMaxRowSize is not supported");
		
	}

	@Override
	public boolean doesMaxRowSizeIncludeBlobs() throws SQLException {
		logger.info("doesMaxRowSizeIncludeBlobs");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.doesMaxRowSizeIncludeBlobs is not supported");
		
	}

	@Override
	public int getMaxStatementLength() throws SQLException {
		logger.info("getMaxStatementLength");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getMaxStatementLength is not supported");
		
	}

	@Override
	public int getMaxStatements() throws SQLException {
		logger.info("getMaxStatements");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getMaxStatements is not supported");
		
	}

	@Override
	public int getMaxTableNameLength() throws SQLException {
		logger.info("getMaxTableNameLength");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getMaxTableNameLength is not supported");
		
	}

	@Override
	public int getMaxTablesInSelect() throws SQLException {
		logger.info("getMaxTablesInSelect");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getMaxTablesInSelect is not supported");
		
	}

	@Override
	public int getMaxUserNameLength() throws SQLException {
		logger.info("getMaxUserNameLength");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getMaxUserNameLength is not supported");
		
	}

	@Override
	public int getDefaultTransactionIsolation() throws SQLException {
		logger.info("getDefaultTransactionIsolation");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getDefaultTransactionIsolation is not supported");
		
	}

	@Override
	public boolean supportsTransactions() throws SQLException {
		logger.info("supportsTransactions");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsTransactions is not supported");
		
	}

	@Override
	public boolean supportsTransactionIsolationLevel(int level) throws SQLException {
		logger.info("supportsTransactionIsolationLevel");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsTransactionIsolationLevel is not supported");
		
	}

	@Override
	public boolean supportsDataDefinitionAndDataManipulationTransactions() throws SQLException {
		logger.info("supportsDataDefinitionAndDataManipulationTransactions");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsDataDefinitionAndDataManipulationTransactions is not supported");
		
	}

	@Override
	public boolean supportsDataManipulationTransactionsOnly() throws SQLException {
		logger.info("supportsDataManipulationTransactionsOnly");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsDataManipulationTransactionsOnly is not supported");
		
	}

	@Override
	public boolean dataDefinitionCausesTransactionCommit() throws SQLException {
		logger.info("dataDefinitionCausesTransactionCommit");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.dataDefinitionCausesTransactionCommit is not supported");
		
	}

	@Override
	public boolean dataDefinitionIgnoredInTransactions() throws SQLException {
		logger.info("dataDefinitionIgnoredInTransactions");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.dataDefinitionIgnoredInTransactions is not supported");
		
	}

	@Override
	public ResultSet getProcedures(String catalog, String schemaPattern, String procedureNamePattern)
			throws SQLException {
		logger.info("getProcedures");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getProcedures is not supported");
		
	}

	@Override
	public ResultSet getProcedureColumns(String catalog, String schemaPattern, String procedureNamePattern,
			String columnNamePattern) throws SQLException {
		logger.info("getProcedureColumns");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getProcedureColumns is not supported");
		
	}

	@Override
	public ResultSet getColumnPrivileges(String catalog, String schema, String table, String columnNamePattern)
			throws SQLException {
		logger.info("getColumnPrivileges");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getColumnPrivileges is not supported");
		
	}

	@Override
	public ResultSet getTablePrivileges(String catalog, String schemaPattern, String tableNamePattern)
			throws SQLException {
		logger.info("getTablePrivileges");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getTablePrivileges is not supported");
		
	}

	@Override
	public ResultSet getBestRowIdentifier(String catalog, String schema, String table, int scope, boolean nullable)
			throws SQLException {
		logger.info("getBestRowIdentifier");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getBestRowIdentifier is not supported");
		
	}

	@Override
	public ResultSet getVersionColumns(String catalog, String schema, String table) throws SQLException {
		logger.info("getVersionColumns");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getVersionColumns is not supported");
		
	}

	@Override
	public ResultSet getExportedKeys(String catalog, String schema, String table) throws SQLException {
		logger.info("getExportedKeys");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getExportedKeys is not supported");
		
	}

	@Override
	public ResultSet getCrossReference(String parentCatalog, String parentSchema, String parentTable,
			String foreignCatalog, String foreignSchema, String foreignTable) throws SQLException {
		logger.info("getCrossReference");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getCrossReference is not supported");
		
	}

	@Override
	public ResultSet getTypeInfo() throws SQLException {
		logger.info("getTypeInfo");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getTypeInfo is not supported");
		
	}

	@Override
	public ResultSet getIndexInfo(String catalog, String schema, String table, boolean unique, boolean approximate)
			throws SQLException {
		logger.info("getIndexInfo");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getIndexInfo is not supported");
		
	}

	@Override
	public boolean supportsResultSetType(int type) throws SQLException {
		logger.info("supportsResultSetType");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsResultSetType is not supported");
		
	}

	@Override
	public boolean supportsResultSetConcurrency(int type, int concurrency) throws SQLException {
		logger.info("supportsResultSetConcurrency");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsResultSetConcurrency is not supported");
		
	}

	@Override
	public boolean ownUpdatesAreVisible(int type) throws SQLException {
		logger.info("ownUpdatesAreVisible");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.ownUpdatesAreVisible is not supported");
		
	}

	@Override
	public boolean ownDeletesAreVisible(int type) throws SQLException {
		logger.info("ownDeletesAreVisible");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.ownDeletesAreVisible is not supported");
		
	}

	@Override
	public boolean ownInsertsAreVisible(int type) throws SQLException {
		logger.info("ownInsertsAreVisible");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.ownInsertsAreVisible is not supported");
		
	}

	@Override
	public boolean othersUpdatesAreVisible(int type) throws SQLException {
		logger.info("othersUpdatesAreVisible");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.othersUpdatesAreVisible is not supported");
		
	}

	@Override
	public boolean othersDeletesAreVisible(int type) throws SQLException {
		logger.info("othersDeletesAreVisible");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.othersDeletesAreVisible is not supported");
		
	}

	@Override
	public boolean othersInsertsAreVisible(int type) throws SQLException {
		logger.info("othersInsertsAreVisible");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.othersInsertsAreVisible is not supported");
		
	}

	@Override
	public boolean updatesAreDetected(int type) throws SQLException {
		logger.info("updatesAreDetected");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.updatesAreDetected is not supported");
		
	}

	@Override
	public boolean deletesAreDetected(int type) throws SQLException {
		logger.info("deletesAreDetected");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.deletesAreDetected is not supported");
		
	}

	@Override
	public boolean insertsAreDetected(int type) throws SQLException {
		logger.info("insertsAreDetected");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.insertsAreDetected is not supported");
		
	}

	@Override
	public boolean supportsBatchUpdates() throws SQLException {
		logger.info("supportsBatchUpdates");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsBatchUpdates is not supported");
		
	}

	@Override
	public ResultSet getUDTs(String catalog, String schemaPattern, String typeNamePattern, int[] types)
			throws SQLException {
		logger.info("getUDTs");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getUDTs is not supported");
		
	}

	@Override
	public Connection getConnection() throws SQLException {
		logger.info("getConnection");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getConnection is not supported");
		
	}

	@Override
	public boolean supportsSavepoints() throws SQLException {
		logger.info("supportsSavepoints");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsSavepoints is not supported");
		
	}

	@Override
	public boolean supportsNamedParameters() throws SQLException {
		logger.info("supportsNamedParameters");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsNamedParameters is not supported");
		
	}

	@Override
	public boolean supportsMultipleOpenResults() throws SQLException {
		logger.info("supportsMultipleOpenResults");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsMultipleOpenResults is not supported");
		
	}

	@Override
	public boolean supportsGetGeneratedKeys() throws SQLException {
		logger.info("supportsGetGeneratedKeys");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsGetGeneratedKeys is not supported");
		
	}

	@Override
	public ResultSet getSuperTypes(String catalog, String schemaPattern, String typeNamePattern) throws SQLException {
		logger.info("getSuperTypes");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getSuperTypes is not supported");
		
	}

	@Override
	public ResultSet getSuperTables(String catalog, String schemaPattern, String tableNamePattern) throws SQLException {
		logger.info("getSuperTables");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getSuperTables is not supported");
		
	}

	@Override
	public ResultSet getAttributes(String catalog, String schemaPattern, String typeNamePattern,
			String attributeNamePattern) throws SQLException {
		logger.info("getAttributes");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getAttributes is not supported");
		
	}

	@Override
	public boolean supportsResultSetHoldability(int holdability) throws SQLException {
		logger.info("supportsResultSetHoldability");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsResultSetHoldability is not supported");
		
	}

	@Override
	public int getResultSetHoldability() throws SQLException {
		logger.info("getResultSetHoldability");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getResultSetHoldability is not supported");
		
	}

	@Override
	public int getDatabaseMajorVersion() throws SQLException {
		logger.info("getDatabaseMajorVersion");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getDatabaseMajorVersion is not supported");
		
	}

	@Override
	public int getDatabaseMinorVersion() throws SQLException {
		logger.info("getDatabaseMinorVersion");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getDatabaseMinorVersion is not supported");
		
	}

	@Override
	public int getJDBCMajorVersion() throws SQLException {
		logger.info("getJDBCMajorVersion");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getJDBCMajorVersion is not supported");
		
	}

	@Override
	public int getJDBCMinorVersion() throws SQLException {
		logger.info("getJDBCMinorVersion");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getJDBCMinorVersion is not supported");
		
	}

	@Override
	public int getSQLStateType() throws SQLException {
		logger.info("getSQLStateType");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getSQLStateType is not supported");
		
	}

	@Override
	public boolean locatorsUpdateCopy() throws SQLException {
		logger.info("locatorsUpdateCopy");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.locatorsUpdateCopy is not supported");
		
	}

	@Override
	public boolean supportsStatementPooling() throws SQLException {
		logger.info("supportsStatementPooling");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsStatementPooling is not supported");
		
	}

	@Override
	public RowIdLifetime getRowIdLifetime() throws SQLException {
		logger.info("getRowIdLifetime");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getRowIdLifetime is not supported");
		
	}

	@Override
	public ResultSet getSchemas(String catalog, String schemaPattern) throws SQLException {
		logger.info("getSchemas");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getSchemas is not supported");
		
	}

	@Override
	public boolean supportsStoredFunctionsUsingCallSyntax() throws SQLException {
		logger.info("supportsStoredFunctionsUsingCallSyntax");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.supportsStoredFunctionsUsingCallSyntax is not supported");
		
	}

	@Override
	public boolean autoCommitFailureClosesAllResultSets() throws SQLException {
		logger.info("autoCommitFailureClosesAllResultSets");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.autoCommitFailureClosesAllResultSets is not supported");
		
	}

	@Override
	public ResultSet getClientInfoProperties() throws SQLException {
		logger.info("getClientInfoProperties");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getClientInfoProperties is not supported");
		
	}

	@Override
	public ResultSet getFunctions(String catalog, String schemaPattern, String functionNamePattern)
			throws SQLException {
		logger.info("getFunctions");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getFunctions is not supported");
		
	}

	@Override
	public ResultSet getFunctionColumns(String catalog, String schemaPattern, String functionNamePattern,
			String columnNamePattern) throws SQLException {
		logger.info("getFunctionColumns");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getFunctionColumns is not supported");
		
	}

	@Override
	public ResultSet getPseudoColumns(String catalog, String schemaPattern, String tableNamePattern,
			String columnNamePattern) throws SQLException {
		logger.info("getPseudoColumns");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.getPseudoColumns is not supported");
		
	}

	@Override
	public boolean generatedKeyAlwaysReturned() throws SQLException {
		logger.info("generatedKeyAlwaysReturned");
		throw new UnsupportedOperationException("KdbDatabaseMetaData.generatedKeyAlwaysReturned is not supported");
		
	}
}