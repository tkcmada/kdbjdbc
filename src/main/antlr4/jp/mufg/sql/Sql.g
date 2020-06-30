grammar Sql;

@header { 
	package jp.mufg.sql;
}

@lexer::header {
	package jp.mufg.sql;
}

greet
	:	'Hello' COMMA 'World'
    ;

COMMA
	:	',';

WS
    : (' ' | '\t') -> skip
    ;
