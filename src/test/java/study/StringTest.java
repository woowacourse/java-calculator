package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    /**
     * 요구사항 1. string split, contain 테스트
     */
    @Test
    void split() {
        String value = "1,2";
        String[] result = value.split(",");
        assertThat(result).contains("1");
        assertThat(result).contains("2");
    }

    /**
     * 요구사항 2. string substring 테스트
     */
    @Test
    void splitSubstring() {
        String value = "(1,2)";
        String result = value.substring(1, value.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

    /**
     * 요구사항 3. IndexOutOfBound 테스트
     */
    @Test
    void indexCheck() {
        assertThatThrownBy(() -> {
            String value = "abc";
            char result2 = value.charAt(5);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("Index: 2, Size: 2");
    }
}
