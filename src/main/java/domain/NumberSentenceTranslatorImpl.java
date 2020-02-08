package domain;

import java.util.List;
import java.util.Queue;

public class NumberSentenceTranslatorImpl implements NumberSentenceTranslator {
    @Override
    public NumberSentence traslate(List<Integer> numbers, Queue<String> operators) {
        return new NumberSentence(numbers, operators);
    }
}
