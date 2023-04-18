package org.dhbw.ka.ml.petritest.sd.primitive;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrimitiveSerializingTest {

    @Test
    void deserializedMessage_should_beEqualToTheDeserialized() {
        MyTestStruct test = new MyTestStruct();
        test.setBool1(true);
        test.setDouble1(2.0);
        test.setFloat1(0.25f);
        test.setInt1(100);
        test.setLong2(1000000000L);
        test.setString1("Hello");
        test.setS2("How");
        test.setS3("Are you?");

        Assertions.assertEquals(test, MyTestStruct.deserialize(test.serialize()));
    }

    @Test
    void setNotAllFields_should_work() {
        MyTestStruct test = new MyTestStruct();
        test.setString1("Hello");
        test.setInt1(1);
        Assertions.assertEquals(test, MyTestStruct.deserialize(test.serialize()));
    }


}
