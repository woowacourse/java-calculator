package calculator;

public enum Operator {
    Plus("+"), Minus("-"), Multiplication("*"), Division("/");

    private String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public String getValue() {
        return this.symbol;
    }
}
