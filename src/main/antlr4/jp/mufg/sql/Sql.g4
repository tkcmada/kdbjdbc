grammar Sql;

@header { 
import jp.mufg.sqlutil.SqlExprs.*;
import java.util.*;
}

selectStmt
    :   'SELECT' columnNames 'FROM' table where? groupBy? having? limit? '$'
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

where returns [Expr val]
    : 'WHERE' expr { $val = $expr.val; }
    ;

groupBy
    : 'GROUP' 'BY' groupargs
    ;

having
    : 'HAVING' expr
    ;

limit
    : 'LIMIT' pint
    ;

expr returns [Expr val]
    : lhs=orExpr { $val = $lhs.val; }
    ;

orExpr returns [Expr val]
    : lhs=andExpr op=('or'|'OR') rhs=andExpr { $val = new BinaryExpr($op.text, $lhs.val, $rhs.val); }
    | lhs=andExpr { $val = $lhs.val; }
    ;

andExpr returns [Expr val]
    : lhs=eqExpr op=('and'|'AND') rhs=eqExpr { $val = new BinaryExpr($op.text, $lhs.val, $rhs.val); }
    | lhs=eqExpr { $val = $lhs.val; }
    ;

eqExpr returns [Expr val]
    : lhs=compExpr op='=' rhs=compExpr    { $val = new EqExpr($op.text, $lhs.val, $rhs.val);  }
    | lhs=compExpr op=('in'|'IN') a=args  { $val = new EqExpr($op.text, $lhs.val, $a.val); }
    | lhs=compExpr op='!=' rhs=compExpr   { $val = new BinaryExpr($op.text, $lhs.val, $rhs.val);  }
    | lhs=compExpr { $val = $lhs.val; }
    ;

compExpr returns [Expr val]
    : lhs=primaryExpr op=('>'|'<'|'<='|'>=') rhs=primaryExpr { $val = new BinaryExpr($op.text, $lhs.val, $rhs.val); }
    | lhs=primaryExpr { $val = $lhs.val; }
    ;

primaryExpr returns [Expr val]
    : e1=columnExpr    { $val = $e1.val; }
    | functionExpr     { $val = $functionExpr.val; }
    | numberExpr       { $val = $numberExpr.val; }
    | stringExpr       { $val = $stringExpr.val; }
    | '(' expr ')'     { $val = new BranketExpr($expr.val); }
    ;

functionExpr returns [FunctionCallExpr val]
    : id=name '(' args ')' { $val = new FunctionCallExpr($id.text, $args.val); }
    ;

numberExpr returns [NumberExpr val]
    : numtk=NUMBER { $val = new NumberExpr($numtk.text); }
    ;

stringExpr returns [StringExpr val]
    : str { $val = new StringExpr($str.text); }
    ;

groupargs returns [List<Integer> val]
    : { List<Integer> _args = new ArrayList<Integer>(); }
      (e1=pint { _args.add($e1.val); }
        (',' e2=pint { _args.add($e2.val); } )*
      )?
      { $val = _args; }
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

str returns [String text]
    : STR { String s = $STR.text; $text = s.substring(1, s.length()-1); } //TODO handling escape char
    ;

pint returns [int val]
    : num=NUMBER { $val = Integer.parseInt($num.text); }
    ;

WS
    : ( ' ' | '\t' | '\r' | '\n' ) -> skip
    ;

NUMBER
    : '-'? [0-9]+ ('.' [0-9])?
    ;

ID1 : ( [A-Za-z_#])  ( [A-Za-z_#$@0-9] )*;
ID2 : '"' (~('"'))* '"';

STR : '\'' (~('\''))* '\'';
