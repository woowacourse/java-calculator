package domain;

import view.InputView;

public class Controller {

    private final String formula;

    public Controller() {
        formula = InputView.inputFormula();
    }
}
