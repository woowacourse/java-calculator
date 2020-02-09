package view;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum YesNo {
    YES(Arrays.asList("y", "Y", "yes", "Yes", "YES")),
    NO(Arrays.asList("n", "N", "no", "No", "NO")),
    EMPTY(Collections.EMPTY_LIST);

    private List<String> sameMeanings;

    YesNo(List<String> sameMeanings) {
        this.sameMeanings = sameMeanings;
    }

    public static YesNo findByString(String string) {
        return Arrays.stream(YesNo.values())
                .filter(yesNo -> yesNo.sameMeanings.stream().anyMatch(sameMeaning -> sameMeaning.equals(string)))
                .findAny()
                .orElse(EMPTY);
    }

    public boolean toBoolean() {
        if (this == YES) {
            return true;
        }
        return false;
    }
}
