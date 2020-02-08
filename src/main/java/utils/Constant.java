package utils;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Constant {
    public static final int ZERO = 0;
    public static final int EVEN = 2;

    public static final BiFunction<Double, Double, Double> ADDITION = (a, b) -> a + b;
    public static final BiFunction<Double, Double, Double> SUBTRACTION = (a, b) -> a - b;
    public static final BiFunction<Double, Double, Double> MULTIPLICATION = (a, b) -> a * b;
    public static final BiFunction<Double, Double, Double> DIVISION = (a, b) -> {
        if (b == ZERO) Exit.sendErrorMessage("0으로는 나눌 수 없습니다.");
        return a / b;
    };
    public static final Map<Character, BiFunction<Double, Double, Double>> operatorFunction = new HashMap<>();

}
