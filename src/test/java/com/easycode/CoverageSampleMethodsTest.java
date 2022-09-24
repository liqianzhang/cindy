package com.easycode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class CoverageSampleMethodsTest {
    @ParameterizedTest
    @DisplayName("Condition Decision coverage sample test result true")
    @CsvSource({"0, 2, 3",
            "1, 0, 3"})
    void testConditionDecisionCoverageTrue(int a, int b, int c) {
        CoverageSampleMethods coverageSampleMethods = new CoverageSampleMethods();
        System.out.println(coverageSampleMethods.testMethod(a, b ,c));
        Assertions.assertTrue(coverageSampleMethods.testMethod(a, b ,c));
    }

//    @ParameterizedTest
//    @CsvSource({"0, 0, 0"})
//    @DisplayName("Condition Decision coverage sample test result fasle")
//    @TestFactory
//    void testConditionDecisionCoverageFalse(int a, int b, int c) {
//        CoverageSampleMethods coverageSampleMethods = new CoverageSampleMethods();
//        Assertions.assertTrue(coverageSampleMethods.testMethod(a, b ,c));
//
//    }
    @Test
    public void testUsingJunitAssertThat() {
        //字符串判断
        String s = "abcde";
        Assertions.assertTrue(s.startsWith("ab"));
        Assertions.assertTrue(s.endsWith("de"));
        Assertions.assertEquals(5, s.length());

        //数字判断
        Integer i = 50;
        Assertions.assertTrue(i > 0);
        Assertions.assertTrue(i < 100);

        //日期判断
        Date date1 = new Date();
        Date date2 = new Date(date1.getTime() + 100);
        Date date3 = new Date(date1.getTime() - 100);
        Assertions.assertTrue(date1.before(date2));
        Assertions.assertTrue(date1.after(date3));

        //List判断
        List<String> list = Arrays.asList("a", "b", "c", "d", "e");
        Assertions.assertEquals("a", list.get(0));
        Assertions.assertEquals(5, list.size());
        Assertions.assertEquals("e", list.get(list.size() - 1));

        //Map判断
        Map<String, Object> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 1);
        map.put("c", 1);

        Set<String> set = map.keySet();
        Assertions.assertEquals(3, map.size());
        Assertions.assertTrue(set.containsAll(Arrays.asList("a", "b", "c")));

    }
}