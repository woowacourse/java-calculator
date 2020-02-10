package domain;

public class ExpressionException extends IllegalArgumentException {
    public static final String NOT_A_NUMBER = "항의 자리엔 숫자가 와야합니다.";
    public static final String INVALID_OPERATION = "적절한 연산자가 아닙니다.";

    public ExpressionException(String errorMessage) {
        super(errorMessage);
    }
}
