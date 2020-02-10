package calculator;

import view.ErrorView;

import java.util.Arrays;
import java.util.List;

public class Calculator {
    private static final String DELIMITER = " ";
    private static final Integer ZERO_INDEX = 0;
    private static final Integer FIRST_OPERATOR_INDEX = 1;
    private static final Integer NEXT_OPERATOR_STEP = 2;

    public static String calculate(String expression) throws IllegalArgumentException {
        List<String> tokens = Arrays.asList(expression.split(DELIMITER));

        checkIsValidSize(tokens);
        checkIsNumber(tokens.get(ZERO_INDEX));

        double result = Integer.parseInt(tokens.get(ZERO_INDEX));
        for (int i = FIRST_OPERATOR_INDEX; i < tokens.size(); i += NEXT_OPERATOR_STEP) {
            checkIsNumber(tokens.get(i + FIRST_OPERATOR_INDEX));
            result = operate(result, tokens.get(i), Integer.parseInt(tokens.get(i + FIRST_OPERATOR_INDEX)));
        }

        return Double.toString(result);
    }

    private static double operate(double prev, String term, double next) throws IllegalArgumentException {
        Operator operator = Operator.getOperator(term);

        return operator.calculate(prev, next);
    }

    private static void checkIsValidSize(List<String> tokens) throws IllegalArgumentException {
        if (isValidSize(tokens)) {
            return;
        }

        throw new IllegalArgumentException(ErrorView.INVALID_EXPRESSION_ERROR_STR);
    }

    private static boolean isValidSize(List<String> tokens) {
        return (tokens.size() & FIRST_OPERATOR_INDEX) == FIRST_OPERATOR_INDEX;
    }

    private static void checkIsNumber(String term) throws IllegalArgumentException {
        if (isNumber(term)) {
            return;
        }
        throw new IllegalArgumentException(ErrorView.INVALID_EXPRESSION_ERROR_STR);
    }

    private static boolean isNumber(String term) {
        int startIndex = ZERO_INDEX;

        if (isFirstMinusMoreThanOneSize(term)) {
            startIndex = FIRST_OPERATOR_INDEX;
        }

        for (int i = startIndex; i < term.length(); i++) {
            if (!Character.isDigit(term.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    private static boolean isFirstMinusMoreThanOneSize(String term) {
        return term.startsWith("-") && term.length() > FIRST_OPERATOR_INDEX;
    }
}
