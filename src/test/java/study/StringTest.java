package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void split_ShouldContainsOneAndTwo() {
        String value = "1,2";
        String[] result = value.split(",");
        assertThat(result).contains("1");
        assertThat(result).contains("2");
    }

    @Test
    void split_ShouldContainsExactlyOne() {
        String value = "1";
        String[] result = value.split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    void substring_ShouldRemoveParentheses() {
        String value = "(1,2)";
        String result = value.substring(1,4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("Find String index out of bounds exception")
    void charAt_ShouldThrowStringOutOfBoundsException(){
        String value = "abc";
        int index = 5;
        assertThatThrownBy(() -> {
            value.charAt(index);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageMatching("String index out of range: \\d+");
    }
}
