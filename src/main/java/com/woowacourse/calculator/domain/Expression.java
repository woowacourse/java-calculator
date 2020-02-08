package com.woowacourse.calculator.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Expression {
    private final static boolean NUMBER_TURN_STATUS = false;
    private final static boolean OPERATOR_TURN_STATUS = true;
    private static final int ONLY_RESULT_REMAIN_SIZE = 1;
    private static final int MIN_EXPRESSION_TOKEN_SIZE = 3;

    private final Stack<Token> expression;

    public Expression(final List<Token> tokens) {
        checkValidSize(tokens);
        checkValidExpression(tokens);
        expression = toExpression(tokens);
    }

    private void checkValidSize(List<Token> tokens) {
        if (tokens.size() < MIN_EXPRESSION_TOKEN_SIZE) {
            throw new IllegalArgumentException("잘못된 연산 식입니다.");
        }
    }

    private void checkValidExpression(final List<Token> tokens) {
        boolean tokenTurnStatus = NUMBER_TURN_STATUS;

        for (Token token : tokens) {
            if (!isTurnStatus(tokenTurnStatus, token)) {
                throw new IllegalArgumentException("잘못된 연산 식입니다.");
            }
            tokenTurnStatus = shiftNextStatus(tokenTurnStatus);
        }
    }

    private boolean isTurnStatus(final boolean tokenStatus, final Token token) {
        if (isTurnStatus(NUMBER_TURN_STATUS, tokenStatus) && !isNumber(token)) {
            return false;
        }
        if (isTurnStatus(OPERATOR_TURN_STATUS, tokenStatus) && !isOperator(token)) {
            return false;
        }
        return true;
    }

    private boolean isTurnStatus(final boolean selectTurnStatus, final boolean tokenTurnStatus) {
        return tokenTurnStatus == selectTurnStatus;
    }

    private boolean isNumber(final Token token) {
        return token.getClass() == Number.class;
    }

    private boolean isOperator(final Token token) {
        return token.getClass() == Operator.class;
    }

    private Stack<Token> toExpression(final List<Token> tokens) {
        Stack<Token> expression = new Stack<>();
        List<Token> reverseTokens = new ArrayList<>(tokens);

        Collections.reverse(reverseTokens);
        reverseTokens.forEach(expression::push);

        return expression;
    }

    private boolean shiftNextStatus(final boolean tokenTurnStatus) {
        return !tokenTurnStatus;
    }

    public int calculate() {
        int calculateResult = 0;
        Number number1;
        Operator operator;
        Number number2;

        while (expression.size() != ONLY_RESULT_REMAIN_SIZE) {
            number1 = (Number) expression.pop();
            operator = (Operator) expression.pop();
            number2 = (Number) expression.pop();

            calculateResult = operator.calculate(number1, number2);

            expression.push(new Number(Integer.toString(calculateResult)));
        }
        return calculateResult;
    }

    public Stack<Token> getExpression() {
        return expression;
    }
}
