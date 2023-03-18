package org.dhbw.ka.ml.petritest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExtensionTest {

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
        Assertions.assertEquals(older.hasMyString(), newer.hasMyString());
        Assertions.assertEquals(older.getMyString(), newer.getMyString());
    }

    @Test
    void newerExtendedVersion_should_beFineWithOlderVersion_whenDeserializing() {
        OlderExtension older = new OlderExtension();
        older.setInteger64(64L);

        NewerExtension newer = NewerExtension.deserialize(older.serialize());

        Assertions.assertEquals(older.hasMyString(), newer.hasMyString());
        Assertions.assertEquals(older.getMyString(), newer.getMyString());
        Assertions.assertEquals(older.hasInteger64(), newer.hasInteger64());
        Assertions.assertEquals(older.getInteger64(), newer.getInteger64());
        Assertions.assertFalse(newer.hasIsNewer());
        Assertions.assertFalse(newer.hasDescription());
    }

}
