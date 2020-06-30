grammar Sql;

@header { 
import jp.mufg.sqlutil.SqlExprs.*;
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

columnName returns [ColumnExprWithAlias val]
    :  expr  'AS' ID { $val = new ColumnExprWithAlias($expr.val, $ID.text); }
    |  expr          { $val = new ColumnExprWithAlias($expr.val, null); }
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
    : lhs=primaryExpr '>' rhs=primaryExpr { $val = new BinaryExpr(">", $lhs.val, $rhs.val); }
    | lhs=primaryExpr '<' rhs=primaryExpr { $val = new BinaryExpr("<", $lhs.val, $rhs.val); }
    | lhs=primaryExpr { $val = $lhs.val; }
    ;

primaryExpr returns [Expr val]
    : e1=columnExpr    { $val = $e1.val; }
    | functionExpr     { $val = $functionExpr.val; }
    | numberExpr       { $val = $numberExpr.val; }
    | '(' expr ')'     { $val = new BranketExpr($expr.val); }
    ;

functionExpr returns [FunctionCallExpr val]
    : ID '(' args ')' { $val = new FunctionCallExpr($ID.text, null); }
    ;

numberExpr returns [NumberExpr val]
    : numtk=NUMBER { $val = new NumberExpr($numtk.text); }
    ;

//args returns [Arguments rtn]
//    : args1 {
//        List<Expr> _args = new ArrayList<Expr>();
//        int i = 0;
//        while(arg1.getChild(Args1Context.class, i) != null) {
//            _args.add(arg1.getChild(ExprContext.class, i))
//        }
//        $rtn = new Arguments(_args); 
//    }
//    ;

args
    : (expr (',' expr)*)?
    ;

columnExpr returns [ColumnExpr val]
    :   ID                { $val = new ColumnExpr(null,      $ID.text); }
    |   id1=ID '.' id2=ID { $val = new ColumnExpr($id1.text, $id2.text); }
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
