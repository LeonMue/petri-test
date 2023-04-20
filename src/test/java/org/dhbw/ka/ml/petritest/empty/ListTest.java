package org.dhbw.ka.ml.petritest.empty;

import org.dhbw.ka.ml.petritest.empty.lists.L;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ListTest {

    @Test
    void deserializeSerializedEmptyLists_should_produceEquallyObject() {
        final var l = new L();
        l.setL1(List.of());
        l.setL2(List.of(List.of(), List.of()));
        l.setL3(List.of(List.of(List.of())));

        final var serialized = l.serialize();
        final var deserialized = L.deserialize(serialized);

        Assertions.assertEquals(l, deserialized);
    }

}
