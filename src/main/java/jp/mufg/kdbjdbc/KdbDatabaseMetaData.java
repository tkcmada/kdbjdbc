package jp.mufg.kdbjdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.RowIdLifetime;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;

import org.slf4j.LoggerFactory;

public class KdbDatabaseMetaData implements DatabaseMetaData {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(KdbDatabaseMetaData.class);
    private final Connection conn;
    private final String user;
    private final String url;

    KdbDatabaseMetaData(final Connection conn) {
        this.conn = conn;
        this.url = null;
        this.user = null;
    }

	@Override
	public <T> T unwrap(final Class<T> iface) throws SQLException {
        throw new UnsupportedOperationException("not support");
	}

	@Override
	public boolean isWrapperFor(final Class<?> iface) throws SQLException {
        throw new UnsupportedOperationException("not support");
    }

	@Override
	public boolean allProceduresAreCallable() throws SQLException {
        return false;
	}

	@Override
	public boolean allTablesAreSelectable() throws SQLException {
		return true;
	}

	@Override
	public String getURL() throws SQLException {
        return url;
    }

	@Override
	public String getUserName() throws SQLException {
        return user;
	}

	@Override
	public boolean isReadOnly() throws SQLException {
        return true;
	}

	@Override
	public boolean nullsAreSortedHigh() throws SQLException {
		return false;
	}

	@Override
	public boolean nullsAreSortedLow() throws SQLException {
        return true;
	}

	@Override
	public boolean nullsAreSortedAtStart() throws SQLException {
		return false;
	}

	@Override
	public boolean nullsAreSortedAtEnd() throws SQLException {
        return true;
	}

	@Override
	public String getDatabaseProductName() throws SQLException {
        return "kdb";
	}

	@Override
	public String getDatabaseProductVersion() throws SQLException {
        return "unknown";
	}

	@Override
	public String getDriverName() throws SQLException {
        return "kdbjdbc";
	}

	@Override
	public String getDriverVersion() throws SQLException {
        return getDriverMajorVersion() + "." + getDriverMinorVersion();
	}

	@Override
	public int getDriverMajorVersion() {
		return 0;
	}

	@Override
	public int getDriverMinorVersion() {
		return 1;
	}

	@Override
	public boolean usesLocalFiles() throws SQLException {
		return false;
	}

	@Override
	public boolean usesLocalFilePerTable() throws SQLException {
		return false;
	}

	@Override
	public boolean supportsMixedCaseIdentifiers() throws SQLException {
		return true;
	}

	@Override
	public boolean storesUpperCaseIdentifiers() throws SQLException {
		return false;
	}

	@Override
	public boolean storesLowerCaseIdentifiers() throws SQLException {
		return false;
	}

	@Override
	public boolean storesMixedCaseIdentifiers() throws SQLException {
		return true;
	}

	@Override
	public boolean supportsMixedCaseQuotedIdentifiers() throws SQLException {
		return true;
	}

	@Override
	public boolean storesUpperCaseQuotedIdentifiers() throws SQLException {
		return false;
	}

	@Override
	public boolean storesLowerCaseQuotedIdentifiers() throws SQLException {
		return false;
	}

	@Override
	public boolean storesMixedCaseQuotedIdentifiers() throws SQLException {
		return true;
	}

	@Override
	public String getIdentifierQuoteString() throws SQLException {
		return "'";
	}

	@Override
	public String getSQLKeywords() throws SQLException {
		return "select from where in";
	}

	@Override
	public String getNumericFunctions() throws SQLException {
        throw new UnsupportedOperationException("not support");
	}

	@Override
	public String getStringFunctions() throws SQLException {
        throw new UnsupportedOperationException("not support");
	}

	@Override
	public String getSystemFunctions() throws SQLException {
        throw new UnsupportedOperationException("not support");
	}

	@Override
	public String getTimeDateFunctions() throws SQLException {
        throw new UnsupportedOperationException("not support");
	}

	@Override
	public String getSearchStringEscape() throws SQLException {
        throw new UnsupportedOperationException("not support");
	}

	@Override
	public String getExtraNameCharacters() throws SQLException {
        throw new UnsupportedOperationException("not support");
	}

	@Override
	public boolean supportsAlterTableWithAddColumn() throws SQLException {
        throw new UnsupportedOperationException("not support");
	}

	@Override
	public boolean supportsAlterTableWithDropColumn() throws SQLException {
        throw new UnsupportedOperationException("not support");
	}

	@Override
	public boolean supportsColumnAliasing() throws SQLException {
        throw new UnsupportedOperationException("not support");
	}

	@Override
	public boolean nullPlusNonNullIsNull() throws SQLException {
        throw new UnsupportedOperationException("not support");
	}

	@Override
	public boolean supportsConvert() throws SQLException {
        throw new UnsupportedOperationException("not support");
	}

	@Override
	public boolean supportsConvert(final int fromType, final int toType) throws SQLException {
        throw new UnsupportedOperationException("not support");
	}

	@Override
	public boolean supportsTableCorrelationNames() throws SQLException {
        throw new UnsupportedOperationException("not support");
	}

	@Override
	public boolean supportsDifferentTableCorrelationNames() throws SQLException {
        throw new UnsupportedOperationException("not support");
	}

	@Override
	public boolean supportsExpressionsInOrderBy() throws SQLException {
        throw new UnsupportedOperationException("not support");
	}

	@Override
	public boolean supportsOrderByUnrelated() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsGroupBy() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsGroupByUnrelated() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsGroupByBeyondSelect() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsLikeEscapeClause() throws SQLException {
        throw new UnsupportedOperationException("not support");
	}

	@Override
	public boolean supportsMultipleResultSets() throws SQLException {
        throw new UnsupportedOperationException("not support");
	}

	@Override
	public boolean supportsMultipleTransactions() throws SQLException {
        throw new UnsupportedOperationException("not support");
	}

	@Override
	public boolean supportsNonNullableColumns() throws SQLException {
        throw new UnsupportedOperationException("not support");
	}

	@Override
	public boolean supportsMinimumSQLGrammar() throws SQLException {
        throw new UnsupportedOperationException("not support");
	}

	@Override
	public boolean supportsCoreSQLGrammar() throws SQLException {
        throw new UnsupportedOperationException("not support");
	}

	@Override
	public boolean supportsExtendedSQLGrammar() throws SQLException {
        throw new UnsupportedOperationException("not support");
	}

	@Override
	public boolean supportsANSI92EntryLevelSQL() throws SQLException {
        throw new UnsupportedOperationException("not support");
	}

	@Override
	public boolean supportsANSI92IntermediateSQL() throws SQLException {
        throw new UnsupportedOperationException("not support");
	}

	@Override
	public boolean supportsANSI92FullSQL() throws SQLException {
        throw new UnsupportedOperationException("not support");
	}

	@Override
	public boolean supportsIntegrityEnhancementFacility() throws SQLException {
        throw new UnsupportedOperationException("not support");
	}

	@Override
	public boolean supportsOuterJoins() throws SQLException {
        throw new UnsupportedOperationException("not support");
	}

	@Override
	public boolean supportsFullOuterJoins() throws SQLException {
        throw new UnsupportedOperationException("not support");
	}

	@Override
	public boolean supportsLimitedOuterJoins() throws SQLException {
        throw new UnsupportedOperationException("not support");
	}

	@Override
	public String getSchemaTerm() throws SQLException {
        throw new UnsupportedOperationException("not support");
	}

	@Override
	public String getProcedureTerm() throws SQLException {
        throw new UnsupportedOperationException("not support");
	}

	@Override
	public String getCatalogTerm() throws SQLException {
        throw new UnsupportedOperationException("not support");
	}

	@Override
	public boolean isCatalogAtStart() throws SQLException {
        throw new UnsupportedOperationException("not support");
	}

	@Override
	public String getCatalogSeparator() throws SQLException {
        throw new UnsupportedOperationException("not support");
	}

	@Override
	public boolean supportsSchemasInDataManipulation() throws SQLException {
        throw new UnsupportedOperationException("not support");
	}

	@Override
	public boolean supportsSchemasInProcedureCalls() throws SQLException {
        throw new UnsupportedOperationException("not support");
	}

	@Override
	public boolean supportsSchemasInTableDefinitions() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsSchemasInIndexDefinitions() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsSchemasInPrivilegeDefinitions() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsCatalogsInDataManipulation() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsCatalogsInProcedureCalls() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsCatalogsInTableDefinitions() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsCatalogsInIndexDefinitions() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsCatalogsInPrivilegeDefinitions() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsPositionedDelete() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsPositionedUpdate() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsSelectForUpdate() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsStoredProcedures() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsSubqueriesInComparisons() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsSubqueriesInExists() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsSubqueriesInIns() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsSubqueriesInQuantifieds() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsCorrelatedSubqueries() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsUnion() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsUnionAll() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsOpenCursorsAcrossCommit() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsOpenCursorsAcrossRollback() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsOpenStatementsAcrossCommit() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsOpenStatementsAcrossRollback() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getMaxBinaryLiteralLength() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxCharLiteralLength() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxColumnNameLength() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxColumnsInGroupBy() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxColumnsInIndex() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxColumnsInOrderBy() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxColumnsInSelect() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxColumnsInTable() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxConnections() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxCursorNameLength() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxIndexLength() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxSchemaNameLength() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxProcedureNameLength() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxCatalogNameLength() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxRowSize() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean doesMaxRowSizeIncludeBlobs() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getMaxStatementLength() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxStatements() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxTableNameLength() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxTablesInSelect() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxUserNameLength() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getDefaultTransactionIsolation() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean supportsTransactions() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsTransactionIsolationLevel(final int level) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsDataDefinitionAndDataManipulationTransactions() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsDataManipulationTransactionsOnly() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean dataDefinitionCausesTransactionCommit() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean dataDefinitionIgnoredInTransactions() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ResultSet getProcedures(final String catalog, final String schemaPattern, final String procedureNamePattern)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet getProcedureColumns(final String catalog, final String schemaPattern, final String procedureNamePattern,
			final String columnNamePattern) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

    /**
     * See https://docs.oracle.com/javase/7/docs/api/java/sql/DatabaseMetaData.html
     */
	@Override
	public ResultSet getTables(final String catalog, final String schemaPattern, final String tableNamePattern, final String[] types)
			throws SQLException {                
        return conn.createStatement().executeQuery("q) flip ( `TABLE_NAME`TABLE_SCHEM`TABLE_CATALOG`TABLE_TYPE`REMARKS`TYPE_CAT`TYPE_SCHEM`TYPE_NAME`SELF_REFERENCING_COL_NAME`REF_GENERATION ! ( tables[]; (count(tables[]))#(enlist `schema1); (count(tables[]))#(enlist `catalog1); (count(tables[]))#(enlist `TABLE); (count(tables[]))#(enlist `); (count(tables[]))#(enlist `); (count(tables[]))#(enlist `); (count(tables[]))#(enlist `); (count(tables[]))#(enlist `); (count(tables[]))#(enlist `) ) )");
	}

	@Override
	public ResultSet getSchemas() throws SQLException {
        return conn.createStatement().executeQuery("q) flip ( `TABLE_SCHEM`TABLE_CATALOG ! ( 1#(enlist `schema1); 1#(enlist `catalog1) ) )");
	}

	@Override
	public ResultSet getCatalogs() throws SQLException {
        return conn.createStatement().executeQuery("q) flip ( `TABLE_CATALOG`dummy ! ( 1#(enlist `catalog1); 1#(enlist `dummy) ) )");
	}

	@Override
	public ResultSet getTableTypes() throws SQLException {
		throw new UnsupportedOperationException("not support");
	}

    @Override
	public ResultSet getColumns(final String catalog, final String schemaPattern, final String tableNamePattern, final String columnNamePattern) throws SQLException {
        final StringBuilder sql = new StringBuilder();
        sql.append("q) ");
        final ResultSet rs = getTables(catalog, schemaPattern, tableNamePattern, null);
        int i = 0;
        while(rs.next()) {
            if(i > 0)
                sql.append(" union ");
            final String tblname = rs.getString("TABLE_NAME");
            sql.append("flip `TABLE_CAT`TABLE_SCHEM`TABLE_NAME`COLUMN_NAME`COLUMN_TYPE!( (count(cols " + tblname + "))#(enlist `catalog1); (count(cols " + tblname + "))#(enlist `schema1); (count(cols " + tblname + "))#(enlist `" + tblname + "); cols " + tblname + "; (value meta " + tblname + ")[;`t] )");
            i++;
            break;
        }
        rs.close();
        logger.info("getColumns: " + sql);
        return conn.createStatement().executeQuery(sql.toString());
	}

	@Override
	public ResultSet getColumnPrivileges(final String catalog, final String schema, final String table, final String columnNamePattern)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet getTablePrivileges(final String catalog, final String schemaPattern, final String tableNamePattern)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet getBestRowIdentifier(final String catalog, final String schema, final String table, final int scope, final boolean nullable)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet getVersionColumns(final String catalog, final String schema, final String table) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet getPrimaryKeys(final String catalog, final String schema, final String table) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet getImportedKeys(final String catalog, final String schema, final String table) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet getExportedKeys(final String catalog, final String schema, final String table) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet getCrossReference(final String parentCatalog, final String parentSchema, final String parentTable,
			final String foreignCatalog, final String foreignSchema, final String foreignTable) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet getTypeInfo() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet getIndexInfo(final String catalog, final String schema, final String table, final boolean unique, final boolean approximate)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean supportsResultSetType(final int type) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsResultSetConcurrency(final int type, final int concurrency) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ownUpdatesAreVisible(final int type) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ownDeletesAreVisible(final int type) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ownInsertsAreVisible(final int type) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean othersUpdatesAreVisible(final int type) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean othersDeletesAreVisible(final int type) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean othersInsertsAreVisible(final int type) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatesAreDetected(final int type) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletesAreDetected(final int type) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertsAreDetected(final int type) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsBatchUpdates() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ResultSet getUDTs(final String catalog, final String schemaPattern, final String typeNamePattern, final int[] types)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Connection getConnection() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean supportsSavepoints() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsNamedParameters() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsMultipleOpenResults() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsGetGeneratedKeys() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ResultSet getSuperTypes(final String catalog, final String schemaPattern, final String typeNamePattern) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet getSuperTables(final String catalog, final String schemaPattern, final String tableNamePattern) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet getAttributes(final String catalog, final String schemaPattern, final String typeNamePattern,
			final String attributeNamePattern) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean supportsResultSetHoldability(final int holdability) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getResultSetHoldability() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getDatabaseMajorVersion() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getDatabaseMinorVersion() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getJDBCMajorVersion() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getJDBCMinorVersion() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSQLStateType() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean locatorsUpdateCopy() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsStatementPooling() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public RowIdLifetime getRowIdLifetime() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet getSchemas(final String catalog, final String schemaPattern) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean supportsStoredFunctionsUsingCallSyntax() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean autoCommitFailureClosesAllResultSets() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ResultSet getClientInfoProperties() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet getFunctions(final String catalog, final String schemaPattern, final String functionNamePattern)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet getFunctionColumns(final String catalog, final String schemaPattern, final String functionNamePattern,
			final String columnNamePattern) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet getPseudoColumns(final String catalog, final String schemaPattern, final String tableNamePattern,
			final String columnNamePattern) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean generatedKeyAlwaysReturned() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}