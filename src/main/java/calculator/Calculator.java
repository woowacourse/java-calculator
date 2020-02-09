package calculator;

import view.InputView;
import view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Calculator {
    private static final String BLANK = " ";
    private static final int START_INDEX = 0;

    List<String> splittedStrings;

    public void setSplittedStrings(String input) {
        splittedStrings = Arrays.asList(input.split(BLANK));
        checkClusteredElements();
        checkIfStartWithSymbol();
    }

    public List<String> repeatRequestingCorrectMathematicalExpression() {
        try {
            String input = InputView.enterMathematicalExpression();
            setSplittedStrings(input);
            return splittedStrings;
        } catch (IllegalArgumentException e) {
            OutputView.print(e.getMessage());
            return repeatRequestingCorrectMathematicalExpression();
        }
    }

    private void checkClusteredElements() {
        IntStream.range(START_INDEX, splittedStrings.size() - 1).forEach(i -> {
            checkIfClustered(splittedStrings.get(i), splittedStrings.get(i + 1));
        });
    }

    private void checkIfClustered(String prev, String post) {
        if (isNumber(prev) && isNumber(post)) {
            throw new IllegalArgumentException("숫자가 연속되면 안됩니다");
        }
        if (!isNumber(prev) && !isNumber(post)) {
            throw new IllegalArgumentException("연산자가 연속되면 안됩니다");
        }
        return;
    }

    private void checkIfStartWithSymbol() {
        if (!isNumber(splittedStrings.get(START_INDEX))) {
            throw new IllegalArgumentException("숫자로 시작해야 합니다");
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
        Double state = Double.parseDouble(splittedStrings.get(START_INDEX));
        for (int i = 1; i < splittedStrings.size(); i++) {
            if (!isNumber(splittedStrings.get(i))) {
                try {
                    Operator operator = Operator.findOperatorBySymbol(splittedStrings.get(i));
                    state = operator.operate(state, Double.parseDouble(splittedStrings.get(i + 1)));
                } catch (IllegalArgumentException e) {
                    OutputView.print(e.getMessage());
                    repeatRequestingCorrectMathematicalExpression();
                }
            }
        }
        return state;
    }
}