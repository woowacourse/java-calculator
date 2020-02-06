package view;

import java.util.Scanner;

public class InputView {
    private final static Scanner SCANNER = new Scanner(System.in);

    public static String inputCalculation() {
        OutputView.printInputCalculationMessage();
        return SCANNER.nextLine();
    }
}
