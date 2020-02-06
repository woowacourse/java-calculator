package calculator.domain;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class EquationFactory {

    private static final String NUMBER_FORMAT = "\\d+";

    public static Equation parseEquation(List<String> input) {
        validate(input);
        return new Equation(getNumbers(input), getOperators(input));
    }

    private static void validate(List<String> input) {
        if (input.size() % 2 == 0) {
            throw new IllegalArgumentException("식이 올바르지 않습니다.\n숫자와 연산자의 개수를 확인해 주세요.");
        }
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
