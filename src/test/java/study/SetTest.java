package study;

import java.util.HashSet;
import java.util.Set;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {
    private Set numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    void setSizeTest() {
        int setSize = numbers.size();
        System.out.println("Set(변수명 numbers)의 크기 : "+setSize);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    void contains(String input) {
        Assertions.assertThat(numbers.contains(Integer.parseInt(input))).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value= {"1:true", "2:true", "4:false"}, delimiter = ':')
    void contains(String input, String expected) {
        boolean actual = numbers.contains(Integer.parseInt(input));
        Assertions.assertThat(String.valueOf(actual)).isEqualTo(expected);
    }
}
