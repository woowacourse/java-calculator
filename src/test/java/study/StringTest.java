package study;

import static org.assertj.core.api.Assertions.*;
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
    }

    @Test
    void substring() {
        String value = "(1,2)";
        String result = value.substring(1,4);
        Assertions.assertThat(result).contains("1,2");
    }
}
