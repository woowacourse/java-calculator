/**
 * Calculator.java
 * 계산 작업을 하는 클래스
 * 우아한테크코스 1주차 미션 온보딩 - 문자열 계산기
 * 히로-핀
 * https://github.com/hotheadfactory/java-calculator
 */
package study.domain;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Calculator {
    public double calculate(String[] values) {
        Queue<String> elements = new LinkedList<>(Arrays.asList(values));
        double result = Double.parseDouble(elements.poll());
        while (!elements.isEmpty()) {
            String operator = elements.poll();
            double rightOperand = Double.parseDouble(elements.poll());
            result = Operator.of(operator)
                    .calculate(result, rightOperand);
        }
        if(Double.isInfinite(result)) {
            throw new ArithmeticException();
        }
        return result;
    }
}
