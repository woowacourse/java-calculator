package domain;

import java.util.Arrays;

public enum Operator {
    PLUS('+'),
    MINUS('-'),
    MULTIPLY('*'),
    DIVISION('/');

    private char symbol;

    Operator(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public static Operator getOperatorForChar(char charOperator) {
        return Arrays.stream(Operator.values())
                .filter(x -> x.symbol == charOperator)
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}
