package calculator;

import java.util.Scanner;

public class Input {
    private ValidityInspector validityInspector = new ValidityInspector();
    private Scanner scanner = new Scanner(System.in);

    private String inputString() {
        System.out.print("계산식을 입력하시오: ");
        String inputLine = scanner.nextLine();
        try {
            validityInspector.isValidInput(inputLine);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputString();
        }
        return inputLine;
    }

    public String[] splitString() {
        String input = inputString();
        String[] splitInput = input.split(" ");
        try {
            validityInspector.isValidSplitedInput(splitInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return splitString();
        }
        return splitInput;
    }
}
