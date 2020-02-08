package calculator.view;

public final class OutputView {
    public static void showResult(double result) {
        System.out.println("결과 : " + result);
    }

    public static void showExceptionMessage(RuntimeException e) {
        System.out.println(e.getMessage());
    }
}
