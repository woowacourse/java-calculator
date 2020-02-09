package calculator;

public class Operator {
    private String value;

    public Operator(String input) {
        value = input;
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
