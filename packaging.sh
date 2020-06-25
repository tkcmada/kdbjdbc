#!/bin/sh

#mvn dependency:copy-dependencies -DoutputDirectory=lib
mvn clean install -DskipTests
cp -p target/kdbjdbc*.jar lib/kdb_jdbc.jar
#tar zcvf kdbjdbc.tar.gz lib
zip -r kdbjdbc.zip lib/
python base64encode.py lib/kdb_jdbc.jar > kdb_jdbc.jar.base
