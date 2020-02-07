package calculator;

import java.util.LinkedList;
import java.util.Queue;

public class Source {
    private Queue<Double> operands;
    private Queue<CalculatorType> operators;
    private boolean operandTurn;

    public Source(String[] inputs) throws Exception {
        operands = new LinkedList<>();
        operators = new LinkedList<>();
        operandTurn = true;
        generateSource(inputs);
    }

    public void generateSource(String[] inputs) throws Exception {
        validateSizeOfInputsIsOdds(inputs);
        validateInputsByIndex(inputs);
    }

    public double calculateInputs() {
        Double result = operands.poll();

        for (CalculatorType operator : operators) {
            Double operand = operands.poll();
            CalculatorType.calculate(result, operator, operand);
        }
        return result;
    }

    private void validateSizeOfInputsIsOdds(String[] inputs) throws Exception {
        if (isOddNumber(inputs.length)) {
            throw new Exception("inputs의 사이즈가 홀수가 아님");
        }
    }

    private boolean isOddNumber(int number) {
        return number % 2 == 1;
    }

    private void validateInputsByIndex(String[] inputs) throws Exception {
        for (String input : inputs) {
            validateInputByIndex(input);
        }
    }

    private void validateInputByIndex(String input) throws Exception {
        if (operandTurn) {
            double operand = Double.parseDouble(input);
            operands.offer(operand);
        }
        if (!operandTurn) {
            CalculatorType operator = CalculatorType.validateOperator(input);
            operators.offer(operator);
        }
        operandTurn = !operandTurn;
    }
}
