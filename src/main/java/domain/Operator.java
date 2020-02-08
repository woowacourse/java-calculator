package domain;

public enum Operator {
    PLUS("+"), MINUS("-"), MULTIPLY("*"), DIVIDE("/");

    private String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public boolean isPlusSymbol(String symbol) {
        return PLUS.symbol.equals(symbol);
    }

    public boolean isMinusSymbol(String symbol) {
        return MINUS.symbol.equals(symbol);
    }

    public boolean isMultiplySymbol(String symbol) {
        return MULTIPLY.symbol.equals(symbol);
    }

    public boolean isDivideSymbol(String symbol) {
        return DIVIDE.symbol.equals(symbol);
    }
}
