package domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public enum Operator {
    PLUS('+'),
    MINUS('-'),
    MULTIPLY('*'),
    DIVISION('/');

    private final static Map<Operator, BiFunction<Double, Double, Double>> calculateFunctionMap = new HashMap<>();
    private char symbol;

    static {
        calculateFunctionMap.put(Operator.PLUS, (x, y) -> x + y);
        calculateFunctionMap.put(Operator.MINUS, (x, y) -> x - y);
        calculateFunctionMap.put(Operator.MULTIPLY, (x, y) -> x * y);
        calculateFunctionMap.put(Operator.DIVISION, (x, y) -> x / y);
    }

    Operator(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public static Operator getOperatorForChar(char charOperator) {
        return Arrays.stream(Operator.values())
                .filter(x -> x.symbol == charOperator)
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public double intermediateCalculation(double prev, double next) {
        return calculateFunctionMap.get(this)
                .apply(prev, next);
    }
}
