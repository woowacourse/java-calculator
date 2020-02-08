package calculator;

public class SourceForCalculating {
    private Operands operands;
    private Operators operators;

    public SourceForCalculating() {
    }

    public SourceForCalculating(String[] inputs) throws Exception {
        operands = new Operands();
        operators = new Operators();
        generateSource(inputs);
    }

    public void generateSource(String[] inputs) throws Exception {
        validateSizeOfInputsIsOdds(inputs);
        validateInputsByIndex(inputs);
    }

    public double calculateInputs() {
        Double result = operands.remove();
        while (operators.isEmpty()) {
            CalculatorType operator = operators.remove();
            Double operand = operands.remove();
            result = CalculatorType.calculate(result, operator, operand);
        }
        return result;
    }

    public void printResult(double result) {
        System.out.println(result);
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
            CalculatorType operator = CalculatorType.validateOperator(input);
            operators.add(operator);
        }
    }
}
