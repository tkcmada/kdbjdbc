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
        type_by_col.put("c"   , 'c');
        type_by_col.put("g"   , 'g');
        type_by_col.put("name", 's');
        // type_by_col.put("ts"  , 'p');
        type_by_col.put("z"   , 'p');
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
    public void test_select_stmt_group_by_where_char_equals() throws IOException {
        String q = parse2("SELECT t2.c AS c, SUM(t2.f) AS \"sum:f:ok\" FROM \"public\".\"t2\" \"t2\" WHERE (t2.c = 'a') GROUP BY 1");
        Assert.assertEquals("select sum__f__ok:sum f by c:c from t2 where ( t2.c = \"a\" )", q);
    }    

    @Test
    public void test_select_stmt_group_by_where_guid_equals() throws IOException {
        String q = parse2("SELECT t2.g AS g, SUM(t2.lg) AS \"sum:lg:ok\" FROM \"public\".\"t2\" \"t2\" WHERE (t2.g = '8c6b8b64-6815-6084-0a3e-178401251b68') GROUP BY 1");
        Assert.assertEquals("select sum__lg__ok:sum lg by g:g from t2 where ( t2.g = \"G\"$\"8c6b8b64-6815-6084-0a3e-178401251b68\" )", q);
    }    

    @Test
    public void test_select_stmt_group_by_where_symbol_equals() throws IOException {
        String q = parse2("SELECT t2.name AS name, SUM(t2.r) AS \"sum:r:ok\" FROM \"public\".\"t2\" \"t2\" WHERE (t2.name = 'def') GROUP BY 1");
        Assert.assertEquals("select sum__r__ok:sum r by name:name from t2 where ( t2.name = `def )", q);
    }    

    @Test
    public void test_select_stmt_group_by_where_timestamp_equals() throws IOException {
        String q = parse2("SELECT SUM(t2.f) AS \"sum:f:ok\", t2.z AS z FROM \"public\".\"t2\" \"t2\" WHERE (t2.z = '2015.01.01D01:02:03.001002030') GROUP BY 2");
        Assert.assertEquals("select sum__f__ok:sum f by z:z from t2 where ( t2.z = 2015.01.01D01:02:03.001002030 )", q);
    }    

    // @Test
    // public void test_select_stmt_group_by_where_symbol_equals() throws IOException {
    //     String q = parse2("SELECT SUM(t2.r) AS \"sum:r:ok\", t2.ts AS ts FROM \"public\".\"t2\" \"t2\" WHERE (t2.ts = '01:02:03.001002000') GROUP BY 2");
    //     Assert.assertEquals("select sum__r__ok:sum r by name:name from t2 where ( t2.name = `def )", q);
    // }    

    // sql=
    // select sum__r__ok:sum r by ts:ts from t2 where ( t2.ts = '01:02:03.001002000' )
    
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
        String q = parse2("SELECT t2.date AS date, SUM(t2.f) AS \"sum:f:ok\", SUM(t2.lg) AS \"sum:lg:ok\" FROM \"public\".\"t2\" \"t2\" WHERE (CASE WHEN (t2.date = '1970-01-04') THEN FALSE WHEN (t2.date = '1970-01-05') THEN FALSE ELSE TRUE END) GROUP BY 1");
        Assert.assertEquals("select sum__f__ok:sum f, sum__lg__ok:sum lg by date:date from t2 where ( not (date in (1970.01.04; 1970.01.05)) )", q);
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

    @Test
    public void test_select_stmt_timestamp_year() throws IOException {
        String q = parse("SELECT CAST(TRUNC(EXTRACT(YEAR FROM t2.z)) AS INTEGER) AS \"yr:z:ok\" FROM \"public\".\"t2\" \"t2\" GROUP BY 1");
        Assert.assertEquals("distinct select yr__z__ok:`int$(`year$(z)) from t2", q);
    }
}