package view;

import utils.InputValidation;

import java.util.Scanner;

public class InputView {
    private final static Scanner scanner = new Scanner(System.in);

    public static String inputFormula() {
        boolean isException = true;
        String input = null;
        while (isException) {
            input = scanner.nextLine().trim();
            isException = InputValidation.checkNullOroSpace(input);
        }
        return input;
    }
}
