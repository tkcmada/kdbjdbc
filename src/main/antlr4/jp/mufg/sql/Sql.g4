grammar Sql;

@header { 
//this is header
}

selectStmt
    :   'SELECT' ID
    ;


WS
    : (' ' | '\t') -> skip
    ;

NUMBER
    : '-'? [0-9]+ ('.' [0-9])?
    ;

ID
    : ([a-z] | [A-Z] | '_') ([a-z] | [A-Z] | '_' | [0-9])*
    ;
