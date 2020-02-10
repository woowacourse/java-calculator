package domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVISION("/");

    private final static Map<Operator, BiFunction<Double, Double, Double>> calculateFunctionMap = new HashMap<>();
    private final static Map<String, Operator> stringOperatorToOperatorMap = new HashMap<>();
    private String symbol;

    static {
        calculateFunctionMap.put(Operator.PLUS, (x, y) -> x + y);
        calculateFunctionMap.put(Operator.MINUS, (x, y) -> x - y);
        calculateFunctionMap.put(Operator.MULTIPLY, (x, y) -> x * y);
        calculateFunctionMap.put(Operator.DIVISION, (x, y) -> {
            if (y == 0) {
                throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
            }
            return x / y;
        });
        stringOperatorToOperatorMap.put("+", Operator.PLUS);
        stringOperatorToOperatorMap.put("-", Operator.MINUS);
        stringOperatorToOperatorMap.put("*", Operator.MULTIPLY);
        stringOperatorToOperatorMap.put("/", Operator.DIVISION);
    }

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public static Operator getOperatorForString(String stringOperator) {
        return stringOperatorToOperatorMap.get(stringOperator);
    }

    public double intermediateCalculation(double prev, double next) {
        return calculateFunctionMap.get(this)
                .apply(prev, next);
    }
}
