package Controller;

import View.InputView;
import View.OutputView;

public class InputException {

    public static String[] checkException() {
        OutputView.printInputMessage();
        String[] inputs = InputView.input();
        try {
            validateSpace(inputs);
            validateFirstAndLast(inputs);
            validateRepeat(inputs);
            validateOperators(inputs);
            return inputs;
        } catch (Exception e) {
            OutputView.printInputExceptionMessage(e);
        }
        return checkException();
    }

    /**
     * 공백 입력 여부 유효성 검사
     *
     * @param inputs
     * @throws Exception
     */
    public static void validateSpace(String[] inputs) throws Exception {
        if (inputs.length == 0) {
            throw new Exception("식이 입력되지 않았습니다.");
        }
    }

    /**
     * 문자열 앞, 뒤 유효성 검사
     *
     * @param inputs
     * @throws Exception
     */
    public static void validateFirstAndLast(String[] inputs) throws Exception {
        if (!isInteger(inputs[0]) || !isInteger(inputs[inputs.length - 1])) {
            throw new Exception("식의 처음과 마지막은 숫자여야 합니다.");
        }
    }

    /**
     * 숫자나 연산자 반복 여부 유효성 검사
     *
     * @param inputs
     * @throws Exception
     */
    private static void validateRepeat(String[] inputs) throws Exception {
        for (int i = 1; i < inputs.length; i++) {
            if (!(isInteger(inputs[i - 1]) ^ isInteger(inputs[i]))) {
                throw new Exception("연속된 숫자 또는 연산자입니다.");
            }
        }
    }

    /**
     * 올바른 연산자 인지 유효성 검사
     *
     * @param inputs
     * @throws Exception
     */
    public static void validateOperators(String[] inputs) throws Exception {
        for (int i = 1; i < inputs.length; i += 2) {
            if (OperatorMap.getOperatorByString(inputs[i]) == null) {
                throw new Exception("올바른 연산자가 아닙니다.");
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
