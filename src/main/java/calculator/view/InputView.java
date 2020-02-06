package calculator.view;

import java.util.Scanner;

public final class InputView {

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String inputEquation() {
        System.out.print("식을 입력하세요 : ");
        return scanner.nextLine();
    }


}
