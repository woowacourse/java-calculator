package calculator;

import view.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Calculator {
    private static final String EXPRESSION_DELIMITER = " ";
    private static final int INDEX_START = 0;
    private static final int INDEX_ONE = 1;

    List<String> splittedStrings;

    Calculator() {
    }

    //테스트용 setter메서드
    public void setSplittedStrings(String input) {
        splittedStrings = Arrays.asList(input.split(EXPRESSION_DELIMITER));
        checkValidList();
    }

    public List<String> enterMathematicalExpression() {
        try {
            splittedStrings = Arrays.asList(InputView.enterMathematicalExpression().split(EXPRESSION_DELIMITER));
            checkValidList();
            return splittedStrings;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return enterMathematicalExpression();
        }
    }

    private void checkValidList() {
        checkClusteredElements();
        checkIfStartWithSymbol();
        checkIfEndWithSymbol();
    }

    private void checkIfStartWithSymbol() {
        if (!isNumber(splittedStrings.get(INDEX_START))) {
            throw new IllegalArgumentException("숫자로 시작해야 합니다");
        }
    }

    private void checkIfEndWithSymbol() {
        if (!isNumber(splittedStrings.get(splittedStrings.size() - INDEX_ONE))) {
            throw new IllegalArgumentException("숫자로 끝나야 합니다");
        }
    }

    private void checkClusteredElements() {
        IntStream.range(0, splittedStrings.size() - INDEX_ONE).forEach(i -> {
            checkIfClustered(splittedStrings.get(i), splittedStrings.get(i + INDEX_ONE));
        });
    }

    private void checkIfClustered(String prev, String post) {
        checkIfBothAreNumbers(prev, post);
        checkIfBothAreSymbols(prev, post);
    }

    private void checkIfBothAreNumbers(String prev, String post) {
        if (isNumber(prev) && isNumber(post)) {
            throw new IllegalArgumentException("숫자가 연속되면 안됩니다");
        }
    }

    private void checkIfBothAreSymbols(String prev, String post) {
        if (!isNumber(prev) && !isNumber(post)) {
            throw new IllegalArgumentException("연산자가 연속되면 안됩니다");
        }
    }

    private Boolean isNumber(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public Double calculate() {
        IntermediateState state = new IntermediateState(splittedStrings.get(INDEX_START));
        IntStream.range(0, splittedStrings.size())
                .filter(i -> !isNumber(splittedStrings.get(i)))
                .forEach(i -> state.updateState(splittedStrings, i));
        return state.getState();
    }

    class IntermediateState {
        double intermediateState;

        IntermediateState(String input) {
            intermediateState = Double.parseDouble(input);
        }

        public void updateState(List<String> splittedStrings, int operatorIndex) {
            double nextNumber = Double.parseDouble(splittedStrings.get(operatorIndex + INDEX_ONE));
            try {
                Operator currentOperator = Operator.getOperatorByString(splittedStrings.get(operatorIndex));
                intermediateState = currentOperator.apply(intermediateState, nextNumber);
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

