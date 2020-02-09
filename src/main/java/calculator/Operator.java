package calculator;

import view.ErrorView;

import java.util.function.BinaryOperator;

public enum Operator {
    addition(Double::sum, "+"),
    subtraction(Operator::subtract, "-"),
    multiplication(Operator::multiply, "*"),
    division(Operator::divide, "/");

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

    private static double subtract(double a, double b) {
        return a - b;
    }

    private static double multiply(double a, double b) {
        return a * b;
    }

    private static double divide(double a, double b) throws IllegalArgumentException {
        if (b == 0) {
            throw new IllegalArgumentException(ErrorView.InvalidExpressionErrorStr);
        }
        return a / b;
    }
}
