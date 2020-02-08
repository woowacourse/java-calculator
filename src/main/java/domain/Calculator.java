package domain;

public class Calculator {
	private static final int FIRST_OPERAND_INDEX = 0;
	private static final int FIRST_OPERATOR_INDEX = 1;
	private static final int OPERATOR_INDEX_STEP = 2;

	public static double calculate(String[] tokens) {
		if (isEmpty(tokens)) {
			return 0;
		}
		return reduce(tokens);
	}

	private static boolean isEmpty(String[] tokens) {
		return tokens == null || tokens.length == 0;
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
