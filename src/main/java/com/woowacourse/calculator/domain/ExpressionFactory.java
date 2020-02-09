package com.woowacourse.calculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExpressionFactory {
    private static final String EXPRESSION_DELIMITER = " ";
    private static final boolean NUMBER_STATUS = true;
    private static final boolean OPERATOR_STATUS = false;

    public static Expression generate(final String inputExpression) {
        List<String> tokens = Arrays.asList(inputExpression.split(EXPRESSION_DELIMITER));
        return makeExpression(tokens);
    }

    private static Expression makeExpression(final List<String> tokens) {
        List<Number> numbers = new ArrayList<>();
        List<Operator> operators = new ArrayList<>();

        boolean tokenStatus = NUMBER_STATUS;

        for (String token : tokens) {
            if (isNumberStatus(tokenStatus)) {
                numbers.add(toNumber(token));
            }
            if (isOperatorStatus(tokenStatus)) {
                operators.add(toOperator(token));
            }
            tokenStatus = convertNext(tokenStatus);
        }

        return new Expression(numbers, operators);
    }

    private static boolean isNumberStatus(final boolean tokenStatus) {
        return tokenStatus == NUMBER_STATUS;
    }

    private static Number toNumber(final String token) {
        try {
            return new Number(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 연산식이 아닙니다.");
        }
    }

    private static boolean isOperatorStatus(final boolean tokenStatus) {
        return tokenStatus == OPERATOR_STATUS;
    }

    private static Operator toOperator(final String token) {
        try {
            return Operator.Of(token);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("유효한 연산식이 아닙니다.");
        }
    }

    private static boolean convertNext(final boolean tokenStatus) {
        return !tokenStatus;
    }
}
