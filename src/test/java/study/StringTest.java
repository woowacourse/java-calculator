package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {
    @Test
    void split() {
        String value = "1,2";
        String[] result = value.split(",");
        assertThat(result).contains("1");
        assertThat(result).contains("2");
    }

    @Test
    void split2() {
        String value2 = "1";
        String[] result2 = value2.split(",");
        assertThat(result2).contains("1");
        assertThat(result2).containsExactly("1");
    }

    @Test
    void substring() {
        String value3 = "(1,2)";
        String result3 = value3.substring(1, 4);
        assertThat(result3).contains("1,2");
    }

    @Test
    @DisplayName("요구사항 3 - assertThatThrownBy, hasMessageContaining 사용")
    public void testException() {
        assertThatThrownBy(() -> {
            String value4 = "abc";
            value4.charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 4");
    }

    @Test
    @DisplayName("요구사항 3 - assertThatExceptionOfType, withMessageMatching 사용")
    public void testException2() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    String value4 = "abc";
                    value4.charAt(4);
                }).withMessageMatching("String index out of range: \\d+");
    }
}
