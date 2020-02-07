package calculator;

public class DivideOperator implements Operator {
    @Override
    public double calculate(double prev, double next) {
        return prev / next;
    }
}
