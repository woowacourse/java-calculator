package View;

public class OutputView {
    public static void printInputMessage() {
        System.out.println("계산할 식을 입력해주세요.");
    }

    public static void printOutputMessage(double output) {
        System.out.println("계산한 결과는 " + output + " 입니다.");
    }

    public static void printInputExceptionMessage(Exception e) {
        System.out.println(e.getMessage());
        System.out.println("다시 입력해주세요");
    }
}
