package domain;

public class Calculator {
	int	add(int number1, int number2) {
		return number1 + number2;
	}

	int subtract(int number1, int number2) {
		return number1 - number2;
	}

	int multiply(int number1, int number2) {
		return number1 * number2;
	}

	int divide(int number1, int number2) {
		if (number2 == 0) {
			throw new IllegalArgumentException("0으로 나누지 마시오.");
		}
		return number1 / number2;
	}
}
