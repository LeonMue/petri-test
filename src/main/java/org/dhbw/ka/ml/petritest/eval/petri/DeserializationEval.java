package org.dhbw.ka.ml.petritest.eval.petri;

import org.dhbw.ka.ml.petritest.eval.Constants;

import java.util.Arrays;

public class DeserializationEval {

    public static void main(String[] args) {
        var toSerialize = ProductCatalogEvalDataSet.IMAGINARY.getProductCatalog();
        var serialized = toSerialize.serialize();
        var sizeOfSerialized = serialized.length;

        System.out.println("Petri message has size of " + sizeOfSerialized + " bytes.");

        var measuredDurations = new long[Constants.NUMBER_OF_DESERIALIZATION_ITERATIONS];
        for (int i = 0; i < Constants.NUMBER_OF_DESERIALIZATION_ITERATIONS; i++) {
            var begin = System.nanoTime();
            var test = ProductCatalog.deserialize(serialized);
            var end = System.nanoTime();
            var duration = end - begin;
            measuredDurations[i] = duration;
        }

        var averageDuration = Arrays.stream(measuredDurations).average().getAsDouble();
        var sortedDurations = Arrays.stream(measuredDurations).sorted().toArray();
        var medianFirst = sortedDurations[(Constants.NUMBER_OF_DESERIALIZATION_ITERATIONS / 2) - 1];
        var medianSecond = sortedDurations[Constants.NUMBER_OF_DESERIALIZATION_ITERATIONS / 2];
        var medianDuration = (medianFirst + medianSecond) / 2.;

        System.out.println("Petri message needed " + averageDuration + " nano seconds to deserialize in average.");
        System.out.println("Median is " + medianDuration + " nano seconds per deserializing.");
    }

}
