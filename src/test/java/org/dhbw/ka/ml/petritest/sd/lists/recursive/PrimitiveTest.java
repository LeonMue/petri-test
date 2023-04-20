package org.dhbw.ka.ml.petritest.sd.lists.recursive;

import org.dhbw.ka.ml.petritest.sd.lists.primitive.recursive.L;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PrimitiveTest {
    // TODO: list of empty, nonr of complex, rec of complex, nonrec empty list, rec empty list, deletion, extension, notset list

    @Test
    void deserializeSerializedLToL_should_produceEquallyObject() {
        final var l = new L();
        l.setL1(List.of(
                List.of(true, false, true, true, true, false, true, false),
                List.of(false, false, false),
                List.of(true)
        ));
        l.setL2(List.of(
                List.of(
                        List.of(4.5, 1.2, 3.0, -4.),
                        List.of(1.0, 0., 3.2, -0.)
                ),
                List.of(
                        List.of(-500.),
                        List.of(-3., -4., 5., -6.)
                )
        ));

        final var serialized = l.serialize();
        final var deserialized = L.deserialize(serialized);

        Assertions.assertEquals(l, deserialized);
    }

}
