package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

//Class명을 제거하기 위해 static import를 한다.
import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @DisplayName("범위 테스트")
    @Test
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
    void substring() {
        // 요구사항 2
//         String value = "(1,2)";
//         String result = value.substring(1, value.length() - 1);
//         System.out.println(result);
    }
    void errorThrow() {
        // 요구사항 3
//        assertThatThrownBy(() -> {
//                String val = "ab";
//                val.charAt(2);
//        }).isInstanceOf(IndexOutOfBoundsException.class).hasMessageContaining("2");
    }

}