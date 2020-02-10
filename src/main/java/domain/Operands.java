package domain;

import java.util.Deque;
import java.util.Objects;

public class Operands {
	private final Deque<Integer> operands;

	public Operands(Deque<Integer> operands) {
		this.operands = operands;
	}

	Integer poll() {
		return operands.poll();
	}

	void offerFirst(Integer operand) {
		operands.offerFirst(operand);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Operands operands1 = (Operands)o;
		return Objects.equals(operands, operands1.operands);
	}

	@Override
	public int hashCode() {
		return Objects.hash(operands);
	}
}