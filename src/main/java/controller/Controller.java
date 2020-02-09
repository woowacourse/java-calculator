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
import model.Formula;
import validator.InputValidator;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Controller {
    public void run() {
        InputValidator inputValidator = new InputValidator();
        String input;

        do {
            input = InputView.inputStringFromUser();
        } while (!inputValidator.checkInput(input));

        Formula stringInput = new Formula(input);
        stringInput.setValueList();
        double sum = calculate(stringInput);
        OutputView.print(sum);
    }

    private double calculate(Formula stringInput) {
        List<Double> numbers = stringInput.getNumberList();
        List<String> operators = stringInput.getOperatorList();
        double sum = numbers.get(0);

        CalculatorMap op = new CalculatorMap();

        for (int i = 0; i < operators.size(); i++) {
            sum = op.getOperator(operators.get(i)).Operate(sum, numbers.get(i + 1));
        }

        return sum;
    }
}
