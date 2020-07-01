package jp.mufg.sql;

import java.io.IOException;
import jp.mufg.kdbjdbc.SqlSelectToQscriptTranslator;
import org.junit.Assert;
import org.junit.Test;

public class SqlParserTest {
    private String parse(String sql) throws IOException {
        String q = new SqlSelectToQscriptTranslator(sql.replace('\'', '"')).toQscript();
        System.out.println(q);
        return q;
    }

    @Test
    public void test_select_stmt1() throws IOException {
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
    public void test_select_stmt_by_d() throws IOException {
        String q = parse("SELECT t2.d AS d FROM 'public'.'t2' 't2' GROUP BY 1");
        Assert.assertEquals("select dummy_d:d by d:d from t2", q);
    }    

}