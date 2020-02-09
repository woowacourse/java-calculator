package calculator;

import view.ErrorView;

import java.util.Arrays;
import java.util.List;

public class Calculator {
    private static String delimiter = " ";

    public static String calculate(String expression) throws IllegalArgumentException {
        List<String> tokens = Arrays.asList(expression.split(delimiter));

        checkIsValidSize(tokens);
        checkIsNumber(tokens.get(0));

        double result = Integer.parseInt(tokens.get(0));
        for (int i = 1; i < tokens.size(); i += 2) {
            checkIsNumber(tokens.get(i + 1));
            result = operate(result, tokens.get(i), Integer.parseInt(tokens.get(i + 1)));
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

        throw new IllegalArgumentException(ErrorView.InvalidExpressionErrorStr);
    }

    private static boolean isValidSize(List<String> tokens) {
        return (tokens.size() & 1) == 1;
    }

    private static void checkIsNumber(String term) throws IllegalArgumentException {
        if (isNumber(term)) {
            return;
        }
        throw new IllegalArgumentException(ErrorView.InvalidExpressionErrorStr);
    }

    private static boolean isNumber(String term) {
        int firstIndex = 0;

        if (isFirstMinusMoreThanOneSize(term)) {
            firstIndex = 1;
        }

        for (int i = firstIndex; i < term.length(); i++) {
            if (!Character.isDigit(term.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    private static boolean isFirstMinusMoreThanOneSize(String term) {
        return term.startsWith("-") && term.length() > 1;
    }
}
