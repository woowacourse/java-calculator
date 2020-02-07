package study.view;

import java.util.Scanner;

public class userInput {
    private static final Scanner scanner = new Scanner(System.in);
    public static String[] inputExpression() {
        System.out.println("계산식을 입력하세요:");
        return scanner.nextLine().split(" ");
    }
}
