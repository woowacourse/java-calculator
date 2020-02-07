package domain;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Calculator {
    private static Map<String, BiFunction<Double, Double, Double>> operators = new HashMap<>();

    static {
        operators.put("+", (num1, num2) -> num1 + num2);
        operators.put("-", (num1, num2) -> num1 - num2);
        operators.put("*", (num1, num2) -> num1 * num2);
        operators.put("/", (num1, num2) -> {
            validDivideZero(num2);
            return num1 / num2;
        });
    }

    private static void validDivideZero(double num) {
        if (num == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
    }

    public static int startCalculate(Formulas formulas) {
        double accumulationValue = formulas.getNumToDouble(0);
        for (int index = 1; index < formulas.size(); index += 2) {
            accumulationValue = calculate(formulas.getOperation(index),
                    accumulationValue, formulas.getNumToDouble(index + 1));
        }
        return (int) accumulationValue;
    }

    private static double calculate(String operator, Double num1, Double num2) {
        return operators.get(operator).apply(num1, num2);
    }
}
