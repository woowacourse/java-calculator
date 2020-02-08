package calculator.domain.operator;

@FunctionalInterface
public interface OperationStrategy {
    double operate(double a, double b);
}
