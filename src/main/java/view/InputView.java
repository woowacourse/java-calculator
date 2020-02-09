package view;

import java.util.Scanner;

import errors.InvalidInputException;

public class InputView {
    private Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String receiveInput() throws InvalidInputException {
        System.out.println("계산식을 입력해주세요.");
        String input = scanner.nextLine();

        if (input.isEmpty()) {
            throw new InvalidInputException("Input is empty");
        }

        return input;
    }
}