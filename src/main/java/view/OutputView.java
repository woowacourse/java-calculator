package view;

public class OutputView {
    private static String firstString = "결과 값은 ";
    private static String endString = "입니다. @author 최근휘 kuenhwi@google.com";

    public static void printResult(String result) {
        System.out.println(firstString + result + endString);
    }
}
