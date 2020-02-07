package calculator;

import java.util.Scanner;

public class StringHandler {
    public static Scanner scanner = new Scanner(System.in);

    public static String[] getInputAndSplit() {
        String input = scanner.nextLine();
        String[] inputs = input.split(" ");

        return inputs;
    }
}
