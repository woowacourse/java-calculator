package calculator.view;

public final class OutputView {
    public static final String RESULT_MESSAGE_FORM = "결과 : ";

    public static void showResult(double result) {
        System.out.println(RESULT_MESSAGE_FORM + result);
    }

    public static void showErrorMessage(Exception message) {
        System.out.println(message);
    }
}
