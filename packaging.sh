#!/bin/sh

#mvn dependency:copy-dependencies -DoutputDirectory=lib
mvn install -DskipTests
cp -p target/kdbjdbc*.jar lib/kdb_jdbc.jar
#tar zcvf kdbjdbc.tar.gz lib
zip -r kdbjdbc.zip lib/
