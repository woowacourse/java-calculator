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
}
