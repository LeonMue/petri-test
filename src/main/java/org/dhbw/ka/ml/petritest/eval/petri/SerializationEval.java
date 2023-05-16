package org.dhbw.ka.ml.petritest.eval.petri;

import org.dhbw.ka.ml.petritest.eval.Constants;

import java.util.Arrays;

public class SerializationEval {

    public static void main(String[] args) {
        final var NUMBER_OF_ITERATIONS = Constants.NUMBER_OF_SERIALIZATION_ITERATIONS;
        final var toSerialize = ProductCatalogEvalDataSet.IMAGINARY.getProductCatalog();

        final var measuredDurations = new long[NUMBER_OF_ITERATIONS];
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            final var begin = System.nanoTime();
            toSerialize.serialize();
            final var end = System.nanoTime();
            final var duration = end - begin;
            measuredDurations[i] = duration;
        }

        var averageDuration = Arrays.stream(measuredDurations).average().getAsDouble();
        var sortedDurations = Arrays.stream(measuredDurations).sorted().toArray();
        var medianFirst = sortedDurations[(Constants.NUMBER_OF_DESERIALIZATION_ITERATIONS / 2) - 1];
        var medianSecond = sortedDurations[Constants.NUMBER_OF_DESERIALIZATION_ITERATIONS / 2];
        var medianDuration = (medianFirst + medianSecond) / 2.;

        System.out.println("Petri message needed " + averageDuration + " nano seconds to serialize in average.");
        System.out.println("Median is " + medianDuration + " nano seconds per serializing.");
    }

}
