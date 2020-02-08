package domain;

import java.util.Objects;
import java.util.Queue;

public class Operators {
	private final Queue<String> operators;

	public Operators(Queue<String> operators) {
		this.operators = operators;
	}

	boolean isEmpty() {
		return operators.isEmpty();
	}

	public String poll() {
		return operators.poll();
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
