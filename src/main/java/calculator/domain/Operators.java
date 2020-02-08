package calculator.domain;

import java.util.InputMismatchException;

enum Operators {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private static Operators[] operators = Operators.values();
    private final String symbol;

    Operators(String symbol) {
        this.symbol = symbol;
    }

    public boolean hasThis(String symbol) {
        return symbol.equals(this.symbol);
    }

    public static Operators findOperator(String symbol) {
        for (Operators op : operators) {
            if (op.hasThis(symbol)) {
                return op;
            }
        }
        throw new InputMismatchException("해당 연산자 없음");
    }
}
