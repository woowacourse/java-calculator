package calculator;

public class Expression {
    private Operands operands;
    private Operators operators;

    public Expression(String[] inputs) throws Exception {
        operands = new Operands();
        operators = new Operators();
        generateExpression(inputs);
    }

    public void generateExpression(String[] inputs) throws Exception {
        validateSizeOfInputsIsOdds(inputs);
        validateInputsByIndex(inputs);
    }

    public double calculateInputs() {
        Double result = operands.remove();
        while (!operators.isEmpty()) {
            Operator operator = operators.remove();
            Double operand = operands.remove();
            result = Operator.calculate(result, operator, operand);
        }
        return result;
    }

    public void validateSizeOfInputsIsOdds(String[] inputs) throws IllegalArgumentException {
        if (!isOddNumber(inputs.length)) {
            throw new IllegalArgumentException("inputs의 사이즈가 홀수가 아님");
        }
    }

    private boolean isOddNumber(int number) {
        return number % 2 == 1;
    }

    private void validateInputsByIndex(String[] inputs) throws Exception {
        for (int i = 0; i < inputs.length; i++) {
            validateInputByIndex(i, inputs[i]);
        }
    }

    private void validateInputByIndex(int index, String input) throws NumberFormatException, IllegalArgumentException {
        if (!isOddNumber(index)) {
            double operand = Double.parseDouble(input);
            operands.add(operand);
        }

        if (isOddNumber(index)) {
            Operator operator = Operator.validateOperator(input);
            operators.add(operator);
        }
    }
}
