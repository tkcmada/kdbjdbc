package jp.mufg.sql;

import java.io.IOException;
import jp.mufg.kdbjdbc.SqlToQscript;
import org.junit.Assert;
import org.junit.Test;

public class SqlParserTest {
    private String parse(String sql) throws IOException {
        String q = new SqlToQscript(sql.replace('\'', '"')).toQscript();
        System.out.println(q);
        return q;
    }

    @Test
    public void test_select_stmt1() throws IOException {
        String q = parse("SELECT 't2'.'id' AS 'id' , 't2'.'name' as 'name' FROM 'public'.'t2' 't2' LIMIT 1000");
        Assert.assertEquals("1000#select id, name from t2", q);
    }

    @Test
    public void test_select_stmt2() throws IOException {
        String q = parse("SELECT 't2'.'bl' AS 'bl' , 't2'.'c' AS 'c', SUM('t2'.'bt') AS 'sum:bt:ok' FROM 'public'.'t2' 't2' GROUP BY 1, 2");
        Assert.assertEquals("select sum bt by bl, c from t2", q);
    }

    @Test
    public void test_select_stmt3() throws IOException {
        String q = parse("SELECT 't2'.'bl' AS 'bl' , SUM('t2'.'bt') AS 'sum:bt:ok' FROM 'public'.'t2' 't2' GROUP BY 1");
        Assert.assertEquals("select sum bt by bl from t2", q);
    }

    @Test
    public void test_select_stmt4() throws IOException {
        String q = parse("SELECT SUM('t2'.'bt') AS 'sum:bt:ok' FROM 'public'.'t2' 't2' HAVING (COUNT(1) > 0)");
        Assert.assertEquals("select sum bt from t2", q);
    }

    @Test
    public void test_select_stmt5() throws IOException {
        String q = parse("SELECT 't2'.'name' AS 'name' , 't2'.'bl' as 'bl', 't2'.'bt' as 'bt', 't2'.'x' as 'x', 't2'.'lg' as 'lg', 't2'.'r' as 'r', 't2'.'f' as 'f', 't2'.'d' as 'd', 't2'.'z' as 'z', 't2'.'ts' as 'ts', 't2'.'c' as 'c', 't2'.'g' as 'g' FROM 'public'.'t2' 't2'");
        Assert.assertEquals("select name, bl, bt, x, lg, r, f, d, z, ts, c, g from t2", q);
    }

    @Test
    public void test_select_stmt5_noquote_col() throws IOException {
        String q = parse("SELECT t2.name AS name , t2.bl as bl, t2.bt as bt, t2.x as x, t2.lg as lg, t2.r as r, t2.f as f, t2.d as d, t2.z as z, t2.ts as ts, t2.c as c, t2.g as g FROM 'public'.'t2' 't2'");
        Assert.assertEquals("select name, bl, bt, x, lg, r, f, d, z, ts, c, g from t2", q);
    }    

    // @Test
    // public void test_select_stmt5_noquote_col_tbl() throws IOException {
    //     String q = parse("SELECT t2.name AS name , t2.bl as bl, t2.bt as bt, t2.x as x, t2.lg as lg, t2.r as r, t2.f as f, t2.d as d, t2.z as z, t2.ts as ts, t2.c as c, t2.g as g FROM public.t2 AS t2");
    //     Assert.assertEquals("select name, bl, bt, x, lg, r, f, d, z, ts, c, g from t2", q);
    // }    
}