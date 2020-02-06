package com.woowacourse.calculator.domain;

/**
 * 클래스 이름 : Number.java
 *
 * @author S.W.PARK
 * @author K.S.KIM
 * @version 1.0
 * <p>
 * 날짜 : 2020.02.06 목요일
 */

public class Number {
    private final int number;

    public Number(int number) {
        this.number = number;
    }

    public static Number of(String input) {
        return new Number(Integer.parseInt(input));
    }

}
