package calculator;

public class Calculator {
    public static double calculate(Expression expression) {
        double operand = expression.getOperand(1);
        double result = operand;

        try {
            for (int i = 1; ; i++) {
                operand = expression.getOperand(i + 1);
                result = Operator.getOperatorByString(expression.getOperator(i))
                            .function.apply(result, operand);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        } finally {
            return result;
        }
    }
}
