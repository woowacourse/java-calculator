package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StringTest {
	@Test
	void split() {
		String value = "1,2";
		String[] result = value.split(",");
		assertThat(result).contains("1");
		assertThat(result).contains("2");
	}
}
