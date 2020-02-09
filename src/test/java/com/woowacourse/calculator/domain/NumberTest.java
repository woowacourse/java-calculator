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
                .hasMessage("적절한 수를 입력해 주십시요.");
    }
}
