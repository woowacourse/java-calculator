package study;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        runCalculator();
    }

    private static void runCalculator() {
        try {
            String[] values = inputExpression();
            System.out.println("정답은 " + Calculator.calculate(values) + "입니다.");
        } catch (NumberFormatException e) {
            System.out.println("다시 입력해 주세요.");
            runCalculator();
        }
    }

    private static String[] inputExpression() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("계산식을 입력하세요:");
        return scanner.nextLine().split(" ");
    }
}
