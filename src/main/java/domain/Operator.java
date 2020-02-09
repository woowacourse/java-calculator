package domain;

enum Operator {
    PLUS('+'),
    MINUS('-'),
    MULTIPLIFICATION('*'),
    DIVISION('/');

    char operator;

    Operator(char operator) {
        this.operator = operator;
    }

    public boolean equals(char operator) {
        return this.operator == operator;
    }
}
