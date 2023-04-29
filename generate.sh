#!/bin/bash
git clone git@github.com:LeonMue/petri.git || git pull
cd petri/petri && mvn clean package assembly:single
cd ../../
export PETRI_PATH=petri/petri/target/petri-1.0-SNAPSHOT-jar-with-dependencies.jar
for f in $(find ./src/main/java/org/dhbw/ka/ml/petritest/ -name 'generate.sh'); do ./$f; done