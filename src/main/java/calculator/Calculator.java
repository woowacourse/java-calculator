package calculator;

public class Calculator {
    private static final int ZERO_SIZE = 0;

    public static double calculateFormula(Formula formula) {
        Operand result = formula.getOperand();
        while(formula.size() > ZERO_SIZE) {
            Operator operator = formula.getOperator();
            Operand operand = formula.getOperand();
            result = new Operand(operator.calculate(result, operand));
        }
        return result.getOperandValue();
    }
}
