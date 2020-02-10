package calculator;

import java.util.Scanner;

public class Input {
    private Validator validator = new Validator();
    private Scanner scanner = new Scanner(System.in);

    public String[] inputFormula() {
        System.out.print("계산식을 입력하시오: ");
        String inputLine = scanner.nextLine();
        if (validator.isValidInput(inputLine)) {
            return inputLine.split(" ");
        }
        throw new IllegalArgumentException("잘못된 계산 식입니다.");
    }
}
