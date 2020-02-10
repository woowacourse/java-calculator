package com.woowacourse.calculator.exception;

/**
 * 클래스 이름 : DivideByZeroException.java
 *
 * @author S.W.PARK
 * @author K.S.KIM
 * @version 1.0
 * <p>
 * 날짜 : 2020/02/09
 */
public class DivideByZeroException extends ArithmeticException {
	public DivideByZeroException(){
		super("0으로 나눌 수 없습니다.");
	}
}
