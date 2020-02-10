package domain;

import java.util.HashMap;
import java.util.Map;

public class Calculator {
    private double result;
    private final static Map<String, Operator> OPERATORS = new HashMap<>();

    static {
        OPERATORS.put("+", Operator.ADDITION);
        OPERATORS.put("-", Operator.SUBTRACTION);
        OPERATORS.put("*", Operator.MULTIPLICATION);
        OPERATORS.put("/", Operator.DIVISION);
    }

    public double run(String[] input) throws ArithmeticException {
        result = Double.parseDouble(input[0]);
        for (int i = 1; i < input.length; i += 2) {
            result = calculate(input[i], result, Double.parseDouble(input[i + 1]));
        }
        return result;
    }

    public double calculate(String operator, double operand1, double operand2) throws ArithmeticException {
        return OPERATORS.get(operator).apply(operand1, operand2);
    }
}
