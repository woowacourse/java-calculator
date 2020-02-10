package domain;

import java.util.HashMap;
import java.util.Map;

public enum OperatorGroup {
    PLUS("+") {
        public double apply(double a, double b) {
            return a + b;
        }
    },
    MINUS("-") {
        public double apply(double a, double b) {
            return a - b;
        }
    },
    MULTIPLY("*") {
        public double apply(double a, double b) {
            return a * b;
        }
    },
    DIVIDE("/") {
        public double apply(double a, double b) {
            return a / b;
        }
    };

    OperatorGroup(String letter) {
        this.letter = letter;
    }

    private String letter;

    public abstract double apply(double a, double b);

    private final static Map<String, OperatorGroup> operatorStringMap = new HashMap<>();

    static {
        operatorStringMap.put("+", OperatorGroup.PLUS);
        operatorStringMap.put("-", OperatorGroup.MINUS);
        operatorStringMap.put("*", OperatorGroup.MULTIPLY);
        operatorStringMap.put("/", OperatorGroup.DIVIDE);
    }

    public static OperatorGroup stringToOperator(String operator) {
        return operatorStringMap.get(operator);
    }
}
