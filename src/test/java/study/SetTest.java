package study;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

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

    // Test Case 구현
    @Test
    void size(){
        int size = numbers.size();
        Assertions.assertThat(size).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {6,2,3})
    void contains(int number) {
        Assertions.assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @CsvSource({"9,false", "2,false", "3,true"})
    void contains2(int input, boolean expected) {
        boolean result = numbers.contains(input);
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
