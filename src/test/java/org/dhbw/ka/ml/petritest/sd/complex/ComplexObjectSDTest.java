package org.dhbw.ka.ml.petritest.sd.complex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ComplexObjectSDTest {

    @Test
    void serializedOuterStruct_should_deserializeToEqualObject() {
        final var inner = new InnerStruct();
        inner.setS("Hello World");

        final var outer = new OuterStruct();
        outer.setInner(inner);
        outer.setS1("Hello");
        outer.setS2("World");

        Assertions.assertEquals(outer, OuterStruct.deserialize(outer.serialize()));
    }

    @Test
    void deserializeSerializedTripleNestedToTripleNested_should_produceEquallyObject() {
        final var inner = new InnerStruct();
        inner.setS("Hello World");

        final var outer = new OuterStruct();
        outer.setS1("How are you?");
        outer.setS2("Hello World");
        outer.setInner(inner);

        final var triple = new TripleNested();
        triple.setTriple(outer);
        triple.setI(-1);
        triple.setS("Hello World");

        final var serialized = triple.serialize();
        final var deserialized = TripleNested.deserialize(serialized);

        Assertions.assertEquals(triple, deserialized);
    }

}
