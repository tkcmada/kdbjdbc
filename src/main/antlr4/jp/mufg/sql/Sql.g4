grammar Sql;

@header { 
//this is header
}

selectStmt
    :   'SELECT' columnNames 'FROM' tableName ('LIMIT' NUMBER)? '$'
    ;

tableName
    :   ID ('AS'? ID)?
    |   ID '.' ID ('AS'? ID)?
    ;

columnNames
    :   columnName (',' columnName)*
    ;

columnName
    :   ID ('AS' ID)?
    |   ID '.' ID ('AS' ID)?
    ;

WS
    : (' ' | '\t') -> skip
    ;

NUMBER
    : '-'? [0-9]+ ('.' [0-9])?
    ;

ID
    : ( [A-Za-z_#])  ( [A-Za-z_#$@0-9] )*
    | '"' ( [A-Za-z_#])  ( [A-Za-z_#$@0-9] )* '"'
    ;
