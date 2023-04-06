package org.dhbw.ka.ml.petritest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ComplexObjectFieldTypeTest {

    @Test
    void serializingSimpleComplexObjectField2_should_work() {
        final var t2 = new SimpleComplexObjectField2();
        final var t1 = new SimpleComplexObjectField1();
        final var t3 = new SimpleComplexObjectField3();
        t2.setMyBool(true);
        t2.setComplex(t1);
        t1.setMyString("Hello World");
        t1.setMyBool(false);
        t1.setComplex(t3);
        t3.setMyFloat(0.5f);

        Assertions.assertEquals(t2, SimpleComplexObjectField2.deserialize(t2.serialize()));
    }

}
