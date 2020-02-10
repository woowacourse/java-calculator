/*
 * Copyright (c) 2019 by tiger,DDoring
 * All rights reserved.
 *
 * StringValue.java
 * 입력 값 객체
 *
 * @author      tiger,DDoring
 * @version     1.0
 * @date        07 Feb 2020
 *
 */

package model;

import java.util.ArrayList;
import java.util.List;

public class Formula {
    private String[] inputSplit;
    private List<Number> numbers = new ArrayList<>();
    private List<Operator> operators = new ArrayList<>();

    public Formula(String input) {
        this.inputSplit = toFormula(input.split(" "));
    }

    private String[] toFormula(String[] input) {
        try {
            if (input.length < 3 || input.length % 2 == 0) {
                throw new IllegalArgumentException();
            }
            for (int i = 0; i < input.length; i++) {
                if (i % 2 == 0) {
                    numbers.add(new Number(input[i]));
                }
                if (i % 2 == 1) {
                    operators.add(new Operator(input[i]));
                }
            }
            return input;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("잘못된 계산식 입니다. 다시 입력해 주세요.");
        }
    }

    public List<Number> getNumberList() {
        return numbers;
    }

    public List<Operator> getOperatorList() {
        return operators;
    }
}
