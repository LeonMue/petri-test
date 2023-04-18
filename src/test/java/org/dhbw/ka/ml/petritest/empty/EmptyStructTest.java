package org.dhbw.ka.ml.petritest.empty;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmptyStructTest {

    @Test
    void algorithmOfSDEmptyStruct_should_workCorrectlyForEdgeCase() {
        final var empty = new Empty();
        final var serialized = empty.serialize();

        Assertions.assertDoesNotThrow(() -> Empty.deserialize(serialized));
    }

    @Test
    void algorithmOfSDNestedEmptyStruct_should_workCorrectlyForEdgeCase() {
        final var empty = new Empty();
        final var nestedEmpty = new NestedEmpty();
        nestedEmpty.setEmpty(empty);
        nestedEmpty.setS("Hello World");

        final var serialized = nestedEmpty.serialize();
        final var deserialized = NestedEmpty.deserialize(serialized);
        Assertions.assertEquals(deserialized.getS(), nestedEmpty.getS());

    }

}
