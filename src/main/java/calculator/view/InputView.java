package calculator.view;

import calculator.view.dto.RawEquationDTO;

import java.util.Scanner;

public final class InputView {

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public RawEquationDTO inputEquation() {
        System.out.print("식을 입력하세요 : ");
        RawEquationDTO rawEquationDTO = new RawEquationDTO(scanner.nextLine());
        return rawEquationDTO;
    }


}
