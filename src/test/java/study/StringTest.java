package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    void splitWithDelimiter() {
        String value = "1,2";
        String[] result = value.split(",");

        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void splitWithoutDelimiter() {
        String value = "1";
        String[] result = value.split(",");

        assertThat(result).containsExactly(value);
    }

    @Test
    void substring() {
        String expectedValue = "1,2";
        String prefix = "(";
        String suffix = ")";
        String combinedValue = prefix + expectedValue + suffix;
        String result = combinedValue.substring(prefix.length(), combinedValue.length() - suffix.length());

        assertThat(result).isEqualTo(expectedValue);
    }

    @Test
    void charAt() {
        String value = "abc";

        assertThat(value.charAt(0)).isEqualTo('a');
        assertThat(value.charAt(1)).isEqualTo('b');
        assertThat(value.charAt(2)).isEqualTo('c');
    }

}
