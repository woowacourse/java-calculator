package calculator;

import view.ErrorView;

import java.util.function.BinaryOperator;

public enum Operator {
    ADDITION(Double::sum, "+"),
    SUBTRACTION((a, b) -> a - b, "-"),
    MULTIPLICATION((a, b) -> a * b, "*"),
    DIVISION((a, b) -> {
        if (b == 0) {
            throw new IllegalArgumentException(ErrorView.InvalidExpressionErrorStr);
        }
        return a / b;
    }, "/");

    private BinaryOperator<Double> operate;
    private String symbol;

    Operator(BinaryOperator<Double> operate, String symbol) {
        this.operate = operate;
        this.symbol = symbol;
    }

    public static Operator getOperator(String symbol) throws IllegalArgumentException {
        for (Operator operator : Operator.values()) {
            if (operator.getSymbol().equals(symbol)) {
                return operator;
            }
        }

        throw new IllegalArgumentException(ErrorView.InvalidExpressionErrorStr);
    }

    public double calculate(double a, double b) {
        return operate.apply(a, b);
    }

    private String getSymbol() {
        return symbol;
    }
}
