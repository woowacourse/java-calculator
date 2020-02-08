package calculator;

import java.util.Scanner;

public class UserInputScanner {
    private ValidityInspector validityInspector = new ValidityInspector();
    private Scanner scanner = new Scanner(System.in);

    private String inputStringToUser() {
        System.out.print("계산식을 입력하시오: ");
        String inputLine = scanner.nextLine();
        validityInspector.checkUserInputIsBlankOrEmpty(inputLine);
        return inputLine;
    }

    public String[] splitUserInputString() {
        String input = inputStringToUser();
        String[] splitInput = input.split(" ");
        validityInspector.checkCanConvertUserInputToNumberAndOperator(splitInput);
        return splitInput;
    }
}
