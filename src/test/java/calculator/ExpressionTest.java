package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.woowacourse.calculator.domain.Expression;
import com.woowacourse.calculator.domain.OperatorType;

/**
 * 클래스 이름 : ExpressionTest.java
 *
 * @author K.S.KIM
 * @version 1.0
 * <p>
 * 날짜 : 2020/02/09
 */
public class ExpressionTest {
	@Test
	@DisplayName("생성자의 인자 numbers가 널인 경우")
	void constructor_NumbersIsNull_NullPointerExceptionThrown() {
		Assertions.assertThatThrownBy(() -> {
			List<OperatorType> operators = Arrays.asList(OperatorType.values());
			new Expression(null, operators);
		}).isInstanceOf(NullPointerException.class);
	}

	@Test
	@DisplayName("생성자의 인자 operators가 널인 경우")
	void constructor_OperatorsIsNull_NullPointerExceptionThrown() {
		Assertions.assertThatThrownBy(() -> {
			List<Double> numbers = Arrays.asList(1D, 2D, 3D, 4D, 5D);
			new Expression(numbers, null);
		}).isInstanceOf(NullPointerException.class);
	}

	@Test
	@DisplayName("생성자의 인자 numbers, operators가 모두 널인 경우")
	void constructor_NumbersAndOperatorsAreNull_NullPointerExceptionThrown() {
		Assertions.assertThatThrownBy(() -> new Expression(null, null))
				.isInstanceOf(NullPointerException.class);
	}

	@Test
	@DisplayName("생성자의 인자 numbers 크기가 0인 경우")
	void constructor_NumberSizeIsZero_IllegalArgumentExceptionThrown() {
		Assertions.assertThatThrownBy(() ->  new Expression(new ArrayList<>(),
				Collections.singletonList(OperatorType.PLUS)))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("수식은 최소한 하나의 숫자를 가져야 합니다");
	}

	@Test
	@DisplayName("생성자의 인자 numbers 크기가 operators + 1 보다 큰 경우")
	void constructor_NumbersSizeGreaterThanOperatorsSizePlusOne_IllegalArgumentExceptionThrown() {
		Assertions.assertThatThrownBy(() -> new Expression(Arrays.asList(1D, 2D, 3D),
				Collections.singletonList(OperatorType.PLUS)))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("피연산자의 개수는 연산자의 개수보다 반드시 하나 더 있어야 합니다");
	}

	@Test
	@DisplayName("생성자의 인자 numbers 크기가 operators 수와 동일한 경우")
	void constructor_NumbersSizeEqualsOperatorsSize_IllegalArgumentExceptionThrown() {
		Assertions.assertThatThrownBy(() -> {
			List<Double> numbers = Arrays.asList(1D, 2D);
			List<OperatorType> operators = Arrays.asList(OperatorType.PLUS, OperatorType.MINUS);
			new Expression(numbers, operators);
		}).isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("피연산자의 개수는 연산자의 개수보다 반드시 하나 더 있어야 합니다");
	}

	@Test
	@DisplayName("생성자의 인자 numbers 크기가 operators + 1 보다 작은 경우")
	void constructor_NumbersSizeLessThanOperatorsSizePlusOne_IllegalArgumentExceptionThrown() {
		Assertions.assertThatThrownBy(() -> {
			List<Double> numbers = Arrays.asList(1D, 2D);
			List<OperatorType> operators = Arrays.asList(OperatorType.PLUS, OperatorType.MINUS, OperatorType.DIVIDE);
			new Expression(numbers, operators);
		}).isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("피연산자의 개수는 연산자의 개수보다 반드시 하나 더 있어야 합니다");
	}

	@Test
	@DisplayName("calculate 테스트")
	void calculate() {
		List<Double> numbers = Arrays.asList(1D, 2D, 3D, 4D, 5D);
		List<OperatorType> operators = Arrays.asList(
				OperatorType.PLUS,
				OperatorType.DIVIDE,
				OperatorType.MINUS,
				OperatorType.MULTIPLY);
		Expression expression = new Expression(numbers, operators);
		Assertions.assertThat(expression.calculate())
				.isEqualTo(-15D);
	}
}
