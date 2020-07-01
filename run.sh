#!/bin/sh

# setting ---------------------
mvn=mvn
java=$(which java)

# compile ---------------------
$mvn clean package

# deploy ---------------------
[ -d deploy ] && rm -rf deploy
mkdir deploy
mkdir deploy/conf
cp -r target/lib deploy
cp target/b2e_url_shortener-0.0.1-SNAPSHOT.jar deploy
cp src/main/resources/application.properties deploy/conf

# clean -------------------
$mvn clean

# run ---------------------
$java -cp deploy/b2e_url_shortener-0.0.1-SNAPSHOT.jar:deploy/conf idv.maxy.b2e_url_shortener.B2EMain


