package calculator;

public class MultiplyOperator implements Operator {
    @Override
    public double calculate(double prev, double next) {
        return prev * next;
    }
}
