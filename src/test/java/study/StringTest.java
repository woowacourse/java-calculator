package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void split() {
        String testCase1 = "1,2";
        String testCase2 = "1";
        assertThat(testCase1.split(",")).contains("1")
                .contains("2")
                .containsExactly("1", "2");
        assertThat(testCase2.split(",")).contains("1")
                .containsExactly("1");
    }

    @Test
    void substring() {
        String testCase = "(1,2)";
        assertThat(testCase.substring(1,4)).isEqualTo("1,2");
    }

    @DisplayName("charAt Test, 범위를 넘어갔을 때 예외가 잘 발생하는지 확인")
    @Test
    void charAt() {
        String testCase = "abc";
        assertThatThrownBy(() -> testCase.charAt(4)).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("index out of range");
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> testCase.charAt(4)).withMessageContaining("index out of range");
    }
}
