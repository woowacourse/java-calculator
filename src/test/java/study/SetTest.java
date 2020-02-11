package study;

import org.junit.jupiter.api.BeforeEach;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
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

    @Test
    @DisplayName("Set Size Test")
    void size() {
        // 요구사항 1
        int inputNum = 3;
        assertThat(numbers.size()).isEqualTo(inputNum);
        System.out.println("numbers' size is " + inputNum);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("Set Contain Test")
    void contains(int num) {
        // 요구사항 2
        assertThat(numbers.contains(num)).isTrue();
        System.out.println(num + " is in ValueSource");
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:2", "3:3", "4:5"}, delimiter = ':')
    @DisplayName("Set Csv Source Test")
    void csv(int num, int expectedNum){
        // 요구사항 3
        assertThat(num).isEqualTo(expectedNum);
        System.out.println(num + " is equal to expected result.");
    }
}
