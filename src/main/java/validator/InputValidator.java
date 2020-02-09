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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputValidator {
    private final String BLANK = " ";
    private final int EVEN = 0;
    private final int ODD = 1;

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

        if (!(isNumberAllElements(evenIndexOfExpression) && isRightOperatorAllElements(oddIndexOfExpression))) {
            return false;
        }
        return true;
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
        String[] signs = {"+", "-", "*", "/"};
        for (String operator : oddIndexOfExpression) {
            if (!Arrays.asList(signs).contains(operator)) {
                return false;
            }
        }
        return true;
    }

    public boolean isNotDivideByZero(String[] expression) {
        for (int i = 2; i < expression.length; i += 2) {
            if (expression[i].equals("0") && expression[i - 1].equals("/")) {
                return false;
            }
        }
        return true;
    }
}
