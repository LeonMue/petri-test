package org.dhbw.ka.ml.petritest.eval.protobuf;

import org.dhbw.ka.ml.petrilib.io.PetriReader;
import org.dhbw.ka.ml.petrilib.io.PetriWriter;
import org.dhbw.ka.ml.petritest.eval.Constants;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class SerializationEval {

    public static void main(String[] args) throws IOException {
        final var NUMBER_OF_ITERATIONS = Constants.NUMBER_OF_SERIALIZATION_ITERATIONS;
        final var toSerialize = ProductCatalogEvalDataSet.IMAGINARY.getProductCatalog();

        final var measuredDurations = new long[NUMBER_OF_ITERATIONS];
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            final var begin = System.nanoTime();
            toSerialize.writeTo(new ByteArrayOutputStream());
            final var end = System.nanoTime();
            final var duration = end - begin;
            measuredDurations[i] = duration;
        }

        final var averageDuration = Arrays.stream(measuredDurations).average().getAsDouble();
        final var sortedDurations = Arrays.stream(measuredDurations).sorted().toArray();
        final var medianFirst = sortedDurations[(NUMBER_OF_ITERATIONS / 2) - 1];
        final var medianSecond = sortedDurations[NUMBER_OF_ITERATIONS / 2];
        final var medianDuration = (medianFirst + medianSecond) / 2.;

        System.out.println("Protobuf message needed " + averageDuration + " nano seconds to serialize in average.");
        System.out.println("Median is " + medianDuration + " nano seconds per serializing.");
    }

}
