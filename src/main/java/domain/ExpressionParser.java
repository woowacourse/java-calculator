package domain;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class ExpressionParser {
	private static final String SPLIT_REGEX = " ";

	private static final int TWO = 2;
	private static final int ZERO = 0;

	private static final int SINGLE_EXPRESSION_SIZE = 1;
	private static final int NUMERIC_START_IDX = 0;
	private static final int OPERATOR_START_IDX = 1;
	private static final int VALID_CHECK_IDX_UNIT = 2;

	private static final String EXPRESSION_SIZE_EXCEPTION_MESSAGE = "계산식의 성분은 %d이(가) 될 수 없습니다.";
	private static final String EXPRESSION_POSITION_EXCEPTION_MESSAGE = "계산식중 일부 위치에 부적절한 값이 있습니다.";

	public static Expression parseExpression(String rawExpression) {
		List<String> splitExpressions = splitExpression(rawExpression);
		validate(splitExpressions);
		return new Expression(getOperands(splitExpressions), getOperators(splitExpressions));
	}

	private static List<String> splitExpression(String expression) {
		return Arrays.stream(expression.split(SPLIT_REGEX))
			.collect(Collectors.toList());
	}

	private static void validate(List<String> expression) {
		validateLength(expression);
		validateNumericPosition(expression);
		validateOperatorPosition(expression);
	}

	private static void validateLength(List<String> expression) {
		int size = expression.size();
		if (isEmptyOrEvenLength(size)) {
			throw new IllegalArgumentException(String.format(EXPRESSION_SIZE_EXCEPTION_MESSAGE, size));
		}
	}

	private static boolean isEmptyOrEvenLength(int expressionLength) {
		return expressionLength == ZERO || expressionLength % TWO == ZERO;
	}

	private static void validateNumericPosition(List<String> expression) {
		for (int i = NUMERIC_START_IDX, size = expression.size(); i < size; i += VALID_CHECK_IDX_UNIT) {
			if (!isNumeric(expression.get(i))) {
				throw new IllegalArgumentException(EXPRESSION_POSITION_EXCEPTION_MESSAGE);
			}
		}
	}

	private static boolean isNumeric(String expressionArg) {
		try {
			Integer.parseInt(expressionArg);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	private static void validateOperatorPosition(List<String> expression) {
		if (expression.size() == SINGLE_EXPRESSION_SIZE) {
			return;
		}

		for (int i = OPERATOR_START_IDX, size = expression.size(); i < size; i += VALID_CHECK_IDX_UNIT) {
			if (!isOperator(expression.get(i))) {
				throw new IllegalArgumentException(EXPRESSION_POSITION_EXCEPTION_MESSAGE);
			}
		}
	}

	private static boolean isOperator(String expressionArg) {
		return Operator.isOperator(expressionArg);
	}

	private static Operands getOperands(List<String> splitExpressions) {
		Deque<Integer> operandsDeque = splitExpressions.stream()
			.filter(ExpressionParser::isNumeric)
			.map(Integer::parseInt)
			.collect(Collectors.toCollection(LinkedList::new));
		return new Operands(operandsDeque);
	}

	private static Operators getOperators(List<String> splitExpressions) {
		Queue<String> operatorsQueue = splitExpressions.stream()
			.filter(ExpressionParser::isOperator)
			.collect(Collectors.toCollection(LinkedList::new));
		return new Operators(operatorsQueue);
	}
}
