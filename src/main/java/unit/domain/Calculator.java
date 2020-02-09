package unit.domain;

public class Calculator {
	private static final int MIN_SIZE_OF_TOKENS = 3;

	public static double calculate(Expression expression) {
		checkValidation(expression);

		double result = 0;
		Number number1;
		Operator operator;
		Number number2;

		while (expression.size() >= MIN_SIZE_OF_TOKENS) {
			number1 = (Number)expression.pop();
			operator = (Operator)expression.pop();
			number2 = (Number)expression.pop();

			result = operator.calculate(number1, number2);

			expression.push(new Number(Double.toString(result)));
		}

		return result;
	}

	private static void checkValidation(Expression expression) {
		if (expression.size() < MIN_SIZE_OF_TOKENS) {
			throw new IllegalArgumentException("식은 최소 3자 이상이어야 합니다.");
		}
	}
}
