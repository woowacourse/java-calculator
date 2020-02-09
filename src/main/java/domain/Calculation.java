package domain;

import java.util.function.BiFunction;

public enum Calculator {
    PLUS("+", (num1, num2) -> num1 + num2),
    MINUS("-", (num1, num2) -> num1 - num2),
    MULTIPLICATION("*", (num1, num2) -> num1 * num2),
    DIVISION("/", (num1, num2) -> {
        validDivideZero(num2);
        return num1 / num2;
    });

    private String operator;
    private BiFunction<Double, Double, Double>  expression;

    Calculator(String operator, BiFunction<Double, Double, Double> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    private static void validDivideZero(double num) {
        if (num == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
    }

    public static int startCalculate(Formulas formulas) {
        double accumulationValue = formulas.getNumToDouble(0);
        for (int index = 1; index < formulas.size(); index += 2) {
            String operation = formulas.getOperator(index);
            double newValue = formulas.getNumToDouble(index + 1);
            accumulationValue = calculate(operation, accumulationValue, newValue);
        }
        return (int) accumulationValue;
    }

    private double calculate(double num1, double num2) {
        return expression.apply(num1, num2)
    }
}
