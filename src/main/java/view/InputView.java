package view;

import java.util.Scanner;

public class InputView {
    public static String input() {
        System.out.println("계산식을 입력하세요 : ");
        return new Scanner(System.in).nextLine().trim();
    }
}
