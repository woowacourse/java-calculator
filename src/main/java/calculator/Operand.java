package calculator;

public class Operand {
    private double value;

    public Operand(String input) {
        value = Double.parseDouble(input);
    }

    public double getValue() {
        return value;
    }
}
