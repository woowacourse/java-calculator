package calculator;

import java.util.ArrayList;
import java.util.List;

public class Source {
    private List<Double> operands;
    private List<CalculatorType> operators;
    private boolean operandTurn;

    public Source(String[] inputs) throws Exception {
        operands = new ArrayList<>();
        operators = new ArrayList<>();
        operandTurn = true;
        generateSource(inputs);
    }

    public void generateSource(String[] inputs) throws Exception {
        validateSizeOfInputsIsOdds(inputs);
        validateInputsByIndex(inputs);
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
            operands.add(operand);
        }
        if (!operandTurn) {
            CalculatorType operator = CalculatorType.validateOperator(input);
            operators.add(operator);
        }
        operandTurn = !operandTurn;
    }
}
