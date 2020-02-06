package calculator.domain.operator;

@FunctionalInterface
public interface OperationStarategy {
    double operate(double a, double b);
}
