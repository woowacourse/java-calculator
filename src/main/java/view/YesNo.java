package view;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum YesNo {
    YES(true, Arrays.asList("y", "Y", "yes", "Yes", "YES")),
    NO(false, Arrays.asList("n", "N", "no", "No", "NO")),
    EMPTY(false, Collections.EMPTY_LIST);

    public boolean trueOrFalse;
    private List<String> sameMeanings;

    YesNo(boolean trueOrFalse, List<String> sameMeanings) {
        this.trueOrFalse = trueOrFalse;
        this.sameMeanings = sameMeanings;
    }

    public static YesNo findByString(String string) {
        return Arrays.stream(YesNo.values())
                .filter(yesNo -> yesNo.sameMeanings.stream().anyMatch(sameMeaning -> sameMeaning.equals(string)))
                .findAny()
                .orElse(EMPTY);
    }
}
