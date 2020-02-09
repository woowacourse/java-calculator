package calculator;

import view.InputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Calculator {
    private static final String EXPRESSION_DELIMITER = " ";
    private static final int INDEX_START = 0;
    private static final int INDEX_ONE = 1;

    public String mathematicalExpression;

    Calculator() {
    }

    public void enterMathematicalExpression() {
        try {
            mathematicalExpression = InputView.enterMathematicalExpression();
            splitMathExpression(mathematicalExpression);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            enterMathematicalExpression();
        }
    }

    public Double calculate() {
        List<String> splittedExpression = splitMathExpression(mathematicalExpression);
        IntermediateState state = new IntermediateState(splittedExpression.get(INDEX_START));
        IntStream.range(0, splittedExpression.size())
                .filter(i -> !CalculatorException.isNumber(splittedExpression.get(i)))
                .forEach(i -> state.updateState(splittedExpression, i));
        return state.getState();
    }

    public List<String> splitMathExpression(String input) {
        mathematicalExpression = input;
        List<String> splittedExpression = Arrays.asList(input.split(EXPRESSION_DELIMITER));
        CalculatorException.checkValidSplit(splittedExpression);
        return splittedExpression;
    }

    class IntermediateState {
        double intermediateState;

        IntermediateState(String input) {
            intermediateState = Double.parseDouble(input);
        }

        public void updateState(List<String> splittedExpression, int operatorIndex) {
            double nextNumber = Double.parseDouble(splittedExpression.get(operatorIndex + INDEX_ONE));
            try {
                Operator currentOperator = Operator.getOperatorByString(splittedExpression.get(operatorIndex));
                intermediateState = currentOperator.calculate(intermediateState, nextNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                enterMathematicalExpression();
            }
        }

        public double getState() {
            return intermediateState;
        }
    }
}

