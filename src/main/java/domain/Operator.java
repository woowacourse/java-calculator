package domain;

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
        for (Operator operator : Operator.values())
            if (operator.symbol == charOperator)
                return operator;
        return null;
    }
}
