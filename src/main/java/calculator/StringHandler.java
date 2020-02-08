package calculator;

import java.util.Scanner;

public class StringHandler {
    public static Scanner scanner = new Scanner(System.in);

    public static String[] getInputAndSplit() {
        System.out.println("계산할 식을 입력해주세요.");
        String input = scanner.nextLine();
        String[] inputs = input.split(" ");

        return inputs;
    }

    public static void printResult(double result) {
        System.out.println("result: " + result);
    }
}
