package org.dhbw.ka.ml.petritest.sd.lists.notrecursive;

import org.dhbw.ka.ml.petritest.sd.lists.complex.nonrecursive.L;
import org.dhbw.ka.ml.petritest.sd.lists.complex.nonrecursive.T;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ComplexTest {

    @Test
    void deserializeSerializedLtoL_should_produceEquallyObject() {
        final var l = new L();

        final var t1 = new T();
        t1.setS("Hello World");
        t1.setI(42);

        final var t2 = new T();
        t2.setS("How Are you?");
        t2.setI(-1);

        l.setL1(List.of(
                t1,
                t2,
                t2,
                t2,
                t1
        ));

        final var serialized = l.serialize();
        final var deserialized = L.deserialize(serialized);

        Assertions.assertEquals(l, deserialized);
    }

}
