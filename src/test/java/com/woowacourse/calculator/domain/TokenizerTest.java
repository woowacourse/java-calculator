package com.woowacourse.calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Tokenizer Test")
class TokenizerTest {
    @DisplayName("Tokenize - Tokenize() Test")
    @Test
    void testTokenize() {
        final String inputExpression = "1 + 2";

        final List<Token> actual = Tokenizer.tokenize(inputExpression);

        final List<Token> expected = Arrays.asList(new Number("1"), new Operator("+"), new Number("2"));

        assertThat(actual).isEqualTo(expected);
    }
}
