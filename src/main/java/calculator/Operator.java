package calculator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.function.BiFunction;

public enum Operator {

    PLUS("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    Operator(String operator) {
        this.operator = operator;
    }

    public static HashMap<Operator, BiFunction<Double, Double, Double>> map = new HashMap<>();
    private String operator;

    static {
        map.put(Operator.PLUS, (a, b) -> a + b);
        map.put(Operator.SUBTRACT, (a, b) -> a - b);
        map.put(Operator.MULTIPLY, (a, b) -> a * b);
        map.put(Operator.DIVIDE, (a, b) -> divideBiFunction(a, b));
    }

    public static double divideBiFunction(double a, double b) {
        if (b == 0) throw new ArithmeticException("0으로 나눌 수 없습니다.");
        return a / b;
    }

    public static Operator of(String operator) throws IllegalAccessException {
        return Arrays.stream(values())
                .filter(op -> op.operator.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());
    }

}
