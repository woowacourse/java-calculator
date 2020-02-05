package study;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

    @Test
    void size(){
        int size = numbers.size();
        assertThat(size).isEqualTo(3);
    }
}
