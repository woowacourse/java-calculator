package domain;

import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (prev, next) -> prev + next),
    MINUS("-", (prev, next) -> prev - next),
    MULTIPLY("*", (prev, next) -> prev * next),
    DIVIDE("/", (prev, next) -> prev / next);

    private String symbol;
    private BiFunction<Double, Double, Double> operate;

    Operator(String symbol, BiFunction<Double, Double, Double> operate) {
        this.symbol = symbol;
        this.operate = operate;
    }

    public static Operator hasOperator(String symbol) {
        if (Operator.PLUS.symbol.equals(symbol)) {
            return Operator.PLUS;
        }
        if (Operator.MINUS.symbol.equals(symbol)) {
            return Operator.MINUS;
        }
        if (Operator.MULTIPLY.symbol.equals(symbol)) {
            return Operator.MULTIPLY;
        }
        if (Operator.DIVIDE.symbol.equals(symbol)) {
            return Operator.DIVIDE;
        }
        throw new ExpressionException(ExpressionException.INVALID_OPERATION);
    }

    public double calculate(double prev, double next) {
        return operate.apply(prev, next);
    }
}
