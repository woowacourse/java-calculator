/**
 * Application.java
 * 메인 클래스
 * 우아한테크코스 1주차 미션 온보딩 - 문자열 계산기
 * 히로-핀
 * https://github.com/hotheadfactory/java-calculator
 */

package study;

import study.domain.Calculator;
import study.view.userInput;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        runCalculator();
    }

    private static void runCalculator() {
        Calculator calculator = new Calculator();
        try {
            String[] values = userInput.inputExpression();
            System.out.println("정답은 " + calculator.calculate(values) + "입니다.");
        } catch (ArithmeticException e) {
            System.out.println("0으로 나눌 수 없습니다.");
            runCalculator();
        } catch (Exception e) {
            System.out.println("다시 입력해 주세요.");
            runCalculator();
        }
    }


}
