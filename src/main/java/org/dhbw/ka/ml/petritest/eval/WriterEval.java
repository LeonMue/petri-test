package org.dhbw.ka.ml.petritest.eval;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class WriterEval {

    public static void main(String[] args) throws IOException {
        final var NUMBER_OF_ITERATIONS = Constants.NUMBER_OF_SERIALIZATION_ITERATIONS;
        final var measuredDurations = new long[NUMBER_OF_ITERATIONS];
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            final var begin = System.nanoTime();
            var writer = new ByteArrayOutputStream();
            for (int j = 0; j < 16; j++) {
                writer.write(Integer.MAX_VALUE);
            }
            final var end = System.nanoTime();
            final var duration = end - begin;
            measuredDurations[i] = duration;
        }

        var averageDuration = Arrays.stream(measuredDurations).average().getAsDouble();
        var sortedDurations = Arrays.stream(measuredDurations).sorted().toArray();
        var medianFirst = sortedDurations[(NUMBER_OF_ITERATIONS / 2) - 1];
        var medianSecond = sortedDurations[NUMBER_OF_ITERATIONS / 2];
        var medianDuration = (medianFirst + medianSecond) / 2.;
        System.out.println("Average byte array writing in nanoseconds " + averageDuration);
        System.out.println("Median is " + medianDuration);

        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            final var begin = System.nanoTime();
            var writer = new DataOutputStream(new ByteArrayOutputStream());
            for (int j = 0; j < 16; j++) {
                writer.write(Integer.MAX_VALUE);
            }
            final var end = System.nanoTime();
            final var duration = end - begin;
            measuredDurations[i] = duration;
        }

        averageDuration = Arrays.stream(measuredDurations).average().getAsDouble();
        sortedDurations = Arrays.stream(measuredDurations).sorted().toArray();
        medianFirst = sortedDurations[(NUMBER_OF_ITERATIONS / 2) - 1];
        medianSecond = sortedDurations[NUMBER_OF_ITERATIONS / 2];
        medianDuration = (medianFirst + medianSecond) / 2.;
        System.out.println("Average data output writing in nanoseconds " + averageDuration);
        System.out.println("Median is " + medianDuration);

    }

}
