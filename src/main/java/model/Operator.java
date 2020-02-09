package model;

/*
 * Copyright (c) 2019 by 또링
 * All rights reserved.
 *
 * Operator.java
 * 연산자를 관리하는 enum
 *
 * @author      또링
 * @version     1.0
 * @date        09 Feb 2020
 *
 */

public enum Operator {
    PLUS("+"),
    MINUS("-"),
    MUL("*"),
    DIV("/");

    final private String operator;

    Operator(String operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return operator;
    }
}
