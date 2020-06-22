#!/bin/sh

#mvn dependency:copy-dependencies -DoutputDirectory=lib
mvn install -DskipTests
cp -p target/kdbjdbc*.jar lib/
tar zcvf kdbjdbc.tar.gz lib

