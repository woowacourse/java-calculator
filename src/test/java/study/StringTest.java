package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringTest {
    @Test
    @DisplayName("#split() : return String Array using standard")
    void split() {
        String value = "1,2";
        String[] result = value.split(",");

        assertThat(result).contains("1");
    }

    @Test
    @DisplayName("#charAt() : return char when indexing within bound")
    void subString() {
        String value = "(1,2)";
        String result = value.substring(1, 4);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("#charAt() : return char when indexing within bound")
    void charAtIndexInBound() {
        String value = "abc";
        char result = value.charAt(1);

        assertThat(result).isEqualTo('b');
    }

    @Test
    @DisplayName("#charAt() : throw IndexOutOfBoundsException when indexing out of bound")
    void charAtIndexOutOfBound() {
        String value = "abc";

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    char anonymousChar = value.charAt(3);
                }
            ).withMessage("String index out of range: 3");
    }
}
