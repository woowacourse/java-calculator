package unit.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Operator test")
class OperatorTest {
	@DisplayName("operator test")
	@Test
	void testOperator() {
		final String invalidValue = "%";
		assertThatThrownBy(() -> {
			new Operator(invalidValue);
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessage("유효한 연산자 형식이 아닙니다.");
	}
}