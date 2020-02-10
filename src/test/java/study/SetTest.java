package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
    void sizeTest() {
        int size = numbers.size();
        Assertions.assertThat(size).isEqualTo(4);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 1, 2, 3})
    void containTest(int number) {
        assertTrue(numbers.contains(number));
    }

    @ParameterizedTest
    @CsvSource(value = {"ravie-RAVIE", "Lavine-LAVINE", "orange-ORANKE", "dog-DoG"}, delimiter = '-')
    void equalUpperCase(String input, String upperCase){
        Assertions.assertThat(upperCase).isEqualTo(input.toUpperCase());
    }
}
