package study;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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

	@Test
	void size() {
		int size = numbers.size();
		Assertions.assertThat(size).isEqualTo(3);
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	void isContain_ShouldReturnTrueForNumberInSet(int number) {
		assertTrue(numbers.contains(number));
	}

	@ParameterizedTest
	@CsvSource(value = {"1:true", "4:false"}, delimiter = ':')
	void isContain_ShouldReturnTrueForNumberInSetElseFalse(int input, boolean expected) {
		Assertions.assertThat(numbers.contains(input)).isEqualTo(expected);
	}
}
