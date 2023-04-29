#!/bin/bash
git clone git@github.com:LeonMue/petri.git || git pull
cd petri/petri && ./install.sh
cd ../../
export PETRI_PATH=petri/petri/bin/petric.jar
for f in $(find ./src/main/java/org/dhbw/ka/ml/petritest/ -name 'generate.sh'); do ./$f; done