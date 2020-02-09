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

import calculator.CalculatorMap;
import model.CalculatedValue;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Controller {
    private final String PLUS = "+";
    private final String MINUS = "-";
    private final String MUL = "*";
    private final String DIV = "/";

    public void run() {
        CalculatedValue stringInput;
        do {
            String input = InputView.inputStringFromUser();
            stringInput = new CalculatedValue(input);
        } while (!stringInput.isValidator());
        stringInput.setValueList();

        double sum = calculate(stringInput);

        OutputView.print(sum);
    }

    private double calculate(CalculatedValue stringInput) {
        List<Double> numbers = stringInput.getNumberList();
        List<String> operators = stringInput.getOperatorList();
        double sum = numbers.get(0);

        CalculatorMap op = new CalculatorMap();

        for (int i = 0; i < operators.size(); i++) {
            sum = op.getOperator(operators.get(i)).getOperatedValue(sum, numbers.get(i + 1));
        }

        return sum;
    }
}
