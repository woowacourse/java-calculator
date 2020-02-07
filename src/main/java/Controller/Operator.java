package Controller;

public enum Operator {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private String sign;

    Operator(String sign) {
        this.sign = sign;
    }

    public double compute(double result, int number) {
        switch (this) {
            case PLUS:
                result += number;
                return result;
            case MINUS:
                result -= number;
                return result;
            case MULTIPLY:
                result *= number;
                return result;
            case DIVIDE:
                result /= number;
                return result;
            default:
                return result;
        }
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
