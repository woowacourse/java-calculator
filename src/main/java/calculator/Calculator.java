package calculator;

public class Calculator {

    public static int calculate(Expression expression) {
        Operand firstOperand = new Operand(0+"");
        Operator operator = new Operator("+");
        Operand secondOperand = expression.getOperand(1);
        int result = 0;

        for (int i = 1; operator != null && secondOperand != null; i++) {
            result = calculateBinomial(firstOperand, operator, secondOperand);

            firstOperand = new Operand("" + result);
            operator = expression.getOperator(i);
            secondOperand = expression.getOperand(i + 1);
         }

        return result;
    }

    private static int calculateBinomial(Operand firstOperand,
            Operator operator, Operand secondOperand) {
        return calculateBinomialByRawData(firstOperand.getValue(),
            operator.getType(), secondOperand.getValue());
    }

    private static int calculateBinomialByRawData(int firstOperand,
            int operator, int secondOperand) {

        if (operator == Operator.ADD_TYPE) {
            return firstOperand + secondOperand;
        }

        if (operator == Operator.SUBTRACT_TYPE) {
            return firstOperand - secondOperand;
        }

        if (operator == Operator.MULTIPLY_TYPE) {
            return firstOperand * secondOperand;
        }

        return firstOperand / secondOperand;
    }
}
