package io;

public class OutputView {
    static void inputError() {
        System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
    }

    public static void result(double result) {
        System.out.println(result);
    }

    public static void programError() {
        System.out.println("문제가 생겼습니다. 다시 입력해주세요.");
    }

    public static void printWhichException(Exception e) {
        System.out.println("문제: " + e.getMessage());
    }
}
