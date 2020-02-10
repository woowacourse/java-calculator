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
        if (Operator.PLUS.getOperator().equals(operator)) {
            return left + right;
        }
        if (Operator.MINUS.getOperator().equals(operator)) {
            return left - right;
        }
        if (Operator.MULTIPLY.getOperator().equals(operator)) {
            return left * right;
        }
        if (Operator.DIVIDE.getOperator().equals(operator)) {
            return left / right;
        }
        throw new IllegalArgumentException("Operator exception.");
    }
}
