package domain;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private final List<String> values;

    public Numbers(List<String> inputs) {
        values = new ArrayList<>();
        add(inputs);
    }

    private void add(String number) {
        values.add(number);
    }

    public void add(List<String> numbers) {
        numbers.stream()
                .forEach(s -> add(s));
    }

    public String get(int index) {
        return values.get(index);
    }
}
