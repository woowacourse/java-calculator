package study;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;

public class SetTest {

    private Set numbers;

    @BeforeEach
    void setUp(){
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("1. set size test")
    void size(){
        int size = numbers.size();
        assertThat(size).isEqualTo(3);
    }

    @DisplayName("2. set contain test")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void contain(Integer input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("3. set value match test")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false"}, delimiter = ':')
    void pairValue(int input, Boolean expected){
        Boolean result = numbers.contains(input) ? true : false;
        assertThat(result).isEqualTo(expected);
    }

}
