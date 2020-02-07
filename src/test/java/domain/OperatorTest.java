package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class OperatorTest {

	@ParameterizedTest
	@CsvSource(value = {"5:3:8", "3:2:5"}, delimiter = ':')
	void addTest(int number1, int number2, int expected) {
		Operator addOperator = Operator.ADD;
		assertThat(addOperator.calculate(number1, number2)).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {"5:3:2", "3:2:1"}, delimiter = ':')
	void subtractTest(int number1, int number2, int expected) {
		Operator subtractOperator = Operator.SUB;
		assertThat(subtractOperator.calculate(number1, number2)).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {"5:3:15", "3:2:6"}, delimiter = ':')
	void multiplyTest(int number1, int number2, int expected) {
		Operator multiplyOperator = Operator.MULTIPLY;
		assertThat(multiplyOperator.calculate(number1, number2)).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {"6:3:2", "3:1:3"}, delimiter = ':')
	void divideTest(int number1, int number2, int expected) {
		Operator divideOperator = Operator.DIVIDE;
		assertThat(divideOperator.calculate(number1, number2)).isEqualTo(expected);
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
	public void isOperatorSymbolTest(String symbolValue, boolean actual) throws Exception {
	    boolean expected  = Operator.isOperatorSymbol(symbolValue);
		assertThat(expected).isEqualTo(actual);
	}

	@Test
	public void findBySymbolPlusTest() throws Exception {
	    Operator expected = Operator.findBySymbol("+");
		assertThat(expected).isEqualTo(Operator.ADD);
	}
	@Test
	public void findBySymbolSubtractTest() throws Exception {
		Operator expected = Operator.findBySymbol("-");
		assertThat(expected).isEqualTo(Operator.SUB);
	}

	@Test
	public void findBySymbolMultiplyTest() throws Exception {
		Operator expected3 = Operator.findBySymbol("*");
		assertThat(expected3).isEqualTo(Operator.MULTIPLY);
	}

	@Test
	public void findBySymbolDivideTest() throws Exception {
		Operator expected4 = Operator.findBySymbol("/");
		assertThat(expected4).isEqualTo(Operator.DIVIDE);
	}

	@ParameterizedTest
	@ValueSource(strings = {"abc", "dsjk", "2", "ㄹㅁ", "&"})
	public void findBySymbolExceptionTest(String operator) {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> Operator.findBySymbol(operator));
	}
}