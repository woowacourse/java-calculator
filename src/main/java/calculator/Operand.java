package calculator;

public class Operand extends FormulaElement {
    private final double operand;

    public Operand(String input) {
        operand = Double.parseDouble(input);
    }

    public Operand(double operand) {
        this.operand = operand;
    }

    public double getOperand() {
        return operand;
    }
}
