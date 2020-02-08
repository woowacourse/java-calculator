package com.woowacourse.study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("String API Test")
public class StringTest {
    @DisplayName("String API - split() Test")
    @Test
    void testSplit() {
        final String value = "1,2";
        final String[] actual = value.split(",");
        assertThat(actual).contains("1");
        assertThat(actual).contains("2");

        final String value2 = "1";
        final String[] actual2 = value2.split(",");
        assertThat(actual2).containsExactly("1");
    }

    @DisplayName("String API - substring() Test")
    @Test
    void testSubstring() {
        final int BRACKET_LENGTH = 1;
        final String value = "(1,2)";
        final String actual = value.substring(BRACKET_LENGTH, value.length() - BRACKET_LENGTH);
        final String expected = "1,2";

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("String API - charAt() Test")
    @Test
    void testCharAt() {
        final String value = "abc";
        final int index = 0;
        final char actual = value.charAt(index);
        final char expected = 'a';

        assertThat(actual).isEqualTo(expected);

        final int outOfBoundIndex = 3;
        assertThatThrownBy(() -> {
            value.charAt(outOfBoundIndex);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessage("String index out of range: %d", outOfBoundIndex);

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    value.charAt(outOfBoundIndex);
                }).withMessage("String index out of range: %d", outOfBoundIndex);
    }
}
