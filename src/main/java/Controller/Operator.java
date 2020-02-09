package Controller;

public enum Operator {
    PLUS("+"){
        @Override
        public double compute(double num1, double num2){
            return num1 + num2;
        }
    },
    MINUS("-"){
        @Override
        public double compute(double num1, double num2){
            return num1 - num2;
        }
    },
    MULTIPLY("*"){
        @Override
        public double compute(double num1, double num2){
            return num1 * num2;
        }
    },
    DIVIDE("/"){
        @Override
        public double compute(double num1, double num2){
            return num1 / num2;
        }
    };

    private String sign;

    Operator(String sign) {
        this.sign = sign;
    }

    public abstract double compute(double num1, double num2);

    public static Operator getEnumFromString(String sign) {
        for (Operator op : Operator.values()) {
            if (op.sign.equals(sign)) {
                return op;
            }
        }
        return null;
    }

}
