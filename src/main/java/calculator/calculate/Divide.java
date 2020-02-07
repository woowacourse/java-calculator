package calculator.calculate;

public class Divide implements Calculatable {
    @Override
    public double calculate(double prev, double next) {
        return prev / next;
    }
}
