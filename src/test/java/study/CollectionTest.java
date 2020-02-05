package study;

import java.util.HashSet;
import java.util.Set;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CollectionTest {

	private Set numbers;

	@BeforeEach
	void setUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}

	@Test
	void sizeTest() {
		Assertions.assertThat(numbers.size()).isEqualTo(3);
	}

	@Test
	void containsTest() {
		Assertions.assertThat(numbers.contains(1)).isTrue();
		Assertions.assertThat(numbers.contains(2)).isTrue();
		Assertions.assertThat(numbers.contains(3)).isTrue();
	}
}
