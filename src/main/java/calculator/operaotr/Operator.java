package calculator.operaotr;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public enum Operator {

    PLUS("+", (prev, next) -> prev + next),
    MULTIPLY("*", (prev, next) -> prev * next),
    MINUS("-", (prev, next) -> prev - next),
    DIVIDE("/", (prev, next) -> prev / next);

    private final String name;
    private final BiFunction<Double, Double, Double> operate;

    private static Map<String, Operator> matcher = getMatcher();

    private static Map<String, Operator> getMatcher() {
        Map<String, Operator> matcher = new HashMap<>();
        Arrays.stream(Operator.values()).forEach(operator -> matcher.put(operator.name, operator));
        return matcher;
    }

    Operator(String name, BiFunction<Double,Double, Double> operate) {
        this.name = name;
        this.operate = operate;
    }

    public static Operator from(String name) {
        if (!matcher.containsKey(name)) {
            throw new OperatorException();
        }
        return matcher.get(name);
    }

    public double calculate(double prev, double next) {
        return operate.apply(prev, next);
    }
}
