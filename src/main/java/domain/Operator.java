package domain;

enum Operator {
    PLUS("+"),
    MINUS("-"),
    MULTIPLIFICATION("*"),
    DIVISION("/");

    String operator;

    Operator(String operator) {
        this.operator = operator;
    }

    public boolean isPlus() {
        return this == PLUS;
    }

    public boolean isMinus() {
        return this == MINUS;
    }

    public boolean isMultiplification() {
        return this == MULTIPLIFICATION;
    }

    @Override
    public String toString() {
        return operator;
    }
}
