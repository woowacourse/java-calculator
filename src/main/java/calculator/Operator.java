package calculator;

import view.ErrorView;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

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
        List<Operator> results =
                Arrays.stream(Operator.values())
                .filter(t -> t.getSymbol().equals(symbol))
                .collect(Collectors.toUnmodifiableList());

        if (results.size() == 1) {
            return results.get(0);
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
