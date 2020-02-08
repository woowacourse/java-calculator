package calculator.view;

import calculator.view.dto.RawEquationDTO;

import java.util.Scanner;

public final class InputView {
    public static final String INPUT_EQUATION_MESSAGE_FORM = "식을 입력하세요 : ";
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public RawEquationDTO inputEquation() {
        System.out.print(INPUT_EQUATION_MESSAGE_FORM);
        RawEquationDTO rawEquationDTO = new RawEquationDTO(scanner.nextLine());
        return rawEquationDTO;
    }
}
