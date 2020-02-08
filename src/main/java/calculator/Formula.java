package calculator;

import java.util.LinkedList;
import java.util.Queue;

public class Formula {
    private Queue<Double> operands;
    private Queue<OperatorType> operators;
    private boolean operandTurn;

    public Formula() {
    }

    public Formula(String[] inputs) {
        operands = new LinkedList<>();
        operators = new LinkedList<>();
        operandTurn = true;
        generateSource(inputs);
    }

    public void generateSource(String[] inputs) {
        validateSizeOfInputsIsOdds(inputs);
        validateInputsByIndex(inputs);
    }

    public double calculateInputs() {
        Double result = operands.poll();
        for (OperatorType operator : operators) {
            Double operand = operands.poll();
            result = operator.calculate(result, operand);
        }
        return result;
    }


    public void validateSizeOfInputsIsOdds(String[] inputs) {
        if (!isOddNumber(inputs.length)) {
            throw new IllegalArgumentException(inputs.length + "(length of inputs) is not odd");
        }
    }

    private boolean isOddNumber(int number) {
        return number % 2 == 1;
    }

    private void validateInputsByIndex(String[] inputs) {
        for (String input : inputs) {
            validateInputByIndex(input);
        }
    }

    private void validateInputByIndex(String input) {
        if (operandTurn) {
            double operand = Double.parseDouble(input);
            operands.offer(operand);
        }
        if (!operandTurn) {
            OperatorType operator = OperatorType.validateOperator(input);
            operators.offer(operator);
        }
        operandTurn = !operandTurn;
    }
}
