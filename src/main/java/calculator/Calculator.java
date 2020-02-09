package calculator;

public class Calculator {
    public double calculate(String[] splitedInput) {
        double left = Double.valueOf(splitedInput[0]);
        for (int i = 1; i < splitedInput.length; i = i + 2) {
            String operator = splitedInput[i];
            double right = Double.valueOf(splitedInput[i + 1]);
            left = Operator.find(operator).calculate(left, right);
        }
        return left;
    }
}
