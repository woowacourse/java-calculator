package view;

import java.util.Scanner;

public class InputView {
    private Scanner scanner ;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String receiveInput() {
        System.out.println("계산식을 입력해주세요.");
        String input = scanner.nextLine();

        return input;
    }
}