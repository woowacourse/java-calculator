package calculator;

public class Calculator {
    public double calculate(String[] splitedInput) {
        double left = Double.valueOf(splitedInput[0]);
        for (int i = 1; i < splitedInput.length; i = i + 2) {
            left = calculateByOperator(left, Double.valueOf(splitedInput[i + 1]), splitedInput[i]);
        }
        return left;
    }

    public double calculateByOperator(double left, double right, String operator) {
        double result = 0d;
        if (operator.equals("+")) {
            result = left + right;
        }
        if (operator.equals("-")) {
            result = left - right;
        }
        if (operator.equals("*")) {
            result = left * right;
        }
        if (operator.equals("/")) {
            result = left / right;
        }
        return result;
    }
}
