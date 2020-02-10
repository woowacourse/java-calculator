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
import model.Number;
import model.Operator;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Controller {
    public void run() {
        Formula stringInput = setInput();
        double sum = calculate(stringInput);
        OutputView.print(sum);
    }

    private Formula setInput() {
        String input;
        while (true) {
            try {
                input = InputView.inputStringFromUser();
                return new Formula(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private double calculate(Formula stringInput) {
        List<Number> numbers = stringInput.getNumberList();
        List<Operator> operators = stringInput.getOperatorList();
        double sum = numbers.get(0).getNumber();

        CalculatorMap op = new CalculatorMap();

        for (int i = 0; i < operators.size(); i++) {
            sum = op.calculate(operators.get(i).getOperator(), sum, numbers.get(i + 1).getNumber());
        }

        return sum;
    }
}
