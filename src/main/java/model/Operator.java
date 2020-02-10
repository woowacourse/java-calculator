/*
 * Copyright (c) 2019 by tiger,DDoring
 * All rights reserved.
 *
 * Operators.java
 * Operators 입력 값 객체
 *
 * @author      tiger,DDoring
 * @version     1.0
 * @date        10 Feb 2020
 *
 */

package model;

import java.util.Arrays;

public class Operator {
    private String operator;

    public Operator(String operator) {
        this.operator = toOperator(operator);
    }

    private String toOperator(String operator) {
        String[] signs = {"+", "-", "*", "/"};
        try {
            if (!Arrays.asList(signs).contains(operator)) {
                throw new IllegalArgumentException();
            }
            return operator;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("잘못된 계산식 입니다. 다시 입력해 주세요.");
        }
    }

    public String getOperator() {
        return operator;
    }
}
