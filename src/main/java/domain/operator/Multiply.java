package domain.operator;

public class Multiply implements Operator {
    @Override
    public double calculate(double prev, double next) {
        return prev * next;
    }
}
