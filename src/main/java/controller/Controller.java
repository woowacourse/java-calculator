/*
 * Copyright (c) 2019 by 또링
 * All rights reserved.
 *
 * Controller.java
 * Expression 객체를 이용하여 계산을 하고 View를 통해 입출력을 제어하는 클래스
 *
 * @author      또링
 * @version     1.0
 * @date        09 Feb 2020
 *
 */

package controller;

import calculator.Calculator;
import model.Expression;
import validator.InputValidator;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Controller {

    public void run() {
        String input;
        InputValidator inputValidator = new InputValidator();

        do {
            input = InputView.inputStringFromUser();
        } while (!inputValidator.validateExpression(input));

        Expression expression = new Expression(input);

        double sum = calculate(expression);

        OutputView.print(sum);
    }

    private double calculate(Expression expression) {
        List<Double> numbers = expression.getNumbers();
        List<String> operators = expression.getOperators();

        double result = numbers.get(0);
        Calculator calculator = new Calculator();

        for (int i = 0; i < operators.size(); i++) {
            calculator.setOperatorType(operators.get(i));
            result = calculator.calculate(result, numbers.get(i + 1));
        }

        return result;
    }
}
