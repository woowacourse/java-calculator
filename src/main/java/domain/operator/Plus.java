package domain.operator;

public class Plus implements Operator {
    @Override
    public double calculate(double prev, double next) {
        return prev + next;
    }
}