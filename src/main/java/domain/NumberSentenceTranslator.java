package domain;

import java.util.List;
import java.util.Queue;

public interface NumberSentenceTranslator {

    NumberSentence traslate(List<Integer> numbers, Queue<String> operators);
}
