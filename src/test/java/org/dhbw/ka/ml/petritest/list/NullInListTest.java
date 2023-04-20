package org.dhbw.ka.ml.petritest.list;

import org.dhbw.ka.ml.petritest.empty.lists.Empty;
import org.dhbw.ka.ml.petritest.empty.lists.L;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class NullInListTest {

    @Test
    void nullInList_should_throwIllegalArgumentException() {
        final var l1 = new L();
        final var nullList = new ArrayList<Empty>();
        nullList.add(null);
        l1.setL1(nullList);

        Assertions.assertThrows(IllegalArgumentException.class, l1::serialize);

        final var l2 = new L();
        l2.setL2(List.of(nullList));
        Assertions.assertThrows(IllegalArgumentException.class, l2::serialize);

        final var l3 = new L();
        l3.setL3(List.of(List.of(nullList)));
        Assertions.assertThrows(IllegalArgumentException.class, l3::serialize);
    }

}
