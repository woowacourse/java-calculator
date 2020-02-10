/*
 * Copyright (c) 2019 by tiger,DDoring
 * All rights reserved.
 *
 * CalculatorTest.java
 * 계산 기능을 테스트하는 클래스
 *
 * @author      tiger,DDoring
 * @version     1.0
 * @date        06 Feb 2020
 *
 */

package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    static CalculatorMap op;

    @BeforeAll
    static void setUp() {
        op = new CalculatorMap();
    }

    @Test
    void testPlus() {
        Assertions.assertEquals(7.0, op.calculate("+",2.0, 5.0));
    }

    @Test
    void testMinus() {
        Assertions.assertEquals(-3.0, op.calculate("-",2.0, 5.0));
    }

    @Test
    void testMul() {
        Assertions.assertEquals(10.0, op.calculate("*",2.0, 5.0));
    }

    @Test
    void testDiv() {
        Assertions.assertEquals(0.4, op.calculate("/",2.0, 5.0));
    }
}
