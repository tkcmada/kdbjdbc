# kdbjdbc
JDBC driver for kdb+

(1)How to build ?
(offline case) If you are offline and cannot access maven repository, copy .m2/repository folder in this repo into your ~/.m2/ ( under ~/.m2/ )

```
cp -rp ./.m2/repository ~/.m2/
mvn compile
```

(online case) If you can access internet follow below steps.

Get kx's jdbc driver and install into local maven repo.
```
git clone https://github.com/kxSystems/kdb.git
cd kdb/c
mvn install:install-file -Dfile=jdbc.jar -DgroupId=com.kx -DartifactId=jdbc -Dversion=0.1 -Dpackaging=jar -DgeneratePom=true
#mvn dependency:copy-dependencies
mvn compile
```

How to launch q process for test ?
```
download 32bit version binary and unarchvie it on your home directory.
cd ~/q
./l32/q -p 5001
q) (and copy and paste following test data)


t2:([] name:`symbol$(); bl:`boolean$(); bt:`byte$(); x:`int$(); lg:`long$(); r:`real$(); f:`float$(); date:`date$(); z:`timestamp$(); ts:`timespan$(); c:`char$(); g:`guid$() )
`t2 insert (`abc; 1b; 0x26; 100; 1000; 1.2e; 1.5; 2015.01.01; 2015.01.01D01:02:03.001002030; 01:02:03.001002000; "a"; (1?0Ng)[0] )
`t2 insert (`def; 0b; 0x04; 104; 1004; 1.4e; 1.4; 1970.01.04; 1970.01.04D00:00:00.004000000; 05:06:07.005006007; "d"; (1?0Ng)[0] )
`t2 insert (`   ; 0b; 0x00; 0Ni;  0Nj;  0Ne;  0n;        0Nd;                           0Np; 0Nn               ; " "; 0Ng        )
meta t2
t2
select name,t,ts,c,g from t2
select x from t2 where x >= 100i, x <= 104i
select x from t2 where (x >= 100i) and (x <= 104i)
select x from t2 where x in (100i, 104i)

t3:flip `name`str`lf`lb`li!(`abc`def`ghi;("xyz"; string "x"; "");1.0 1.1 1.5; (0x00; 0x01; 0x02); (0i; 1i; 100i))
meta t3
t3

t4: ([] c1:0 1; ll:(10 20; (0Nj; 40)); lb:((0x00; 0x01); (0x00; 0x03)); li:((0i; 1i); (0Ni; 3i)); ls:(`abc`def; (` ;`def)) ; lf:(1.0 1.1; 0n 1.5); lz:((1970.01.04D00:00:00.001002003 ; 1970.01.04D00:00:00.001002003) ; (0Np ; 1970.01.04D00:00:00.001002003)); date:(2020.01.01 2020.01.02) )
meta t4
t4

MarketBooks: ([] date:2020.01.01 2020.01.02; universal_id:( (1?0Ng)[0]; (1?0Ng)[0] ); sym:`USDJPY`USDJPY; version_id:`V1`V2; bid_prices:((0n; 100.02); (200.01; 200.02)); bid_amounts:((1000000; 2000000); (3000000; 4000000) ); ask_amounts:((1000001; 2000001); (3000001; 4000001) ) )
meta MarketBooks
MarketBooks

MarketBooksNoNull: ([] universal_id:( (1?0Ng)[0]; (1?0Ng)[0] ); sym:`USDJPY`USDJPY; version_id:`V1`V2; bid_prices:((100.01; 100.02); (200.01; 200.02)); bid_amounts:((1000000; 2000000); (3000000; 4000000) ); ask_amounts:((1000001; 2000001); (3000001; 4000001) ) )
meta MarketBooksNoNull
MarketBooksNoNull

MarketBooksFunc:{ [sym;ver] select universal_id , version_id , bid_prices, bid_amounts from MarketBooks where sym = sym , version_id = ver }
MarketBooksFunc[`USDJPY;`V1]

MarketBooksFunc2:{ [date_;sym] select date, universal_id , version_id , bid_prices, bid_amounts from MarketBooks where date = date_, sym = sym }
MarketBooksFunc2[2020.01.01;`USDJPY]

MarketBooksDateFunc:{ [date_from;date_to;sym] select date, universal_id , version_id , bid_prices, bid_amounts from MarketBooks where date_from <= date , date <= date_to, sym = sym }
MarketBooksDateFunc[2020.01.01;2020.01.01;`USDJPY]


tbl1: ([] date:2020.01.01 2020.01.02; sym:`USDJPY`USDJPY; version_id:`V1`V2 )
myfunc: { [date_from;date_to] select from tbl1 where date_from <= date }

```

How to test ?
```
export JAVA_TOOL_OPTIONS="-Xmx2254m -Dlog4j.configurationFile=target/classes/log4j.xml"
mvn clean test
```

