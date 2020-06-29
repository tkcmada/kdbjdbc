#!/bin/sh

#mvn dependency:copy-dependencies -DoutputDirectory=lib
mvn clean install -DskipTests
cp -p target/kdbjdbc*.jar lib/kdb_jdbc.jar
#tar zcvf kdbjdbc.tar.gz lib
#zip -r kdbjdbc.zip lib/
zip -r tableau_connectors.zip tableau_connectors README.md
python base64encode.py lib/kdb_jdbc.jar > kdb_jdbc.jar.base
aws s3 cp tableau_connectors.zip s3://shimada-tmp/
aws s3 cp kdb_jdbc.jar.base s3://shimada-tmp/
