#!/bin/bash
#java -jar ../petri/petri/target/petri-1.0-SNAPSHOT-jar-with-dependencies.jar --psd-path src/test/resources/test.petri --java-out src/main/java/org/dhbw/ka/ml/petritest/ --java-package "org.dhbw.ka.ml.petritest"
#java -jar ../petri/petri/target/petri-1.0-SNAPSHOT-jar-with-dependencies.jar --psd-path src/test/resources/older_newer_version_extension.petri --java-out src/main/java/org/dhbw/ka/ml/petritest/ --java-package "org.dhbw.ka.ml.petritest"
PETRI_PATH=../petri/petri/target/petri-1.0-SNAPSHOT-jar-with-dependencies.jar
for f in $(find ./src/main/java/org/dhbw/ka/ml/petritest/ -name 'generate.sh'); do ./$f; done