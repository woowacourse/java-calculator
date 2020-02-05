package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringTest {
    @DisplayName("spilt()에 대한 test")
    @Test
    void One() {
        //given
        String string = "1,2";
        //when
        String[] result = string.split(",");
        //then
        assertThat(result).contains("1", "2");
    }

    @DisplayName("substring() test")
    @Test
    void Two() {
        //given
        String string = "(1,2)";
        //when
        String result = string.substring(1, 4);
        //then
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("charAt()에 대한 범위 밖의 인자값 입력시 Exception test")
    @Test
    void Three() {
        //given
        String string = "abc";
        //when

        assertThatThrownBy(() -> {
            string.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
        //then
    }
}