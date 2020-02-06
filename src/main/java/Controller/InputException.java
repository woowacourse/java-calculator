package Controller;

import View.InputView;
import View.OutputView;

public class InputException {

    public static void checkException() {
        OutputView.printInputMessage();
        String[] inputs = InputView.input();
        try {
            validateFirstAndLast(inputs);
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

    public static boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
