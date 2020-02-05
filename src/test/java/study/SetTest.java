package study;

import java.util.HashSet;
import java.util.Set;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Set Methods Test")
public class SetTest {
	private Set numbers;

	@BeforeEach
	void setUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
	}

	@Test
	@DisplayName("size() works properly")
	void size() {
		Assertions.assertThat(numbers.size()).isEqualTo(4);
	}
}
