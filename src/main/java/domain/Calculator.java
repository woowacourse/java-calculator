package domain;

public class Calculator {
	private static final int FIRST_OPERAND_INDEX = 0;
	private static final int FIRST_OPERATOR_INDEX = 1;
	private static final int OPERATOR_INDEX_STEP = 2;
	private static final String TOKEN_DELIMITER = " ";

	public static double calculate(String expression) {
		if (isEmpty(expression)) {
			return 0;
		}
		return reduce(split(expression));
	}

	private static boolean isEmpty(String expression) {
		return expression == null || expression.isEmpty();
	}

	private static String[] split(String expression) {
		return expression.split(TOKEN_DELIMITER);
	}

	private static double reduce(String[] tokens) {
		double result = Double.parseDouble(tokens[FIRST_OPERAND_INDEX]);
		for (int i = FIRST_OPERATOR_INDEX; i < tokens.length; i += OPERATOR_INDEX_STEP) {
			Operator operator = Operator.of(tokens[i]);
			double rightOperand = Double.parseDouble(tokens[i + 1]);
			result = operator.calculate(result, rightOperand);
		}
		return result;
	}
}
