public class InputValidation {
    public void validateDouble(String[] values) {
        int length = values.length;

        for (int i = 0; i < length; i += 2) {
            try {
                Double.parseDouble(values[i]);
            } catch (Exception e) {
                throw new IllegalArgumentException("피연산자가 잘못되었습니다.");
            }
        }

    }

    public void validateOperator(String[] values) {
        int length = values.length;

        for (int i = 1; i < length; i += 2) {
            Operator.getOperatorByString(values[i]);
        }
    }

    public void validateEndWithOperator(String[] values) {
        int length = values.length;

        if (length % 2 == 0)
            throw new IllegalArgumentException("연산자와 숫자가 맞지 않습니다.");
    }
}
