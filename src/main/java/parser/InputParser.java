package parser;

import domain.OperatorGroup;

import java.util.ArrayList;
import java.util.List;

public class InputParser {
    private final static String SPACE = " ";

    public static String[] split(String input) {
        return input.split(SPACE);
    }

    public static List<String> extractNumber(String[] input) {
        List<String> numbers = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            if (i % 2 == 0) {
                numbers.add(input[i]);
            }
        }
        return numbers;
    }

    public static List<OperatorGroup> extractOperator(String[] input) {
        List<OperatorGroup> operators = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            if (i % 2 != 0) {
                operators.add(OperatorGroup.stringToOperator(input[i]));
            }
        }
        return operators;
    }
}
