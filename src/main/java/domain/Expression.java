package domain;

import java.util.Deque;
import java.util.Queue;

public class Expression {
	private final Deque<Integer> operands;
	private final Queue<String> operators;

	Expression(Deque<Integer> operands, Queue<String> operators) {
		this.operands = operands;
		this.operators = operators;
	}

	int calculate() {
		while (!operators.isEmpty()) {
			Operator operator = Operator.getOperatorOf(operators.poll());
			int result = operator.calculate(operands.poll(), operands.poll());
			operands.offerFirst(result);
		}
		return operands.peek();
	}
}
