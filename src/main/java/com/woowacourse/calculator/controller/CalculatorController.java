package com.woowacourse.calculator.controller;

import com.woowacourse.calculator.domain.Expression;
import com.woowacourse.calculator.domain.ExpressionFactory;
import com.woowacourse.calculator.view.InputView;
import com.woowacourse.calculator.view.OutputView;

/**
 * 클래스 이름 : CalculatorController.java
 *
 * @author S.W.PARK
 * @author K.S.KIM
 * @version 1.0
 * <p>
 * 날짜 : 2020.02.06 목요일
 */

public class CalculatorController {

    public void run() {
        Expression expression = makeExpression();
        double result = expression.calculate();
        OutputView.printAnswer(result);
    }

    private Expression makeExpression() {
        try {
            String input = InputView.inputEquation();
            return ExpressionFactory.create(input);
        } catch (IllegalArgumentException e) {
            OutputView.printRetryMessage(e.getMessage());
            return makeExpression();
        }
    }
}
