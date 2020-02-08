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
		validateNonZeroLength(expression);
		validateOddLength(expression);
		validateNumericPosition(expression);
		validateOperatorPosition(expression);
	}

	private static void validateNonZeroLength(List<String> expression) {
		if (expression.size() == ZERO) {
			throw new IllegalArgumentException("계산식의 성분은 빈값이 될 수 없습니다.");
		}
	}

	private static void validateOddLength(List<String> expression) {
		if (expression.size() % TWO == ZERO) {
			throw new IllegalArgumentException("계산식의 성분은 짝수개가 될 수 없습니다.");
		}
	}

	private static void validateNumericPosition(List<String> expression) {
		for (int i = NUMERIC_START_IDX, size = expression.size(); i < size; i += VALID_CHECK_IDX_UNIT) {
			if (!isNumeric(expression.get(i))) {
				throw new IllegalArgumentException("피연산자 위치에 숫자 외 값이 들어있습니다.");
			}
		}
	}

	private static boolean isNumeric(String expressionArg) {
		try {
			Integer.parseInt(expressionArg);
		} catch (Exception e) {
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
				throw new IllegalArgumentException("연산자 위치에 연산자 외 값이 들어있습니다.");
			}
		}
	}

	private static boolean isOperator(String expressionArg) {
		return Operator.isOperator(expressionArg);
	}

	private static Deque<Integer> getOperands(List<String> splitExpressions) {
		return splitExpressions.stream()
			.filter(ExpressionParser::isNumeric)
			.map(Integer::parseInt)
			.collect(Collectors.toCollection(LinkedList::new));
	}

	private static Queue<String> getOperators(List<String> splitExpressions) {
		return splitExpressions.stream()
			.filter(ExpressionParser::isOperator)
			.collect(Collectors.toCollection(LinkedList::new));
	}
}
