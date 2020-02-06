package calculator.domain.operator;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum OperatorGroup {
    PLUS("+", Double::sum),
    MINUS("-", (a, b) -> a - b),
    MULTIPLE("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> a / b);

    private final OperationStrategy operationStrategy;
    private final String delimiter;

    OperatorGroup(String delimiter, OperationStrategy operationStrategy) {
        this.delimiter = delimiter;
        this.operationStrategy = operationStrategy;
    }

    public static double operate(double a, String inputOperator, double b) {
        return findOperationStrategy(inputOperator)
                .operationStrategy
                .operate(a, b);
    }

    private static OperatorGroup findOperationStrategy(String inputOperator) {
        return Arrays.stream(values())
                .filter(operator -> operator.isEqual(inputOperator))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(inputOperator + "는 등록되지 않은 연산자 입니다."));
    }

    private boolean isEqual(String op) {
        return this.delimiter.equals(op);
    }
}
