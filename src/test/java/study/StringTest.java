package study;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    void split() {
        String value1 = "1,2";
        String value2 = "1";

        String[] result1 = value1.split(",");
        Assertions.assertThat(result1).contains("1");
        Assertions.assertThat(result1).contains("2");

        String[] result2 = value2.split(",");
        Assertions.assertThat(result2).containsExactly("1");
    }

    @Test
    void substring() {
        String value = "(1,2)";
        String result = value.substring(1, 4);

        Assertions.assertThat(result).isEqualTo("1,2");
    }

    @Test
    void charAt() {
        Assertions.assertThatThrownBy(()-> {
            String value = "abc";
            char value2 = value.charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class).hasMessageContaining("String index out of range: 4");

    }
}
