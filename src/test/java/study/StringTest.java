package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringTest {
    @Test
    @DisplayName("#split() : return String Array using standard")
    void split() {
        //given
        String component = "1";
        String standard = ",";
        String valueWithStandard = component + standard + "2";

        //when
        String[] result = valueWithStandard.split(standard);

        //then
        assertThat(result).contains(component);
    }

    @Test
    @DisplayName("#charAt() : return char when indexing within bound")
    void subString() {
        //given
        String startingWrapper = "(";
        String endingWrapper = ")";
        String value = "1,2";
        String valueWithWrapper =  startingWrapper + value +endingWrapper;

        //when
        String result = valueWithWrapper.substring(startingWrapper.length(), valueWithWrapper.length() - endingWrapper.length());

        //then
        assertThat(result).isEqualTo(value);
    }

    @Test
    @DisplayName("#charAt() : return char when indexing within bound")
    void charAtIndexInBound() {
        //given
        char target = 'b';
        String value = "a" + target + "c";

        //when
        char result = value.charAt(value.indexOf(target));

        //then
        assertThat(result).isEqualTo(target);
    }

    @Test
    @DisplayName("#charAt() : throw IndexOutOfBoundsException when indexing out of bound")
    void charAtIndexOutOfBound() {
        String value = "abc";

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    value.charAt(value.length());
                }
            ).withMessage("String index out of range: " + value.length());
    }
}
