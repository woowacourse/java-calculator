import java.util.function.BiFunction;
import java.util.function.Function;

public enum Operator {
    PLUS("+", (num1, num2) -> num1 + num2 ),
    MINUS("-", (num1, num2) -> num1 - num2 ),
    MUL("*", (num1, num2) -> num1 * num2 ),
    DIV("/",  (num1, num2) -> {
            if (Double.isInfinite(num1 / num2) || Double.isNaN(num1 / num2)) {
                throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
            }
            return num1 / num2;
    });

    private String stringOperator;
    private BiFunction<Double, Double, Double> calculate;

    Operator(String stringOperator, BiFunction<Double, Double, Double> calculate) {
        this.stringOperator = stringOperator;
        this.calculate = calculate;
    }

    static Operator getOperatorByString(String stringOperator) {
        Operator[] operators = values();

        for (Operator o : operators) {
            if (o.stringOperator.equals(stringOperator)) {
                return o;
            }
        }
        throw new IllegalArgumentException("연산자가 잘못되었습니다.");
    }

    double operate(double num1, double num2) {
        return calculate.apply(num1, num2);
    }
}
