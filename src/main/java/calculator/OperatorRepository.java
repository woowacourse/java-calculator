package calculator;

import view.ErrorView;

public class OperatorRepository {
    private static final Double ZERO = 0d;

    public static double add(double a, double b) {
        return Double.sum(a, b);
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        if (b == ZERO) {
            throw new IllegalArgumentException(ErrorView.INVALID_EXPRESSION_ERROR_STR);
        }
        return a / b;
    }
}
