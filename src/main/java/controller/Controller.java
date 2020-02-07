/*
 * Copyright (c) 2019 by tiger,DDoring
 * All rights reserved.
 *
 * Controller.java
 * StringValue 객체를 이용하여 계산을 하고 View를 통해 입출력을 제어하는 클래스
 *
 * @author      tiger,DDoring
 * @version     1.0
 * @date        07 Feb 2020
 *
 */

package controller;

import calculator.Calculator;
import model.StringValue;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Controller {
    private final String PLUS = "+";
    private final String MINUS = "-";
    private final String MUL = "*";
    private final String DIV = "/";

    public void run() {
        StringValue stringInput;
        do {
            String input = InputView.inputStringFromUser();
            stringInput = new StringValue(input);
        } while (stringInput.isValidator());

        double sum = calculate(stringInput);

        OutputView.print(sum);
    }

    private double calculate(StringValue stringInput) {
        List<Double> numberList = stringInput.getNumberList();
        List<String> operatorList = stringInput.getOperatorList();
        double sum = numberList.get(0);

        Calculator calculator = new Calculator();

        for (int i = 0; i < operatorList.size(); i++) {
            if (operatorList.get(i).equals(PLUS)) {
                sum = calculator.plus(sum, numberList.get(i + 1));
            }
            if (operatorList.get(i).equals(MINUS)) {
                sum = calculator.minus(sum, numberList.get(i + 1));
            }
            if (operatorList.get(i).equals(MUL)) {
                sum = calculator.mul(sum, numberList.get(i + 1));
            }
            if (operatorList.get(i).equals(DIV)) {
                sum = calculator.div(sum, numberList.get(i + 1));
            }
        }

        return sum;
    }
}
