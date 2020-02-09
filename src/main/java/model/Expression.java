/*
 * Copyright (c) 2019 by 또링
 * All rights reserved.
 *
 * Expression.java
 * 입력 값 객체
 *
 * @author      또링
 * @version     1.0
 * @date        09 Feb 2020
 *
 */
package model;

import validator.InputValidator;

import java.util.ArrayList;
import java.util.List;

public class Expression {
    private String expression;
    private List<Double> numbers = new ArrayList<>();
    private List<String> operators = new ArrayList<>();

    public Expression(String expression) {
        this.expression = expression;
    }

    public void setValueList() {
        String[] componentOfExpression = expression.split(InputValidator.BLANK);
        for (int i = 0; i < componentOfExpression.length; i++) {
            if (i % 2 == 0) {
                numbers.add(Double.parseDouble(componentOfExpression[i]));
            }
            if (i % 2 == 1) {
                operators.add(componentOfExpression[i]);
            }
        }
    }

    public List<Double> getNumbers() {
        return numbers;
    }

    public List<String> getOperators() {
        return operators;
    }
}
