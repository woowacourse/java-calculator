package calculator.calculate;

public class Plus implements Calculatable {
    @Override
    public double calculate(double prev, double next) {
        return prev + next;
    }
}