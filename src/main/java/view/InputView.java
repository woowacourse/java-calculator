package view;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static String inputExpression() {
        System.out.println("공백으로 구분하여 식을 입력해주세요(ex. 1 + 2 - 4)");
        try {
            String input = scanner.nextLine();
            checkIsBlank(input);
            return input;
        } catch (IllegalArgumentException e) {
            ErrorView.println(e.getMessage());
            return inputExpression();
        }
    }

    private static void checkIsBlank(String input) throws IllegalArgumentException {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
    }

}
