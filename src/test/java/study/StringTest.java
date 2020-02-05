package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class dStringTest {

    @Test
    void split() {
        String value = "1,2";
        String[] split = value.split(",");

        assertThat(split.length).isEqualTo(2);
        assertThat(split).contains("2", "1");
        assertThat(split).doesNotContain(",");
        assertThat(value.split(",")).containsExactly("1", "2");
    }

    @Test
    void substring() {
        String value = "(1,2)";
        String result = value.substring(1, 4);
        assertThat(result).isEqualTo("1,2");
        assertThat(result).doesNotContain("(", ")");
    }

    @DisplayName("String Test")
    @Test
    void charAt() {
        String value = "abc";

        assertThat(value.charAt(0)).isEqualTo('a');
        assertThat(value.charAt(1)).isEqualTo('b');
        assertThat(value.charAt(2)).isEqualTo('c');

        assertThatThrownBy(() -> {
            value.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("index");

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    value.charAt(3);
                }).withMessageContaining("range");

    }
}
