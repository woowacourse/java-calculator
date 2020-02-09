/*
 * Copyright (c) 2019 by 또링
 * All rights reserved.
 *
 * Calculator.java
 * 계산을 담당하는 클래스
 *
 * @author      또링
 * @version     1.0
 * @date        09 Feb 2020
 *
 */

package calculator;

import model.OperatorType;

public class Calculator {
    private OperatorType operatorType;

    public void setOperatorType(String operator) {
        for (OperatorType op : OperatorType.values()) {
            if (operator.equals(op.toString())) {
                operatorType = op;
            }
        }
    }

    public double calculate(double number1, double number2) {
        return operatorType.calculate(number1, number2);
    }
}

