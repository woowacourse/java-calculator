package calculator;

import java.util.List;

public class Calculator {
    private static final int START_INDEX = 0;
    private static final int DISTANCE_BETWEEN_OPERATORS = 2;

    public Double calculate(List<String> splittedStrings) {
        Double state = Double.parseDouble(splittedStrings.get(START_INDEX));
        for (int i = 1; i < splittedStrings.size(); i += DISTANCE_BETWEEN_OPERATORS) {
            Operator operator = Operator.findOperatorBySymbol(splittedStrings.get(i));
            state = operator.operate(state, Double.parseDouble(splittedStrings.get(i + 1)));
        }
        return state;
    }

    private static Boolean isNumber(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}