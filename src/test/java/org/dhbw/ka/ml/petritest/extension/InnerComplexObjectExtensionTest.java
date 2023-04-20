package org.dhbw.ka.ml.petritest.extension;

import org.dhbw.ka.ml.petritest.extension.complex.NewerInnerObject;
import org.dhbw.ka.ml.petritest.extension.complex.NewerParentObject;
import org.dhbw.ka.ml.petritest.extension.complex.OlderInnerObject;
import org.dhbw.ka.ml.petritest.extension.complex.OlderParentObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class InnerComplexObjectExtensionTest {

    @Test
    void deserializingToNewerParentObject_should_acceptSerializedOlderSchema() {
        final var olderChild = new OlderInnerObject();
        olderChild.setI(3);
        final var older = new OlderParentObject();
        older.setOlder(olderChild);

        final var serialized = older.serialize();
        final var deserialized = NewerParentObject.deserialize(serialized);

        Assertions.assertTrue(deserialized.hasNewer());
        final var innerNewer = deserialized.getNewer();
        Assertions.assertTrue(innerNewer.hasI1());
        Assertions.assertEquals(innerNewer.getI1(), olderChild.getI());
        Assertions.assertFalse(innerNewer.hasB());
        Assertions.assertFalse(innerNewer.hasF1());
        Assertions.assertFalse(innerNewer.hasF2());
        Assertions.assertFalse(innerNewer.hasI2());
        Assertions.assertFalse(innerNewer.hasI3());
        Assertions.assertFalse(innerNewer.hasS1());
        Assertions.assertFalse(innerNewer.hasS2());
        Assertions.assertFalse(innerNewer.hasS3());
    }

    @Test
    void deserializingToOlderObject_should_acceptExtension() {
        final var inner = new NewerInnerObject();
        inner.setB(true);
        inner.setF1(2.25f);
        inner.setF2(4.5);
        inner.setI1(23);
        inner.setI2(-1);
        inner.setI3(42);
        inner.setS1("Hello");
        inner.setS2("World");
        inner.setS3("!");
        inner.setL(List.of("Hello", "World"));

        final var newerParent = new NewerParentObject();
        newerParent.setNewer(inner);

        final var serialized = newerParent.serialize();
        final var deserialized = OlderParentObject.deserialize(serialized);

        Assertions.assertTrue(deserialized.hasOlder());
        final var older = deserialized.getOlder();
        Assertions.assertTrue(older.hasI());
        Assertions.assertEquals(older.getI(), inner.getI1());
    }

}
