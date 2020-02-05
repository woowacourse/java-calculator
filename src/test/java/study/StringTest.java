package study;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    void splitWithDelimiter(){
        String value = "1,2";
        String[] result = value.split(",");

        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void splitWithoutDelimiter() {
        String value = "1";
        String[] result = value.split(",");

        assertThat(result).containsExactly(value);
    }
}
