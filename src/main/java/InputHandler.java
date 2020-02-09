import java.util.Scanner;

public class InputHandler {
    private static Scanner scanner = new Scanner(System.in);

    public static String getInput() {
        try {
            return InputValidator.checkInputHandler(scanner.nextLine());
        } catch ( IllegalArgumentException e) {
            System.out.println("입력값을 확인해주세요.");
            return getInput();
        }
    }
}