package ViewTest;

import Model.Operator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {

    @Test
    void InputViewTest(){
        String Test1="\n";
        String[] result = {"3","+","4"};
        assertThat(Test1.replaceAll(" ","").split("")).isEqualTo(result);
    }
}
