package study;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Set Collection API - study test")
public class SetTest {
	private Set numbers;

	@BeforeEach
	void setUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}

	@DisplayName("Set Collection API - size() test")
	@Test
	void testSize() {
		final int expected = 3;
		assertThat(numbers).hasSize(expected);
	}

	@DisplayName("Set Collection API - contains() test")
	@ParameterizedTest
	@CsvSource(value = {"1,true", "2,true", "3,true", "4,false"})
	void testContains(int input, boolean expected) {
		assertThat(numbers.contains(input)).isEqualTo(expected);
	}
}
