package calculator;

import java.util.function.BiFunction;

public enum Operator implements BiFunction<Double, Double, Double> {
    PLUS("+") {
        @Override
        public Double apply(Double input1, Double input2) {
            return input1 + input2;
        }
    },
    MINUS("-") {
        @Override
        public Double apply(Double input1, Double input2) {
            return input1 - input2;
        }
    },
    MULTIPLY("*") {
        @Override
        public Double apply(Double input1, Double input2) {
            return input1 * input2;
        }
    },
    DIVIDE("/") {
        @Override
        public Double apply(Double input1, Double input2) {
            checkZero(input2);
            return input1 / input2;
        }
    };

    private final String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public String toString() {
        return this.symbol;
    }

    public static Operator getOperatorByString(String input) {
        for (Operator operator : Operator.values()) {
            if (operator.toString().equals(input)) {
                return operator;
            }
        }
        throw new IllegalArgumentException("사칙연산 연산자만 계산 가능합니다");
    }

    private static void checkZero(double input) {
        if (input == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
    }
}