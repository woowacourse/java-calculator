package unit.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NumbersTest {
	private Numbers numbers;

	@BeforeEach
	void init() {
		numbers = new Numbers(new Stack<>());
		numbers.push(new Number(1));
		numbers.push(new Number(2));
	}

	@Test
	void testSize() {
		final int two = 2;
		assertEquals(two, this.numbers.size());
	}
}