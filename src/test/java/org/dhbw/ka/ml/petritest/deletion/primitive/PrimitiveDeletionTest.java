package org.dhbw.ka.ml.petritest.deletion.primitive;

import org.dhbw.ka.ml.petritest.deletion.primitive.DeletedFieldStruct;
import org.dhbw.ka.ml.petritest.deletion.primitive.NonDeletedFieldStruct;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrimitiveDeletionTest {

    @Test
    void serializingDeletedFieldStruct_should_letAllTheseFieldsNull_when_deserializingWithNonDeletedFieldStruct() {
        DeletedFieldStruct deleted = new DeletedFieldStruct();
        deleted.setWorld("World");
        deleted.setMyInt32(32);

        NonDeletedFieldStruct nonDeleted = NonDeletedFieldStruct.deserialize(deleted.serialize());

        Assertions.assertFalse(nonDeleted.hasIsNotDeleted());
        Assertions.assertFalse(nonDeleted.hasHello());
        Assertions.assertEquals(deleted.getMyInt32(), nonDeleted.getMyInt32());
        Assertions.assertEquals(deleted.getWorld(), nonDeleted.getWorld());
    }

    @Test
    void deserializingToDeletedFieldStruct_should_skipAllFieldsDeleted_when_serializingWithANonDeletedFieldStruct() {
        NonDeletedFieldStruct nonDeleted = new NonDeletedFieldStruct();
        nonDeleted.setIsNotDeleted(true);
        nonDeleted.setMyInt32(100);
        nonDeleted.setHello("Hello");
        nonDeleted.setWorld("World");
        nonDeleted.setMyFloat64(0.25);

        DeletedFieldStruct deleted = DeletedFieldStruct.deserialize(nonDeleted.serialize());

        Assertions.assertEquals(nonDeleted.getMyInt32(), deleted.getMyInt32());
        Assertions.assertEquals(nonDeleted.getWorld(), deleted.getWorld());
    }

}
