package View;

public class OutputView {
    public static void printInputMessage() {
        System.out.println("계산할 식을 입력해주세요.");
    }

    public static void printOutputMessage(double output) {
        System.out.println("계산한 결과는 " + output + " 입니다.");
    }

    public static void printInputExceptionMessage() {
        System.out.println("입력이 잘못되었습니다. 계산할 식을 다시 입력해주세요.");
    }
}
