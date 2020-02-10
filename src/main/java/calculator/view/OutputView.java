package calculator.view;

public class OutputView {

    public static void printMessage_EmptyCase() {
        System.out.println("빈 문자열입니다. 다시 입력해주세요.\n");
    }

    public static void printMessage_DividedByZeroCase() {
        System.out.println("0으로 나눌 수 없습니다. 다시 입력해주세요.\n");
    }

    public static void printMessage_InvalidEquationCase() {
        System.out.println("잘못된 수식이 입력되었습니다. 다시 입력해주세요.\n");
    }

    public static void printResult(int result) {
        System.out.println("결과: " + result);
    }
}
