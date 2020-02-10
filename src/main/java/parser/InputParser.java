package parser;

import domain.OperatorGroup;

import java.util.*;

public class InputParser {
    private final static String SPACE = " ";
    private final static Map<String, OperatorGroup> map = new HashMap<>();

    public static String[] split(String input) {
        return input.split(SPACE);
    }

    public static List<String> extractNumber(String[] input) {
        List<String> numbers = new ArrayList<>();
        int numberIndex = 2;
        for (int i = 0; i < input.length; i++) {
            if (i % numberIndex == 0) {
                numbers.add(input[i]);
            }
        }
        return Collections.unmodifiableList(numbers);
    }

    public static List<OperatorGroup> extractOperator(String[] input) {
        init();
        List<OperatorGroup> operators = new ArrayList<>();
        int numberIndex = 2;
        for (int i = 0; i < input.length; i++) {
            if (i % numberIndex != 0) {
                operators.add(OperatorGroup.stringToOperator(input[i]));
            }
        }
        return Collections.unmodifiableList(operators);
    }

    private static void init() {
        map.put("+", OperatorGroup.PLUS);
        map.put("-", OperatorGroup.MINUS);
        map.put("*", OperatorGroup.MULTIPLY);
        map.put("/", OperatorGroup.DIVIDE);
    }
}
