package calculator;

import view.InputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Calculator {
    List<String> splittedStrings;

    Calculator() {}

    public List<String> enterMathematicalExpression() {
        try {
            splittedStrings = Arrays.asList(InputView.enterMathematicalExpression().split(" "));
            checkClusteredElements();
            checkIfStartWithSymbol();
            return splittedStrings;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return enterMathematicalExpression();
        }
    }

    private void checkIfStartWithSymbol() {
        if (!isNumber(splittedStrings.get(0))) {
            throw new IllegalArgumentException("숫자로 시작해야 합니다");
        }
    }

    private void checkClusteredElements() {
        IntStream.range(0,splittedStrings.size()-1).forEach(i->{
            checkIfClustered(splittedStrings.get(i), splittedStrings.get(i + 1));
        });
    }

    private void checkIfClustered(String prev, String post){
        if(isNumber(prev) && isNumber(post)){
            throw new IllegalArgumentException("숫자가 연속되면 안됩니다");
        } else if (!isNumber(prev) && !isNumber(post)) {
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
        Double state = Double.parseDouble(splittedStrings.get(0));
        for (int i = 1; i < splittedStrings.size(); i++) {
            if (!isNumber(splittedStrings.get(i))) {
                state = Operator.calculate(splittedStrings.get(i), state, Double.parseDouble(splittedStrings.get(i + 1)));
            }
        }
        return state;
    }

}
