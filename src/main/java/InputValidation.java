public class InputValidation {
    static final int GAP = 2;
    static final int EVEN = 2;
    static final int DIGIT_START = 0;
    static final int OPERATOR_START = 1;


    public void validateDouble(String[] values) {
        int length = values.length;

        for (int i = DIGIT_START; i < length; i += GAP) {
            try {
                Double.parseDouble(values[i]);
            } catch (Exception e) {
                throw new IllegalArgumentException("피연산자가 잘못되었습니다.");
            }
        }

    }

    public void validateOperator(String[] values) {
        int length = values.length;

        for (int i = OPERATOR_START; i < length; i += GAP) {
            Operator.getOperatorByString(values[i]);
        }
    }

    public void validateEndWithOperator(String[] values) {
        int length = values.length;

        // 짝수로 끝난다면 연산자로 끝나는 경우
        if (length % EVEN == 0)
            throw new IllegalArgumentException("연산자와 숫자가 맞지 않습니다.");
    }
}
