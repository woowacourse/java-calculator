package view;

import java.util.Scanner;

public class InputView {
    public static Scanner scanner = new Scanner(System.in);

    public static String[] getInputAndSplit() {
        System.out.println("계산할 식을 입력해주세요.");
        String input = scanner.nextLine();
        String[] inputs = input.split(" ");

        return inputs;
    }
}
