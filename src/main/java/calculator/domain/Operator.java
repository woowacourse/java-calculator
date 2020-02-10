package calculator.domain;

import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (nowNumber, returnValue) -> returnValue + nowNumber),
    MINUS("-", (nowNumber, returnValue) -> returnValue - nowNumber),
    MULTIPLY("*", (nowNumber, returnValue) -> returnValue * nowNumber),
    DIVIDE("/", (nowNumber, returnValue) -> returnValue / nowNumber);

    private String operator;
    private BiFunction<Double, Double, Double> expression;

    Operator(String operator, BiFunction<Double, Double, Double> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public double calculate(double nowNumber, double returnValue) {
        return expression.apply(nowNumber, returnValue);
    }

    public String getOperator() {
        return this.operator;
    }
}