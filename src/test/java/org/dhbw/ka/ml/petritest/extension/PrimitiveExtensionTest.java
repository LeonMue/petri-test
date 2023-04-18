package org.dhbw.ka.ml.petritest.extension;

import org.dhbw.ka.ml.petritest.extension.primitive.NewerExtension;
import org.dhbw.ka.ml.petritest.extension.primitive.OlderExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrimitiveExtensionTest {

    @Test
    void olderVersionOfDefinedStruct_should_ignoreTheNewerExtendedFields_when_deserializing() {
        NewerExtension newer = new NewerExtension();
        // newer fields
        newer.setMyString("This is a string field of the older version");
        newer.setIsNewer(true);
        // older fields
        newer.setDescription("This is the newer version");

        OlderExtension older = OlderExtension.deserialize(newer.serialize());

        Assertions.assertEquals(older.hasInteger64(), newer.hasInteger64());
        Assertions.assertEquals(older.getInteger64(), newer.getInteger64());
    }

    @Test
    void newerExtendedVersion_should_beFineWithOlderVersion_whenDeserializing() {
        OlderExtension older = new OlderExtension();
        older.setInteger64(-1L);

        NewerExtension newer = NewerExtension.deserialize(older.serialize());

        Assertions.assertEquals(older.hasInteger64(), newer.hasInteger64());
        Assertions.assertEquals(older.getInteger64(), newer.getInteger64());
        Assertions.assertFalse(newer.hasIsNewer());
        Assertions.assertFalse(newer.hasDescription());
        Assertions.assertFalse(newer.hasB1());
        Assertions.assertFalse(newer.hasF1());
        Assertions.assertFalse(newer.hasF2());
        Assertions.assertFalse(newer.hasI2());
        Assertions.assertFalse(newer.hasMyString());
    }

}
