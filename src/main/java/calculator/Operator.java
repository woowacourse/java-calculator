package calculator;

import java.util.Arrays;

public enum Operator {

    PLUS("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private String operator;

    Operator(String operator) {
        this.operator = operator;
    }

    public static Operator of(String operator) throws IllegalAccessException {
        return Arrays.stream(values())
                .filter(op -> op.operator.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());
    }

}
