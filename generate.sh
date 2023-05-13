#!/bin/bash
#curl https://github.com/LeonMue/petri/releases/download/petric_v1.0/petric.jar -o petric.jar
export PETRI_PATH=../petri/petri/target/petri-1.0-SNAPSHOT-jar-with-dependencies.jar
for f in $(find ./src/main/java/org/dhbw/ka/ml/petritest/ -name 'generate.sh'); do ./$f; done