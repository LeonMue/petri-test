package org.dhbw.ka.ml.petritest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DeletionComplexObjectFieldTypeTest {

    @Test
    void deserializingToDeletedFieldStruct_should_skipAllFieldsDeleted_when_serializingWithANonDeletedFieldStruct() {
        final var dummy2 = new ComplexObjectFieldTypeDeletionDummy2();

        final var dummy3 = new ComplexObjectFieldTypeDeletionDummy3();
        dummy3.setMyBool(true);

        final var dummy1 = new ComplexObjectFieldTypeDeletionDummy1();
        dummy1.setComplex2(dummy2);
        dummy1.setComplex3(dummy3);
        dummy1.setMyInt(42);
        dummy1.setMyString("Hello World");

        final var nonDeleted = new NonDeletedComplexObjectFieldType();
        nonDeleted.setComplex1(dummy1);
        nonDeleted.setComplex2(dummy1);
        nonDeleted.setMyString1("How are you?");
        nonDeleted.setMyString2("I'm great. Thank you!");


        final var serialized = nonDeleted.serialize();
        final var deserialized = DeletedComplexObjectFieldType.deserialize(serialized);

        Assertions.assertEquals(deserialized.getComplex2(), nonDeleted.getComplex2());
    }

    @Test
    void serializingDeletedFieldStruct_should_letAllTheseFieldsNull_when_deserializingWithNonDeletedFieldStruct() {
        final var dummy2 = new ComplexObjectFieldTypeDeletionDummy2();

        final var dummy3 = new ComplexObjectFieldTypeDeletionDummy3();
        dummy3.setMyBool(true);

        final var dummy1 = new ComplexObjectFieldTypeDeletionDummy1();
        dummy1.setComplex2(dummy2);
        dummy1.setComplex3(dummy3);
        dummy1.setMyInt(42);
        dummy1.setMyString("Hello World");

        final var deleted = new DeletedComplexObjectFieldType();
        deleted.setComplex2(dummy1);

        final var serialized = deleted.serialize();
        final var deserialized = NonDeletedComplexObjectFieldType.deserialize(serialized);

        Assertions.assertEquals(deleted.getComplex2(), deserialized.getComplex2());
        Assertions.assertNull(deserialized.getComplex1());
        Assertions.assertNull(deserialized.getMyString1());
        Assertions.assertNull(deserialized.getMyString2());
    }

}
