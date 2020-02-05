package study;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;

public class SetTest {

    private Set numbers;

    @BeforeEach  // 각각의 테스트함수를 실행하기 직전에 매번 수행된다.
    void setUp(){
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    /**
     * 요구사항 1. set size 테스트
     */
    @Test
    void size(){
        int size = numbers.size();
        assertThat(size).isEqualTo(3);
    }

    /**
     * 요구사항 2. set contain 테스트
     * @param input
     */
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void contain(Integer input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    /**
     * 요구사항 3. set value match 테스트
     * @param input
     * @param expected
     */
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false"}, delimiter = ':')
    void pairValue(int input, Boolean expected){
        Boolean result = numbers.contains(input) ? true : false;
        assertThat(result).isEqualTo(expected);
    }

}
