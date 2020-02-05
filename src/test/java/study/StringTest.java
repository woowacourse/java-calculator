package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
    void charAtIndexInBound() {
        String value = "abc";
        char result = value.charAt(1);

        assertThat(result).isEqualTo('b');
    }

    @Test
    void charAtIndexOutOfBound() {
        String value = "abc";

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    char anonymousChar = value.charAt(3);;
                }
            ).withMessage("String index out of range: 3");
    }
}
