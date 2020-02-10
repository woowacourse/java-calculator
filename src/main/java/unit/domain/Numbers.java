package unit.domain;

import java.util.Objects;
import java.util.Stack;

public class Numbers {
	private final Stack<Number> numbers;

	public Numbers(final Stack<Number> numbers) {
		this.numbers = numbers;
	}

	public Number pop() {
		return numbers.pop();
	}

	public void push(final Number number) {
		numbers.push(number);
	}

	public int size() {
		return numbers.size();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Numbers numbers1 = (Numbers)o;
		return Objects.equals(numbers, numbers1.numbers);
	}

	@Override
	public int hashCode() {
		return Objects.hash(numbers);
	}
}
