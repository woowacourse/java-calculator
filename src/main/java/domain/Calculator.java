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
        operators.put("/", (num1, num2) -> num1 / num2);
    }

    public static double calculate(String operator, Double num1, Double num2) {
        if (operator.equals("/") && num2.intValue() == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return operators.get(operator).apply(num1, num2);
    }
}
