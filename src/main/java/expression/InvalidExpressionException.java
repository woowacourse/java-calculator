package expression;

public class InvalidExpressionException extends IllegalArgumentException {

    public static final String WRONG_MATCH_NUMBER_OPERATOR = "수식에 숫자와 연산자를 확인해주세요";
    public static final String NOT_A_NUMBER = "숫자가 들어가야 할 자리에 다른 문자가 입력되었습니다";
    public static final String WRONG_OPERATOR = "연산자 자리에 다른 문자가 입력되었습니다.";

    public InvalidExpressionException(String errorMessage) {
        super(errorMessage);
    }

}
