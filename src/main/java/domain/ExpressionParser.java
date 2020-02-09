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
	private static final int OPERAND_START_IDX = 0;
	private static final int OPERATOR_START_IDX = 1;
	private static final int OPERAND_IDX = 2;
	private static final int OPERATOR_IDX = 2;

	private static final String EXPRESSION_SIZE_EXCEPTION_MESSAGE = "계산식의 성분은 %d이(가) 될 수 없습니다.";
	private static final String EXPRESSION_POSITION_EXCEPTION_MESSAGE = "계산식중 일부 위치에 부적절한 값이 있습니다.";

	public static Expression parse(String rawExpression) {
		List<String> expression = split(rawExpression);
		validate(expression);
		return new Expression(getOperands(expression), getOperators(expression));
	}

	private static List<String> split(String rawExpression) {
		return Arrays.stream(rawExpression.split(SPLIT_REGEX))
			.collect(Collectors.toList());
	}

	private static void validate(List<String> expression) {
		validateLength(expression);
		validateOperandPosition(expression);
		validateOperatorPosition(expression);
	}

	private static void validateLength(List<String> expression) {
		int size = expression.size();
		throwExceptionIfUnValidCondition(isNonZeroAndOddLength(size), String.format(EXPRESSION_SIZE_EXCEPTION_MESSAGE, size));
	}

	private static void throwExceptionIfUnValidCondition(boolean isValidCondition, String message) {
		if (!isValidCondition) {
			throw new IllegalArgumentException(message);
		}
	}

	private static boolean isNonZeroAndOddLength(int expressionLength) {
		return expressionLength != ZERO && expressionLength % TWO != ZERO;
	}

	private static void validateOperandPosition(List<String> expression) {
		for (int i = OPERAND_START_IDX, size = expression.size(); i < size; i += OPERAND_IDX) {
			throwExceptionIfUnValidCondition(isOperand(expression.get(i)), EXPRESSION_POSITION_EXCEPTION_MESSAGE);
		}
	}

	private static boolean isOperand(String expressionArg) {
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

		for (int i = OPERATOR_START_IDX, size = expression.size(); i < size; i += OPERATOR_IDX) {
			throwExceptionIfUnValidCondition(isOperator(expression.get(i)), EXPRESSION_POSITION_EXCEPTION_MESSAGE);
		}
	}

	private static boolean isOperator(String expressionArg) {
		return Operator.isOperator(expressionArg);
	}

	private static Operands getOperands(List<String> expression) {
		Deque<Integer> operandsDeque = expression.stream()
			.filter(ExpressionParser::isOperand)
			.map(Integer::parseInt)
			.collect(Collectors.toCollection(LinkedList::new));
		return new Operands(operandsDeque);
	}

	private static Operators getOperators(List<String> expression) {
		Queue<String> operatorsQueue = expression.stream()
			.filter(ExpressionParser::isOperator)
			.collect(Collectors.toCollection(LinkedList::new));
		return new Operators(operatorsQueue);
	}
}
