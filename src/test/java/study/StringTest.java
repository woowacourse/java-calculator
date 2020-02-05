package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class StringTest {

    @Test
    void split() {
        String value = "1,2";
        String[] result = value.split(",");
        assertThat(result[0]).isEqualTo("1");   //actual 값과 expected 값이 같은지 확인
        assertThat(result[1]).isEqualTo("2");
    }
}
