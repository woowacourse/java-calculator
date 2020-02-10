package view;

public class OutputView {
    private static final String HEAD = "결과 값은 ";
    private static final String TAIL = "입니다. @author 최근휘 kuenhwi@google.com";

    public static void printCalculateResult(String result) {
        System.out.println(HEAD + result + TAIL);
    }
}
