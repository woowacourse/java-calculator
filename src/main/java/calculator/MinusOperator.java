package calculator;

public class MinusOperator implements Operator
{
    @Override
    public double calculate(double prev, double next) {
        return prev - next;
    }
}
