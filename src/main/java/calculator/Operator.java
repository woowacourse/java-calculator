package calculator;

public class Operator extends FormulaElement {
    private final OperatorType operator;

    public Operator(OperatorType operator) {
        this.operator = operator;
    }

    public Operator(String input) {
        this(OperatorType.createOperator(input));
    }

    public double calculate(Operand operand1, Operand operand2) {
        return operator.calculate(operand1, operand2);
    }
}
