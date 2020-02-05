package com.woowacourse.calculator.domain;

public class Number {
    private final int number;

    public Number(int number) {
        this.number = number;
    }

    public static Number of(String input) {
        return new Number(Integer.parseInt(input));
    }

}
