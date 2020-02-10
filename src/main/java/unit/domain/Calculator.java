package unit.domain;

public class Calculator {
	private static final int MIN_SIZE_OF_EXPRESSION = 3;

	public static double calculate(Numbers numbers, Operators operators) {
		double result = 0;
		Number number1;
		Number number2;

		while (canCalculate(numbers, operators)) {
			number1 = numbers.pop();
			number2 = numbers.pop();

			final String letter = operators.pop();
			final Operator currentOperator = Operator.of(letter);
			result = currentOperator.operate(number1, number2);

			numbers.push(new Number(result));
		}

		return result;
	}

	private static boolean canCalculate(Numbers numbers, Operators operators) {
		final int expressionSize = numbers.size() + operators.size();
		return expressionSize >= MIN_SIZE_OF_EXPRESSION;
	}
}
