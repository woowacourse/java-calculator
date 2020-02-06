package Controller;

import View.InputView;
import View.OutputView;

public class InputException {

    public static void checkException() {
        OutputView.printInputMessage();
        String[] inputs = InputView.input();
        try {
            validateFirstAndLast(inputs);
            validateRepeat(inputs);
        } catch (Exception e) {
            OutputView.printInputExceptionMessage();
            checkException();
        }
    }

    /**
     * 문자열 앞, 뒤 유효성 검사
     * @param inputs
     * @throws Exception
     */
    public static void validateFirstAndLast(String[] inputs) throws Exception {
        if (!isInteger(inputs[0]) || !isInteger(inputs[inputs.length - 1])) {
            throw new Exception();
        }
    }

    /**
     * 숫자나 연산자 반복 여부 유효성 검사
     * @param inputs
     * @throws Exception
     */
    private static void validateRepeat(String[] inputs) throws Exception {
        for (int i = 1; i < inputs.length; i++) {
            if (!(isInteger(inputs[i - 1]) ^ isInteger(inputs[i]))) {
                throw new Exception();
            }
        }
    }

    /**
     * 올바른 연산자 인지 유효성 검사
     * @param inputs
     * @throws Exception
     */
    public static void validateOperators(String[] inputs) throws Exception {
        for (int i = 1; i < inputs.length; i+=2) {
            if (!(Operator.PLUS.isOperator(inputs[i])
                || Operator.MINUS.isOperator(inputs[i])
                || Operator.MULTIPLY.isOperator(inputs[i])
                || Operator.DIVIDE.isOperator(inputs[i]))){
                throw new Exception();
            }
        }
    }

    public static boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
