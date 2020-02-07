package calculator.calculate;

public class Multiply implements Calculatable {
    @Override
    public double calculate(double prev, double next) {
        return prev * next;
    }
}
