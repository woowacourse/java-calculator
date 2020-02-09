package domain;

import java.util.Arrays;
import java.util.List;

public class Formulas {
    private final List<String> formulas;
    private static final String BLANK = " ";

    public Formulas(String formula) {
        formula = formula.trim()
                .replaceAll("  *", BLANK);
        this.formulas = Arrays.asList(formula.split(BLANK));
    }

    public int size() {
        return formulas.size();
    }

    public String get(int index) {
        return formulas.get(index);
    }
}
