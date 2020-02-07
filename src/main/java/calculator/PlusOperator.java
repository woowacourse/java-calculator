package calculator;

public class PlusOperator implements Operator {
    @Override
    public double calculate(double prev, double next) {
        return prev + next;
    }
}