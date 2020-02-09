package calculator;

public class Operator {
    private String value;
    private enum OperatorType {

    }

    public Operator(String input) {
        value = input;
    }

    public static boolean isOperator(String input) {
        return input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/");
    }

    public double operate(double firstValue, double secondValue) {

        if (value.equals("+")) {
            return firstValue + secondValue;
        }

        if (value.equals("-")) {
            return firstValue - secondValue;
        }

        if (value.equals("*")) {
            return firstValue * secondValue;
        }

        return firstValue / secondValue;
    }
}
