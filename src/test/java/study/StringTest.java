package study;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void split(){
        String value = "1,2";
        String[] result = value.split(",");
        assertThat(result).contains("1");
        assertThat(result).contains("2");
    }

    @Test
    void splitSubstring(){
        String value = "(1,2)";
        String result = value.substring(1, value.length()-1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void indexCheck(){
        assertThatThrownBy(() -> {
            String value = "abc";
            char result2 = value.charAt(5);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("Index: 2, Size: 2");
    }
}
