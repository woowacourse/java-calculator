package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class ExpressionTest {

	@DisplayName("올바른 조건 아래 계산 동작 테스트")
	@ParameterizedTest
	@CsvSource(value = {"10:10", "1 + 2 * 3 / 4:2", "1 + 3 + 3 / 4:1", "3 + 4:7", "11 + 57 - 10:58",
		"1 - 10:-9"}, delimiter = ':')
	public void getResultTest(String rawExpression, int expected) {
		Expression expression = ExpressionFactory.parse(rawExpression);
		int actual = expression.getResult();
		assertThat(actual).isEqualTo(expected);
	}

	@DisplayName("부적절한 조건 아래 계산 시도시 RuntimeException 발생")
	@ParameterizedTest
	@ValueSource(strings = {"", "1 + k * 3 ; 4", "1 3 3 * 3 / 4", "+ + 3 * 3 ; 4", "1 + 3 * 3 / 4 +", "+"})
	public void getResultExceptionTest(String rawExpression) {
		assertThatExceptionOfType(RuntimeException.class)
			.isThrownBy(() -> {
				Expression expression = ExpressionFactory.parse(rawExpression);
				expression.getResult();
			});
	}

	@DisplayName("0으로 나누는 시도시 ArithmeticException 발생")
	@ParameterizedTest
	@ValueSource(strings = {"1 + 5 * 3 / 0", "1 / 0", "0 / 0", "1 / 0 * 3 / 4"})
	public void getResultDivideExceptionTest(String rawExpression) {
		Expression expression = ExpressionFactory.parse(rawExpression);
		assertThatExceptionOfType(ArithmeticException.class)
			.isThrownBy(() -> expression.getResult());
	}
}