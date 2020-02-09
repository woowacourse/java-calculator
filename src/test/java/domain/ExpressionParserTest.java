package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ExpressionParserTest {

	@DisplayName("10 단항식에 대한 계산식 파싱 테스트")
	@Test
	public void parseExpressionTest() {
		//given
		String rawExpression = "10";
		//when
		Expression expression = ExpressionFactory.parse(rawExpression);
		//then
		assertThat(expression).isEqualTo(new Expression(new Operands(new LinkedList<>(Arrays.asList(10))),
			new Operators(new LinkedList<>())));
	}

	@DisplayName("1 + 5 계산식 파싱 테스트")
	@Test
	public void parseExpressionTest1() {
		//given
		String rawExpression = "1 + 5";
		//when
		Expression expression = ExpressionFactory.parse(rawExpression);
		//then
		assertThat(expression)
			.isEqualTo(new Expression(new Operands(new LinkedList<>(Arrays.asList(1, 5))),
				new Operators(new LinkedList<>(Arrays.asList("+")))));
	}

	@DisplayName("0 + 0 + 0 + 0 계산식 파싱 테스트")
	@Test
	public void parseExpressionTest3() {
		//given
		String rawExpression = "0 + 0 + 0 + 0";
		//when
		Expression expression = ExpressionFactory.parse(rawExpression);
		//then
		assertThat(expression)
			.isEqualTo(new Expression(new Operands(new LinkedList<>(Arrays.asList(0, 0, 0, 0))),
				new Operators(new LinkedList<>(Arrays.asList("+", "+", "+")))));
	}

	@DisplayName("1 + 2 - 3 * 4 / 5 계산식 파싱 테스트")
	@Test
	public void parseExpressionTest4() {
		//given
		String rawExpression = "1 + 2 - 3 * 4 / 5";
		//when
		Expression expression = ExpressionFactory.parse(rawExpression);
		//then
		assertThat(expression)
			.isEqualTo(new Expression(new Operands(new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5))),
				new Operators(new LinkedList<>(Arrays.asList("+", "-", "*", "/")))));
	}

	@DisplayName("10 / 10 / 10 / 10 계산식 파싱 테스트")
	@Test
	public void parseExpressionTest5() {
		//given
		String rawExpression = "10 / 10 / 10 / 10";
		//when
		Expression expression = ExpressionFactory.parse(rawExpression);
		//then
		assertThat(expression)
			.isEqualTo(new Expression(new Operands(new LinkedList<>(Arrays.asList(10, 10, 10, 10))),
				new Operators(new LinkedList<>(Arrays.asList("/", "/", "/")))));
	}

	@DisplayName("부적절한 조건 아래 파싱 시도시 RuntimeException 발생")
	@ParameterizedTest
	@ValueSource(strings = {"", "1 + k * 3 ; 4", "1 3 3 * 3 / 4", "+ + 3 * 3 ; 4", "1 + 3 * 3 / 4 +", "+"})
	public void parseExpressionExceptionTest(String expression) {
		assertThatExceptionOfType(RuntimeException.class)
			.isThrownBy(() -> ExpressionFactory.parse(expression));
	}
}