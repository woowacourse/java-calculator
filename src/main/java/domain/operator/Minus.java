package domain.operator;

public class Minus implements Operator {
    @Override
    public double calculate(double prev, double next) {
        return prev - next;
    }
}
