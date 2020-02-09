package calculator;

import java.util.Arrays;

import com.woowacourse.calculator.domain.Expression;
import com.woowacourse.calculator.domain.ExpressionFactory;
import com.woowacourse.calculator.domain.OperatorType;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * 클래스 이름 : ExpressionFactoryTest.java
 *
 * @author S.W.PARK
 * @author K.S.KIM
 * @version 1.0
 * <p>
 * 날짜 : 2020/02/06
 */
public class ExpressionFactoryTest {
	@Test
	@DisplayName("수식 생성 테스트")
	void create() {
		Expression expression = new Expression(Arrays.asList(2D, 3D, 4D, 7D, -6D),
				Arrays.asList(OperatorType.PLUS, OperatorType.MULTIPLY, OperatorType.DIVIDE, OperatorType.MINUS));
		Assertions.assertThat(ExpressionFactory.create("2 + 3 * 4 / 7 - -6"))
				.isEqualTo(expression);
	}

	@Test
	@DisplayName("입력 문자열이 널인 경우")
	void create_InputStringIsNull_NullPointerExceptionThrown() {
		Assertions.assertThatThrownBy(() -> ExpressionFactory.create(null))
				.isInstanceOf(NullPointerException.class);
	}

	@ParameterizedTest
	@DisplayName("공백을 여러번 입력한 경우")
	@ValueSource(strings = {"2   + 3", "2 +  3"})
	void create_ConsecutiveSpace_IllegalArgumentExceptionThrown(String input) {
		Assertions.assertThatThrownBy(() -> ExpressionFactory.create(input))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("empty String");
	}

	@Test
	@DisplayName("존재하지 않는 연산자를 입력한 경우")
	void create_InvalidToken_IllegalArgumentExceptionThrown() {
		Assertions.assertThatThrownBy(() -> ExpressionFactory.create("2 & 3 * 4"))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("연산자에 포함되지 않습니다.");
	}

	@Test
	@DisplayName("연산자를 연속으로 입력한 경우")
	void create_ConsecutiveOperator_NumberFormatExceptionThrown() {
		Assertions.assertThatThrownBy(() -> ExpressionFactory.create("12 - - 332 / 4"))
				.isInstanceOf(NumberFormatException.class);
	}

	@Test
	@DisplayName("숫자를 연속으로 입력한 경우")
	void create_ConsecutiveNumber_IllegalArgumentExceptionThrown() {
		Assertions.assertThatThrownBy(() -> ExpressionFactory.create("2112 323 + 3 - 4"))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("For input string: ");
	}
}
