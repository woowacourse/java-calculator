package com.woowacourse.calculator;

import com.woowacourse.calculator.controller.Calculator;
import com.woowacourse.calculator.view.InputView;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        final int calculateResult = calculator.calculate(InputView.inputExpression());
    }
}
