package domain.operator;

public class Divide implements Operator {
    @Override
    public double calculate(double prev, double next) {
        return prev / next;
    }
}
