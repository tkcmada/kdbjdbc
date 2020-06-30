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
    :  expr  ('AS' ID)?
    ;

expr
    : columnExpr
    | ID '(' args ')'
    ;

args
    : (expr (',' expr)*)?
    ;

columnExpr
    :   ID
    |   ID '.' ID
    ;

WS
    : (' ' | '\t') -> skip
    ;

NUMBER
    : '-'? [0-9]+ ('.' [0-9])?
    ;

ID
    : ( [A-Za-z_#])  ( [A-Za-z_#$@0-9] )*
    | '"' (~('"'))* '"'
    ;
