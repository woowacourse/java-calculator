package Model;

public enum Operator implements Operation {
    PLUS("+") {
        public double compute(double result, int number) {
            return result + number;
        }
    },
    MINUS("-") {
        public double compute(double result, int number) {
            return result - number;
        }
    },
    MULTIPLY("*") {
        public double compute(double result, int number) {
            return result * number;
        }
    },
    DIVIDE("/") {
        public double compute(double result, int number) {
            return result / number;
        }
    };

    private final String sign;

    Operator(String sign) {
        this.sign = sign;
    }

    public boolean isOperator(String sign) {
        return this.sign.equals(sign);
    }

    public static Operator from(String sign) {
        for (Operator op : Operator.values()) {
            if (op.sign.equals(sign)) {
                return op;
            }
        }
        return null;
    }

}

interface Operation {
    double compute(double result, int number);
}
