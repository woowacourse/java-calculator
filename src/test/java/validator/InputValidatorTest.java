/*
 * Copyright (c) 2019 by tiger,DDoring
 * All rights reserved.
 *
 * InputValidatorTest.java
 * 값 유효성 검사를 테스트하는 클래스
 *
 * @author      tiger,DDoring
 * @version     1.0
 * @date        06 Feb 2020
 *
 */

package validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class InputValidatorTest {
    static InputValidator inputValidator;

    @BeforeAll
    static void setUp() {
        inputValidator = new InputValidator();
    }

    @Test
    void isCorrectLength_rightLength_success() {
        Assertions.assertTrue(inputValidator.isCorrectLength(new String[]{"2", "-", "3"}));
    }

    @Test
    void isCorrectLength_wrongLength_fail() {
        Assertions.assertTrue(inputValidator.isCorrectLength(new String[]{"2", "-", "3", "/"}));
    }

    @Test
    void isCorrectEvanIndex_isNumber_success() {
        Assertions.assertTrue(inputValidator.isCorrectEvanIndex(Arrays.asList("2", "1", "3", "23")));
    }

    @Test
    void isCorrectEvanIndex_isNumber_fail() {
        Assertions.assertTrue(inputValidator.isCorrectEvanIndex(Arrays.asList("2", "1", "3", "23", "l")));
    }

    @Test
    void isCorrectOddIndex_isNumber_success() {
        Assertions.assertTrue(inputValidator.isCorrectOddIndex(Arrays.asList("+", "-", "/", "*")));
    }

    @Test
    void isCorrectOddIndex_isNumber_fail() {
        Assertions.assertTrue(inputValidator.isCorrectOddIndex(Arrays.asList("-", "*", "1")));
    }

    @Test
    void isCorrectDivide_isZero_success() {
        Assertions.assertFalse(inputValidator.isCorrectDivide(new String[]{"2", "/", "0"}));
    }

    @Test
    void isCorrectDivide_isZero_fail() {
        Assertions.assertTrue(inputValidator.isCorrectDivide(new String[]{"2", "/", "0"}));
    }
}
