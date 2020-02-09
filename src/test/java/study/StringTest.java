package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @DisplayName("1. string split, contain test")
    @Test
    void split(){
        String value = "1,2";
        String[] result = value.split(",");
        assertThat(result).contains("1");
        assertThat(result).contains("2");
    }

    @DisplayName("2. string substring test")
    @Test
    void splitSubstring(){
        String value = "(1,2)";
        String result = value.substring(1, value.length()-1);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("3. IndexOutOfBound test")
    @Test
    void indexCheck(){
        assertThatThrownBy(() -> {
            String value = "abc";
            char result2 = value.charAt(5);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("Index: 2, Size: 2");
    }
}
