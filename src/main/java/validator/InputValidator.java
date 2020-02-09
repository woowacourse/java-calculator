/*
 * Copyright (c) 2019 by 또링
 * All rights reserved.
 *
 * InputValidator.java
 * 값 유효성 검사를 담당하는 클래스
 *
 * @author      또링
 * @version     1.0
 * @date        09 Feb 2020
 *
 */

package validator;

import model.OperatorType;

import java.util.ArrayList;
import java.util.List;

public class InputValidator {
    public static final String BLANK = " ";
    private static final String ZERO = "0";
    private static final int EVEN = 0;
    private static final int ODD = 1;

    public boolean validateExpression(String expression) {
        String[] expressionArr = expression.split(BLANK);
        return isCorrectLength(expressionArr) && isCorrectIndex(expressionArr) && isNotDivideByZero(expressionArr);
    }

    public boolean isCorrectLength(String[] expressionArr) {
        return expressionArr.length % 2 == ODD;
    }

    private boolean isCorrectIndex(String[] expressionArr) {
        List<String> evenIndexOfExpression = getEvenOrOddArr(EVEN, expressionArr);
        List<String> oddIndexOfExpression = getEvenOrOddArr(ODD, expressionArr);

        return isNumberAllElements(evenIndexOfExpression) && isRightOperatorAllElements(oddIndexOfExpression);
    }

    private List<String> getEvenOrOddArr(int num, String[] inputArr) {
        List<String> evenOrOddList = new ArrayList<>();
        for (int i = 0; i < inputArr.length; i++) {
            if (i % 2 == num) {
                evenOrOddList.add(inputArr[i]);
            }
        }
        return evenOrOddList;
    }

    public boolean isNumberAllElements(List<String> evenIndexOfExpression) {
        for (String number : evenIndexOfExpression) {
            try {
                Integer.parseInt(number);
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    public boolean isRightOperatorAllElements(List<String> oddIndexOfExpression) {
        List<String> fourOperators = new ArrayList<>();

        for (OperatorType op : OperatorType.values()) {
            fourOperators.add(op.toString());
        }

        for (String operator : oddIndexOfExpression) {
            if (!fourOperators.contains(operator)) {
                return false;
            }
        }

        return true;
    }

    public boolean isNotDivideByZero(String[] expression) {
        for (int i = 2; i < expression.length; i += 2) {
            if (ZERO.equals(expression[i]) && expression[i - 1].equals(OperatorType.DIV.toString())) {
                return false;
            }
        }
        return true;
    }
}
