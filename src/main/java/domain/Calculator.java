package domain;

import java.util.HashMap;
import java.util.Map;

public class Calculator {
    private double result;

    public double run(String[] input) {
        result = Double.parseDouble(input[0]);
        for (int i = 1; i < input.length; i += 2) {
            result = calculate(input[i], result, Double.parseDouble(input[i + 1]));
        }
        return result;
    }

    private final static Map<String, Operator> OPERATORS = new HashMap<>();

    static {
        OPERATORS.put("+", Operator.ADDITION);
        OPERATORS.put("-", Operator.SUBTRACTION);
        OPERATORS.put("*", Operator.MULTIPLICATION);
        OPERATORS.put("/", Operator.DIVISION);
    }

    public double calculate(String operator, double operand1, double operand2) {
        return OPERATORS.get(operator).apply(operand1, operand2);
    }
}
