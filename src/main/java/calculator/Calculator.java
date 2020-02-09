package calculator;

import view.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Calculator {
    private static final String EXPRESSION_DELIMITER = " ";
    private static final int INDEX_START = 0;
    private static final int INDEX_ONE = 1;

    private Double calculationResult;

    Calculator() {
    }

    public void calculate(String input) {
        List<String> splittedExpression = splitMathExpression(input);
        IntermediateState state = new IntermediateState(splittedExpression.get(INDEX_START));
        IntStream.range(0, splittedExpression.size())
                .filter(i -> !CalculatorException.isNumber(splittedExpression.get(i)))
                .forEach(i -> state.updateState(splittedExpression, i));
        calculationResult = state.getState();
    }

    public static List<String> splitMathExpression(String input) {
        CalculatorException.checkValidInput(input);
        return Arrays.asList(input.split(EXPRESSION_DELIMITER));
    }

    public Double getResult() {
        return calculationResult;
    }

    class IntermediateState {
        double intermediateState;

        IntermediateState(String input) {
            intermediateState = Double.parseDouble(input);
        }

        public void updateState(List<String> splittedExpression, int operatorIndex) {
            double nextNumber = Double.parseDouble(splittedExpression.get(operatorIndex + INDEX_ONE));
            Operator currentOperator = Operator.getOperatorByString(splittedExpression.get(operatorIndex));
            intermediateState = currentOperator.calculate(intermediateState, nextNumber);
        }

        public double getState() {
            return intermediateState;
        }
    }
}

