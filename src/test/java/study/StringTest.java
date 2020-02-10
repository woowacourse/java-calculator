package study;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    @DisplayName("특정한 토큰을 통해 문자열 나누기")
    void splitStringTest() {
        String value = "1,2";
        String[] result = value.split(",");
        Assertions.assertThat(result).contains("1");
        Assertions.assertThat(result).contains("2");
    }

    @Test
    @DisplayName("문자열에 없는 토큰으로 문자열 나누기")
    void splitStringErrorTest() {
        String value = "1";
        String[] result = value.split(",");
        Assertions.assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("subString 메서드 테스트")
    void subStringTest() {
        String value = "(1,2)";
        value = value.substring(1, value.length() - 1);
        Assertions.assertThat(value).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 위치 문자 가져오기")
    void findChar() {
        String value = "abc";
        char c = value.charAt(1);
        Assertions.assertThat(c).isEqualTo('b');
    }

    @Test
    @DisplayName("익셉션 확인")
    void checkException() {
        Assertions.assertThatThrownBy(() -> {
            String value = "abc";
            char c = value.charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class)
        .hasMessageContaining("index out of range: 4");
    }
}
