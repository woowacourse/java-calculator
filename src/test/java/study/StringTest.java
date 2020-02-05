package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class StringTest {
    @Test
    void split() {
        String value = "1,2";
        String[] result = value.split(",");
        assertThat(result).contains("1");
    }

    @Test
    void subString() {
        String value = "(1,2)";
        String result = value.substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void charAtSuccess() {
        String value = "abc";
        char result = value.charAt(1);
        assertThat(result).isEqualTo('b');
    }
}
