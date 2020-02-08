package com.woowacourse.calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Tokenizer {

    private static final String EXPRESSION_DELIMITER = " ";

    public static List<Token> tokenize(final String inputExpression) {
        return Arrays.stream(inputExpression.split(EXPRESSION_DELIMITER))
                .map(token -> {
                    try {
                        return new Number(token);
                    } catch (NumberFormatException e) {
                        return new Operator(token);
                    }
                })
                .collect(Collectors.toList());
    }
}
