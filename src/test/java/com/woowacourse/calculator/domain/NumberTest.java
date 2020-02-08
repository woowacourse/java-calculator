package com.woowacourse.calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Number Test")
class NumberTest {
    @DisplayName("Number - Number() Test")
    @Test
    void testNumber() {
        final String intUpperOverflowNumber = "2147483648";

        assertThatThrownBy(() -> new Number(intUpperOverflowNumber))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage("유효한 범위의 숫자를 입력해 주세요");

        final String intLowerOverflowNumber = "-2147483649";

        assertThatThrownBy(() -> new Number(intLowerOverflowNumber))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage("유효한 범위의 숫자를 입력해 주세요");
    }
}
