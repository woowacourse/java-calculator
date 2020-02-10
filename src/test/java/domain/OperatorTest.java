package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class OperatorTest {

	@DisplayName("연산자 덧셈 기능 테스트")
	@ParameterizedTest
	@CsvSource(value = {"5:3:8", "3:2:5"}, delimiter = ':')
	void addTest(int operand1, int operand2, int expected) {
		Operator addOperator = Operator.ADD;
		assertThat(addOperator.calculate(operand1, operand2)).isEqualTo(expected);
	}

	@DisplayName("연산자 뺄셈 기능 테스트")
	@ParameterizedTest
	@CsvSource(value = {"5:3:2", "3:2:1"}, delimiter = ':')
	void subtractTest(int operand1, int operand2, int expected) {
		Operator subtractOperator = Operator.SUBTRACT;
		assertThat(subtractOperator.calculate(operand1, operand2)).isEqualTo(expected);
	}

	@DisplayName("연산자 곱셈 기능 테스트")
	@ParameterizedTest
	@CsvSource(value = {"5:3:15", "3:2:6"}, delimiter = ':')
	void multiplyTest(int operand1, int operand2, int expected) {
		Operator multiplyOperator = Operator.MULTIPLY;
		assertThat(multiplyOperator.calculate(operand1, operand2)).isEqualTo(expected);
	}

	@DisplayName("연산자 나눗셈 기능 테스트")
	@ParameterizedTest
	@CsvSource(value = {"6:3:2", "3:1:3"}, delimiter = ':')
	void divideTest(int operand1, int operand2, int expected) {
		Operator divideOperator = Operator.DIVIDE;
		assertThat(divideOperator.calculate(operand1, operand2)).isEqualTo(expected);
	}

	@DisplayName("Divide with 0 test")
	@ParameterizedTest
	@CsvSource(value = {"0,0", "1,0", "10,0", "20,0"}, delimiter = ',')
	void divideWithZeroTest(int operand1, int operand2) {
		Operator divideOperator = Operator.DIVIDE;
		assertThatThrownBy(() -> divideOperator.calculate(operand1, operand2))
			.isInstanceOf(ArithmeticException.class);
	}

	@DisplayName("해당 문자 연산자 체크 기능 테스트")
	@ParameterizedTest
	@CsvSource(value = {"+,true", "-,true", "/,true", "*,true", "3,false", "a,false"}, delimiter = ',')
	public void isOperatorTest(String symbolValue, boolean actual) {
		boolean expected = Operator.isOperator(symbolValue);
		assertThat(expected).isEqualTo(actual);
	}

	@DisplayName("덧셈 Operator 객체 탐색 테스트")
	@Test
	public void getOperatorOfPlusTest() {
		Operator expected = Operator.getOf("+");
		assertThat(expected).isEqualTo(Operator.ADD);
	}

	@DisplayName("뺄셈 Operator 객체 탐색 테스트")
	@Test
	public void getOperatorOfSubtractTest() {
		Operator expected = Operator.getOf("-");
		assertThat(expected).isEqualTo(Operator.SUBTRACT);
	}

	@DisplayName("곱셈 Operator 객체 탐색 테스트")
	@Test
	public void getOperatorOfMultiplyTest() {
		Operator expected3 = Operator.getOf("*");
		assertThat(expected3).isEqualTo(Operator.MULTIPLY);
	}

	@DisplayName("나눗셈 Operator 객체 탐색 테스트")
	@Test
	public void getOperatorOfDivideTest() {
		Operator expected4 = Operator.getOf("/");
		assertThat(expected4).isEqualTo(Operator.DIVIDE);
	}

	@DisplayName("부적절한 Operator 객체 탐색시 실패 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"abc", "dsjk", "2", "ㄹㅁ", "&"})
	public void getOperatorOfExceptionTest(String operator) {
		assertThatExceptionOfType(NoSuchElementException.class)
			.isThrownBy(() -> Operator.getOf(operator));
	}
}