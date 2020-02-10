package calculator.domain;

import calculator.view.OutputView;

import java.util.Arrays;

public class EquationHandler {
    private static final String DELIMITER = "\\s+";
    private static final int ZERO = 0;

    public static Equation handleRawEquation(String rawEquation) {
        rawEquation = rawEquation.trim();
        validateRawEquation(rawEquation);
        return createEquation(rawEquation);
    }

    private static void validateRawEquation(String rawEquation) {
        if (rawEquation.isEmpty()) {
            OutputView.printMessage_EmptyCase();
            throw new IllegalArgumentException("빈 문자열");
        }
    }

    private static Equation createEquation(String inputEquation) {
        String[] equationElements = inputEquation.split(DELIMITER, ZERO);
        return new Equation(Arrays.asList(equationElements));
    }
}
