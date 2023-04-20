package org.dhbw.ka.ml.petritest.sd.lists.notrecursive;

import org.dhbw.ka.ml.petritest.sd.lists.primitive.nonrecursive.L;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PrimitiveTest {

    @Test
    void deserializeSerializedLToL_should_deserializeToEquallyObject() {
        final var l = new L();
        l.setL1(List.of(12, 13, 1, -3, 500));
        l.setL2(List.of("Hello", "World", "How", "Are", "You", "?"));

        final var serialized = l.serialize();
        final var deserialized = L.deserialize(serialized);

        Assertions.assertEquals(l, deserialized);
    }

}
