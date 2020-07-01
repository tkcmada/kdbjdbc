grammar Sql;

@header { 
import jp.mufg.sqlutil.SqlExprs.*;
import java.util.*;
}

selectStmt
    :   'SELECT' columnNames 'FROM' table groupBy? having? limit? '$'
    ;

table returns [Table tbl]
    :            t=name 'AS' a=name { $tbl = new Table($t.text, $a.text); }
    |            t=name      a=name { $tbl = new Table($t.text, $a.text); }
    |            t=name             { $tbl = new Table($t.text, null   ); }
    |   name '.' t=name 'AS' a=name { $tbl = new Table($t.text, $a.text); }
    |   name '.' t=name      a=name { $tbl = new Table($t.text, $a.text); }
    |   name '.' t=name             { $tbl = new Table($t.text, null   ); }
    ;

columnNames returns [List<ColumnExprWithAlias> columns]
    :   c1=columnName { $columns = new LinkedList<ColumnExprWithAlias>(); $columns.add($c1.val); }
        (',' c2=columnName { $columns.add($c2.val); })*
    ;

columnName returns [ColumnExprWithAlias val]
    :  expr  'AS' id=name { $val = new ColumnExprWithAlias($expr.val, $id.text); }
    |  expr               { $val = new ColumnExprWithAlias($expr.val, null); }
    ;

groupBy
    : 'GROUP' 'BY' args
    ;

having
    : 'HAVING' expr
    ;

limit
    : 'LIMIT' NUMBER
    ;

expr returns [Expr val]
    : compExpr { $val = $compExpr.val; }
    ;

compExpr returns [Expr val]
    : lhs=primaryExpr op=('>'|'<') rhs=primaryExpr { $val = new BinaryExpr($op.text, $lhs.val, $rhs.val); }
    | lhs=primaryExpr { $val = $lhs.val; }
    ;

primaryExpr returns [Expr val]
    : e1=columnExpr    { $val = $e1.val; }
    | functionExpr     { $val = $functionExpr.val; }
    | numberExpr       { $val = $numberExpr.val; }
    | '(' expr ')'     { $val = new BranketExpr($expr.val); }
    ;

functionExpr returns [FunctionCallExpr val]
    : id=name '(' args ')' { $val = new FunctionCallExpr($id.text, $args.val); }
    ;

numberExpr returns [NumberExpr val]
    : numtk=NUMBER { $val = new NumberExpr($numtk.text); }
    ;

args returns [Arguments val]
    : { List<Expr> _args = new ArrayList<Expr>(); }
      (e1=expr { _args.add($e1.val); }
        (',' e2=expr { _args.add($e2.val); } )*
      )?
      { $val = new Arguments(_args); }
    ;

columnExpr returns [ColumnExpr val]
    :                id2=name { $val = new ColumnExpr(null,      $id2.text); }
    |   id1=name '.' id2=name { $val = new ColumnExpr($id1.text, $id2.text); }
    ;

//https://stackoverflow.com/questions/17897651/antlrv4-how-to-read-double-quote-escaped-double-quotes-in-string
//https://stackoverflow.com/questions/37525542/changing-text-of-rule-in-antlr4-using-settext
name returns [String text]
    :ID1 { $text = $ID1.text; }
    |ID2 { String s = $ID2.text; $text = s.substring(1, s.length()-1); }
    ;


WS
    : ( ' ' | '\t' | '\r' | '\n' ) -> skip
    ;

NUMBER
    : '-'? [0-9]+ ('.' [0-9])?
    ;

ID1 : ( [A-Za-z_#])  ( [A-Za-z_#$@0-9] )*;
ID2 : '"' (~('"'))* '"';

