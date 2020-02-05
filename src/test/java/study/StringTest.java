package study;

import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    void split() {
        String value = "1,2";
        String[] result = value.split(",");
        System.out.println(result[0] + ":" + result[1]);
    }

    @Test
    void splitArray() {
        String value = "1";
        String[] splitArr = value.split(",");
        System.out.println(splitArr[0]);
    }

    @Test
    void subString() {
        String value = "(1,2)";
        String substring = value.substring(1, value.length()-1);
        System.out.println(substring);
    }
}
