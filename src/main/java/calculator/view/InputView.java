package calculator.view;

import java.util.Scanner;

public final class InputView {

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String inputEquation() {
        System.out.print("식을 입력하세요 : ");
        String equation = scanner.nextLine();
        validate(equation);
        return equation;
    }

    private void validate(String equation) {
        if (equation.trim().isEmpty()) {
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }
    }
}
