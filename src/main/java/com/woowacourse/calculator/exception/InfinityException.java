package com.woowacourse.calculator.exception;

/**
 * 클래스 이름 : InfinityException.java
 *
 * @author S.W.PARK
 * @author K.S.KIM
 * @version 1.0
 * <p>
 * 날짜 : 2020/02/09
 */
public class InfinityException extends ArithmeticException {
	public InfinityException() {
		super("값을 표현할 수 있는 범위를 벗어났습니다.");
	}
}
