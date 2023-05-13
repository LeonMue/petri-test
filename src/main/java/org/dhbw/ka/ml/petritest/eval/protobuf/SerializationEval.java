package org.dhbw.ka.ml.petritest.eval.protobuf;

import org.dhbw.ka.ml.petritest.eval.Constants;

public class SerializationEval {

    public static void main(String[] args) {
        var toSerialize = ProductCatalogEvalDataSet.IMAGINARY.getProductOrders();

        final var start = System.nanoTime();
        for (int i = 0; i < Constants.NUMBER_OF_SERIALIZATION_ITERATIONS; i++) {
            toSerialize.toByteArray();
        }
        final var end = System.nanoTime();

        final var duration = end - start;
        var averageSerializationSpeed = 1. * duration / Constants.NUMBER_OF_DESERIALIZATION_ITERATIONS;

        System.out.println("Protobuf message needed " + duration + " nano seconds to serialize.");
        System.out.println("Average is " + averageSerializationSpeed + " nano seconds per serializing.");
    }

}
