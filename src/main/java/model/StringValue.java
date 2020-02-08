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

import validator.InputValidator;

import java.util.ArrayList;
import java.util.List;

public class StringValue {
    private String input;
    private List<Double> numberList = new ArrayList<>();
    private List<String> operatorList = new ArrayList<>();
    private final InputValidator inputValidator = new InputValidator();

    public StringValue(String input) {
        this.input = input;
    }

    public boolean isValidator() {
        return inputValidator.checkInput(input);
    }

    public void setValueList() {
        String[] inputSplit = this.input.split(" ");
        for (int i = 0; i < inputSplit.length; i++) {
            if (i % 2 == 0) {
                numberList.add(Double.parseDouble(inputSplit[i]));
            }
            if (i % 2 == 1) {
                operatorList.add(inputSplit[i]);
            }
        }
    }

    public List<Double> getNumberList() {
        return numberList;
    }

    public List<String> getOperatorList() {
        return operatorList;
    }
}
