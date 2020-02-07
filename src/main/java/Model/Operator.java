package Model;

public enum Operator {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private String sign;

    Operator(String sign) {
        this.sign = sign;
    }

    public boolean isOperator(String sign) {
        return this.sign.equals(sign);
    }

    public double compute(double result, int number) {
        if (this == PLUS) {
            result += number;
            return result;
        }

        if (this == MINUS) {
            result -= number;
            return result;
        }

        if (this == MULTIPLY) {
            result *= number;
            return result;
        }

        if (this == DIVIDE) {
            result /= number;
            return result;
        }
        return result;
    }

    public static Operator getEnumFromString(String sign) {
        for (Operator op : Operator.values()) {
            if (op.sign.equals(sign)) {
                return op;
            }
        }
        return null;
    }

}
