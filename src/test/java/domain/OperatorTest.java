package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class OperatorTest {

	@ParameterizedTest
	@CsvSource(value = {"5:3:8", "3:2:5"}, delimiter = ':')
	void addTest(int operand1, int operand2, int expected) {
		Operator addOperator = Operator.ADD;
		assertThat(addOperator.calculate(operand1, operand2)).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {"5:3:2", "3:2:1"}, delimiter = ':')
	void subtractTest(int operand1, int operand2, int expected) {
		Operator subtractOperator = Operator.SUBTRACT;
		assertThat(subtractOperator.calculate(operand1, operand2)).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {"5:3:15", "3:2:6"}, delimiter = ':')
	void multiplyTest(int operand1, int operand2, int expected) {
		Operator multiplyOperator = Operator.MULTIPLY;
		assertThat(multiplyOperator.calculate(operand1, operand2)).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {"6:3:2", "3:1:3"}, delimiter = ':')
	void divideTest(int operand1, int operand2, int expected) {
		Operator divideOperator = Operator.DIVIDE;
		assertThat(divideOperator.calculate(operand1, operand2)).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {"0,0", "1,0", "10,0", "20,0"}, delimiter = ',')
	@DisplayName("Divide with 0 test")
	void divideWithZeroTest(int operand1, int operand2) {
		Operator divideOperator = Operator.DIVIDE;
		assertThatThrownBy(() -> divideOperator.calculate(operand1, operand2))
			.isInstanceOf(ArithmeticException.class);
	}

	@ParameterizedTest
	@CsvSource(value = {"+,true", "-,true", "/,true", "*,true", "3,false", "a,false"}, delimiter = ',')
	public void isOperatorTest(String symbolValue, boolean actual) {
	    boolean expected  = Operator.isOperator(symbolValue);
		assertThat(expected).isEqualTo(actual);
	}

	@Test
	public void getOperatorOfPlusTest() {
	    Operator expected = Operator.getOperatorOf("+");
		assertThat(expected).isEqualTo(Operator.ADD);
	}
	@Test
	public void getOperatorOfSubtractTest() {
		Operator expected = Operator.getOperatorOf("-");
		assertThat(expected).isEqualTo(Operator.SUBTRACT);
	}

	@Test
	public void getOperatorOfMultiplyTest() {
		Operator expected3 = Operator.getOperatorOf("*");
		assertThat(expected3).isEqualTo(Operator.MULTIPLY);
	}

	@Test
	public void getOperatorOfDivideTest() {
		Operator expected4 = Operator.getOperatorOf("/");
		assertThat(expected4).isEqualTo(Operator.DIVIDE);
	}

	@ParameterizedTest
	@ValueSource(strings = {"abc", "dsjk", "2", "ㄹㅁ", "&"})
	public void getOperatorOfExceptionTest(String operator) {
		assertThatExceptionOfType(NoSuchElementException.class)
			.isThrownBy(() -> Operator.getOperatorOf(operator));
	}
}