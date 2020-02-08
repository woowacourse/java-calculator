/**
 * userInput.java
 * 입력을 받는 클래스
 * 우아한테크코스 1주차 미션 온보딩 - 문자열 계산기
 * 히로-핀
 * https://github.com/hotheadfactory/java-calculator
 */

package study.view;

import java.util.Scanner;

public class userInput {
    private static final Scanner scanner = new Scanner(System.in);

    public static String[] inputExpression() {
        System.out.println("계산식을 입력하세요:");
        return scanner.nextLine().split(" ");
    }
}
