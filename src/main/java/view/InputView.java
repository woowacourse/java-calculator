package view;

import java.util.Scanner;

public class InputView {
    final static Scanner SCANNER = new Scanner(System.in);

    public static void inputCalculation() {
        OutputView.printInputCalculationMessage();
        String value = SCANNER.nextLine();
    }
}
