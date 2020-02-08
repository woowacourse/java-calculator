package calculator;

import view.ErrorView;

import java.util.function.BinaryOperator;

public enum Operator {
    addition(Double::sum),
    subtraction(Operator::subtract),
    multiplication(Operator::multiply),
    division(Operator::divide);

    private BinaryOperator<Double> operate;

    Operator(BinaryOperator<Double> operate) {
        this.operate = operate;
    }

    public static Operator getOperator(String operator) throws IllegalArgumentException {
        if (operator.equals("+")) {
            return Operator.addition;
        }
        if (operator.equals("-")) {
            return Operator.subtraction;
        }
        if (operator.equals("*")) {
            return Operator.multiplication;
        }
        if (operator.equals("/")) {
            return Operator.division;
        }
        throw new IllegalArgumentException(ErrorView.InvalidExpressionErrorStr);
    }

    public double calculate(double a, double b) {
        return operate.apply(a, b);
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
