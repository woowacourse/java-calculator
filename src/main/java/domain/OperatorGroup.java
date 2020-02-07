package domain;

public enum OperatorGroup {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    OperatorGroup(String letter) {
        this.letter = letter;
    }

    private String letter;

    private boolean isPlus() {
        return this.letter.equals(OperatorGroup.PLUS.letter);
    }

    private boolean isMinus() {
        return this.letter.equals(OperatorGroup.MINUS.letter);
    }

    private boolean isMultiply() {
        return this.letter.equals(OperatorGroup.MULTIPLY.letter);
    }

    private boolean isDivide() {
        return this.letter.equals(OperatorGroup.DIVIDE.letter);
    }

    public double calculateBy(double a, double b) {
        if (isPlus()) {
            return a + b;
        }
        if (isMinus()) {
            return a - b;
        }
        if (isMultiply()) {
            return a * b;
        }
        if (isDivide()) {
            return a / b;
        }
        throw new IllegalStateException("잘못된 연산자가 입력되었습니다.");
    }

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
