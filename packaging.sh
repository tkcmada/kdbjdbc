#!/bin/sh

date > src/main/resources/META-INF/version.txt
mvn clean install -DskipTests
cp -p target/kdbjdbc*.jar lib/kdb_jdbc.jar
rm -f  tableau_connectors.zip
zip -r tableau_connectors.zip tableau_connectors README.md
aws s3 cp tableau_connectors.zip s3://shimada-tmp/
aws s3 cp lib/kdb_jdbc.jar       s3://shimada-tmp/
#python base64encode.py lib/kdb_jdbc.jar > kdb_jdbc.jar.base
#aws s3 cp kdb_jdbc.jar.base     s3://shimada-tmp/
