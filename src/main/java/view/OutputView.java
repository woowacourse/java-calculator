package view;

public class OutputView {
    private static final String FIRST_STRING = "결과 값은 ";
    private static final String END_STRING = "입니다. @author 최근휘 kuenhwi@google.com";

    public static void printResult(String result) {
        System.out.println(FIRST_STRING + result + END_STRING);
    }
}
