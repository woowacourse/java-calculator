package com.woowacourse.calculator.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NumberTest {
	@Test
	void testNumber() {
		final String overflowNumber = "2147483648";
		assertThatThrownBy(() -> {
			new Number(overflowNumber);
		}).isInstanceOf(NumberFormatException.class)
			.hasMessage("유효한 범위의 숫자를 입력해 주세요");
	}
}
