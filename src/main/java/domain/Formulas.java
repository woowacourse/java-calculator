package domain;

import java.util.List;

public class Formulas {
    private final List<String> formulas;

    public Formulas(Formula formula) {
        this.formulas = formula.toList();
    }

    public int size() {
        return formulas.size();
    }

    public String getOperation(int index) {
        return formulas.get(index);
    }

    public double getNumToDouble(int index) {
        return Double.parseDouble(formulas.get(index));
    }
}
