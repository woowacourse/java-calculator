package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    void split() {
        String commaValues = "1,2";
        String[] result = commaValues.split(",");
        assertThat(result).contains("1");
        assertThat(result).contains("2");
    }


    @Test
    void substring() {
        String subValues = "(1,2)";
        String resultValue = subValues.substring(1, 4);
        assertThat(resultValue).doesNotContain("(", ")");
    }

    @Test
    void charAt() {
        String value = "abc";
        assertThatThrownBy(() -> {
            value.charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range:");

    }


}
