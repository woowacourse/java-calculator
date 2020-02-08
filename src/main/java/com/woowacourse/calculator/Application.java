package com.woowacourse.calculator;

import com.woowacourse.calculator.controller.CalculatorController;
import com.woowacourse.calculator.domain.Expression;
import com.woowacourse.calculator.domain.Tokenizer;
import com.woowacourse.calculator.view.InputView;
import com.woowacourse.calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();

        Expression expression = getExpressionFromInputExpression();

        CalculatorController calculatorController = new CalculatorController(expression);
        final int calculateResult = calculatorController.calculate();

        outputView.printCalculateResult(calculateResult);
    }

    private static Expression getExpressionFromInputExpression() {
        InputView inputView = new InputView();

        final String inputExpression = inputView.inputExpression();
        return new Expression(Tokenizer.tokenize(inputExpression));
    }
}
