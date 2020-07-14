package jp.mufg.logjdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.RowIdLifetime;
import java.sql.SQLException;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LogDatabaseMetaData implements DatabaseMetaData {
	private static final Logger logger = LoggerFactory.getLogger(LogDatabaseMetaData.class);
	private final DatabaseMetaData target;

	public LogDatabaseMetaData(DatabaseMetaData target) {
		super();
        this.target = target;
	}

    //-------------------------------------------------------

public String getURL() throws java.sql.SQLException {
	logger.info("getURL");
	String result = target.getURL();
	logger.info("getURL result is " + result);
	return result;
}

public boolean supportsDataDefinitionAndDataManipulationTransactions() throws java.sql.SQLException {
	logger.info("supportsDataDefinitionAndDataManipulationTransactions");
	boolean result = target.supportsDataDefinitionAndDataManipulationTransactions();
	logger.info("supportsDataDefinitionAndDataManipulationTransactions result is " + result);
	return result;
}

public boolean isWrapperFor(java.lang.Class<?> arg0) throws java.sql.SQLException {
	logger.info("isWrapperFor" + " , " + arg0 );
	boolean result = target.isWrapperFor(arg0);
	logger.info("isWrapperFor result is " + result);
	return result;
}

public boolean allProceduresAreCallable() throws java.sql.SQLException {
	logger.info("allProceduresAreCallable");
	boolean result = target.allProceduresAreCallable();
	logger.info("allProceduresAreCallable result is " + result);
	return result;
}

public boolean allTablesAreSelectable() throws java.sql.SQLException {
	logger.info("allTablesAreSelectable");
	boolean result = target.allTablesAreSelectable();
	logger.info("allTablesAreSelectable result is " + result);
	return result;
}

public String getUserName() throws java.sql.SQLException {
	logger.info("getUserName");
	String result = target.getUserName();
	logger.info("getUserName result is " + result);
	return result;
}

public boolean nullsAreSortedHigh() throws java.sql.SQLException {
	logger.info("nullsAreSortedHigh");
	boolean result = target.nullsAreSortedHigh();
	logger.info("nullsAreSortedHigh result is " + result);
	return result;
}

public boolean nullsAreSortedLow() throws java.sql.SQLException {
	logger.info("nullsAreSortedLow");
	boolean result = target.nullsAreSortedLow();
	logger.info("nullsAreSortedLow result is " + result);
	return result;
}

public boolean nullsAreSortedAtStart() throws java.sql.SQLException {
	logger.info("nullsAreSortedAtStart");
	boolean result = target.nullsAreSortedAtStart();
	logger.info("nullsAreSortedAtStart result is " + result);
	return result;
}

public boolean nullsAreSortedAtEnd() throws java.sql.SQLException {
	logger.info("nullsAreSortedAtEnd");
	boolean result = target.nullsAreSortedAtEnd();
	logger.info("nullsAreSortedAtEnd result is " + result);
	return result;
}

public String getDatabaseProductName() throws java.sql.SQLException {
	logger.info("getDatabaseProductName");
	String result = target.getDatabaseProductName();
	logger.info("getDatabaseProductName result is " + result);
	return result;
}

public String getDatabaseProductVersion() throws java.sql.SQLException {
	logger.info("getDatabaseProductVersion");
	String result = target.getDatabaseProductVersion();
	logger.info("getDatabaseProductVersion result is " + result);
	return result;
}

public String getDriverName() throws java.sql.SQLException {
	logger.info("getDriverName");
	String result = target.getDriverName();
	logger.info("getDriverName result is " + result);
	return result;
}

public String getDriverVersion() throws java.sql.SQLException {
	logger.info("getDriverVersion");
	String result = target.getDriverVersion();
	logger.info("getDriverVersion result is " + result);
	return result;
}

public int getDriverMajorVersion(){
	logger.info("getDriverMajorVersion");
	int result = target.getDriverMajorVersion();
	logger.info("getDriverMajorVersion result is " + result);
	return result;
}

public int getDriverMinorVersion(){
	logger.info("getDriverMinorVersion");
	int result = target.getDriverMinorVersion();
	logger.info("getDriverMinorVersion result is " + result);
	return result;
}

public boolean usesLocalFiles() throws java.sql.SQLException {
	logger.info("usesLocalFiles");
	boolean result = target.usesLocalFiles();
	logger.info("usesLocalFiles result is " + result);
	return result;
}

public boolean usesLocalFilePerTable() throws java.sql.SQLException {
	logger.info("usesLocalFilePerTable");
	boolean result = target.usesLocalFilePerTable();
	logger.info("usesLocalFilePerTable result is " + result);
	return result;
}

public boolean supportsMixedCaseIdentifiers() throws java.sql.SQLException {
	logger.info("supportsMixedCaseIdentifiers");
	boolean result = target.supportsMixedCaseIdentifiers();
	logger.info("supportsMixedCaseIdentifiers result is " + result);
	return result;
}

public boolean storesUpperCaseIdentifiers() throws java.sql.SQLException {
	logger.info("storesUpperCaseIdentifiers");
	boolean result = target.storesUpperCaseIdentifiers();
	logger.info("storesUpperCaseIdentifiers result is " + result);
	return result;
}

public boolean storesLowerCaseIdentifiers() throws java.sql.SQLException {
	logger.info("storesLowerCaseIdentifiers");
	boolean result = target.storesLowerCaseIdentifiers();
	logger.info("storesLowerCaseIdentifiers result is " + result);
	return result;
}

public boolean storesMixedCaseIdentifiers() throws java.sql.SQLException {
	logger.info("storesMixedCaseIdentifiers");
	boolean result = target.storesMixedCaseIdentifiers();
	logger.info("storesMixedCaseIdentifiers result is " + result);
	return result;
}

public boolean supportsMixedCaseQuotedIdentifiers() throws java.sql.SQLException {
	logger.info("supportsMixedCaseQuotedIdentifiers");
	boolean result = target.supportsMixedCaseQuotedIdentifiers();
	logger.info("supportsMixedCaseQuotedIdentifiers result is " + result);
	return result;
}

public boolean storesUpperCaseQuotedIdentifiers() throws java.sql.SQLException {
	logger.info("storesUpperCaseQuotedIdentifiers");
	boolean result = target.storesUpperCaseQuotedIdentifiers();
	logger.info("storesUpperCaseQuotedIdentifiers result is " + result);
	return result;
}

public boolean storesLowerCaseQuotedIdentifiers() throws java.sql.SQLException {
	logger.info("storesLowerCaseQuotedIdentifiers");
	boolean result = target.storesLowerCaseQuotedIdentifiers();
	logger.info("storesLowerCaseQuotedIdentifiers result is " + result);
	return result;
}

public boolean storesMixedCaseQuotedIdentifiers() throws java.sql.SQLException {
	logger.info("storesMixedCaseQuotedIdentifiers");
	boolean result = target.storesMixedCaseQuotedIdentifiers();
	logger.info("storesMixedCaseQuotedIdentifiers result is " + result);
	return result;
}

public String getIdentifierQuoteString() throws java.sql.SQLException {
	logger.info("getIdentifierQuoteString");
	String result = target.getIdentifierQuoteString();
	logger.info("getIdentifierQuoteString result is " + result);
	return result;
}

public String getSQLKeywords() throws java.sql.SQLException {
	logger.info("getSQLKeywords");
	String result = target.getSQLKeywords();
	logger.info("getSQLKeywords result is " + result);
	return result;
}

public String getNumericFunctions() throws java.sql.SQLException {
	logger.info("getNumericFunctions");
	String result = target.getNumericFunctions();
	logger.info("getNumericFunctions result is " + result);
	return result;
}

public String getStringFunctions() throws java.sql.SQLException {
	logger.info("getStringFunctions");
	String result = target.getStringFunctions();
	logger.info("getStringFunctions result is " + result);
	return result;
}

public String getSystemFunctions() throws java.sql.SQLException {
	logger.info("getSystemFunctions");
	String result = target.getSystemFunctions();
	logger.info("getSystemFunctions result is " + result);
	return result;
}

public String getTimeDateFunctions() throws java.sql.SQLException {
	logger.info("getTimeDateFunctions");
	String result = target.getTimeDateFunctions();
	logger.info("getTimeDateFunctions result is " + result);
	return result;
}

public String getSearchStringEscape() throws java.sql.SQLException {
	logger.info("getSearchStringEscape");
	String result = target.getSearchStringEscape();
	logger.info("getSearchStringEscape result is " + result);
	return result;
}

public String getExtraNameCharacters() throws java.sql.SQLException {
	logger.info("getExtraNameCharacters");
	String result = target.getExtraNameCharacters();
	logger.info("getExtraNameCharacters result is " + result);
	return result;
}

public boolean supportsAlterTableWithAddColumn() throws java.sql.SQLException {
	logger.info("supportsAlterTableWithAddColumn");
	boolean result = target.supportsAlterTableWithAddColumn();
	logger.info("supportsAlterTableWithAddColumn result is " + result);
	return result;
}

public boolean supportsAlterTableWithDropColumn() throws java.sql.SQLException {
	logger.info("supportsAlterTableWithDropColumn");
	boolean result = target.supportsAlterTableWithDropColumn();
	logger.info("supportsAlterTableWithDropColumn result is " + result);
	return result;
}

public boolean supportsColumnAliasing() throws java.sql.SQLException {
	logger.info("supportsColumnAliasing");
	boolean result = target.supportsColumnAliasing();
	logger.info("supportsColumnAliasing result is " + result);
	return result;
}

public boolean nullPlusNonNullIsNull() throws java.sql.SQLException {
	logger.info("nullPlusNonNullIsNull");
	boolean result = target.nullPlusNonNullIsNull();
	logger.info("nullPlusNonNullIsNull result is " + result);
	return result;
}

public boolean supportsConvert() throws java.sql.SQLException {
	logger.info("supportsConvert");
	boolean result = target.supportsConvert();
	logger.info("supportsConvert result is " + result);
	return result;
}

public boolean supportsConvert(int arg0, int arg1) throws java.sql.SQLException {
	logger.info("supportsConvert" + " , " + arg0  + " , " + arg1 );
	boolean result = target.supportsConvert(arg0, arg1);
	logger.info("supportsConvert result is " + result);
	return result;
}

public boolean supportsTableCorrelationNames() throws java.sql.SQLException {
	logger.info("supportsTableCorrelationNames");
	boolean result = target.supportsTableCorrelationNames();
	logger.info("supportsTableCorrelationNames result is " + result);
	return result;
}

public boolean supportsDifferentTableCorrelationNames() throws java.sql.SQLException {
	logger.info("supportsDifferentTableCorrelationNames");
	boolean result = target.supportsDifferentTableCorrelationNames();
	logger.info("supportsDifferentTableCorrelationNames result is " + result);
	return result;
}

public boolean supportsExpressionsInOrderBy() throws java.sql.SQLException {
	logger.info("supportsExpressionsInOrderBy");
	boolean result = target.supportsExpressionsInOrderBy();
	logger.info("supportsExpressionsInOrderBy result is " + result);
	return result;
}

public boolean supportsOrderByUnrelated() throws java.sql.SQLException {
	logger.info("supportsOrderByUnrelated");
	boolean result = target.supportsOrderByUnrelated();
	logger.info("supportsOrderByUnrelated result is " + result);
	return result;
}

public boolean supportsGroupBy() throws java.sql.SQLException {
	logger.info("supportsGroupBy");
	boolean result = target.supportsGroupBy();
	logger.info("supportsGroupBy result is " + result);
	return result;
}

public boolean supportsGroupByUnrelated() throws java.sql.SQLException {
	logger.info("supportsGroupByUnrelated");
	boolean result = target.supportsGroupByUnrelated();
	logger.info("supportsGroupByUnrelated result is " + result);
	return result;
}

public boolean supportsGroupByBeyondSelect() throws java.sql.SQLException {
	logger.info("supportsGroupByBeyondSelect");
	boolean result = target.supportsGroupByBeyondSelect();
	logger.info("supportsGroupByBeyondSelect result is " + result);
	return result;
}

public boolean supportsLikeEscapeClause() throws java.sql.SQLException {
	logger.info("supportsLikeEscapeClause");
	boolean result = target.supportsLikeEscapeClause();
	logger.info("supportsLikeEscapeClause result is " + result);
	return result;
}

public boolean supportsMultipleResultSets() throws java.sql.SQLException {
	logger.info("supportsMultipleResultSets");
	boolean result = target.supportsMultipleResultSets();
	logger.info("supportsMultipleResultSets result is " + result);
	return result;
}

public boolean supportsMultipleTransactions() throws java.sql.SQLException {
	logger.info("supportsMultipleTransactions");
	boolean result = target.supportsMultipleTransactions();
	logger.info("supportsMultipleTransactions result is " + result);
	return result;
}

public boolean supportsNonNullableColumns() throws java.sql.SQLException {
	logger.info("supportsNonNullableColumns");
	boolean result = target.supportsNonNullableColumns();
	logger.info("supportsNonNullableColumns result is " + result);
	return result;
}

public boolean supportsMinimumSQLGrammar() throws java.sql.SQLException {
	logger.info("supportsMinimumSQLGrammar");
	boolean result = target.supportsMinimumSQLGrammar();
	logger.info("supportsMinimumSQLGrammar result is " + result);
	return result;
}

public boolean supportsCoreSQLGrammar() throws java.sql.SQLException {
	logger.info("supportsCoreSQLGrammar");
	boolean result = target.supportsCoreSQLGrammar();
	logger.info("supportsCoreSQLGrammar result is " + result);
	return result;
}

public boolean supportsExtendedSQLGrammar() throws java.sql.SQLException {
	logger.info("supportsExtendedSQLGrammar");
	boolean result = target.supportsExtendedSQLGrammar();
	logger.info("supportsExtendedSQLGrammar result is " + result);
	return result;
}

public boolean supportsANSI92EntryLevelSQL() throws java.sql.SQLException {
	logger.info("supportsANSI92EntryLevelSQL");
	boolean result = target.supportsANSI92EntryLevelSQL();
	logger.info("supportsANSI92EntryLevelSQL result is " + result);
	return result;
}

public boolean supportsANSI92IntermediateSQL() throws java.sql.SQLException {
	logger.info("supportsANSI92IntermediateSQL");
	boolean result = target.supportsANSI92IntermediateSQL();
	logger.info("supportsANSI92IntermediateSQL result is " + result);
	return result;
}

public boolean supportsANSI92FullSQL() throws java.sql.SQLException {
	logger.info("supportsANSI92FullSQL");
	boolean result = target.supportsANSI92FullSQL();
	logger.info("supportsANSI92FullSQL result is " + result);
	return result;
}

public boolean supportsIntegrityEnhancementFacility() throws java.sql.SQLException {
	logger.info("supportsIntegrityEnhancementFacility");
	boolean result = target.supportsIntegrityEnhancementFacility();
	logger.info("supportsIntegrityEnhancementFacility result is " + result);
	return result;
}

public boolean supportsOuterJoins() throws java.sql.SQLException {
	logger.info("supportsOuterJoins");
	boolean result = target.supportsOuterJoins();
	logger.info("supportsOuterJoins result is " + result);
	return result;
}

public boolean supportsFullOuterJoins() throws java.sql.SQLException {
	logger.info("supportsFullOuterJoins");
	boolean result = target.supportsFullOuterJoins();
	logger.info("supportsFullOuterJoins result is " + result);
	return result;
}

public boolean supportsLimitedOuterJoins() throws java.sql.SQLException {
	logger.info("supportsLimitedOuterJoins");
	boolean result = target.supportsLimitedOuterJoins();
	logger.info("supportsLimitedOuterJoins result is " + result);
	return result;
}

public String getSchemaTerm() throws java.sql.SQLException {
	logger.info("getSchemaTerm");
	String result = target.getSchemaTerm();
	logger.info("getSchemaTerm result is " + result);
	return result;
}

public String getProcedureTerm() throws java.sql.SQLException {
	logger.info("getProcedureTerm");
	String result = target.getProcedureTerm();
	logger.info("getProcedureTerm result is " + result);
	return result;
}

public String getCatalogTerm() throws java.sql.SQLException {
	logger.info("getCatalogTerm");
	String result = target.getCatalogTerm();
	logger.info("getCatalogTerm result is " + result);
	return result;
}

public boolean isCatalogAtStart() throws java.sql.SQLException {
	logger.info("isCatalogAtStart");
	boolean result = target.isCatalogAtStart();
	logger.info("isCatalogAtStart result is " + result);
	return result;
}

public String getCatalogSeparator() throws java.sql.SQLException {
	logger.info("getCatalogSeparator");
	String result = target.getCatalogSeparator();
	logger.info("getCatalogSeparator result is " + result);
	return result;
}

public boolean supportsSchemasInDataManipulation() throws java.sql.SQLException {
	logger.info("supportsSchemasInDataManipulation");
	boolean result = target.supportsSchemasInDataManipulation();
	logger.info("supportsSchemasInDataManipulation result is " + result);
	return result;
}

public boolean supportsSchemasInProcedureCalls() throws java.sql.SQLException {
	logger.info("supportsSchemasInProcedureCalls");
	boolean result = target.supportsSchemasInProcedureCalls();
	logger.info("supportsSchemasInProcedureCalls result is " + result);
	return result;
}

public boolean supportsSchemasInTableDefinitions() throws java.sql.SQLException {
	logger.info("supportsSchemasInTableDefinitions");
	boolean result = target.supportsSchemasInTableDefinitions();
	logger.info("supportsSchemasInTableDefinitions result is " + result);
	return result;
}

public boolean supportsSchemasInIndexDefinitions() throws java.sql.SQLException {
	logger.info("supportsSchemasInIndexDefinitions");
	boolean result = target.supportsSchemasInIndexDefinitions();
	logger.info("supportsSchemasInIndexDefinitions result is " + result);
	return result;
}

public boolean supportsSchemasInPrivilegeDefinitions() throws java.sql.SQLException {
	logger.info("supportsSchemasInPrivilegeDefinitions");
	boolean result = target.supportsSchemasInPrivilegeDefinitions();
	logger.info("supportsSchemasInPrivilegeDefinitions result is " + result);
	return result;
}

public boolean supportsCatalogsInDataManipulation() throws java.sql.SQLException {
	logger.info("supportsCatalogsInDataManipulation");
	boolean result = target.supportsCatalogsInDataManipulation();
	logger.info("supportsCatalogsInDataManipulation result is " + result);
	return result;
}

public boolean supportsCatalogsInProcedureCalls() throws java.sql.SQLException {
	logger.info("supportsCatalogsInProcedureCalls");
	boolean result = target.supportsCatalogsInProcedureCalls();
	logger.info("supportsCatalogsInProcedureCalls result is " + result);
	return result;
}

public boolean supportsCatalogsInTableDefinitions() throws java.sql.SQLException {
	logger.info("supportsCatalogsInTableDefinitions");
	boolean result = target.supportsCatalogsInTableDefinitions();
	logger.info("supportsCatalogsInTableDefinitions result is " + result);
	return result;
}

public boolean supportsCatalogsInIndexDefinitions() throws java.sql.SQLException {
	logger.info("supportsCatalogsInIndexDefinitions");
	boolean result = target.supportsCatalogsInIndexDefinitions();
	logger.info("supportsCatalogsInIndexDefinitions result is " + result);
	return result;
}

public boolean supportsCatalogsInPrivilegeDefinitions() throws java.sql.SQLException {
	logger.info("supportsCatalogsInPrivilegeDefinitions");
	boolean result = target.supportsCatalogsInPrivilegeDefinitions();
	logger.info("supportsCatalogsInPrivilegeDefinitions result is " + result);
	return result;
}

public boolean supportsPositionedDelete() throws java.sql.SQLException {
	logger.info("supportsPositionedDelete");
	boolean result = target.supportsPositionedDelete();
	logger.info("supportsPositionedDelete result is " + result);
	return result;
}

public boolean supportsPositionedUpdate() throws java.sql.SQLException {
	logger.info("supportsPositionedUpdate");
	boolean result = target.supportsPositionedUpdate();
	logger.info("supportsPositionedUpdate result is " + result);
	return result;
}

public boolean supportsSelectForUpdate() throws java.sql.SQLException {
	logger.info("supportsSelectForUpdate");
	boolean result = target.supportsSelectForUpdate();
	logger.info("supportsSelectForUpdate result is " + result);
	return result;
}

public boolean supportsStoredProcedures() throws java.sql.SQLException {
	logger.info("supportsStoredProcedures");
	boolean result = target.supportsStoredProcedures();
	logger.info("supportsStoredProcedures result is " + result);
	return result;
}

public boolean supportsSubqueriesInComparisons() throws java.sql.SQLException {
	logger.info("supportsSubqueriesInComparisons");
	boolean result = target.supportsSubqueriesInComparisons();
	logger.info("supportsSubqueriesInComparisons result is " + result);
	return result;
}

public boolean supportsSubqueriesInExists() throws java.sql.SQLException {
	logger.info("supportsSubqueriesInExists");
	boolean result = target.supportsSubqueriesInExists();
	logger.info("supportsSubqueriesInExists result is " + result);
	return result;
}

public boolean supportsSubqueriesInIns() throws java.sql.SQLException {
	logger.info("supportsSubqueriesInIns");
	boolean result = target.supportsSubqueriesInIns();
	logger.info("supportsSubqueriesInIns result is " + result);
	return result;
}

public boolean supportsSubqueriesInQuantifieds() throws java.sql.SQLException {
	logger.info("supportsSubqueriesInQuantifieds");
	boolean result = target.supportsSubqueriesInQuantifieds();
	logger.info("supportsSubqueriesInQuantifieds result is " + result);
	return result;
}

public boolean supportsCorrelatedSubqueries() throws java.sql.SQLException {
	logger.info("supportsCorrelatedSubqueries");
	boolean result = target.supportsCorrelatedSubqueries();
	logger.info("supportsCorrelatedSubqueries result is " + result);
	return result;
}

public boolean supportsUnion() throws java.sql.SQLException {
	logger.info("supportsUnion");
	boolean result = target.supportsUnion();
	logger.info("supportsUnion result is " + result);
	return result;
}

public boolean supportsUnionAll() throws java.sql.SQLException {
	logger.info("supportsUnionAll");
	boolean result = target.supportsUnionAll();
	logger.info("supportsUnionAll result is " + result);
	return result;
}

public boolean supportsOpenCursorsAcrossCommit() throws java.sql.SQLException {
	logger.info("supportsOpenCursorsAcrossCommit");
	boolean result = target.supportsOpenCursorsAcrossCommit();
	logger.info("supportsOpenCursorsAcrossCommit result is " + result);
	return result;
}

public boolean supportsOpenCursorsAcrossRollback() throws java.sql.SQLException {
	logger.info("supportsOpenCursorsAcrossRollback");
	boolean result = target.supportsOpenCursorsAcrossRollback();
	logger.info("supportsOpenCursorsAcrossRollback result is " + result);
	return result;
}

public boolean supportsOpenStatementsAcrossCommit() throws java.sql.SQLException {
	logger.info("supportsOpenStatementsAcrossCommit");
	boolean result = target.supportsOpenStatementsAcrossCommit();
	logger.info("supportsOpenStatementsAcrossCommit result is " + result);
	return result;
}

public boolean supportsOpenStatementsAcrossRollback() throws java.sql.SQLException {
	logger.info("supportsOpenStatementsAcrossRollback");
	boolean result = target.supportsOpenStatementsAcrossRollback();
	logger.info("supportsOpenStatementsAcrossRollback result is " + result);
	return result;
}

public int getMaxBinaryLiteralLength() throws java.sql.SQLException {
	logger.info("getMaxBinaryLiteralLength");
	int result = target.getMaxBinaryLiteralLength();
	logger.info("getMaxBinaryLiteralLength result is " + result);
	return result;
}

public int getMaxCharLiteralLength() throws java.sql.SQLException {
	logger.info("getMaxCharLiteralLength");
	int result = target.getMaxCharLiteralLength();
	logger.info("getMaxCharLiteralLength result is " + result);
	return result;
}

public int getMaxColumnNameLength() throws java.sql.SQLException {
	logger.info("getMaxColumnNameLength");
	int result = target.getMaxColumnNameLength();
	logger.info("getMaxColumnNameLength result is " + result);
	return result;
}

public int getMaxColumnsInGroupBy() throws java.sql.SQLException {
	logger.info("getMaxColumnsInGroupBy");
	int result = target.getMaxColumnsInGroupBy();
	logger.info("getMaxColumnsInGroupBy result is " + result);
	return result;
}

public int getMaxColumnsInIndex() throws java.sql.SQLException {
	logger.info("getMaxColumnsInIndex");
	int result = target.getMaxColumnsInIndex();
	logger.info("getMaxColumnsInIndex result is " + result);
	return result;
}

public int getMaxColumnsInOrderBy() throws java.sql.SQLException {
	logger.info("getMaxColumnsInOrderBy");
	int result = target.getMaxColumnsInOrderBy();
	logger.info("getMaxColumnsInOrderBy result is " + result);
	return result;
}

public int getMaxColumnsInSelect() throws java.sql.SQLException {
	logger.info("getMaxColumnsInSelect");
	int result = target.getMaxColumnsInSelect();
	logger.info("getMaxColumnsInSelect result is " + result);
	return result;
}

public int getMaxColumnsInTable() throws java.sql.SQLException {
	logger.info("getMaxColumnsInTable");
	int result = target.getMaxColumnsInTable();
	logger.info("getMaxColumnsInTable result is " + result);
	return result;
}

public int getMaxConnections() throws java.sql.SQLException {
	logger.info("getMaxConnections");
	int result = target.getMaxConnections();
	logger.info("getMaxConnections result is " + result);
	return result;
}

public int getMaxCursorNameLength() throws java.sql.SQLException {
	logger.info("getMaxCursorNameLength");
	int result = target.getMaxCursorNameLength();
	logger.info("getMaxCursorNameLength result is " + result);
	return result;
}

public int getMaxIndexLength() throws java.sql.SQLException {
	logger.info("getMaxIndexLength");
	int result = target.getMaxIndexLength();
	logger.info("getMaxIndexLength result is " + result);
	return result;
}

public int getMaxSchemaNameLength() throws java.sql.SQLException {
	logger.info("getMaxSchemaNameLength");
	int result = target.getMaxSchemaNameLength();
	logger.info("getMaxSchemaNameLength result is " + result);
	return result;
}

public int getMaxProcedureNameLength() throws java.sql.SQLException {
	logger.info("getMaxProcedureNameLength");
	int result = target.getMaxProcedureNameLength();
	logger.info("getMaxProcedureNameLength result is " + result);
	return result;
}

public int getMaxCatalogNameLength() throws java.sql.SQLException {
	logger.info("getMaxCatalogNameLength");
	int result = target.getMaxCatalogNameLength();
	logger.info("getMaxCatalogNameLength result is " + result);
	return result;
}

public int getMaxRowSize() throws java.sql.SQLException {
	logger.info("getMaxRowSize");
	int result = target.getMaxRowSize();
	logger.info("getMaxRowSize result is " + result);
	return result;
}

public boolean doesMaxRowSizeIncludeBlobs() throws java.sql.SQLException {
	logger.info("doesMaxRowSizeIncludeBlobs");
	boolean result = target.doesMaxRowSizeIncludeBlobs();
	logger.info("doesMaxRowSizeIncludeBlobs result is " + result);
	return result;
}

public int getMaxStatementLength() throws java.sql.SQLException {
	logger.info("getMaxStatementLength");
	int result = target.getMaxStatementLength();
	logger.info("getMaxStatementLength result is " + result);
	return result;
}

public int getMaxStatements() throws java.sql.SQLException {
	logger.info("getMaxStatements");
	int result = target.getMaxStatements();
	logger.info("getMaxStatements result is " + result);
	return result;
}

public int getMaxTableNameLength() throws java.sql.SQLException {
	logger.info("getMaxTableNameLength");
	int result = target.getMaxTableNameLength();
	logger.info("getMaxTableNameLength result is " + result);
	return result;
}

public int getMaxTablesInSelect() throws java.sql.SQLException {
	logger.info("getMaxTablesInSelect");
	int result = target.getMaxTablesInSelect();
	logger.info("getMaxTablesInSelect result is " + result);
	return result;
}

public int getMaxUserNameLength() throws java.sql.SQLException {
	logger.info("getMaxUserNameLength");
	int result = target.getMaxUserNameLength();
	logger.info("getMaxUserNameLength result is " + result);
	return result;
}

public int getDefaultTransactionIsolation() throws java.sql.SQLException {
	logger.info("getDefaultTransactionIsolation");
	int result = target.getDefaultTransactionIsolation();
	logger.info("getDefaultTransactionIsolation result is " + result);
	return result;
}

public boolean supportsTransactions() throws java.sql.SQLException {
	logger.info("supportsTransactions");
	boolean result = target.supportsTransactions();
	logger.info("supportsTransactions result is " + result);
	return result;
}

public boolean supportsTransactionIsolationLevel(int arg0) throws java.sql.SQLException {
	logger.info("supportsTransactionIsolationLevel" + " , " + arg0 );
	boolean result = target.supportsTransactionIsolationLevel(arg0);
	logger.info("supportsTransactionIsolationLevel result is " + result);
	return result;
}

public boolean supportsDataManipulationTransactionsOnly() throws java.sql.SQLException {
	logger.info("supportsDataManipulationTransactionsOnly");
	boolean result = target.supportsDataManipulationTransactionsOnly();
	logger.info("supportsDataManipulationTransactionsOnly result is " + result);
	return result;
}

public boolean dataDefinitionCausesTransactionCommit() throws java.sql.SQLException {
	logger.info("dataDefinitionCausesTransactionCommit");
	boolean result = target.dataDefinitionCausesTransactionCommit();
	logger.info("dataDefinitionCausesTransactionCommit result is " + result);
	return result;
}

public boolean dataDefinitionIgnoredInTransactions() throws java.sql.SQLException {
	logger.info("dataDefinitionIgnoredInTransactions");
	boolean result = target.dataDefinitionIgnoredInTransactions();
	logger.info("dataDefinitionIgnoredInTransactions result is " + result);
	return result;
}

public java.sql.ResultSet getProcedures(String arg0, String arg1, String arg2) throws java.sql.SQLException {
	logger.info("getProcedures" + " , " + arg0  + " , " + arg1  + " , " + arg2 );
	java.sql.ResultSet result = new LogResultSet( target.getProcedures(arg0, arg1, arg2) );
	logger.info("getProcedures result is " + result);
	return result;
}

public java.sql.ResultSet getProcedureColumns(String arg0, String arg1, String arg2, String arg3) throws java.sql.SQLException {
	logger.info("getProcedureColumns" + " , " + arg0  + " , " + arg1  + " , " + arg2  + " , " + arg3 );
	java.sql.ResultSet result = new LogResultSet(target.getProcedureColumns(arg0, arg1, arg2, arg3));
	logger.info("getProcedureColumns result is " + result);
	return result;
}

public java.sql.ResultSet getTables(String arg0, String arg1, String arg2, String[] arg3) throws java.sql.SQLException {
	logger.info("getTables" + " , " + arg0  + " , " + arg1  + " , " + arg2  + " , " + arg3 );
	java.sql.ResultSet result = new LogResultSet(target.getTables(arg0, arg1, arg2, arg3));
	logger.info("getTables result is " + result);
	return result;
}

public java.sql.ResultSet getSchemas() throws java.sql.SQLException {
	logger.info("getSchemas");
	java.sql.ResultSet result = new LogResultSet(target.getSchemas());
	logger.info("getSchemas result is " + result);
	return result;
}

public java.sql.ResultSet getSchemas(String arg0, String arg1) throws java.sql.SQLException {
	logger.info("getSchemas" + " , " + arg0  + " , " + arg1 );
	java.sql.ResultSet result = new LogResultSet(target.getSchemas(arg0, arg1));
	logger.info("getSchemas result is " + result);
	return result;
}

public java.sql.ResultSet getCatalogs() throws java.sql.SQLException {
	logger.info("getCatalogs");
	java.sql.ResultSet result = new LogResultSet(target.getCatalogs());
	logger.info("getCatalogs result is " + result);
	return result;
}

public java.sql.ResultSet getTableTypes() throws java.sql.SQLException {
	logger.info("getTableTypes");
	java.sql.ResultSet result = new LogResultSet(target.getTableTypes());
	logger.info("getTableTypes result is " + result);
	return result;
}

public java.sql.ResultSet getColumns(String arg0, String arg1, String arg2, String arg3) throws java.sql.SQLException {
	logger.info("getColumns" + " , " + arg0  + " , " + arg1  + " , " + arg2  + " , " + arg3 );
	java.sql.ResultSet result = new LogResultSet(target.getColumns(arg0, arg1, arg2, arg3));
	logger.info("getColumns result is " + result);
	return result;
}

public java.sql.ResultSet getColumnPrivileges(String arg0, String arg1, String arg2, String arg3) throws java.sql.SQLException {
	logger.info("getColumnPrivileges" + " , " + arg0  + " , " + arg1  + " , " + arg2  + " , " + arg3 );
	java.sql.ResultSet result = new LogResultSet(target.getColumnPrivileges(arg0, arg1, arg2, arg3));
	logger.info("getColumnPrivileges result is " + result);
	return result;
}

public java.sql.ResultSet getTablePrivileges(String arg0, String arg1, String arg2) throws java.sql.SQLException {
	logger.info("getTablePrivileges" + " , " + arg0  + " , " + arg1  + " , " + arg2 );
	java.sql.ResultSet result = new LogResultSet(target.getTablePrivileges(arg0, arg1, arg2));
	logger.info("getTablePrivileges result is " + result);
	return result;
}

public java.sql.ResultSet getBestRowIdentifier(String arg0, String arg1, String arg2, int arg3, boolean arg4) throws java.sql.SQLException {
	logger.info("getBestRowIdentifier" + " , " + arg0  + " , " + arg1  + " , " + arg2  + " , " + arg3  + " , " + arg4 );
	java.sql.ResultSet result = new LogResultSet(target.getBestRowIdentifier(arg0, arg1, arg2, arg3, arg4));
	logger.info("getBestRowIdentifier result is " + result);
	return result;
}

public java.sql.ResultSet getVersionColumns(String arg0, String arg1, String arg2) throws java.sql.SQLException {
	logger.info("getVersionColumns" + " , " + arg0  + " , " + arg1  + " , " + arg2 );
	java.sql.ResultSet result = new LogResultSet(target.getVersionColumns(arg0, arg1, arg2));
	logger.info("getVersionColumns result is " + result);
	return result;
}

public java.sql.ResultSet getPrimaryKeys(String arg0, String arg1, String arg2) throws java.sql.SQLException {
	logger.info("getPrimaryKeys" + " , " + arg0  + " , " + arg1  + " , " + arg2 );
	java.sql.ResultSet result = new LogResultSet(target.getPrimaryKeys(arg0, arg1, arg2));
	logger.info("getPrimaryKeys result is " + result);
	return result;
}

public java.sql.ResultSet getImportedKeys(String arg0, String arg1, String arg2) throws java.sql.SQLException {
	logger.info("getImportedKeys" + " , " + arg0  + " , " + arg1  + " , " + arg2 );
	java.sql.ResultSet result = new LogResultSet(target.getImportedKeys(arg0, arg1, arg2));
	logger.info("getImportedKeys result is " + result);
	return result;
}

public java.sql.ResultSet getExportedKeys(String arg0, String arg1, String arg2) throws java.sql.SQLException {
	logger.info("getExportedKeys" + " , " + arg0  + " , " + arg1  + " , " + arg2 );
	java.sql.ResultSet result = new LogResultSet(target.getExportedKeys(arg0, arg1, arg2));
	logger.info("getExportedKeys result is " + result);
	return result;
}

public java.sql.ResultSet getCrossReference(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5) throws java.sql.SQLException {
	logger.info("getCrossReference" + " , " + arg0  + " , " + arg1  + " , " + arg2  + " , " + arg3  + " , " + arg4  + " , " + arg5 );
	java.sql.ResultSet result = new LogResultSet(target.getCrossReference(arg0, arg1, arg2, arg3, arg4, arg5));
	logger.info("getCrossReference result is " + result);
	return result;
}

public java.sql.ResultSet getTypeInfo() throws java.sql.SQLException {
	logger.info("getTypeInfo");
	java.sql.ResultSet result = new LogResultSet(target.getTypeInfo());
	logger.info("getTypeInfo result is " + result);
	return result;
}

public java.sql.ResultSet getIndexInfo(String arg0, String arg1, String arg2, boolean arg3, boolean arg4) throws java.sql.SQLException {
	logger.info("getIndexInfo" + " , " + arg0  + " , " + arg1  + " , " + arg2  + " , " + arg3  + " , " + arg4 );
	java.sql.ResultSet result = new LogResultSet(target.getIndexInfo(arg0, arg1, arg2, arg3, arg4));
	logger.info("getIndexInfo result is " + result);
	return result;
}

public boolean supportsResultSetType(int arg0) throws java.sql.SQLException {
	logger.info("supportsResultSetType" + " , " + arg0 );
	boolean result = target.supportsResultSetType(arg0);
	logger.info("supportsResultSetType result is " + result);
	return result;
}

public boolean supportsResultSetConcurrency(int arg0, int arg1) throws java.sql.SQLException {
	logger.info("supportsResultSetConcurrency" + " , " + arg0  + " , " + arg1 );
	boolean result = target.supportsResultSetConcurrency(arg0, arg1);
	logger.info("supportsResultSetConcurrency result is " + result);
	return result;
}

public boolean ownUpdatesAreVisible(int arg0) throws java.sql.SQLException {
	logger.info("ownUpdatesAreVisible" + " , " + arg0 );
	boolean result = target.ownUpdatesAreVisible(arg0);
	logger.info("ownUpdatesAreVisible result is " + result);
	return result;
}

public boolean ownDeletesAreVisible(int arg0) throws java.sql.SQLException {
	logger.info("ownDeletesAreVisible" + " , " + arg0 );
	boolean result = target.ownDeletesAreVisible(arg0);
	logger.info("ownDeletesAreVisible result is " + result);
	return result;
}

public boolean ownInsertsAreVisible(int arg0) throws java.sql.SQLException {
	logger.info("ownInsertsAreVisible" + " , " + arg0 );
	boolean result = target.ownInsertsAreVisible(arg0);
	logger.info("ownInsertsAreVisible result is " + result);
	return result;
}

public boolean othersUpdatesAreVisible(int arg0) throws java.sql.SQLException {
	logger.info("othersUpdatesAreVisible" + " , " + arg0 );
	boolean result = target.othersUpdatesAreVisible(arg0);
	logger.info("othersUpdatesAreVisible result is " + result);
	return result;
}

public boolean othersDeletesAreVisible(int arg0) throws java.sql.SQLException {
	logger.info("othersDeletesAreVisible" + " , " + arg0 );
	boolean result = target.othersDeletesAreVisible(arg0);
	logger.info("othersDeletesAreVisible result is " + result);
	return result;
}

public boolean othersInsertsAreVisible(int arg0) throws java.sql.SQLException {
	logger.info("othersInsertsAreVisible" + " , " + arg0 );
	boolean result = target.othersInsertsAreVisible(arg0);
	logger.info("othersInsertsAreVisible result is " + result);
	return result;
}

public boolean updatesAreDetected(int arg0) throws java.sql.SQLException {
	logger.info("updatesAreDetected" + " , " + arg0 );
	boolean result = target.updatesAreDetected(arg0);
	logger.info("updatesAreDetected result is " + result);
	return result;
}

public boolean deletesAreDetected(int arg0) throws java.sql.SQLException {
	logger.info("deletesAreDetected" + " , " + arg0 );
	boolean result = target.deletesAreDetected(arg0);
	logger.info("deletesAreDetected result is " + result);
	return result;
}

public boolean insertsAreDetected(int arg0) throws java.sql.SQLException {
	logger.info("insertsAreDetected" + " , " + arg0 );
	boolean result = target.insertsAreDetected(arg0);
	logger.info("insertsAreDetected result is " + result);
	return result;
}

public boolean supportsBatchUpdates() throws java.sql.SQLException {
	logger.info("supportsBatchUpdates");
	boolean result = target.supportsBatchUpdates();
	logger.info("supportsBatchUpdates result is " + result);
	return result;
}

public java.sql.ResultSet getUDTs(String arg0, String arg1, String arg2, int[] arg3) throws java.sql.SQLException {
	logger.info("getUDTs" + " , " + arg0  + " , " + arg1  + " , " + arg2  + " , " + arg3 );
	java.sql.ResultSet result = new LogResultSet(target.getUDTs(arg0, arg1, arg2, arg3));
	logger.info("getUDTs result is " + result);
	return result;
}

public java.sql.Connection getConnection() throws java.sql.SQLException {
	logger.info("getConnection");
	java.sql.Connection result = target.getConnection();
	logger.info("getConnection result is " + result);
	return result;
}

public boolean supportsSavepoints() throws java.sql.SQLException {
	logger.info("supportsSavepoints");
	boolean result = target.supportsSavepoints();
	logger.info("supportsSavepoints result is " + result);
	return result;
}

public boolean supportsNamedParameters() throws java.sql.SQLException {
	logger.info("supportsNamedParameters");
	boolean result = target.supportsNamedParameters();
	logger.info("supportsNamedParameters result is " + result);
	return result;
}

public boolean supportsMultipleOpenResults() throws java.sql.SQLException {
	logger.info("supportsMultipleOpenResults");
	boolean result = target.supportsMultipleOpenResults();
	logger.info("supportsMultipleOpenResults result is " + result);
	return result;
}

public boolean supportsGetGeneratedKeys() throws java.sql.SQLException {
	logger.info("supportsGetGeneratedKeys");
	boolean result = target.supportsGetGeneratedKeys();
	logger.info("supportsGetGeneratedKeys result is " + result);
	return result;
}

public java.sql.ResultSet getSuperTypes(String arg0, String arg1, String arg2) throws java.sql.SQLException {
	logger.info("getSuperTypes" + " , " + arg0  + " , " + arg1  + " , " + arg2 );
	java.sql.ResultSet result = new LogResultSet(target.getSuperTypes(arg0, arg1, arg2));
	logger.info("getSuperTypes result is " + result);
	return result;
}

public java.sql.ResultSet getSuperTables(String arg0, String arg1, String arg2) throws java.sql.SQLException {
	logger.info("getSuperTables" + " , " + arg0  + " , " + arg1  + " , " + arg2 );
	java.sql.ResultSet result = new LogResultSet(target.getSuperTables(arg0, arg1, arg2));
	logger.info("getSuperTables result is " + result);
	return result;
}

public boolean supportsResultSetHoldability(int arg0) throws java.sql.SQLException {
	logger.info("supportsResultSetHoldability" + " , " + arg0 );
	boolean result = target.supportsResultSetHoldability(arg0);
	logger.info("supportsResultSetHoldability result is " + result);
	return result;
}

public int getResultSetHoldability() throws java.sql.SQLException {
	logger.info("getResultSetHoldability");
	int result = target.getResultSetHoldability();
	logger.info("getResultSetHoldability result is " + result);
	return result;
}

public int getDatabaseMajorVersion() throws java.sql.SQLException {
	logger.info("getDatabaseMajorVersion");
	int result = target.getDatabaseMajorVersion();
	logger.info("getDatabaseMajorVersion result is " + result);
	return result;
}

public int getDatabaseMinorVersion() throws java.sql.SQLException {
	logger.info("getDatabaseMinorVersion");
	int result = target.getDatabaseMinorVersion();
	logger.info("getDatabaseMinorVersion result is " + result);
	return result;
}

public int getJDBCMajorVersion() throws java.sql.SQLException {
	logger.info("getJDBCMajorVersion");
	int result = target.getJDBCMajorVersion();
	logger.info("getJDBCMajorVersion result is " + result);
	return result;
}

public int getJDBCMinorVersion() throws java.sql.SQLException {
	logger.info("getJDBCMinorVersion");
	int result = target.getJDBCMinorVersion();
	logger.info("getJDBCMinorVersion result is " + result);
	return result;
}

public int getSQLStateType() throws java.sql.SQLException {
	logger.info("getSQLStateType");
	int result = target.getSQLStateType();
	logger.info("getSQLStateType result is " + result);
	return result;
}

public boolean locatorsUpdateCopy() throws java.sql.SQLException {
	logger.info("locatorsUpdateCopy");
	boolean result = target.locatorsUpdateCopy();
	logger.info("locatorsUpdateCopy result is " + result);
	return result;
}

public boolean supportsStatementPooling() throws java.sql.SQLException {
	logger.info("supportsStatementPooling");
	boolean result = target.supportsStatementPooling();
	logger.info("supportsStatementPooling result is " + result);
	return result;
}

public java.sql.RowIdLifetime getRowIdLifetime() throws java.sql.SQLException {
	logger.info("getRowIdLifetime");
	java.sql.RowIdLifetime result = target.getRowIdLifetime();
	logger.info("getRowIdLifetime result is " + result);
	return result;
}

public boolean supportsStoredFunctionsUsingCallSyntax() throws java.sql.SQLException {
	logger.info("supportsStoredFunctionsUsingCallSyntax");
	boolean result = target.supportsStoredFunctionsUsingCallSyntax();
	logger.info("supportsStoredFunctionsUsingCallSyntax result is " + result);
	return result;
}

public boolean autoCommitFailureClosesAllResultSets() throws java.sql.SQLException {
	logger.info("autoCommitFailureClosesAllResultSets");
	boolean result = target.autoCommitFailureClosesAllResultSets();
	logger.info("autoCommitFailureClosesAllResultSets result is " + result);
	return result;
}

public java.sql.ResultSet getClientInfoProperties() throws java.sql.SQLException {
	logger.info("getClientInfoProperties");
	java.sql.ResultSet result = new LogResultSet(target.getClientInfoProperties());
	logger.info("getClientInfoProperties result is " + result);
	return result;
}

public java.sql.ResultSet getFunctions(String arg0, String arg1, String arg2) throws java.sql.SQLException {
	logger.info("getFunctions" + " , " + arg0  + " , " + arg1  + " , " + arg2 );
	java.sql.ResultSet result = new LogResultSet(target.getFunctions(arg0, arg1, arg2));
	logger.info("getFunctions result is " + result);
	return result;
}

public java.sql.ResultSet getFunctionColumns(String arg0, String arg1, String arg2, String arg3) throws java.sql.SQLException {
	logger.info("getFunctionColumns" + " , " + arg0  + " , " + arg1  + " , " + arg2  + " , " + arg3 );
	java.sql.ResultSet result = new LogResultSet(target.getFunctionColumns(arg0, arg1, arg2, arg3));
	logger.info("getFunctionColumns result is " + result);
	return result;
}

public java.sql.ResultSet getPseudoColumns(String arg0, String arg1, String arg2, String arg3) throws java.sql.SQLException {
	logger.info("getPseudoColumns" + " , " + arg0  + " , " + arg1  + " , " + arg2  + " , " + arg3 );
	java.sql.ResultSet result = new LogResultSet(target.getPseudoColumns(arg0, arg1, arg2, arg3));
	logger.info("getPseudoColumns result is " + result);
	return result;
}

public boolean generatedKeyAlwaysReturned() throws java.sql.SQLException {
	logger.info("generatedKeyAlwaysReturned");
	boolean result = target.generatedKeyAlwaysReturned();
	logger.info("generatedKeyAlwaysReturned result is " + result);
	return result;
}

public long getMaxLogicalLobSize() throws java.sql.SQLException {
	logger.info("getMaxLogicalLobSize");
	long result = target.getMaxLogicalLobSize();
	logger.info("getMaxLogicalLobSize result is " + result);
	return result;
}

public boolean supportsRefCursors() throws java.sql.SQLException {
	logger.info("supportsRefCursors");
	boolean result = target.supportsRefCursors();
	logger.info("supportsRefCursors result is " + result);
	return result;
}

public boolean supportsSharding() throws java.sql.SQLException {
	logger.info("supportsSharding");
	boolean result = target.supportsSharding();
	logger.info("supportsSharding result is " + result);
	return result;
}

public <T> T unwrap(java.lang.Class<T> arg0) throws java.sql.SQLException {
	logger.info("unwrap" + " , " + arg0 );
	T result = target.unwrap(arg0);
	logger.info("unwrap result is " + result);
	return result;
}

public java.sql.ResultSet getAttributes(String arg0, String arg1, String arg2, String arg3) throws java.sql.SQLException {
	logger.info("getAttributes" + " , " + arg0  + " , " + arg1  + " , " + arg2  + " , " + arg3 );
	java.sql.ResultSet result = new LogResultSet(target.getAttributes(arg0, arg1, arg2, arg3));
	logger.info("getAttributes result is " + result);
	return result;
}

public boolean isReadOnly() throws java.sql.SQLException {
	logger.info("isReadOnly");
	boolean result = target.isReadOnly();
	logger.info("isReadOnly result is " + result);
	return result;
}


	
}
