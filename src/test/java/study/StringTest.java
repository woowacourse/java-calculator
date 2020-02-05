package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

//Class명을 제거하기 위해 static import를 한다.
import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    @DisplayName("split Test")
    void split() {
        // 요구사항 1
//         String value = "1,2";
//         String[] result = value.split(",");
//         assertThat(result).contains("1");
//         assertThat(result).contains("2");
//         String value = "1";
//         String[] result = value.split(",");
//         assertThat(result).containsExactly("1");
    }
    @Test
    @DisplayName("substring Test")
    void substring() {
        // 요구사항 2
//         String value = "(1,2)";
//         String result = value.substring(1, value.length() - 1);
//         System.out.println(result);
    }
    @Test
    @DisplayName("IOB Exception Test")
    void errorThrow() {
        // 요구사항 3
//        assertThatThrownBy(() -> {
//                String val = "ab";
//                val.charAt(2);
//        }).isInstanceOf(IndexOutOfBoundsException.class).hasMessageContaining("2");
    }
}