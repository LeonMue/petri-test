package org.dhbw.ka.ml.petritest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SerializingTest {

    @Test
    void deserializedMessage_should_beEqualToTheDeserialized() {
        switch (1) {
            case (0): {
                System.out.println("Hello");
                break;
            }
            default: {
                return;
            }
        }
        MyTestStruct test = new MyTestStruct();
        test.setBool1(true);
        test.setDouble1(2.0);
        test.setFloat1(0.25f);
        test.setInt1(100);
        test.setLong2(1000000000L);
        test.setString1("Hello");

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
