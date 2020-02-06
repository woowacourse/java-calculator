package study;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class StringTest {
	@Test
	void split() {
		String value = "1,2";
		String[] values = value.split(",");
		assertThat(values).contains("1");
		assertThat(values).contains("2");
		assertThat(values).containsExactly("1", "2");
	}
}
