package com.woowacourse.calculator.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Number Test")
class NumberTest {
    @DisplayName("Number - Number() Test")
    @Test
    void testNumber() {
        final String integerOverflowNumber = "2147483648";
        assertThatThrownBy(() -> new Number(integerOverflowNumber))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage("유효한 범위의 숫자를 입력해 주세요");
    }
}
