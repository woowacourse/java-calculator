package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    @DisplayName("split 메소드가 잘 작동하는지 알아보는 학습 테스트")
    void split() {
        String[] result = "1,2".split(",");
        Assertions.assertThat(result).contains("2");
        Assertions.assertThat(result).containsExactly("1", "2");
        assertThat(result).contains("2","1");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    @DisplayName("delimiter가 없는 상태에서 split 메소드 잘 작동하는지 알아보는 학습 테스트")
    void splitArray() {
        String[] splitArr = "1".split(",");
        Assertions.assertThat(splitArr).contains("1");
        Assertions.assertThat(splitArr).containsExactly("1");
        assertThat(splitArr).contains("1");
        assertThat(splitArr).containsExactly("1");
    }

    @Test
    @DisplayName("substring 메소드가 잘 작동하는지 확인하는 테스트")
    void subString() {
        String value = "(1,2)";
        String substring = value.substring(1, value.length()-1);
        assertThat(substring).contains("1");
    }

    @Test
    @DisplayName("charAt 메소드가 잘 작동하는지 확인하는 테스트")
    void charAt() {
        char c = "abc".charAt(2);
        assertThat(c).isEqualTo('c');
    }

    @Test
    @DisplayName("charAt 메소드에서 범위를 넘어선 값이 입력됐을때 발생하는 Exception을 확인하는 학습테스트")
    void charAtException() {

        Assertions.assertThatThrownBy(() -> {
            "abc".charAt(5);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 5");
    }
}
