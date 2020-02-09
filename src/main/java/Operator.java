import java.util.function.BinaryOperator;

public enum Operator {
    PLUS("+") {
        double operate(double num1, double num2) {
            return operate2((s, t) -> s + t, num1, num2);
        }
    },
    MINUS("-") {
        double operate(double num1, double num2) {
            return operate2((s, t) -> s - t, num1, num2);
        }
    },
    MUL("*") {
        double operate(double num1, double num2) {
            return operate2((s, t) -> s * t, num1, num2);
        }
    },
    DIV("/") {
        double operate(double num1, double num2) {
            double result = num1 / num2;

            if (Double.isInfinite(result) || Double.isNaN(result)) {
                throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
            }

            return operate2((s, t) -> s / t, num1, num2);
        }
    };

    private String stringOperator;

    Operator(String stringOperator) {
        this.stringOperator = stringOperator;
    }

    abstract double operate(double num1, double num2);

    double operate2(BinaryOperator<Double> binaryOperator, double num1,
                    double num2) {
        return binaryOperator.apply(num1, num2);
    }

    static Operator getOperatorByString(String stringOperator) throws IllegalArgumentException {
        Operator[] operators = values();

        for (Operator o : operators) {
            if (o.stringOperator.equals(stringOperator)) {
                return o;
            }
        }
        throw new IllegalArgumentException("연산자가 잘못되었습니다.");
    }
}
