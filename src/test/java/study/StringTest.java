package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
    void name() {
        //given
        String string = "(1,2)";
        //when
        String result = string.substring(1, 4);
        //then
        assertThat(result).isEqualTo("1,2");
    }
}