package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("String methods test")
public class StringTest {
	private String value;
	private String[] result;

	@Test
	@DisplayName("split() when delimiter exists within input")
	void splitNumbers() {
		value = "1,2";
		result = value.split(",");
		assertThat(result).contains("1").contains("2");
	}

	@Test
	@DisplayName("split() when delimiter does not exists within input")
	void splitNumber() {
		value = "1";
		result = value.split(",");
		assertThat(result).containsExactly("1");
	}

	@Test
	@DisplayName("substring() works properly")
	void substring() {
		value = "(1,2)";
		String substringResult = value.substring(1, 4);
		assertThat(substringResult).isEqualTo("1,2");
	}

	@Test
	@DisplayName("charAt() throws StringIndexOutOfBoundsException")
	void charAt() {
		value = "abc";
		assertThatThrownBy(() -> {
			for (int i = 0; i <= 3; i++) {
				value.charAt(i);
			}
		}).isInstanceOf(StringIndexOutOfBoundsException.class).hasMessageContaining("String index out of range: 3");
	}
}
