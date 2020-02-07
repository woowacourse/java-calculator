package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static calculator.Operator.checkIfOperator;

public class Calculator {
    List<String> splittedStrings;

    Calculator(String input) {
        splittedStrings = Arrays.asList(input.split(" "));
        checkClusteredElements();
        checkIfStartWithSymbol();
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
}
