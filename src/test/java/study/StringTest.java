package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringTest {
	@Test
	void split() {
		String value = "1,2";
		String[] result = value.split(",");
		Assertions.assertThat(result).contains("1");
		Assertions.assertThat(result).contains("2");
		Assertions.assertThat(result).contains("3");
	}

	@Test
	void splitOnlyOne() {
		String value = "1";
		String[] result = value.split(",");
		Assertions.assertThat(result).containsExactly("1");
	}

	@Test
	void splitRemoveBrace() {
		String value = "(1,2)";
		String result = value.substring(1, 4);
		Assertions.assertThat(result).isEqualTo("1,2");
	}

}
