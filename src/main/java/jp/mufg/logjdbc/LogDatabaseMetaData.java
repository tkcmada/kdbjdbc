package jp.mufg.logjdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.RowIdLifetime;
import java.sql.SQLException;
import java.util.Arrays;

import org.slf4j.Logger;

import jp.mufg.slf4j.FileLogger;

public class LogDatabaseMetaData implements DatabaseMetaData { logger.info("xxx");
	private static final Logger logger = FileLogger.getLogger(LogDatabaseMetaData.class);
	private final DatabaseMetaData meta;

	public LogDatabaseMetaData(DatabaseMetaData meta) { logger.info("xxx");
		super();
		this.meta = meta;
	}

	public <T> T unwrap(Class<T> iface) throws SQLException { logger.info("xxx");
		logger.info("unwrap");
		return meta.unwrap(iface);
	}

	public boolean isWrapperFor(Class<?> iface) throws SQLException { logger.info("xxx");
		logger.info("isWrapperFor");
		return meta.isWrapperFor(iface);
	}

	public boolean allProceduresAreCallable() throws SQLException { logger.info("xxx");
		logger.info("allProceduresAreCallable");
		return meta.allProceduresAreCallable();
	}

	public boolean allTablesAreSelectable() throws SQLException { logger.info("xxx");
		logger.info("allTablesAreSelectable");
		return meta.allTablesAreSelectable();
	}

	public String getURL() throws SQLException { logger.info("xxx");
		logger.info("getURL");
		return meta.getURL();
	}

	public String getUserName() throws SQLException { logger.info("xxx");
		logger.info("getUserName");
		return meta.getUserName();
	}

	public boolean isReadOnly() throws SQLException { logger.info("xxx");
		logger.info("isReadOnly");
		return meta.isReadOnly();
	}

	public boolean nullsAreSortedHigh() throws SQLException { logger.info("xxx");
		logger.info("nullsAreSortedHigh");
		return meta.nullsAreSortedHigh();
	}

	public boolean nullsAreSortedLow() throws SQLException { logger.info("xxx");
		logger.info("xxx");
		return meta.nullsAreSortedLow();
	}

	public boolean nullsAreSortedAtStart() throws SQLException { logger.info("xxx");
		logger.info("xxx");
		return meta.nullsAreSortedAtStart();
	}

	public boolean nullsAreSortedAtEnd() throws SQLException { logger.info("xxx");
		logger.info("xxx");
		return meta.nullsAreSortedAtEnd();
	}

	public String getDatabaseProductName() throws SQLException { logger.info("xxx");
		logger.info("getDatabaseProductName");
		return meta.getDatabaseProductName();
	}

	public String getDatabaseProductVersion() throws SQLException { logger.info("xxx");
		logger.info("getDatabaseProductVersion");
		return meta.getDatabaseProductVersion();
	}

	public String getDriverName() throws SQLException { logger.info("xxx");
		logger.info("getDriverName");
		return meta.getDriverName();
	}

	public String getDriverVersion() throws SQLException { logger.info("xxx");
		logger.info("getDriverVersion");
		return meta.getDriverVersion();
	}

	public int getDriverMajorVersion() { logger.info("xxx");
		return meta.getDriverMajorVersion();
	}

	public int getDriverMinorVersion() { logger.info("xxx");
		return meta.getDriverMinorVersion();
	}

	public boolean usesLocalFiles() throws SQLException { logger.info("xxx");
		return meta.usesLocalFiles();
	}

	public boolean usesLocalFilePerTable() throws SQLException { logger.info("xxx");
		return meta.usesLocalFilePerTable();
	}

	public boolean supportsMixedCaseIdentifiers() throws SQLException { logger.info("xxx");
		return meta.supportsMixedCaseIdentifiers();
	}

	public boolean storesUpperCaseIdentifiers() throws SQLException { logger.info("xxx");
		return meta.storesUpperCaseIdentifiers();
	}

	public boolean storesLowerCaseIdentifiers() throws SQLException { logger.info("xxx");
		return meta.storesLowerCaseIdentifiers();
	}

	public boolean storesMixedCaseIdentifiers() throws SQLException { logger.info("xxx");
		return meta.storesMixedCaseIdentifiers();
	}

	public boolean supportsMixedCaseQuotedIdentifiers() throws SQLException { logger.info("xxx");
		return meta.supportsMixedCaseQuotedIdentifiers();
	}

	public boolean storesUpperCaseQuotedIdentifiers() throws SQLException { logger.info("xxx");
		return meta.storesUpperCaseQuotedIdentifiers();
	}

	public boolean storesLowerCaseQuotedIdentifiers() throws SQLException { logger.info("xxx");
		return meta.storesLowerCaseQuotedIdentifiers();
	}

	public boolean storesMixedCaseQuotedIdentifiers() throws SQLException { logger.info("xxx");
		return meta.storesMixedCaseQuotedIdentifiers();
	}

	public String getIdentifierQuoteString() throws SQLException { logger.info("xxx");
		return meta.getIdentifierQuoteString();
	}

	public String getSQLKeywords() throws SQLException { logger.info("xxx");
		return meta.getSQLKeywords();
	}

	public String getNumericFunctions() throws SQLException { logger.info("xxx");
		return meta.getNumericFunctions();
	}

	public String getStringFunctions() throws SQLException { logger.info("xxx");
		return meta.getStringFunctions();
	}

	public String getSystemFunctions() throws SQLException { logger.info("xxx");
		return meta.getSystemFunctions();
	}

	public String getTimeDateFunctions() throws SQLException { logger.info("xxx");
		return meta.getTimeDateFunctions();
	}

	public String getSearchStringEscape() throws SQLException { logger.info("xxx");
		return meta.getSearchStringEscape();
	}

	public String getExtraNameCharacters() throws SQLException { logger.info("xxx");
		return meta.getExtraNameCharacters();
	}

	public boolean supportsAlterTableWithAddColumn() throws SQLException { logger.info("xxx");
		return meta.supportsAlterTableWithAddColumn();
	}

	public boolean supportsAlterTableWithDropColumn() throws SQLException { logger.info("xxx");
		return meta.supportsAlterTableWithDropColumn();
	}

	public boolean supportsColumnAliasing() throws SQLException { logger.info("xxx");
		return meta.supportsColumnAliasing();
	}

	public boolean nullPlusNonNullIsNull() throws SQLException { logger.info("xxx");
		return meta.nullPlusNonNullIsNull();
	}

	public boolean supportsConvert() throws SQLException { logger.info("xxx");
		return meta.supportsConvert();
	}

	public boolean supportsConvert(int fromType, int toType) throws SQLException { logger.info("xxx");
		return meta.supportsConvert(fromType, toType);
	}

	public boolean supportsTableCorrelationNames() throws SQLException { logger.info("xxx");
		return meta.supportsTableCorrelationNames();
	}

	public boolean supportsDifferentTableCorrelationNames() throws SQLException { logger.info("xxx");
		return meta.supportsDifferentTableCorrelationNames();
	}

	public boolean supportsExpressionsInOrderBy() throws SQLException { logger.info("xxx");
		return meta.supportsExpressionsInOrderBy();
	}

	public boolean supportsOrderByUnrelated() throws SQLException { logger.info("xxx");
		return meta.supportsOrderByUnrelated();
	}

	public boolean supportsGroupBy() throws SQLException { logger.info("xxx");
		return meta.supportsGroupBy();
	}

	public boolean supportsGroupByUnrelated() throws SQLException { logger.info("xxx");
		return meta.supportsGroupByUnrelated();
	}

	public boolean supportsGroupByBeyondSelect() throws SQLException { logger.info("xxx");
		return meta.supportsGroupByBeyondSelect();
	}

	public boolean supportsLikeEscapeClause() throws SQLException { logger.info("xxx");
		return meta.supportsLikeEscapeClause();
	}

	public boolean supportsMultipleResultSets() throws SQLException { logger.info("xxx");
		return meta.supportsMultipleResultSets();
	}

	public boolean supportsMultipleTransactions() throws SQLException { logger.info("xxx");
		return meta.supportsMultipleTransactions();
	}

	public boolean supportsNonNullableColumns() throws SQLException { logger.info("xxx");
		return meta.supportsNonNullableColumns();
	}

	public boolean supportsMinimumSQLGrammar() throws SQLException { logger.info("xxx");
		return meta.supportsMinimumSQLGrammar();
	}

	public boolean supportsCoreSQLGrammar() throws SQLException { logger.info("xxx");
		return meta.supportsCoreSQLGrammar();
	}

	public boolean supportsExtendedSQLGrammar() throws SQLException { logger.info("xxx");
		return meta.supportsExtendedSQLGrammar();
	}

	public boolean supportsANSI92EntryLevelSQL() throws SQLException { logger.info("xxx");
		return meta.supportsANSI92EntryLevelSQL();
	}

	public boolean supportsANSI92IntermediateSQL() throws SQLException { logger.info("xxx");
		return meta.supportsANSI92IntermediateSQL();
	}

	public boolean supportsANSI92FullSQL() throws SQLException { logger.info("xxx");
		return meta.supportsANSI92FullSQL();
	}

	public boolean supportsIntegrityEnhancementFacility() throws SQLException { logger.info("xxx");
		return meta.supportsIntegrityEnhancementFacility();
	}

	public boolean supportsOuterJoins() throws SQLException { logger.info("xxx");
		return meta.supportsOuterJoins();
	}

	public boolean supportsFullOuterJoins() throws SQLException { logger.info("xxx");
		return meta.supportsFullOuterJoins();
	}

	public boolean supportsLimitedOuterJoins() throws SQLException { logger.info("xxx");
		return meta.supportsLimitedOuterJoins();
	}

	public String getSchemaTerm() throws SQLException { logger.info("xxx");
		return meta.getSchemaTerm();
	}

	public String getProcedureTerm() throws SQLException { logger.info("xxx");
		return meta.getProcedureTerm();
	}

	public String getCatalogTerm() throws SQLException { logger.info("xxx");
		return meta.getCatalogTerm();
	}

	public boolean isCatalogAtStart() throws SQLException { logger.info("xxx");
		return meta.isCatalogAtStart();
	}

	public String getCatalogSeparator() throws SQLException { logger.info("xxx");
		return meta.getCatalogSeparator();
	}

	public boolean supportsSchemasInDataManipulation() throws SQLException { logger.info("xxx");
		return meta.supportsSchemasInDataManipulation();
	}

	public boolean supportsSchemasInProcedureCalls() throws SQLException { logger.info("xxx");
		return meta.supportsSchemasInProcedureCalls();
	}

	public boolean supportsSchemasInTableDefinitions() throws SQLException { logger.info("xxx");
		return meta.supportsSchemasInTableDefinitions();
	}

	public boolean supportsSchemasInIndexDefinitions() throws SQLException { logger.info("xxx");
		return meta.supportsSchemasInIndexDefinitions();
	}

	public boolean supportsSchemasInPrivilegeDefinitions() throws SQLException { logger.info("xxx");
		return meta.supportsSchemasInPrivilegeDefinitions();
	}

	public boolean supportsCatalogsInDataManipulation() throws SQLException { logger.info("xxx");
		return meta.supportsCatalogsInDataManipulation();
	}

	public boolean supportsCatalogsInProcedureCalls() throws SQLException { logger.info("xxx");
		return meta.supportsCatalogsInProcedureCalls();
	}

	public boolean supportsCatalogsInTableDefinitions() throws SQLException { logger.info("xxx");
		return meta.supportsCatalogsInTableDefinitions();
	}

	public boolean supportsCatalogsInIndexDefinitions() throws SQLException { logger.info("xxx");
		return meta.supportsCatalogsInIndexDefinitions();
	}

	public boolean supportsCatalogsInPrivilegeDefinitions() throws SQLException { logger.info("xxx");
		return meta.supportsCatalogsInPrivilegeDefinitions();
	}

	public boolean supportsPositionedDelete() throws SQLException { logger.info("xxx");
		return meta.supportsPositionedDelete();
	}

	public boolean supportsPositionedUpdate() throws SQLException { logger.info("xxx");
		return meta.supportsPositionedUpdate();
	}

	public boolean supportsSelectForUpdate() throws SQLException { logger.info("xxx");
		return meta.supportsSelectForUpdate();
	}

	public boolean supportsStoredProcedures() throws SQLException { logger.info("xxx");
		return meta.supportsStoredProcedures();
	}

	public boolean supportsSubqueriesInComparisons() throws SQLException { logger.info("xxx");
		return meta.supportsSubqueriesInComparisons();
	}

	public boolean supportsSubqueriesInExists() throws SQLException { logger.info("xxx");
		return meta.supportsSubqueriesInExists();
	}

	public boolean supportsSubqueriesInIns() throws SQLException { logger.info("xxx");
		return meta.supportsSubqueriesInIns();
	}

	public boolean supportsSubqueriesInQuantifieds() throws SQLException { logger.info("xxx");
		return meta.supportsSubqueriesInQuantifieds();
	}

	public boolean supportsCorrelatedSubqueries() throws SQLException { logger.info("xxx");
		return meta.supportsCorrelatedSubqueries();
	}

	public boolean supportsUnion() throws SQLException { logger.info("xxx");
		return meta.supportsUnion();
	}

	public boolean supportsUnionAll() throws SQLException { logger.info("xxx");
		return meta.supportsUnionAll();
	}

	public boolean supportsOpenCursorsAcrossCommit() throws SQLException { logger.info("xxx");
		return meta.supportsOpenCursorsAcrossCommit();
	}

	public boolean supportsOpenCursorsAcrossRollback() throws SQLException { logger.info("xxx");
		return meta.supportsOpenCursorsAcrossRollback();
	}

	public boolean supportsOpenStatementsAcrossCommit() throws SQLException { logger.info("xxx");
		return meta.supportsOpenStatementsAcrossCommit();
	}

	public boolean supportsOpenStatementsAcrossRollback() throws SQLException { logger.info("xxx");
		return meta.supportsOpenStatementsAcrossRollback();
	}

	public int getMaxBinaryLiteralLength() throws SQLException { logger.info("xxx");
		return meta.getMaxBinaryLiteralLength();
	}

	public int getMaxCharLiteralLength() throws SQLException { logger.info("xxx");
		return meta.getMaxCharLiteralLength();
	}

	public int getMaxColumnNameLength() throws SQLException { logger.info("xxx");
		return meta.getMaxColumnNameLength();
	}

	public int getMaxColumnsInGroupBy() throws SQLException { logger.info("xxx");
		return meta.getMaxColumnsInGroupBy();
	}

	public int getMaxColumnsInIndex() throws SQLException { logger.info("xxx");
		return meta.getMaxColumnsInIndex();
	}

	public int getMaxColumnsInOrderBy() throws SQLException { logger.info("xxx");
		return meta.getMaxColumnsInOrderBy();
	}

	public int getMaxColumnsInSelect() throws SQLException { logger.info("xxx");
		return meta.getMaxColumnsInSelect();
	}

	public int getMaxColumnsInTable() throws SQLException { logger.info("xxx");
		return meta.getMaxColumnsInTable();
	}

	public int getMaxConnections() throws SQLException { logger.info("xxx");
		return meta.getMaxConnections();
	}

	public int getMaxCursorNameLength() throws SQLException { logger.info("xxx");
		return meta.getMaxCursorNameLength();
	}

	public int getMaxIndexLength() throws SQLException { logger.info("xxx");
		return meta.getMaxIndexLength();
	}

	public int getMaxSchemaNameLength() throws SQLException { logger.info("xxx");
		return meta.getMaxSchemaNameLength();
	}

	public int getMaxProcedureNameLength() throws SQLException { logger.info("xxx");
		return meta.getMaxProcedureNameLength();
	}

	public int getMaxCatalogNameLength() throws SQLException { logger.info("xxx");
		return meta.getMaxCatalogNameLength();
	}

	public int getMaxRowSize() throws SQLException { logger.info("xxx");
		return meta.getMaxRowSize();
	}

	public boolean doesMaxRowSizeIncludeBlobs() throws SQLException { logger.info("xxx");
		return meta.doesMaxRowSizeIncludeBlobs();
	}

	public int getMaxStatementLength() throws SQLException { logger.info("xxx");
		return meta.getMaxStatementLength();
	}

	public int getMaxStatements() throws SQLException { logger.info("xxx");
		return meta.getMaxStatements();
	}

	public int getMaxTableNameLength() throws SQLException { logger.info("xxx");
		return meta.getMaxTableNameLength();
	}

	public int getMaxTablesInSelect() throws SQLException { logger.info("xxx");
		return meta.getMaxTablesInSelect();
	}

	public int getMaxUserNameLength() throws SQLException { logger.info("xxx");
		return meta.getMaxUserNameLength();
	}

	public int getDefaultTransactionIsolation() throws SQLException { logger.info("xxx");
		return meta.getDefaultTransactionIsolation();
	}

	public boolean supportsTransactions() throws SQLException { logger.info("xxx");
		return meta.supportsTransactions();
	}

	public boolean supportsTransactionIsolationLevel(int level) throws SQLException { logger.info("xxx");
		return meta.supportsTransactionIsolationLevel(level);
	}

	public boolean supportsDataDefinitionAndDataManipulationTransactions() throws SQLException { logger.info("xxx");
		return meta.supportsDataDefinitionAndDataManipulationTransactions();
	}

	public boolean supportsDataManipulationTransactionsOnly() throws SQLException { logger.info("xxx");
		return meta.supportsDataManipulationTransactionsOnly();
	}

	public boolean dataDefinitionCausesTransactionCommit() throws SQLException { logger.info("xxx");
		return meta.dataDefinitionCausesTransactionCommit();
	}

	public boolean dataDefinitionIgnoredInTransactions() throws SQLException { logger.info("xxx");
		return meta.dataDefinitionIgnoredInTransactions();
	}

	public ResultSet getProcedures(String catalog, String schemaPattern, String procedureNamePattern)
			throws SQLException { logger.info("getProcedures " + catalog + " " + schemaPattern + " " + procedureNamePattern);
		return meta.getProcedures(catalog, schemaPattern, procedureNamePattern);
	}

	public ResultSet getProcedureColumns(String catalog, String schemaPattern, String procedureNamePattern,
			String columnNamePattern) 
			throws SQLException { logger.info("getProcedureColumns " + catalog + " " + schemaPattern + " " + procedureNamePattern + " " + columnNamePattern);
		return meta.getProcedureColumns(catalog, schemaPattern, procedureNamePattern, columnNamePattern);
	}

	public ResultSet getTables(String catalog, String schemaPattern, String tableNamePattern, String[] types)
			throws SQLException { logger.info("getTables " + catalog + " " + schemaPattern + " " + schemaPattern + " " + tableNamePattern + " " + Arrays.toString(types));
		return meta.getTables(catalog, schemaPattern, tableNamePattern, types);
	}

	public ResultSet getSchemas() throws SQLException { logger.info("getSchemas");
		return meta.getSchemas();
	}

	public ResultSet getCatalogs() throws SQLException { logger.info("getCatalogs");
		return meta.getCatalogs();
	}

	public ResultSet getTableTypes() throws SQLException { logger.info("getTableTypes");
		return meta.getTableTypes();
	}

	public ResultSet getColumns(String catalog, String schemaPattern, String tableNamePattern, String columnNamePattern)
			throws SQLException { logger.info("getColumns " + catalog + " " + schemaPattern + " " + tableNamePattern + " " + columnNamePattern);
		return meta.getColumns(catalog, schemaPattern, tableNamePattern, columnNamePattern);
	}

	public ResultSet getColumnPrivileges(String catalog, String schema, String table, String columnNamePattern)
			throws SQLException { logger.info("getColumnPrivileges " + catalog + " " + schema + " " + table + " " + columnNamePattern);
		return meta.getColumnPrivileges(catalog, schema, table, columnNamePattern);
	}

	public ResultSet getTablePrivileges(String catalog, String schemaPattern, String tableNamePattern)
			throws SQLException { logger.info("getTablePrivileges");
		return meta.getTablePrivileges(catalog, schemaPattern, tableNamePattern);
	}

	public ResultSet getBestRowIdentifier(String catalog, String schema, String table, int scope, boolean nullable)
			throws SQLException { logger.info("getBestRowIdentifier");
		return meta.getBestRowIdentifier(catalog, schema, table, scope, nullable);
	}

	public ResultSet getVersionColumns(String catalog, String schema, String table) throws SQLException { logger.info("getVersionColumns");
		return meta.getVersionColumns(catalog, schema, table);
	}

	public ResultSet getPrimaryKeys(String catalog, String schema, String table) throws SQLException { logger.info("getPrimaryKeys");
		return meta.getPrimaryKeys(catalog, schema, table);
	}

	public ResultSet getImportedKeys(String catalog, String schema, String table) throws SQLException { logger.info("getImportedKeys");
		return meta.getImportedKeys(catalog, schema, table);
	}

	public ResultSet getExportedKeys(String catalog, String schema, String table) throws SQLException { logger.info("getExportedKeys");
		return meta.getExportedKeys(catalog, schema, table);
	}

	public ResultSet getCrossReference(String parentCatalog, String parentSchema, String parentTable,
			String foreignCatalog, String foreignSchema, String foreignTable) throws SQLException { logger.info("getCrossReference");
		return meta.getCrossReference(parentCatalog, parentSchema, parentTable, foreignCatalog, foreignSchema,
				foreignTable);
	}

	public ResultSet getTypeInfo() throws SQLException { logger.info("getTypeInfo");
		return meta.getTypeInfo();
	}

	public ResultSet getIndexInfo(String catalog, String schema, String table, boolean unique, boolean approximate)
			throws SQLException { logger.info("getIndexInfo " + catalog + " " + schema + " " + table + " " + unique + " " + approximate);
		return meta.getIndexInfo(catalog, schema, table, unique, approximate);
	}

	public boolean supportsResultSetType(int type) throws SQLException { logger.info("supportsResultSetType");
		return meta.supportsResultSetType(type);
	}

	public boolean supportsResultSetConcurrency(int type, int concurrency) throws SQLException { logger.info("supportsResultSetConcurrency");
		return meta.supportsResultSetConcurrency(type, concurrency);
	}

	public boolean ownUpdatesAreVisible(int type) throws SQLException { logger.info("ownUpdatesAreVisible");
		return meta.ownUpdatesAreVisible(type);
	}

	public boolean ownDeletesAreVisible(int type) throws SQLException { logger.info("ownDeletesAreVisible");
		return meta.ownDeletesAreVisible(type);
	}

	public boolean ownInsertsAreVisible(int type) throws SQLException { logger.info("ownInsertsAreVisible");
		return meta.ownInsertsAreVisible(type);
	}

	public boolean othersUpdatesAreVisible(int type) throws SQLException { logger.info("othersUpdatesAreVisible");
		return meta.othersUpdatesAreVisible(type);
	}

	public boolean othersDeletesAreVisible(int type) throws SQLException { logger.info("othersDeletesAreVisible");
		return meta.othersDeletesAreVisible(type);
	}

	public boolean othersInsertsAreVisible(int type) throws SQLException { logger.info("othersInsertsAreVisible");
		return meta.othersInsertsAreVisible(type);
	}

	public boolean updatesAreDetected(int type) throws SQLException { logger.info("updatesAreDetected");
		return meta.updatesAreDetected(type);
	}

	public boolean deletesAreDetected(int type) throws SQLException { logger.info("deletesAreDetected");
		return meta.deletesAreDetected(type);
	}

	public boolean insertsAreDetected(int type) throws SQLException { logger.info("insertsAreDetected");
		return meta.insertsAreDetected(type);
	}

	public boolean supportsBatchUpdates() throws SQLException { logger.info("supportsBatchUpdates");
		return meta.supportsBatchUpdates();
	}

	public ResultSet getUDTs(String catalog, String schemaPattern, String typeNamePattern, int[] types)
			throws SQLException { logger.info("getUDTs");
		return meta.getUDTs(catalog, schemaPattern, typeNamePattern, types);
	}

	public Connection getConnection() throws SQLException { logger.info("getConnection");
		return meta.getConnection();
	}

	public boolean supportsSavepoints() throws SQLException { logger.info("supportsSavepoints");
		return meta.supportsSavepoints();
	}

	public boolean supportsNamedParameters() throws SQLException { logger.info("supportsNamedParameters");
		return meta.supportsNamedParameters();
	}

	public boolean supportsMultipleOpenResults() throws SQLException { logger.info("supportsMultipleOpenResults");
		return meta.supportsMultipleOpenResults();
	}

	public boolean supportsGetGeneratedKeys() throws SQLException { logger.info("supportsGetGeneratedKeys");
		return meta.supportsGetGeneratedKeys();
	}

	public ResultSet getSuperTypes(String catalog, String schemaPattern, String typeNamePattern) throws SQLException { logger.info("getSuperTypes");
		return meta.getSuperTypes(catalog, schemaPattern, typeNamePattern);
	}

	public ResultSet getSuperTables(String catalog, String schemaPattern, String tableNamePattern) throws SQLException { logger.info("getSuperTables");
		return meta.getSuperTables(catalog, schemaPattern, tableNamePattern);
	}

	public ResultSet getAttributes(String catalog, String schemaPattern, String typeNamePattern,
			String attributeNamePattern) throws SQLException { logger.info("getAttributes");
		return meta.getAttributes(catalog, schemaPattern, typeNamePattern, attributeNamePattern);
	}

	public boolean supportsResultSetHoldability(int holdability) throws SQLException { logger.info("supportsResultSetHoldability");
		return meta.supportsResultSetHoldability(holdability);
	}

	public int getResultSetHoldability() throws SQLException { logger.info("getResultSetHoldability");
		return meta.getResultSetHoldability();
	}

	public int getDatabaseMajorVersion() throws SQLException { logger.info("getDatabaseMajorVersion");
		return meta.getDatabaseMajorVersion();
	}

	public int getDatabaseMinorVersion() throws SQLException { logger.info("getDatabaseMinorVersion");
		return meta.getDatabaseMinorVersion();
	}

	public int getJDBCMajorVersion() throws SQLException { logger.info("getJDBCMajorVersion");
		return meta.getJDBCMajorVersion();
	}

	public int getJDBCMinorVersion() throws SQLException { logger.info("getJDBCMinorVersion");
		return meta.getJDBCMinorVersion();
	}

	public int getSQLStateType() throws SQLException { logger.info("getSQLStateType");
		return meta.getSQLStateType();
	}

	public boolean locatorsUpdateCopy() throws SQLException { logger.info("locatorsUpdateCopy");
		return meta.locatorsUpdateCopy();
	}

	public boolean supportsStatementPooling() throws SQLException { logger.info("supportsStatementPooling");
		return meta.supportsStatementPooling();
	}

	public RowIdLifetime getRowIdLifetime() throws SQLException { logger.info("getRowIdLifetime");
		return meta.getRowIdLifetime();
	}

	public ResultSet getSchemas(String catalog, String schemaPattern) throws SQLException { logger.info("getSchemas");
		return meta.getSchemas(catalog, schemaPattern);
	}

	public boolean supportsStoredFunctionsUsingCallSyntax() throws SQLException { logger.info("supportsStoredFunctionsUsingCallSyntax");
		return meta.supportsStoredFunctionsUsingCallSyntax();
	}

	public boolean autoCommitFailureClosesAllResultSets() throws SQLException { logger.info("autoCommitFailureClosesAllResultSets");
		return meta.autoCommitFailureClosesAllResultSets();
	}

	public ResultSet getClientInfoProperties() throws SQLException { logger.info("getClientInfoProperties");
		return meta.getClientInfoProperties();
	}

	public ResultSet getFunctions(String catalog, String schemaPattern, String functionNamePattern)
			throws SQLException { logger.info("getFunctions");
		return meta.getFunctions(catalog, schemaPattern, functionNamePattern);
	}

	public ResultSet getFunctionColumns(String catalog, String schemaPattern, String functionNamePattern,
			String columnNamePattern) throws SQLException { logger.info("getFunctionColumns");
		return meta.getFunctionColumns(catalog, schemaPattern, functionNamePattern, columnNamePattern);
	}

	public ResultSet getPseudoColumns(String catalog, String schemaPattern, String tableNamePattern,
			String columnNamePattern) throws SQLException { logger.info("getPseudoColumns");
		return meta.getPseudoColumns(catalog, schemaPattern, tableNamePattern, columnNamePattern);
	}

	public boolean generatedKeyAlwaysReturned() throws SQLException { logger.info("generatedKeyAlwaysReturned");
		return meta.generatedKeyAlwaysReturned();
	}

	public long getMaxLogicalLobSize() throws SQLException { logger.info("getMaxLogicalLobSize");
		return meta.getMaxLogicalLobSize();
	}

	public boolean supportsRefCursors() throws SQLException { logger.info("supportsRefCursors");
		return meta.supportsRefCursors();
	}

	public boolean supportsSharding() throws SQLException { logger.info("supportsSharding");
		return meta.supportsSharding();
	}
	
	
}
