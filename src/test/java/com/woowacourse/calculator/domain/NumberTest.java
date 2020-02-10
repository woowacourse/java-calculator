package com.woowacourse.calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Number Test")
class NumberTest {
    @DisplayName("Number - Number() Test")
    @Test
    void testNumber() {
        final String value = "+";

        assertThatThrownBy(() -> new Number(value))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage("유효한 숫자 형식이 아닙니다.");
    }
}
