package org.dhbw.ka.ml.petritest.extension;

import org.dhbw.ka.ml.petritest.extension.lists.Newer;
import org.dhbw.ka.ml.petritest.extension.lists.Older;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ListExtensionTest {

    @Test
    void deserializingToNewer_should_acceptSerializedOlderSchema() {
        final var older = new Older();
        older.setS2("Hello World");

        final var serialized = older.serialize();
        final var deserialized = Newer.deserialize(serialized);

        Assertions.assertEquals(older.getS2(), deserialized.getS2());
    }

    @Test
    void deserializingToOlder_should_acceptExtensionOfNewer() {
        final var newer = new Newer();
        newer.setS2("Hello World");
        newer.setL(List.of("Hello", "World"));

        final var serialized = newer.serialize();
        final var deserialized = Older.deserialize(serialized);

        Assertions.assertTrue(deserialized.hasS2());
        Assertions.assertEquals(newer.getS2(), deserialized.getS2());
    }
}
