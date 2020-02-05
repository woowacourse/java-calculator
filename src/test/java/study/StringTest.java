package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void split() {
        String value = "1,2";
        String[] result = value.split(",");
        assertThat(result).contains("1");
        assertThat(result).contains("2");
    }

    @Test
    void split2() {
        String value2 = "1";
        String[] result2 = value2.split(",");
        assertThat(result2).contains("1");
        assertThat(result2).containsExactly("1");
    }

}
