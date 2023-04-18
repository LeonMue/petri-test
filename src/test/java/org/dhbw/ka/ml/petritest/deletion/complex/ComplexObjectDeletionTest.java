package org.dhbw.ka.ml.petritest.deletion.complex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ComplexObjectDeletionTest {

    @Test
    void deserializeSerializedNonDeletedOuterStructToDeletedOuterStruct_should_acceptPresentDeletedField() {
        final var nonDeletedInner = new NonDeletedInnerStruct();
        nonDeletedInner.setS("Hello World");

        final var nonDeletedOuter = new NonDeletedOuterStruct();
        nonDeletedOuter.setI(-1);
        nonDeletedOuter.setS("How are you");
        nonDeletedOuter.setInner(nonDeletedInner);

        final var serialized = nonDeletedOuter.serialize();
        final var deserialized = DeletedOuterStruct.deserialize(serialized);

        Assertions.assertTrue(deserialized.hasI());
        Assertions.assertTrue(deserialized.hasS());
        Assertions.assertEquals(deserialized.getI(), nonDeletedOuter.getI());
        Assertions.assertEquals(deserialized.getS(), nonDeletedOuter.getS());
    }

    @Test
    void deserializeSerializedDeletedOuterStructToNonDeletedOuterStruct_should_acceptAbsentField() {
        final var deletedOuter = new DeletedOuterStruct();
        deletedOuter.setI(-1);
        deletedOuter.setS("Hello World");

        final var serialized = deletedOuter.serialize();
        final var deserialized = NonDeletedOuterStruct.deserialize(serialized);

        Assertions.assertFalse(deserialized.hasInner());
        Assertions.assertTrue(deserialized.hasI());
        Assertions.assertTrue(deserialized.hasS());
        Assertions.assertEquals(deserialized.getI(), deletedOuter.getI());
        Assertions.assertEquals(deserialized.getS(), deletedOuter.getS());
    }

    @Test
    void deserializeSerializedDeletedOuterStructToDeletedOuterStruct_should_produceEquallyObjects() {
        final var deletedOuter = new DeletedOuterStruct();
        deletedOuter.setI(-1);
        deletedOuter.setS("Hello World");

        final var serialized = deletedOuter.serialize();
        final var deserialized = DeletedOuterStruct.deserialize(serialized);

        Assertions.assertEquals(deserialized, deletedOuter);
    }

}
