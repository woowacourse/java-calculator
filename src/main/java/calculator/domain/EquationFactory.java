package calculator.domain;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class EquationFactory {

    private static final String NUMBER_FORMAT = "\\d+";

    public static Equation parseEquation(List<String> input) {
        return new Equation(getNumbers(input), getOperators(input));
    }

    private static List<Double> getNumbers(List<String> input) {
        return input.stream()
                .filter(EquationFactory::isNumber)
                .map(Double::parseDouble)
                .collect(toList());
    }

    private static List<String> getOperators(List<String> input) {
        return input.stream()
                .filter(EquationFactory::isNotNumber)
                .collect(toList());
    }

    private static boolean isNotNumber(String maybeNumber) {
        return !isNumber(maybeNumber);
    }

    private static boolean isNumber(String maybeNumber) {
        return maybeNumber.matches(NUMBER_FORMAT);
    }
}
