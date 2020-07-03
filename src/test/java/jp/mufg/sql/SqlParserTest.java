package jp.mufg.sql;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jp.mufg.kdbjdbc.SqlSelectToQscriptTranslator;
import jp.mufg.sqlutil.SqlExprs;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class SqlParserTest {
    public static void main(String[] args) {
        JUnitCore junit = new JUnitCore();
        Result result = junit.run(SqlParserTest.class);
    }
    private String parse(String sql) throws IOException {
        return parse2(sql.replace('\'', '"'));
    }

    private String parse2(String sql) throws IOException {
        SqlSelectToQscriptTranslator t = new SqlSelectToQscriptTranslator(sql);
        HashMap<String, Character> type_by_col = new HashMap<String,Character>();
        type_by_col.put("date", 'd');
        Map<String, Map<String, Character>> type_by_col_tbl = new HashMap<String, Map<String, Character>>();
        type_by_col_tbl.put("t2", type_by_col);
        t.convertLiteralType(new SqlExprs.TypeContextImpl(type_by_col_tbl));
        String q = t.toQscript();
        System.out.println(q);
        return q;
    }

    @Test
    public void test_select_stmt1_limit() throws IOException {
        String q = parse("SELECT 't2'.'id' AS 'id' , 't2'.'name' as 'name' FROM 'public'.'t2' 't2' LIMIT 1000");
        Assert.assertEquals("1000#select id:id, name:name from t2", q);
    }

    @Test
    public void test_select_stmt2() throws IOException {
        String q = parse("SELECT 't2'.'bl' AS 'bl' , 't2'.'c' AS 'c', SUM('t2'.'bt') AS 'sum:bt:ok' FROM 'public'.'t2' 't2' GROUP BY 1, 2");
        Assert.assertEquals("select sum__bt__ok:sum bt by bl:bl, c:c from t2", q);
    }

    @Test
    public void test_select_stmt3() throws IOException {
        String q = parse("SELECT 't2'.'bl' AS 'bl' , SUM('t2'.'bt') AS 'sum:bt:ok' FROM 'public'.'t2' 't2' GROUP BY 1");
        Assert.assertEquals("select sum__bt__ok:sum bt by bl:bl from t2", q);
    }

    @Test
    public void test_select_stmt4() throws IOException {
        String q = parse("SELECT SUM('t2'.'bt') AS 'sum:bt:ok' FROM 'public'.'t2' 't2' HAVING (COUNT(1) > 0)");
        Assert.assertEquals("select sum__bt__ok:sum bt from t2", q);
    }

    @Test
    public void test_select_stmt5() throws IOException {
        String q = parse("SELECT 't2'.'name' AS 'name' , 't2'.'bl' as 'bl', 't2'.'bt' as 'bt', 't2'.'x' as 'x', 't2'.'lg' as 'lg', 't2'.'r' as 'r', 't2'.'f' as 'f', 't2'.'d' as 'd', 't2'.'z' as 'z', 't2'.'ts' as 'ts', 't2'.'c' as 'c', 't2'.'g' as 'g' FROM 'public'.'t2' 't2'");
        Assert.assertEquals("select name:name, bl:bl, bt:bt, x:x, lg:lg, r:r, f:f, d:d, z:z, ts:ts, c:c, g:g from t2", q);
    }

    @Test
    public void test_select_stmt5_noquote_col() throws IOException {
        String q = parse("SELECT t2.name AS name , t2.bl as bl, t2.bt as bt, t2.x as x, t2.lg as lg, t2.r as r, t2.f as f, t2.d as d, t2.z as z, t2.ts as ts, t2.c as c, t2.g as g FROM 'public'.'t2' 't2'");
        Assert.assertEquals("select name:name, bl:bl, bt:bt, x:x, lg:lg, r:r, f:f, d:d, z:z, ts:ts, c:c, g:g from t2", q);
    }    

    // @Test
    // public void test_select_stmt5_noquote_col_tbl() throws IOException {
    //     String q = parse("SELECT t2.name AS name , t2.bl as bl, t2.bt as bt, t2.x as x, t2.lg as lg, t2.r as r, t2.f as f, t2.d as d, t2.z as z, t2.ts as ts, t2.c as c, t2.g as g FROM public.t2 AS t2");
    //     Assert.assertEquals("select name, bl, bt, x, lg, r, f, d, z, ts, c, g from t2", q);
    // }    

    @Test
    public void test_select_stmt_group_by_where_date_equals() throws IOException {
        String q = parse2("SELECT t2.date AS date, SUM(t2.f) AS \"sum:f:ok\" FROM \"public\".\"t2\" \"t2\" WHERE t2.date = '2019-08-01' GROUP BY 1");
        Assert.assertEquals("select sum__f__ok:sum f by date:date from t2 where t2.date = 2019.08.01", q);
    }    

    @Test
    public void test_select_stmt_group_by_where_date_in_with_curry() throws IOException {
        String q = parse2("SELECT t2.date AS date, SUM(t2.f) AS \"sum:f:ok\" FROM \"public\".\"t2\" \"t2\" WHERE (t2.date in ('2019-08-01', '2019-08-02')) GROUP BY 1");
        Assert.assertEquals("select sum__f__ok:sum f by date:date from t2 where ( t2.date in (2019.08.01, 2019.08.02) )", q);
    }    

    @Test
    public void test_select_stmt_group_by_where_date_not_in() throws IOException {
        String q = parse2("SELECT t2.date AS date, SUM(t2.f) AS \"sum:f:ok\", SUM(t2.lg) AS \"sum:lg:ok\" FROM \"public\".\"t2\" \"t2\" WHERE (CASE WHEN (t2.date = '1970-01-04') THEN FALSE ELSE TRUE END) GROUP BY 1");
        // Assert.assertEquals("select sum__lg__ok:sum lg, sum__f__ok:sum f by date:date from t2 where ( t2.date in (2019.08.01, 2019.08.02) )", q);
    }    

    //SELECT "t2"."date" AS "date" FROM "public"."t2" "t2" GROUP BY 1 ORDER BY 1 ASC NULLS FIRST

    //

    @Test
    public void test_select_stmt_by_d() throws IOException {
        String q = parse("SELECT t2.d AS d FROM 'public'.'t2' 't2' GROUP BY 1");
        Assert.assertEquals("distinct select d:d from t2", q);
    }    

    @Test
    public void test_select_stmt_by_c_d() throws IOException {
        String q = parse("SELECT t2.c AS c, t2.d AS d FROM 'public'.'t2' 't2' GROUP BY 1, 2");
        Assert.assertEquals("distinct select c:c, d:d from t2", q);
    }    
}