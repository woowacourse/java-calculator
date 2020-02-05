package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
	@Test
	void split() {
		String value = "1,2";
		String[] result = value.split(",");

		assertThat(result).contains("1");
		assertThat(result).contains("2");
		assertThat(result).containsExactly("1", "2");
	}

	@Test
	public void substring() {
		String value = "(1,2)";
		String result = value.substring(1, 4);

		assertThat(result).isEqualTo("1,2");
	}

	@Test
	@DisplayName("IndexOutOfBoundsException 발생 테스트")
	public void charAt() {
		String value = "abc";

		assertThatExceptionOfType(IndexOutOfBoundsException.class)
			.isThrownBy(() -> {
				char c = value.charAt(4);
			}).withMessageMatching("String index out of range: \\d+");
	}
}
