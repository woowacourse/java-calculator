package View;

import java.util.Scanner;

public class InputView {
    private static String input;

    public static String[] input() {
        Scanner sc = new Scanner(System.in);
        input = sc.nextLine().trim();
        return input.split(" ");
    }
}
