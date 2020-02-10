package domain;

import java.util.HashMap;
import java.util.Map;

public enum OperatorGroup {
    PLUS("+") {
        @Override
        public double calculate(double x, double y) {
            return Double.sum(x, y);
        }
    },
    MINUS("-") {
        @Override
        public double calculate(double x, double y) {
            return x - y;
        }
    },
    MULTIPLY("*") {
        @Override
        public double calculate(double x, double y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        @Override
        public double calculate(double x, double y) {
            return x / y;
        }
    };

    OperatorGroup(String letter) {
        this.letter = letter;
    }

    private String letter;
    private final static Map<String, OperatorGroup> map = new HashMap<>();

    public static OperatorGroup stringToOperator(String operator) {
        return map.get(operator);
    }

    public abstract double calculate(double x, double y);

    static {
        map.put("+", OperatorGroup.PLUS);
        map.put("-", OperatorGroup.MINUS);
        map.put("*", OperatorGroup.MULTIPLY);
        map.put("/", OperatorGroup.DIVIDE);
    }
}
