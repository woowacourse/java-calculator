package calculator;

import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (x, y) -> x + y),
    SUBTRACT("-", (x, y) -> x - y),
    MULTIPLY("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);

    private String shape;
    private BiFunction<Double, Double, Double> function;

    Operator(String shape, BiFunction<Double, Double, Double> function) {
        this.shape = shape;
        this.function = function;
    }

    public static boolean isNotOperator(String input) {
        try {
            getOperator(input);
        } catch (IllegalArgumentException e) {
            return true;
        }
        return false;
    }

    public static Operator getOperator(String input) {
        Operator[] operators = Operator.values();
        for (Operator operator : operators) {
            if (operator.shape.equals(input)) {
                return operator;
            }
        }
        throw new IllegalArgumentException("입력값과 같은 연산 기호가 없습니다.");
    }

    public Double apply(double firstElement, double secondElement) {
        return this.function.apply(firstElement, secondElement);
    }
}
