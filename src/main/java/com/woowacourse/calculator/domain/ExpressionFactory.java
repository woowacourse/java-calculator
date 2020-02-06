package com.woowacourse.calculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 클래스 이름 : ExpressionFactory.java
 *
 * @author S.W.PARK
 * @author K.S.KIM
 * @version 1.0
 * <p>
 * 날짜 : 2020.02.06 목요일
 */

public class ExpressionFactory {
    private static final String DELIMITER = " ";
    private static final String EMPTY_STRING = "";

    private ExpressionFactory() {}

    public static Expression create(final String input) {
        validateTokens(input);
        List<String> tokens = Arrays.asList(input.split(DELIMITER));
        Numbers numbers = makeNumbers(tokens);
        Operators operators = makeOperators(tokens);
        return new Expression(numbers, operators);
    }

    private static void validateTokens(final String inputString) {
        if (!inputString.matches("^\\b[1-9]{1}[0-9]*(\\s[+-\\\\*]\\s[1-9]{1}[0-9]*)*\\b")) {
            throw new IllegalArgumentException("잘못된 형식으로 입력하셨습니다.");
        }
    }

    private static Numbers makeNumbers(final List<String> tokens) {
        List<Number> numbers = new ArrayList<>();
        for (int index = 0; index < tokens.size(); index += 2) {
            numbers.add(Number.of(tokens.get(index)));
        }
        return new Numbers(numbers);
    }

    private static Operators makeOperators(final List<String> tokens) {
        List<OperatorType> operators = new ArrayList<>();
        for (int index = 1; index < tokens.size(); index += 2) {
            operators.add(OperatorType.of(tokens.get(index)));
        }
        return new Operators(operators);
    }
}
