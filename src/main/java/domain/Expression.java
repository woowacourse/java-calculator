package domain;

import java.util.Objects;

public class Expression {
	private final Operands operands;
	private final Operators operators;

	Expression(Operands operands, Operators operators) {
		this.operands = operands;
		this.operators = operators;
	}

	int calculate() {
		while (!operators.isEmpty()) {
			Operator operator = Operator.getOperatorOf(operators.poll());
			int result = operator.calculate(operands.poll(), operands.poll());
			operands.offerFirst(result);
		}
		return operands.poll();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Expression that = (Expression)o;
		return Objects.equals(operands, that.operands) &&
			Objects.equals(operators, that.operators);
	}

	@Override
	public int hashCode() {
		return Objects.hash(operands, operators);
	}
}
