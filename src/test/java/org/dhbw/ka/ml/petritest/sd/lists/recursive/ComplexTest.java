package org.dhbw.ka.ml.petritest.sd.lists.recursive;

import org.dhbw.ka.ml.petritest.sd.lists.complex.recursive.L;
import org.dhbw.ka.ml.petritest.sd.lists.complex.recursive.T;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ComplexTest {

    @Test
    void deserializeSerializedLToL_should_produceEquallyObject() {
        final var l = new L();

        final var t1 = new T();
        t1.setL(List.of("Hello", "World"));
        t1.setB(true);

        final var t2 = new T();
        t2.setL(List.of("How", "are", "you", "?", "?", "!"));
        t2.setB(false);

        l.setL(List.of(
                List.of(t1, t1, t2),
                List.of(t2),
                List.of(t1)
        ));

        final var serialized = l.serialize();
        final var deserialized = L.deserialize(serialized);

        Assertions.assertEquals(l, deserialized);
    }

}
