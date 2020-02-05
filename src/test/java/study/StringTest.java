package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("String methods test")
public class StringTest {
	private String input;
	private String[] result;

	@Test
	@DisplayName("split() when delimiter exists within input")
	void splitNumbers() {
		input = "1,2";
		result = input.split(",");
		assertThat(result).contains("1").contains("2");
	}

	@Test
	@DisplayName("split() when delimiter does not exists within input")
	void splitNumber() {
		input = "1";
		result = input.split(",");
		assertThat(result).containsExactly("1");
	}

	@Test
	@DisplayName("substring() works properly")
	void substring() {
		input = "(1,2)";
		String substringResult = input.substring(1, 4);
		assertThat(substringResult).isEqualTo("1,2");
	}

	@Test
	@DisplayName("chatAt() works properly")
	void charAtWorksProperly() {
		input = "abc";
		for (int i = 0; i < input.length(); i++) {
			assertThat(input.charAt(i)).isInstanceOf(Character.class);
		}
	}

	@Test
	@DisplayName("charAt() throws StringIndexOutOfBoundsException")
	void charAt() {
		input = "abc";
		assertThatThrownBy(() -> {
			input.charAt(input.length());
		}).isInstanceOf(StringIndexOutOfBoundsException.class).hasMessageContaining("String index out of range: 3");
	}
}
