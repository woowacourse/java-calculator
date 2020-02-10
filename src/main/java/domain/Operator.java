package domain;

public enum Operator {
    ADDITION("+") {
        @Override
        public double apply(double operand1, double operand2) {
            return operand1 + operand2;
        }
    },
    SUBTRACTION("-") {
        @Override
        public double apply(double operand1, double operand2) {
            return operand1 - operand2;
        }
    },
    MULTIPLICATION("*") {
        @Override
        public double apply(double operand1, double operand2) {
            return operand1 * operand2;
        }
    },
    DIVISION("/") {
        @Override
        public double apply(double operand1, double operand2) {
            if (Double.isInfinite(operand1 / operand2)) {
                throw new ArithmeticException("0으로 나눌수 없습니다.");
            }
            return operand1 / operand2;
        }
    },
    ;

    private final String textOperator;

    private Operator(String textOperator) {
        this.textOperator = textOperator;
    }

    public abstract double apply(double operand1, double operand2);

}
