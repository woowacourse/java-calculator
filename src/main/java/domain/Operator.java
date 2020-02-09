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

    public boolean equals(String operator) {
        return this.operator.equals(operator);
    }

    public String toString() {
        return operator;
    }
}
