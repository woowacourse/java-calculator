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

    public static double calculateBy(OperatorGroup operator, double a, double b) {
        if (operator.isPlus()) {
            return a + b;
        }
        if (operator.isMinus()) {
            return a - b;
        }
        if (operator.isMultiply()) {
            return a * b;
        }
        if (operator.isDivide()) {
            return a / b;
        }
        throw new IllegalStateException("잘못된 연산자가 입력되었습니다.");
    }
}
