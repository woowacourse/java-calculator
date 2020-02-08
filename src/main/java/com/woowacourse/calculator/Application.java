package com.woowacourse.calculator;

import com.woowacourse.calculator.controller.CalculatorController;
import com.woowacourse.calculator.view.InputView;
import com.woowacourse.calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        CalculatorController calculatorController = new CalculatorController();

        final int calculateResult = calculatorController.calculate(InputView.inputExpression());
		OutputView.printCalculateResult(calculateResult);
    }
}
