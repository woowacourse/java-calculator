package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    void split() {
        String[] result = "1,2".split(",");
        Assertions.assertThat(result).contains("2");
        Assertions.assertThat(result).containsExactly("1", "2");
        assertThat(result).contains("2","1");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    void splitArray() {
        String[] splitArr = "1".split(",");
        Assertions.assertThat(splitArr).contains("1");
        Assertions.assertThat(splitArr).containsExactly("1");
        assertThat(splitArr).contains("1");
        assertThat(splitArr).containsExactly("1");
    }

    @Test
    void subString() {
        String value = "(1,2)";
        String substring = value.substring(1, value.length()-1);
        assertThat(substring).contains("1");
    }

    @Test
    void charAt() {
        char c = "abc".charAt(2);
        assertThat(c).isEqualTo('c');
    }

    @Test
    void charAtException() {
        String value = "abc";

        Assertions.assertThatThrownBy(() -> {
            char c = value.charAt(5);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 5");
    }
}
