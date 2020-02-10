package domain;

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
}
