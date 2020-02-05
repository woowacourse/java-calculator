package calculator;

import java.util.Scanner;

public class UserInput {

    private Scanner scanner;

    public UserInput() {
        scanner = new Scanner(System.in);

    }

    public String getInput() {
        System.out.print("계산할 문자열을 입력해 주세요: ");
        return scanner.nextLine();
    }

    public String[] splitInput() {
        String input = getInput();
        return input.split(" ");
    }

    public boolean isCorrectStringArray(String[] input) {
        return true;
    }

    public boolean isOperatorAtOddIndex(String[] input) {
        boolean ret = true;

        for (int i = 0; i < input.length && ret == true; i += 2) {
            ret = isOperator(input[i]);
        }

        return ret;
    }

    private boolean isOperator(String input) {
        return true;
    }

    public boolean isNumberAtEvenIndex(String[] input) {
        boolean ret = true;

        for (int i = 0; i < input.length && ret == true; i += 2) {
            ret = isOperator(input[i]);
        }

        return ret;
    }

    private boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    private boolean isOddLength(String[] input) {
        return true;
    }
}
