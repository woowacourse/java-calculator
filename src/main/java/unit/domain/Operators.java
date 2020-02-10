package unit.domain;

import java.util.Objects;
import java.util.Stack;

public class Operators {
	private final Stack<String> operators;

	public Operators(Stack<String> operators) {
		this.operators = operators;
	}

	public void push(final String operator) {
		operators.push(operator);
	}

	public String pop() {
		return operators.pop();
	}

	public int size() {
		return operators.size();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Operators operators1 = (Operators)o;
		return Objects.equals(operators, operators1.operators);
	}

	@Override
	public int hashCode() {
		return Objects.hash(operators);
	}
}
