package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("split메서드를 사용하면 delimiter를 기준으로 분리된 배열 반환 ")
    void splitWithDelimiter() {
        String value = "1,2";
        String[] result = value.split(",");

        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("delimiter를 포함하지 않는 문자열을 split하면 문자열 전체를 포함하는 배열 반환")
    void splitWithoutDelimiter() {
        String value = "1";
        String[] result = value.split(",");

        assertThat(result).containsExactly(value);
    }

    @Test
    @DisplayName("substring을 사용하면 지정한 범위의 String을 반환")
    void substring() {
        String expectedValue = "1,2";
        String prefix = "(";
        String suffix = ")";
        String combinedValue = prefix + expectedValue + suffix;
        String result = combinedValue.substring(prefix.length(), combinedValue.length() - suffix.length());

        assertThat(result).isEqualTo(expectedValue);
    }

    @Test
    @DisplayName("charAt 메서드를 사용하면 해당 index의 char 값을 반환")
    void charAt() {
        String value = "abc";

        assertThat(value.charAt(0)).isEqualTo('a');
        assertThat(value.charAt(1)).isEqualTo('b');
        assertThat(value.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("charAt 메서드에 범위 밖 인덱스를 넣으면 IndexOutOfBoundsException 발생")
    void charAtUsingIndexOutOfBounds() {
        String value = "abc";

        assertThatThrownBy(() -> value.charAt(value.length()))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("range: " + value.length());

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> value.charAt(value.length()))
                .withMessageContaining("range: " + value.length());
    }

    @Test
    public void 문자열_길이_구하기() throws Exception {
        String name = "박재성";
        assertThat(name.length()).isEqualTo(3);
    }

    @Test
    public void 문자열_더하기() throws Exception {
        String name = "박재성";
        String welcome = "안녕!";
        assertThat(welcome.concat(name)).isEqualTo("안녕!박재성");
    }

    @Test
    public void 문자열을_문자_단위로_출력() throws Exception {
        String name = "박재성";
        char[] expected = {'박', '재', '성'};
        assertThat(name.toCharArray()).isEqualTo(expected);
    }

    @Test
    public void 문자열_뒤집기() throws Exception {
        String name = "박재성";
        String reverseName = "";
        char[] charArr = name.toCharArray();

        for (int i = charArr.length - 1; i >= 0; i--) {
            reverseName += charArr[i];
        }
        assertThat(reverseName).isEqualTo("성재박");
    }
}
