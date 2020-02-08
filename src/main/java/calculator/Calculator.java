package calculator;

public class Calculator {
    public double calculate(String[] splitedInput) {
        double left = Double.valueOf(splitedInput[0]);
        for (int i = 1; i < splitedInput.length; i = i + 2) {
            left = calculateByOperator(left, Double.valueOf(splitedInput[i + 1]), splitedInput[i]);
        }
        return left;
    }

    private double calculateByOperator(double left, double right, String operator) {
        if (Operator.Plus.getValue().equals(operator)) {
            return left + right;
        } else if (Operator.Minus.getValue().equals(operator)) {
            return left - right;
        } else if (Operator.Multiplication.getValue().equals(operator)) {
            return left * right;
        } else if (Operator.Division.getValue().equals(operator)) {
            return left / right;
        }
        return 0d;
    }
}
