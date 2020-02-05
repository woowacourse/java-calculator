package study;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
	@DisplayName("Set 사이즈 테스트")
	public void size() {
		assertThat(numbers.size()).isEqualTo(3);
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	@DisplayName("Set contains 테스트")
	public void contains(int number) {
		assertThat(numbers).contains(number);
	}

	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false"}, delimiter = ':')
	@DisplayName("Set contains 기댓값 테스트")
	public void containsWithExpectedValue(String input, String expected) {
		int actualInput = Integer.parseInt(input);
		boolean actualExpected = Boolean.parseBoolean(expected);

		assertThat(numbers.contains(actualInput)).isEqualTo(actualExpected);
	}
}
