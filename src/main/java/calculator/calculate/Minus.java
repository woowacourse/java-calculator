package calculator.calculate;

public class Minus implements Calculatable {
    @Override
    public double calculate(double prev, double next) {
        return prev - next;
    }
}
