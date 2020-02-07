package calculator.domain.operator;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum OperatorGroup {
    PLUS("+", Double::sum),
    MINUS("-", (a, b) -> a - b),
    MULTIPLE("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> a / b);

    private static final String NOT_FOUND_OPERATOR_MESSAGE = "%s는 등록되지 않은 연산자 입니다.";

    private final OperationStrategy operationStrategy;
    private final String delimiter;

    OperatorGroup(String delimiter, OperationStrategy operationStrategy) {
        this.delimiter = delimiter;
        this.operationStrategy = operationStrategy;
    }

    public static OperatorGroup findByDelimiter(String delimiter) {
        return Arrays.stream(values())
                .filter(aOperator -> aOperator.isEqual(delimiter))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(String.format(NOT_FOUND_OPERATOR_MESSAGE, delimiter)));
    }

    public double operate(double a, double b) {
        return this.operationStrategy.operate(a, b);
    }

    private boolean isEqual(String op) {
        return this.delimiter.equals(op);
    }
}
