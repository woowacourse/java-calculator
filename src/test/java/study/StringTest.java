package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StringTest {
	private String value;
	private String[] result;

	@Test
	void splitNumbers() {
		value = "1,2";
		result = value.split(",");
		assertThat(result).contains("1").contains("2");
	}

	@Test
	void splitNumber() {
		value = "1";
		result = value.split(",");
		assertThat(result).containsExactly("1");
	}

	@Test
	void substring() {
		value = "(1,2)";
		String substringResult = value.substring(1, 4);
		assertThat(substringResult).isEqualTo("1,2");
	}
}
