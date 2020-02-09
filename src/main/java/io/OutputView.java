package io;

public class OutputView {
    public static final String WELCOME = "계산기를 이용 해 주셔서 감사합니다~~ 아래에 계산하고자 하는 식을 입력해주세요";
    public static final String INPUT_ERROR = "잘못된 입력입니다. 다시 입력해주세요.";

    public static void inputError() {
        System.out.println(INPUT_ERROR);
    }

    public static void result(double result) {
        System.out.println(result);
    }

    public static void welcome() {
        System.out.println(WELCOME);
    }
}
