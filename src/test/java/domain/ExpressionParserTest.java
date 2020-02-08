package domain;

import java.util.Arrays;
import java.util.LinkedList;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ExpressionParserTest {

	@Test
	@DisplayName("10 단항식에 대한 계산식 파싱 테스트")
	public void parseExpressionTest() throws Exception {
	    //given
	    String rawExpression = "10";
	    //when
		Expression expression = ExpressionParser.parseExpression(rawExpression);
		//then
		Assertions.assertThat(expression).isEqualTo(new Expression(new LinkedList<>(Arrays.asList(10)), new LinkedList<>()));
	}

	@Test
	@DisplayName("1 + 5 계산식 파싱 테스트")
	public void parseExpressionTest1() throws Exception {
		//given
		String rawExpression = "1 + 5";
		//when
		Expression expression = ExpressionParser.parseExpression(rawExpression);
		//then
		Assertions.assertThat(expression)
			.isEqualTo(new Expression(new LinkedList<>(Arrays.asList(1, 5)), new LinkedList<>(Arrays.asList("+"))));
	}

	@Test
	@DisplayName("0 + 0 + 0 + 0 계산식 파싱 테스트")
	public void parseExpressionTest3() throws Exception {
		//given
		String rawExpression = "0 + 0 + 0 + 0";
		//when
		Expression expression = ExpressionParser.parseExpression(rawExpression);
		//then
		Assertions.assertThat(expression)
			.isEqualTo(new Expression(new LinkedList<>(Arrays.asList(0, 0, 0, 0)),
				new LinkedList<>(Arrays.asList("+", "+", "+"))));
	}

	@Test
	@DisplayName("1 + 2 - 3 * 4 / 5 계산식 파싱 테스트")
	public void parseExpressionTest4() throws Exception {
		//given
		String rawExpression = "1 + 2 - 3 * 4 / 5";
		//when
		Expression expression = ExpressionParser.parseExpression(rawExpression);
		//then
		Assertions.assertThat(expression)
			.isEqualTo(new Expression(new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5)),
				new LinkedList<>(Arrays.asList("+", "-", "*", "/"))));
	}

	@Test
	@DisplayName("10 / 10 / 10 / 10 계산식 파싱 테스트")
	public void parseExpressionTest5() throws Exception {
		//given
		String rawExpression = "10 / 10 / 10 / 10";
		//when
		Expression expression = ExpressionParser.parseExpression(rawExpression);
		//then
		Assertions.assertThat(expression)
			.isEqualTo(new Expression(new LinkedList<>(Arrays.asList(10, 10, 10, 10)),
				new LinkedList<>(Arrays.asList("/", "/", "/"))));
	}
}