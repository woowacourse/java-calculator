package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private String operator;

    Operator (String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }
}
