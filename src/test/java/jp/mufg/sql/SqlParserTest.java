package jp.mufg.sql;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jp.mufg.kdbjdbc.SqlSelectToQscriptTranslator;
import jp.mufg.kdbjdbc.SqlExprs;

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
        Map<String, Map<String, Character>> type_by_col_tbl = new HashMap<String, Map<String, Character>>();
        // for t2
        HashMap<String, Character> type_by_col = new HashMap<String,Character>();
        type_by_col.put("date", 'd');
        type_by_col.put("otherdate", 'd');
        type_by_col.put("c"   , 'c');
        type_by_col.put("g"   , 'g');
        type_by_col.put("x"   , 'i');
        type_by_col.put("name", 's');
        type_by_col.put("ts"  , 'n');
        type_by_col.put("z"   , 'p');
        type_by_col_tbl.put("t2", type_by_col);
        // for t3
        type_by_col = new HashMap<String,Character>();
        type_by_col.put("str" , 'C');
        type_by_col_tbl.put("t3", type_by_col);
        // for (select  from MarketBooksFunc[`USDJPY;`V1])
        type_by_col = new HashMap<String,Character>();
        type_by_col.put("date"        , 'd');
        type_by_col.put("universal_id", 'g');
        type_by_col.put("version_id"  , 's');
        type_by_col.put("bid_prices"  , 'F');
        type_by_col.put("bid_amounts" , 'J');
        type_by_col_tbl.put("(select  from MarketBooksFunc[`USDJPY;`V1])", type_by_col);
        // for (select  from MarketBooksDateFunc[ 2020.01.01 ; 2020.01.01 ;`USDJPY])
        type_by_col = new HashMap<String,Character>();
        type_by_col.put("date"        , 'd');
        type_by_col.put("universal_id", 'g');
        type_by_col.put("version_id"  , 's');
        type_by_col.put("bid_prices"  , 'F');
        type_by_col.put("bid_amounts" , 'J');
        type_by_col_tbl.put("(select  from MarketBooksDateFunc[ 2020.01.01 ; 2020.01.01 ;`USDJPY])", type_by_col);

        t.convertLiteralType(new SqlExprs.TypeContextImpl(type_by_col_tbl));
        String q = t.toQscript();
        System.out.println(q);
        return q;
    }

    @Test
    public void test_select_stmt1_limit() throws IOException {
        String q = parse("SELECT 't2'.'id' AS 'id' , 't2'.'name' as 'name' FROM 'public'.'t2' 't2' LIMIT 1000");
        Assert.assertEquals("(min(1000,count(select id:id, name:name from t2)))#select id:id, name:name from t2", q);
    }

    @Test
    public void test_select_stmt1_limit_offset() throws IOException {
        String q = parse("SELECT 't2'.'id' AS 'id' , 't2'.'name' as 'name' FROM 'public'.'t2' 't2' LIMIT 1000 OFFSET 2000");
        Assert.assertEquals("select [2000,1000] from (min(3000,count(select id:id, name:name from t2)))#select id:id, name:name from t2", q);
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

    @Test
    public void test_select_stmt_cast_date_to_timestamp() throws IOException {
        String q = parse("SELECT CAST(t2.date AS TIMESTAMP) AS ts FROM 'public'.'t2' 't2'");
        Assert.assertEquals("select ts:(`timestamp$(date)) from t2", q);
    }

    @Test
    public void test_select_stmt_cast_to_timestamp() throws IOException {
        String q = parse("SELECT CAST(t2.date AS TEXT) AS ts FROM 'public'.'t2' 't2'");
        Assert.assertEquals("select ts:string(date) from t2", q);
    }

    // @Test
    // public void test_select_stmt_date_to_timestamp_and_trunc() throws IOException {
    //     String q = parse("SELECT DATE_TRUNC('DAY', CAST(t2.date AS TIMESTAMP)) AS ts FROM 'public'.'t2' 't2'");
    //     Assert.assertEquals("select ts:date from t2", q);
    // }

    @Test
    public void test_select_stmt_group_by_count_distinct() throws IOException {
        String q = parse("SELECT COUNT(DISTINCT 't2'.'bl') AS 'ctd:bl:ok', 't2'.'bl' AS 'bl' FROM 'public'.'t2' 't2' GROUP BY 2");
        Assert.assertEquals("select ctd__bl__ok:count distinct bl by bl:bl from t2", q);
    }    

    @Test
    public void test_select_stmt_group_by_stddev() throws IOException {
        String q = parse("SELECT STDDEV('t2'.'bl') AS 'ctd:bl:ok', 't2'.'bl' AS 'bl' FROM 'public'.'t2' 't2' GROUP BY 2");
        Assert.assertEquals("select ctd__bl__ok:dev bl by bl:bl from t2", q);
    }    

    @Test
    public void test_select_stmt_group_by_variance() throws IOException {
        String q = parse("SELECT VARIANCE('t2'.'bl') AS 'ctd:bl:ok', 't2'.'bl' AS 'bl' FROM 'public'.'t2' 't2' GROUP BY 2");
        Assert.assertEquals("select ctd__bl__ok:(dev bl) xexp 2 by bl:bl from t2", q);
    }    

    @Test
    public void test_select_stmt_group_by_where_char_equals() throws IOException {
        String q = parse2("SELECT t2.c AS c, SUM(t2.f) AS \"sum:f:ok\" FROM \"public\".\"t2\" \"t2\" WHERE (t2.c = 'a') GROUP BY 1");
        Assert.assertEquals("select sum__f__ok:sum f by c:c from t2 where c = \"a\"", q);
    }    

    @Test
    public void test_select_stmt_group_by_where_guid_equals() throws IOException {
        String q = parse2("SELECT t2.g AS g, SUM(t2.lg) AS \"sum:lg:ok\" FROM \"public\".\"t2\" \"t2\" WHERE (t2.g = '8c6b8b64-6815-6084-0a3e-178401251b68') GROUP BY 1");
        Assert.assertEquals("select sum__lg__ok:sum lg by g:g from t2 where g = \"G\"$\"8c6b8b64-6815-6084-0a3e-178401251b68\"", q);
    }    

    @Test
    public void test_select_stmt_group_by_where_symbol_equals() throws IOException {
        String q = parse2("SELECT t2.name AS name, SUM(t2.r) AS \"sum:r:ok\" FROM \"public\".\"t2\" \"t2\" WHERE (t2.name = 'def') GROUP BY 1");
        Assert.assertEquals("select sum__r__ok:sum r by name:name from t2 where name = `def", q);
    }    

    @Test
    public void test_select_stmt_group_by_where_string1_equals() throws IOException {
        String q = parse2("SELECT SUM(1) AS \"cnt:t3:ok\", t3.str AS str FROM \"public\".\"t3\" \"t3\" WHERE (t3.str = 'x') GROUP BY 2");
        Assert.assertEquals("select cnt__t3__ok:sum 1 by str:str from t3 where str like string \"x\"", q);
    }    

    @Test
    public void test_select_stmt_group_by_where_string2_equals() throws IOException {
        String q = parse2("SELECT SUM(1) AS \"cnt:t3:ok\", t3.str AS str FROM \"public\".\"t3\" \"t3\" WHERE (t3.str = 'xyz') GROUP BY 2");
        Assert.assertEquals("select cnt__t3__ok:sum 1 by str:str from t3 where str like \"xyz\"", q);
    }    

    @Test
    public void test_select_stmt_group_by_where_int_equals() throws IOException {
        String q = parse("SELECT SUM('t2'.'f') AS 'sum:f:ok', 100 AS 'x' FROM 'public'.'t2' 't2' WHERE ('t2'.'x' = 100) GROUP BY 't2'.'x'");
        Assert.assertEquals("select sum__f__ok:sum f, x:100 by dummy_0:x from t2 where x = 100", q);
    }    

    @Test
    public void test_select_stmt_group_by_where_timestamp_equals() throws IOException {
        String q = parse2("SELECT SUM(t2.f) AS \"sum:f:ok\", t2.z AS z FROM \"public\".\"t2\" \"t2\" WHERE (t2.z = '2015.01.01D01:02:03.001002030') GROUP BY 2");
        Assert.assertEquals("select sum__f__ok:sum f by z:z from t2 where z = 2015.01.01D01:02:03.001002030", q);
    }    

    @Test
    public void test_select_stmt_group_by_where_timespan_equals() throws IOException {
        String q = parse2("SELECT SUM(t2.f) AS \"sum:f:ok\", t2.ts AS ts FROM \"public\".\"t2\" \"t2\" WHERE (t2.ts = '01:02:03.001002000') GROUP BY 2");
        Assert.assertEquals("select sum__f__ok:sum f by ts:ts from t2 where ts = 01:02:03.001002000", q);
    }    

    @Test
    public void test_select_stmt_group_by_where_date_equals() throws IOException {
        String q = parse2("SELECT t2.date AS date, SUM(t2.f) AS \"sum:f:ok\" FROM \"public\".\"t2\" \"t2\" WHERE t2.date = '2019-08-01' GROUP BY 1");
        Assert.assertEquals("select sum__f__ok:sum f by date:date from t2 where date = 2019.08.01", q);
    }    

    @Test
    public void test_select_stmt_group_by_where_date_in_with_curry() throws IOException {
        String q = parse2("SELECT t2.date AS date, SUM(t2.f) AS \"sum:f:ok\" FROM \"public\".\"t2\" \"t2\" WHERE (t2.date in ('2019-08-01', '2019-08-02')) GROUP BY 1");
        Assert.assertEquals("select sum__f__ok:sum f by date:date from t2 where date in (2019.08.01, 2019.08.02)", q);
    }    

    @Test
    public void test_select_stmt_group_by_where_and_date_equals() throws IOException {
        String q = parse2("SELECT t2.date AS date, SUM(t2.f) AS \"sum:f:ok\" FROM \"public\".\"t2\" \"t2\" WHERE ((t2.name = 'abc') AND (t2.date = '2019-08-01')) GROUP BY 1");
        Assert.assertEquals("select sum__f__ok:sum f by date:date from t2 where (date = 2019.08.01), (name = `abc)", q);
    }    

    @Test
    public void test_select_stmt_group_by_where_and_date_equals_as_date_literal() throws IOException {
        String q = parse2("SELECT t2.date AS date, SUM(t2.f) AS \"sum:f:ok\" FROM \"public\".\"t2\" \"t2\" WHERE (t2.date = DATE '2019-08-01') GROUP BY 1");
        Assert.assertEquals("select sum__f__ok:sum f by date:date from t2 where date = 2019.08.01", q);
    }    

    @Test
    public void test_select_stmt_group_by_where_and_date_gt_as_date_literal() throws IOException {
        String q = parse2("SELECT t2.date AS date, SUM(t2.f) AS \"sum:f:ok\" FROM \"public\".\"t2\" \"t2\" WHERE (t2.date >= DATE '2019-08-01') GROUP BY 1");
        Assert.assertEquals("select sum__f__ok:sum f by date:date from t2 where date >= 2019.08.01", q);
    }    

    @Test
    public void test_select_stmt_group_by_where_and_otherdate_equals() throws IOException {
        String q = parse2("SELECT t2.date AS date, SUM(t2.f) AS \"sum:f:ok\" FROM \"public\".\"t2\" \"t2\" WHERE ((t2.name = 'abc') AND (t2.otherdate = '2019-08-01')) GROUP BY 1");
        Assert.assertEquals("select sum__f__ok:sum f by date:date from t2 where (name = `abc), (otherdate = 2019.08.01)", q);
    }    

    @Test
    public void test_select_stmt_group_by_where_and_date_in() throws IOException {
        String q = parse2("SELECT t2.date AS date, SUM(t2.f) AS \"sum:f:ok\" FROM \"public\".\"t2\" \"t2\" WHERE t2.name = 'abc' AND t2.date IN ('2019-08-01','2019-08-02') GROUP BY 1");
        Assert.assertEquals("select sum__f__ok:sum f by date:date from t2 where (date in (2019.08.01, 2019.08.02)), (name = `abc)", q);
    }    

    @Test
    public void test_select_stmt_group_by_where_date_not_in_case() throws IOException {
        String q = parse2("SELECT t2.date AS date, SUM(t2.f) AS \"sum:f:ok\", SUM(t2.lg) AS \"sum:lg:ok\" FROM \"public\".\"t2\" \"t2\" WHERE (CASE WHEN (t2.date = '1970-01-04') THEN FALSE WHEN (t2.date = '1970-01-05') THEN FALSE ELSE TRUE END) GROUP BY 1");
        Assert.assertEquals("select sum__f__ok:sum f, sum__lg__ok:sum lg by date:date from t2 where not (date in (1970.01.04; 1970.01.05))", q);
    }    

    @Test
    public void test_select_stmt_group_by_where_generic_case() throws IOException {
        String q = parse2("SELECT t2.date AS date, SUM(t2.f) AS \"sum:f:ok\", SUM(t2.lg) AS \"sum:lg:ok\" FROM \"public\".\"t2\" \"t2\" WHERE (CASE WHEN (t2.date = '1970-01-04' or t2.date = '1970-01-03') THEN FALSE WHEN (t2.date = '1970-01-05') THEN FALSE ELSE TRUE END) GROUP BY 1");
        Assert.assertEquals("select sum__f__ok:sum f, sum__lg__ok:sum lg by date:date from t2 where $[((t2.date = 1970.01.04) or (t2.date = 1970.01.03));0x00;(t2.date = 1970.01.05);0x00;0x01]", q);
    }    

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
        Assert.assertEquals("distinct select yr__z__ok:(`int$(`year$(z))) from t2", q);
    }

    @Test
    public void test_select_stmt_timestamp_year_quater() throws IOException {
        String q = parse("SELECT CAST(TRUNC(EXTRACT(QUARTER FROM 't2'.'z')) AS INTEGER) AS 'qr:z:ok', CAST(TRUNC(EXTRACT(YEAR FROM 't2'.'z')) AS INTEGER) AS 'yr:z:ok' FROM 'public'.'t2' 't2' GROUP BY 1, 2");
        Assert.assertEquals("distinct select qr__z__ok:(`int$(`int$floor((2+(`mm$(z)))%3))), yr__z__ok:(`int$(`year$(z))) from t2", q);
    }

    @Test
    public void test_select_stmt_timestamp_year_month() throws IOException {
        String q = parse("SELECT CAST(TRUNC(EXTRACT(MONTH FROM t2.z)) AS INTEGER) AS 'mn:z:ok', CAST(TRUNC(EXTRACT(YEAR FROM t2.z)) AS INTEGER) AS 'yr:z:ok' FROM 'public'.'t2' 't2' GROUP BY 1, 2");
        Assert.assertEquals("distinct select mn__z__ok:(`int$(`mm$(z))), yr__z__ok:(`int$(`year$(z))) from t2", q);
    }

    @Test
    public void test_select_stmt_func_subquery() throws IOException {
        String q = parse("SELECT * FROM (SELECT * FROM \"public\".\"MarketBooksFunc[`USDJPY;`V1]\") \"TableauSQL\" WHERE (0 = 1)");
        Assert.assertEquals("select  from (1#select  from MarketBooksFunc[`USDJPY;`V1])", q);
    }

    @Test
    public void test_select_stmt_func_subquery2() throws IOException {
        String q = parse("SELECT * FROM (SELECT * FROM public.\"MarketBooksFunc[`USDJPY;`V1]\") \"カスタム SQL クエリー\" WHERE (0 = 1)");
        Assert.assertEquals("select  from (1#select  from MarketBooksFunc[`USDJPY;`V1])", q);
    }

    @Test
    public void test_select_stmt_func_subquery_where_current_date() throws IOException {
        String q = parse("SELECT * FROM (SELECT * FROM public.\"MarketBooksFunc[`USDJPY;`V1]\") \"カスタム SQL クエリー\" WHERE (\"カスタム SQL クエリー\".date = CURRENT_DATE)");
        Assert.assertEquals("select  from (select  from MarketBooksFunc[`USDJPY;`V1]) where date = .z.D", q);
    }

    @Test
    public void test_select_stmt_func_subquery_where_unary() throws IOException {
        String q = parse("SELECT * FROM (SELECT * FROM public.\"MarketBooksFunc[`USDJPY;`V1]\") \"カスタム SQL クエリー\" WHERE (\"カスタム SQL クエリー\".date = -CURRENT_DATE + -2 * 1)");
        Assert.assertEquals("select  from (select  from MarketBooksFunc[`USDJPY;`V1]) where date = - .z.D + -2 * 1", q);
    }

    @Test
    public void test_select_stmt_func_subquery_where_current_date_interval() throws IOException {
        String q = parse2("SELECT * FROM (SELECT * FROM public.\"MarketBooksFunc[`USDJPY;`V1]\") \"カスタム SQL クエリー\" WHERE ((\"カスタム SQL クエリー\".date >= CURRENT_DATE + -2 * INTERVAL '1 DAY') AND (\"カスタム SQL クエリー\".date < CURRENT_DATE + 1 * INTERVAL '1 DAY'))");
        Assert.assertEquals("select  from (select  from MarketBooksFunc[`USDJPY;`V1]) where (date >= .z.D + -2 * 1), (date < .z.D + 1 * 1)", q);
    }

    @Test
    public void test_select_stmt_func_subquery_where_current_date_interval_pushdown() throws IOException {
        String q = parse2("SELECT * FROM (SELECT * FROM public.\"MarketBooksDateFunc[ 2020.01.01 ; 2020.01.01 ;`USDJPY]\") \"カスタム SQL クエリー\" WHERE ((\"カスタム SQL クエリー\".date >= (CURRENT_DATE + -2 * INTERVAL '1 DAY')) AND (\"カスタム SQL クエリー\".date <= CURRENT_DATE + 1 * INTERVAL '1 DAY'))");
        Assert.assertEquals("select  from (select  from MarketBooksDateFunc[.z.D + -2 * 1;.z.D + 1 * 1;`USDJPY]) where (date >= ( .z.D + -2 * 1 )), (date <= .z.D + 1 * 1)", q);
    }

    @Test
    public void test_select_stmt_func_subquery_where_current_date_interval_pushdown2() throws IOException {
        String q = parse2("SELECT * FROM (SELECT * FROM public.\"MarketBooksDateFunc[ 2020.01.01 ; 2020.01.01 ;`USDJPY]\") \"カスタム SQL クエリー\" WHERE ((\"カスタム SQL クエリー\".date > (CURRENT_DATE + -2 * INTERVAL '1 DAY')) AND (\"カスタム SQL クエリー\".date < CURRENT_DATE + 1 * INTERVAL '1 DAY'))");
        Assert.assertEquals("select  from (select  from MarketBooksDateFunc[(.z.D + -2 * 1) + 1;(.z.D + 1 * 1) - 1;`USDJPY]) where (date > ( .z.D + -2 * 1 )), (date < .z.D + 1 * 1)", q);
    }

    @Test
    public void test_select_stmt_func_subquery_where_current_date_equals_pushdown3() throws IOException {
        String q = parse2("SELECT * FROM (SELECT * FROM public.\"MarketBooksDateFunc[ 2020.01.01 ; 2020.01.01 ;`USDJPY]\") \"カスタム SQL クエリー\" WHERE \"カスタム SQL クエリー\".date = CURRENT_DATE + -2 * INTERVAL '1 DAY'");
        Assert.assertEquals("select  from (select  from MarketBooksDateFunc[.z.D + -2 * 1;.z.D + -2 * 1;`USDJPY]) where date = .z.D + -2 * 1", q);
    }

    @Test
    public void test_select_stmt_func_subquery_where_current_date_equals_pushdown4() throws IOException {
        String q = parse2("SELECT * FROM (SELECT * FROM public.\"MarketBooksDateFunc[ 2020.01.01 ; 2020.01.01 ;`USDJPY]\") \"カスタム SQL クエリー\" WHERE \"カスタム SQL クエリー\".date = (DATE '1999-01-01')");
        Assert.assertEquals("select  from (select  from MarketBooksDateFunc[1999.01.01;1999.01.01;`USDJPY]) where date = ( 1999.01.01 )", q);
    }

    @Test
    public void test_select_stmt_func_subquery2_date_cast() throws IOException {
        String q = parse("SELECT CAST(\"カスタム SQL クエリー\".date AS DATE) AS date, \"カスタム SQL クエリー\".version_id AS version_id FROM (SELECT * FROM public.\"MarketBooksFunc2[2020.01.01;`USDJPY]\") \"カスタム SQL クエリー\" ");
        Assert.assertEquals("select date:(`date$(date)), version_id:version_id from (select  from MarketBooksFunc2[2020.01.01;`USDJPY])", q);
    }

    @Test
    public void test_select_stmt_func_cnt() throws IOException {
        String q = parse2("SELECT SUM(1) AS \"cnt:CustomSQL_74E37922F46A4521AB1810425A001810:ok\", \"Custom SQL Query\".\"universal_id\" AS \"universal_id\", \"Custom SQL Query\".\"version_id\" AS \"version_id\" FROM ( SELECT * FROM public.\"MarketBooksFunc[`USDJPY;`V1]\" ) \"Custom SQL Query\" WHERE (\"Custom SQL Query\".\"version_id\" = 'V1') GROUP BY 2, 3");
        Assert.assertEquals("select cnt__CustomSQL_74E37922F46A4521AB1810425A001810__ok:sum 1 by universal_id:universal_id, version_id:version_id from (select  from MarketBooksFunc[`USDJPY;`V1]) where version_id = `V1", q);
    }

    // 

    
    //remaining issues
    
    //Edit Filter cause this SQL
    //SELECT "t2"."date" AS "date" FROM "public"."t2" "t2" GROUP BY 1 ORDER BY 1 ASC NULLS FIRST

}