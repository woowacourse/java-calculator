package view;

public class OutputView {
    public static void printAnswer(Double input) {
        System.out.println("계산된 결과는 " + input + "입니다");
    }

    public static void printErrorMessageAndErrorCount(String input, int errorCount) {
        System.out.println(input + " (남은 시도 횟수: " + (5 - errorCount) + ")");
    }

    public static void printExitMessage(){
        System.out.println("5회 잘못 입력하였으므로 프로그램을 종료합니다.");
    }
}
