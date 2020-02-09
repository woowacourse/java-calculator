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
import view.InputView;
import view.OutputView;

import java.util.List;

public class Controller {
    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String MUL = "*";
    private static final String DIV = "/";

    public void run() {
        Expression expression;
        do {
            String input = InputView.inputStringFromUser();
            expression = new Expression(input);
        } while (!expression.isValidator());
        expression.setValueList();

        double sum = calculate(expression);

        OutputView.print(sum);
    }

    private double calculate(Expression expression) {
        List<Double> numbers = expression.getNumbers();
        List<String> operators = expression.getOperators();
        double sum = numbers.get(0);

        Calculator calculator = new Calculator();

        for (int i = 0; i < operators.size(); i++) {
            if (operators.get(i).equals(PLUS)) {
                sum = calculator.plus(sum, numbers.get(i + 1));
            }
            if (operators.get(i).equals(MINUS)) {
                sum = calculator.minus(sum, numbers.get(i + 1));
            }
            if (operators.get(i).equals(MUL)) {
                sum = calculator.mul(sum, numbers.get(i + 1));
            }
            if (operators.get(i).equals(DIV)) {
                sum = calculator.div(sum, numbers.get(i + 1));
            }
        }

        return sum;
    }
}
