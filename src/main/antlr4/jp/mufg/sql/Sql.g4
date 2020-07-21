grammar Sql;

@header { 
import jp.mufg.kdbjdbc.SqlExprs.*;
import java.util.*;
}

selectStmtWhole returns [SelectStatement val]
    :   selectStmt '$' { $val = $selectStmt.val; }
    ;

selectStmt returns [SelectStatement val]
    :   ('SELECT'|'select') columnNames ('FROM'|'from') table where groupBy having limit offset
        { $val = new SelectStatement(
            $columnNames.columns,
            $table.val,
            $where.val,
            $groupBy.val,
            $having.val,
            $limit.val,
            $offset.val
            );
        }
    ;

table returns [Table val]
    :            t=name 'AS' a=name { $val = new TableImpl($t.text, $a.text); }
    |            t=name      a=name { $val = new TableImpl($t.text, $a.text); }
    |            t=name             { $val = new TableImpl($t.text, null   ); }
    |   name '.' t=name 'AS' a=name { $val = new TableImpl($t.text, $a.text); }
    |   name '.' t=name      a=name { $val = new TableImpl($t.text, $a.text); }
    |   name '.' t=name             { $val = new TableImpl($t.text, null   ); }
    |   '(' selectStmt ')' 'AS' a=name { $val = new TableSelect($selectStmt.val, $a.text); }
    |   '(' selectStmt ')'      a=name { $val = new TableSelect($selectStmt.val, $a.text); }
    |   '(' selectStmt ')'             { $val = new TableSelect($selectStmt.val, null   ); }
    ;

columnNames returns [List<Column> columns]
    :   c1=columnName { $columns = new LinkedList<Column>(); $columns.add($c1.val); }
        (',' c2=columnName { $columns.add($c2.val); })*
    ;

columnName returns [Column val]
    :  expr  'AS' id=name { $val = new ColumnImpl($expr.val, $id.text); }
    |  expr               { $val = new ColumnImpl($expr.val, null); }
    |  '*'                { $val = new WildcardColumns(); }
    ;

where returns [Expr val]
    : 'WHERE' expr { $val = $expr.val; }
    |              { $val = null;      }
    ;

groupBy returns [List<GroupArg> val]
    : 'GROUP' 'BY' groupargs { $val = $groupargs.val; }
    |                        { $val = null;           }
    ;

having returns [Expr val]
    : 'HAVING' expr { $val = $expr.val; }
    |               { $val = null;      }
    ;

limit returns [Integer val]
    : 'LIMIT' pint { $val = $pint.val; }
    |              { $val = null;      }
    ;

offset returns [Integer val]
    : 'OFFSET' pint { $val = $pint.val; }
    |               { $val = null;      }
    ;

expr returns [Expr val]
    : lhs=orExpr { $val = $lhs.val; }
    ;

orExpr returns [Expr val]
    : lhs=andExpr op=('or'|'OR') rhs=andExpr { $val = new BinaryExpr($op.text, $lhs.val, $rhs.val); }
    | lhs=andExpr { $val = $lhs.val; }
    ;

andExpr returns [Expr val]
    : lhs=eqExpr op=('and'|'AND') rhs=eqExpr { $val = new AndExpr($lhs.val, $rhs.val); }
    | lhs=eqExpr { $val = $lhs.val; }
    ;

eqExpr returns [Expr val]
    : lhs=compExpr op='=' rhs=compExpr    { $val = new EqExpr($op.text, $lhs.val, $rhs.val);  }
    | lhs=compExpr op=('in'|'IN') '(' a=args ')'   { $a.val.setWithCurry(true); $val = new EqExpr($op.text, $lhs.val, $a.val);  }
    | lhs=compExpr op='!=' rhs=compExpr   { $val = new BinaryExpr($op.text, $lhs.val, $rhs.val);  }
    | lhs=compExpr { $val = $lhs.val; }
    ;

compExpr returns [Expr val]
    : lhs=addExpr op=('>'|'<'|'<='|'>=') rhs=addExpr { $val = new BinaryExpr($op.text, $lhs.val, $rhs.val); }
    | lhs=addExpr { $val = $lhs.val; }
    ;

addExpr returns [Expr val]
    : lhs=mulExpr { Expr e = $lhs.val; }
      ( op=('+'|'-') rhs=mulExpr { e = new BinaryExpr($op.text, e, $rhs.val); } )*
      { $val = e; }
    ;

mulExpr returns [Expr val]
    : lhs=unaryExpr { Expr e = $lhs.val; }
      ( op=('*'|'/') rhs=unaryExpr { e = new BinaryExpr($op.text, e, $rhs.val); } )*
      { $val = e; }
    ;

unaryExpr returns [Expr val]
    : lhs=primaryExpr        { $val = $lhs.val; }
    | op='-' rhs=primaryExpr { $val = new UnaryExpr($op.text, $rhs.val); }
    ;

primaryExpr returns [Expr val]
    : e1=columnExpr    { $val = $e1.val; }
    | functionExpr     { $val = $functionExpr.val; }
    | numberLiteral    { $val = $numberLiteral.val; }
    | stringLiteral    { $val = $stringLiteral.val; }
    | booleanLiteral   { $val = $booleanLiteral.val; }
    | dateLiteral      { $val = $dateLiteral.val; }
    | intervalLiteral  { $val = $intervalLiteral.val; }
    | caseExpr         { $val = $caseExpr.val; }
    | 'DISTINCT' expr  { $val = new DistinctExpr($expr.val); }
    | 'CAST' '(' expr 'AS' type=('INTEGER'|'DATE'|'TIMESTAMP'|'TEXT') ')' { $val = new CastExpr($expr.val, $type.text); }
    | 'EXTRACT' '(' type=('YEAR'|'QUARTER'|'MONTH'|'DAY'|'HOUR'|'MINUTE'|'SECOND') 'FROM' expr ')' { $val = new ExtractExpr($expr.val, $type.text); }
    | '(' expr ')'     { $val = new CurryExpr($expr.val); }
    ;

caseExpr returns [CaseExpr val]
    : 'CASE' wt=whenThenExpr 'ELSE' e=expr 'END' { $val = new CaseExpr(null, $wt.val, $e.val); }
    ;

whenThenExpr returns [List<WhenThen> val]
    :  'WHEN' e1=expr 'THEN' e2=expr   { $val = new LinkedList<WhenThen>(); $val.add(new WhenThen($e1.val, $e2.val)); }
      ('WHEN' e3=expr 'THEN' e4=expr { $val.add(new WhenThen($e3.val, $e4.val)); })*
    ;

functionExpr returns [FunctionCallExpr val]
    : id=name '(' args ')' { $val = new FunctionCallExpr($id.text, $args.val); }
    | tk='CURRENT_DATE'    { $val = new FunctionCallExpr($tk.text, new Arguments()); }
    ;

booleanLiteral returns [BooleanLiteral val]
    : tk=('TRUE'|'FALSE') { $val = new BooleanLiteral(Boolean.parseBoolean($tk.text)); }
    ;

numberLiteral returns [NumberLiteral val]
    : numtk=NUMBER_LITERAL { $val = new NumberLiteral($numtk.text); }
    ;

stringLiteral returns [StringLiteral val]
    : str { $val = new StringLiteral($str.text); }
    ;

dateLiteral returns [DateLiteral val]
    : 'DATE' str { $val = new DateLiteral($str.text); }
    ;

intervalLiteral returns [IntervalLiteral val]
    : 'INTERVAL' str { $val = new IntervalLiteral($str.text); }
    ;

groupargs returns [List<GroupArg> val]
    : { List<GroupArg> _args = new ArrayList<GroupArg>(); }
      ( e1=grouparg { _args.add($e1.val); }
        (',' e2=grouparg { _args.add($e2.val); } )*
      )?
      { $val = _args; }
    ;

grouparg returns [GroupArg val]
    : pint       { $val = new ColumnNumberArg($pint.val); }
    | expr       { $val = new GroupExpr($expr.val);       }
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
    : num=NUMBER_LITERAL { $val = Integer.parseInt($num.text); }
    ;

WS  : [ \t\r\n]+  -> skip;

NUMBER_LITERAL
    : '-'? [0-9]+ ('.' [0-9])?
    ;

ID1 : ( [A-Za-z_#])  ( [A-Za-z_#$@0-9] )*;
ID2 : '"' (~('"'))* '"';

STR : SQUOTA_STRING;

//fragment ID_LITERAL:                 [A-Z_$0-9]*?[A-Z_$]+?[A-Z_$0-9]*;
fragment DQUOTA_STRING:              '"' ( '\\'. | '""' | ~('"'| '\\') )* '"';
fragment SQUOTA_STRING:              '\'' ('\\'. | '\'\'' | ~('\'' | '\\'))* '\'';
