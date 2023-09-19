#!/bin/bash

mvn clean package assembly:single
mv target/petri-test-1.0-SNAPSHOT-jar-with-dependencies.jar target/petri-test.jar
#BIN_PATH=target/petri-test-1.0-SNAPSHOT-jar-with-dependencies.jar
BIN_PATH=target/petri-test.jar

#echo "-------------------------------------------------------------------------"
#echo "download petri-test.jar to $BIN_PATH"
#echo "-------------------------------------------------------------------------"
#curl https://github.com/LeonMue/petri-test/releases/download/petri-testv1.0/petri-test-1.0-SNAPSHOT.jar --output $BIN_PATH

echo "-------------------------------------------------------------------------"
echo "Execute Evaluation-Test"
echo "-------------------------------------------------------------------------"

echo "-------------------------------------------------------------------------"
echo "Execute src/main/java/org/dhbw/ka/ml/petritest/eval/protobuf/SerializationEval.java"
echo "-------------------------------------------------------------------------"
java -cp $BIN_PATH org.dhbw.ka.ml.petritest.eval.protobuf.SerializationEval

echo "-------------------------------------------------------------------------"
echo "Execute src/main/java/org/dhbw/ka/ml/petritest/eval/protobuf/DeserializationEval.java"
echo "-------------------------------------------------------------------------"
java -cp $BIN_PATH org.dhbw.ka.ml.petritest.eval.protobuf.DeserializationEval

echo "-------------------------------------------------------------------------"
echo "Execute src/main/java/org/dhbw/ka/ml/petritest/eval/petri/SerializationEval.java"
echo "-------------------------------------------------------------------------"
java -cp $BIN_PATH org.dhbw.ka.ml.petritest.eval.petri.SerializationEval

echo "-------------------------------------------------------------------------"
echo "Execute src/main/java/org/dhbw/ka/ml/petritest/eval/petri/DeserializationEval.java"
echo "-------------------------------------------------------------------------"
java -cp $BIN_PATH org.dhbw.ka.ml.petritest.eval.petri.DeserializationEval

echo "-------------------------------------------------------------------------"
echo "Execute src/main/java/org/dhbw/ka/ml/petritest/eval/ReaderEval.java"
echo "-------------------------------------------------------------------------"
java -cp $BIN_PATH org.dhbw.ka.ml.petritest.eval.ReaderEval

echo "-------------------------------------------------------------------------"
echo "Execute src/main/java/org/dhbw/ka/ml/petritest/eval/WriterEval.java"
echo "-------------------------------------------------------------------------"
java -cp $BIN_PATH org.dhbw.ka.ml.petritest.eval.WriterEval
