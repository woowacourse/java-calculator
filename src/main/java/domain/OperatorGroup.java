package domain;

public enum OperatorGroup {
    PLUS("+") {
        @Override
        public double calculate(double x, double y) {
            return Double.sum(x,y);
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

    public static OperatorGroup stringToOperator(String operator) {
        if (operator.equals(PLUS.letter)) {
            return OperatorGroup.PLUS;
        }
        if (operator.equals(MINUS.letter)) {
            return OperatorGroup.MINUS;
        }
        if (operator.equals(MULTIPLY.letter)) {
            return OperatorGroup.MULTIPLY;
        }
        if (operator.equals(DIVIDE.letter)) {
            return OperatorGroup.DIVIDE;
        }
        throw new IllegalStateException("잘못된 연산자가 입력되었습니다.");
    }

    public abstract double calculate(double x, double y);
}
