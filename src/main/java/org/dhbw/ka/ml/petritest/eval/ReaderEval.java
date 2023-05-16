package org.dhbw.ka.ml.petritest.eval;

import org.dhbw.ka.ml.petrilib.io.PetriReader;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ReaderEval {

    public static void main(String[] args) throws IOException {
        var byteArray = new ByteArrayOutputStream();
        var out = new DataOutputStream(byteArray);
        out.writeDouble(64);
        out.writeDouble(1000000);
        var serialized = byteArray.toByteArray();
        var buffer = new byte[16];

        var measuredDurations = new long[Constants.NUMBER_OF_DESERIALIZATION_ITERATIONS];

        for (int i = 0; i < Constants.NUMBER_OF_DESERIALIZATION_ITERATIONS; i++) {
            var begin = System.nanoTime();
            var stream = new ByteArrayInputStream(serialized);
            stream.read(buffer, 0, 16);
            var end = System.nanoTime();
            var duration = end - begin;
            measuredDurations[i] = duration;
        }

        var averageDuration = Arrays.stream(measuredDurations).average().getAsDouble();
        var sortedDurations = Arrays.stream(measuredDurations).sorted().toArray();
        var medianFirst = sortedDurations[(Constants.NUMBER_OF_DESERIALIZATION_ITERATIONS / 2) - 1];
        var medianSecond = sortedDurations[Constants.NUMBER_OF_DESERIALIZATION_ITERATIONS / 2];
        var medianDuration = (medianFirst + medianSecond) / 2.;
        System.out.println("Average byte array reading in nanoseconds " + averageDuration);
        System.out.println("Median is " + medianDuration);



        for (int i = 0; i < Constants.NUMBER_OF_DESERIALIZATION_ITERATIONS; i++) {
            var begin = System.nanoTime();
            var stream = new PetriReader(serialized);
            stream.read(buffer, 0, 16);
            var end = System.nanoTime();
            var duration = end - begin;
            measuredDurations[i] = duration;
        }

        averageDuration = Arrays.stream(measuredDurations).average().getAsDouble();
        sortedDurations = Arrays.stream(measuredDurations).sorted().toArray();
        medianFirst = sortedDurations[(Constants.NUMBER_OF_DESERIALIZATION_ITERATIONS / 2) - 1];
        medianSecond = sortedDurations[Constants.NUMBER_OF_DESERIALIZATION_ITERATIONS / 2];
        medianDuration = (medianFirst + medianSecond) / 2.;
        System.out.println("Average petri reader reading in nanoseconds " + averageDuration);
        System.out.println("Median is " + medianDuration);
    }

}