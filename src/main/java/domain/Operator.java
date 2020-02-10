package domain;

import domain.errors.UnAcceptableOperatorException;

public enum Operator {
    ADD("+", (int number1, int number2) ->  number1 + number2),
    SUBSTRACT("-", (int number1, int number2) -> number1 - number2),
    MULTIPLY("*", (int number1, int number2) ->  number1 * number2),
    DIVIDE("/", (int number1, int number2) -> number1 / number2);

    private String pattern;
    private Operation operation;

    Operator(String patten, Operation operation) {
        this.pattern = patten;
        this.operation = operation;
    }

    public static Operation getOperationByPattern(String pattern) {
        for (Operator operator : values()) {
            if (operator.matchPattern(pattern)) {
                return operator.getOperation();
            }
        }

        throw new UnAcceptableOperatorException(String.format("%s is not supproted operator", pattern));
    }

    private boolean matchPattern(String pattern) {
        return this.pattern.equals(pattern);
    }

    private Operation getOperation() {
        return operation;
    }
}
