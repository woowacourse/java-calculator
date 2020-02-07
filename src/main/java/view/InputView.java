package view;

import java.util.Scanner;

public class InputView {
    private final static Scanner SCANNER = new Scanner(System.in);

    public static String inputCalculation() {
        OutputView.printInputCalculationMessage();
        return SCANNER.nextLine();
    }

    public void validBlankInput(String input) {
        if (input.replace(" ", "").length() == 0) {
            throw new IllegalArgumentException("숫자와 연산자를 입력해주세요.");
        }
    }
}
