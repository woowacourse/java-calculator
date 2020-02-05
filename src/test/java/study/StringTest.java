package study;

import static org.assertj.core.api.Java6Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    void split() {
        String value = "1,2";
        String[] result = value.split(",");

        Assertions.assertThat(result).contains("1");
        Assertions.assertThat(result).contains("2");

        String oneValue = "1";
        String[] result2 = oneValue.split(",");

        Assertions.assertThat(result2).containsExactly("1");
    }

    @Test
    void subString() {
        String twoValue = "(1,2)";
        String resultTwo = twoValue.substring(1, 4);

        Assertions.assertThat(resultTwo).contains("1,2");
    }

    @Test
    @DisplayName("문자열의 최대 index 를 벗어난 위치의 문자를 얻으려고할 때")
    void charAt() {
        String threeValue = "abc";
        assertThatThrownBy(()->{
            threeValue.charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class)
            .hasMessageContaining("String index out");
    }
}
