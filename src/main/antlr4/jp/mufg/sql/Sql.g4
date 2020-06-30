grammar Sql;

@header { 
//this is header
}

selectStmt
    :   'SELECT' columnNames 'FROM' tableName groupBy? having? limit? '$'
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

groupBy
    : 'GROUP' 'BY' args
    ;

having
    : 'HAVING' expr
    ;

limit
    : ('LIMIT' NUMBER)?
    ;

expr
    : compExpr
    ;

compExpr
    : primaryExpr '>' primaryExpr
    | primaryExpr '<' primaryExpr
    | primaryExpr
    ;

primaryExpr
    : columnExpr
    | ID '(' args ')'
    | NUMBER
    | '(' expr ')' 
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
