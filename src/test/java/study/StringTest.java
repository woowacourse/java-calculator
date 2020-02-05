package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringTest {

	@Test
	void splitTest() {
		String value = "1,2";
		String[] result = value.split(",");
		System.out.println(result);
		System.out.println(result[0] + "," + result[1]);
		Assertions.assertThat(result).contains("1");
		Assertions.assertThat(result).contains("2");
		Assertions.assertThat(result).contains("1", "2");
		Assertions.assertThat(result).containsExactly("1", "2");
		Assertions.assertThat(result).doesNotContain("3");
	}

	@Test
	void singleSplitTest() {
		String value = "1";
		String[] result = value.split(",");
		System.out.println(result);
		System.out.println(result[0]);
		Assertions.assertThat(result).containsExactly("1");
	}
}
