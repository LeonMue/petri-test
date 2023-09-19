package org.dhbw.ka.ml.petritest.eval.protobuf;

import org.dhbw.ka.ml.petrilib.io.PetriReader;
import org.dhbw.ka.ml.petritest.eval.Constants;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;

public class DeserializationEval {

    public static void main(String[] args) throws IOException {
        var toSerialize = ProductCatalogEvalDataSet.IMAGINARY.getProductCatalog();
        var serialized = toSerialize.toByteArray();
        var sizeOfSerialized = serialized.length;

        System.out.println("Protobuf message has size of " + sizeOfSerialized + " bytes.");

        System.out.println("");
        // -------------------------------------------------------------------------------------------------------------
        System.out.println("Deserializing with ByteArrayInputStream:");
        System.out.println("----------------------------------------");

        var measuredDurations = new long[Constants.NUMBER_OF_DESERIALIZATION_ITERATIONS];
        for (int i = 0; i < Constants.NUMBER_OF_DESERIALIZATION_ITERATIONS; i++) {
            var begin = System.nanoTime();
            // var serializedStream = new PetriReader(serialized);
            final var serializedStream = new ByteArrayInputStream(serialized);
            var test = ProductCatalog.parseFrom(serializedStream);
            var end = System.nanoTime();
            var duration = end - begin;
            measuredDurations[i] = duration;
        }

        var averageDuration = Arrays.stream(measuredDurations).average().getAsDouble();
        var sortedDurations = Arrays.stream(measuredDurations).sorted().toArray();
        var medianFirst = sortedDurations[(Constants.NUMBER_OF_DESERIALIZATION_ITERATIONS / 2) - 1];
        var medianSecond = sortedDurations[Constants.NUMBER_OF_DESERIALIZATION_ITERATIONS / 2];
        var medianDuration = (medianFirst + medianSecond) / 2.;
        System.out.println("Protobuf message needed " + averageDuration + " nano seconds to deserialize in average.");
        System.out.println("Median is " + medianDuration + " nano seconds per deserializing.");

        System.out.println("");
        // -------------------------------------------------------------------------------------------------------------
        System.out.println("Deserializing with PetriReader:");
        System.out.println("-------------------------------");
        for (int i = 0; i < Constants.NUMBER_OF_DESERIALIZATION_ITERATIONS; i++) {
            var begin = System.nanoTime();
            final var serializedStream = new PetriReader(serialized);
            var test = ProductCatalog.parseFrom(serializedStream);
            var end = System.nanoTime();
            var duration = end - begin;
            measuredDurations[i] = duration;
        }

        averageDuration = Arrays.stream(measuredDurations).average().getAsDouble();
        sortedDurations = Arrays.stream(measuredDurations).sorted().toArray();
        medianFirst = sortedDurations[(Constants.NUMBER_OF_DESERIALIZATION_ITERATIONS / 2) - 1];
        medianSecond = sortedDurations[Constants.NUMBER_OF_DESERIALIZATION_ITERATIONS / 2];
        medianDuration = (medianFirst + medianSecond) / 2.;
        System.out.println("Protobuf message needed " + averageDuration + " nano seconds to deserialize in average.");
        System.out.println("Median is " + medianDuration + " nano seconds per deserializing.");
    }

}
