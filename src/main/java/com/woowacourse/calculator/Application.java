package com.woowacourse.calculator;

import com.woowacourse.calculator.controller.CalculatorController;

/**
 * 클래스 이름 : Application.java
 *
 * @author S.W.PARK
 * @author K.S.KIM
 * @version 1.0
 * <p>
 * 날짜 : 2020/02/06
 */
public class Application {
	public static void main(String[] args) {
		CalculatorController calculatorController = new CalculatorController();
		calculatorController.run();
	}
}
