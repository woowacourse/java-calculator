/*
 * Copyright (c) 2019 by tiger,DDoring
 * All rights reserved.
 *
 * InputValidator.java
 * 값 유효성 검사를 담당하는 클래스
 *
 * @author      tiger,DDoring
 * @version     1.0
 * @date        06 Feb 2020
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

    public boolean checkInput(String inputString) {
        String[] inputArr = inputString.split(BLANK);

        return isCorrectLength(inputArr) && isCorrectIndex(inputArr);
    }

    public boolean isCorrectLength(String[] inputArr) {
        return inputArr.length % 2 == ODD;
    }

    private boolean isCorrectIndex(String[] inputArr) {
        List<String> evenArr = getEvenOrOddArr(EVEN, inputArr);
        List<String> oddArr = getEvenOrOddArr(ODD, inputArr);

        if (!(isCorrectEvanIndex(evenArr) && isCorrectOddIndex(oddArr))) {
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

    public boolean isCorrectEvanIndex(List<String> evenArr) {
        for (String number : evenArr) {
            try {
                Integer.parseInt(number);
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    public boolean isCorrectOddIndex(List<String> oddArr) {
        String[] signs = {"+", "-", "*", "/"};
        for (String operator : oddArr) {
            if (!Arrays.asList(signs).contains(operator)) {
                return false;
            }
        }
        return true;
    }
}
