package model;

/*
 * Copyright (c) 2019 by 또링
 * All rights reserved.
 *
 * OperatorType.java
 * 연산자를 관리하는 enum
 *
 * @author      또링
 * @version     1.0
 * @date        09 Feb 2020
 *
 */

public enum OperatorType {
    PLUS("+") {
        @Override
        public double calculate(double number1, double number2) {
            return number1 + number2;
        }
    },
    MINUS("-") {
        @Override
        public double calculate(double number1, double number2) {
            return number1 - number2;
        }
    },
    MUL("*") {
        @Override
        public double calculate(double number1, double number2) {
            return number1 * number2;
        }
    },
    DIV("/") {
        @Override
        public double calculate(double number1, double number2) {
            return number1 / number2;
        }
    };

    final private String operator;

    OperatorType(String operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return operator;
    }

    public abstract double calculate(double number1, double number2);

}
