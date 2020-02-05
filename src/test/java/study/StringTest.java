package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void split() {
        String value = "1,2";
        String[] result = value.split(",");
        assertThat(result).contains("1");
        assertThat(result).contains("2");
    }


    @Test
    void substring() {
        String value = "(1,2)";
        String result = value.substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("charAt 테스트")
    @Test
    void charAt() {
        String value = "abc";
        assertThat(value.charAt(1)).isEqualTo('b');
        assertThatThrownBy(() -> value.charAt(-1)).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range");
    }
}
