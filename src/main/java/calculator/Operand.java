package calculator;

public class Operand {
    private final double operand;

    public Operand(double operand) {
        this.operand = operand;
    }

    public Operand(String input) {
        this(Double.parseDouble(input));
    }

    public double getOperand() {
        return operand;
    }
}
