package calculator;

import java.util.HashMap;
import java.util.function.BiFunction;

public class Operator {
    private String value;
    private static final HashMap<String, BiFunction<Double, Double, Double>> operatings = new HashMap<>();

    static {
        operatings.put("+", (beforeOperand, afterOperand) -> beforeOperand + afterOperand);
        operatings.put("-", (beforeOperand, afterOperand) -> beforeOperand - afterOperand);
        operatings.put("*", (beforeOperand, afterOperand) -> beforeOperand * afterOperand);
        operatings.put("/", (beforeOperand, afterOperand) -> beforeOperand / afterOperand);
    }

    public Operator(String input) {
        value = input;
    }

    public static boolean isOperator(String input) {
        return operatings.containsKey(input);
    }

    public double operate(double firstValue, double secondValue) {
        return operatings.get(value).apply(firstValue, secondValue);
    }
}
