/**
 * Application.java
 * 메인 클래스
 * 우아한테크코스 1주차 미션 온보딩 - 문자열 계산기
 * 히로-핀
 * https://github.com/hotheadfactory/java-calculator
 */

package study;

import study.domain.Calculator;

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
