package calculator;

import java.util.Map;
import java.util.HashMap;

public enum Operator {
    PLUS("+") {
        @Override
        public int calculate(int a, int b) {
            return a + b;
        }
    },
    MINUS("-") {
        @Override
        public int calculate(int a, int b) {
            return a - b;
        }
    },
    MULTIPLY("*") {
        @Override
        public int calculate(int a, int b) {
            return a * b;
        }
    },
    DIVIDE("/") {
        @Override
        public int calculate(int a, int b) {
            return a / b;
        }
    };

    private static Map<String, Operator> cal = new HashMap<>();
    private String operation;

    Operator(String operation) {
        this.operation = operation;
    }

    public static void init() {
        cal.put("+", Operator.PLUS);
        cal.put("-", Operator.MINUS);
        cal.put("*", Operator.MULTIPLY);
        cal.put("/", Operator.DIVIDE);
    }

    public static boolean isValidOperator(String oper) {
        boolean status = false;
        for (Operator operator : Operator.values()) {
            status = status || operator.operation.contains(oper);
        }
        return status;
    }

    public abstract int calculate(int a, int b);

    public static Operator startCalculate(String oper) {
        return cal.get(oper);
    }
}
