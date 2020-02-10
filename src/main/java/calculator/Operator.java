package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+",
            (left, right) -> (left + right)),
    MINUS("-",
            (left, right) -> (left - right)),
    MULTIPLICATION("*",
            (left, right) -> (left * right)),
    DIVISION("/",
            (left, right) -> (left / right));

    private String symbol;
    private BiFunction<Double, Double, Double> expression;

    Operator(String symbol, BiFunction<Double, Double, Double> expression) {
        this.symbol = symbol;
        this.expression = expression;
    }

    private String getSymbol() {
        return this.symbol;
    }

    public static Operator find(String operator) {
        return Arrays.stream(Operator.values())
                .filter(op -> op.getSymbol().equals(operator))
                .findFirst()
                .get();
    }

    public double calculate(double left, double right) {
        return expression.apply(left, right);
    }

    public static boolean isRightOperator(String operator) {
        return Arrays.stream(Operator.values())
                .anyMatch(op -> op.getSymbol().equals(operator));
    }

    public static boolean isDivisionOperator(String operator) {
        return "/".equals(operator);
    }
}
