package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
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

	@Test
	void substring() {
		String value = "(1,2)";
		value = value.substring(1, 4);
		assertThat(value).isEqualTo("1,2");
	}

	@Test
	@DisplayName("문자열 인덱스 범위를 벗어난 접근 예외 발생확인 테스트")
	void charAt() {
		String value = "abc";
		assertThatThrownBy(() -> {
			value.charAt(3);
		}).isInstanceOf(StringIndexOutOfBoundsException.class)
				.hasMessageContaining("String index out of range: ");
		assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
				.isThrownBy(() -> {
					value.charAt(12);
				}).withMessageMatching("String index out of range: \\d+");
	}
}
