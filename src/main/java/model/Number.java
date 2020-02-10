/*
 * Copyright (c) 2019 by tiger,DDoring
 * All rights reserved.
 *
 * Numbers.java
 * Numbers 입력 값 객체
 *
 * @author      tiger,DDoring
 * @version     1.0
 * @date        10 Feb 2020
 *
 */

package model;

public class Number {
    private double number;

    public Number(String number) {
        this.number = toNumber(number);
    }

    private Double toNumber(String number) {
        try {
            return Double.parseDouble(number);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("잘못된 계산식 입니다. 다시 입력해 주세요.");
        }
    }

    public double getNumber() {
        return number;
    }
}
