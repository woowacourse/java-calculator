package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static calculator.Operator.checkIfOperator;

public class SplitedStrings {
    List<String> splittedStrings;

    SplitedStrings(String input) {
        splittedStrings = Arrays.asList(input.split(" "));
        checkClusteredNumbers();
    }

    private void checkClusteredNumbers() {
        IntStream.range(0,splittedStrings.size()-1).forEach(i->{
            checkIfBothAreNumbers(splittedStrings.get(i), splittedStrings.get(i + 1));
            checkIfBothAreOperators(splittedStrings.get(i), splittedStrings.get(i + 1));
        });
    }

    private void checkIfBothAreNumbers(String input1, String input2) {
        try {
            checkIfNumber(input1);
            checkIfNumber(input2);
        } catch (IllegalArgumentException e) {
        }
        throw new IllegalArgumentException("숫자가 연속되면 안됩니다");
    }

    private void checkIfBothAreOperators(String input1, String input2) {
        try {
            checkIfOperator(input1);
            checkIfOperator(input2);
        } catch (IllegalArgumentException e) {
        }
        throw new IllegalArgumentException("연산자가 연속되면 안됩니다");
    }

    private void checkIfNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }
}
