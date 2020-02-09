package calculator;

public class Calculator {

    public static double calculate(Expression expression) {
        Operand firstOperand = new Operand(0+"");
        Operator operator = new Operator("+");
        Operand secondOperand = expression.getOperand(1);
        double result = 0;

        for (int i = 1; operator != null && secondOperand != null; i++) {
            result = calculateBinomial(firstOperand, operator, secondOperand);

            firstOperand = new Operand("" + result);
            operator = expression.getOperator(i);
            secondOperand = expression.getOperand(i + 1);
         }

        return result;
    }

    private static double calculateBinomial(Operand firstOperand,
            Operator operator, Operand secondOperand) {
        return calculateBinomialByRawData(firstOperand.getValue(),
            operator, secondOperand.getValue());
    }

    private static double calculateBinomialByRawData(double firstOperand,
            Operator operator, double secondOperand) {
        return operator.operate(firstOperand, secondOperand);
    }
}
