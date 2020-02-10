import java.util.Scanner;

public class InputHandler {
    private Scanner scanner = new Scanner(System.in);
    private InputValidator inputValidator = new InputValidator();

    public String[] getInput() {
        String input;
        System.out.println("=========계산기==========");
        System.out.println("숫자(0-9)와 연산자를 공백 기준으로 입력해주세요.");
        do {
            input = scanner.nextLine();
        } while (inputValidator.isReenterWithInvalidValue(input));
        return input.split(" ");
    }

    public boolean isStartingAgain() {
        String input;
        System.out.println("다시 시작하시겠습니까? (y / n)");
        do {
            input = scanner.nextLine();
        } while (!input.matches("[ynYN]"));
        return input.toLowerCase().equals("y");
    }
}
