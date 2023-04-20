package org.dhbw.ka.ml.petritest.deletion.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ListDeletionTest {

    @Test
    void deserializeSerializedNonDeletedListStructToDeletedListStruct_should_acceptPresentDeletedField() {
        final var nonDeleted = new NonDeletedListStruct();
        nonDeleted.setI(-1);
        nonDeleted.setL(List.of(1, 2, 3, 4, 5, 6, 7, 8));
        nonDeleted.setS("Hello World");

        final var serialized = nonDeleted.serialize();
        final var deserialized = DeletedListStruct.deserialize(serialized);

        Assertions.assertEquals(nonDeleted.getI(), deserialized.getI());
        Assertions.assertEquals(nonDeleted.getS(), deserialized.getS());
    }

    @Test
    void deserializeSerializedDeletedListStructToNonDeletedListStruct_should_acceptAbsentField() {
        final var deleted = new DeletedListStruct();
        deleted.setI(-1);
        deleted.setS("Hello World");

        final var serialized = deleted.serialize();
        final var deserialized = NonDeletedListStruct.deserialize(serialized);

        Assertions.assertFalse(deserialized.hasL());
        Assertions.assertEquals(deleted.getI(), deserialized.getI());
        Assertions.assertEquals(deleted.getS(), deserialized.getS());
    }

}
