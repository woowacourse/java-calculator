package calculator;

import calculator.domain.Equation;
import calculator.filter.EquationFilter;
import calculator.spliter.StringSplitter;
import calculator.view.InputView;
import calculator.view.OutputView;
import calculator.view.dto.RawEquationDTO;

import java.util.List;

public class Calculator {
    private final InputView inputView;
    private RawEquationDTO equation;

    public Calculator(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        init();
        OutputView.showResult(operate());
    }

    private void init() {
        try {
            this.equation = inputView.inputEquation();
        } catch (IllegalArgumentException e) {
            OutputView.showErrorMessage(e);
            init();
        }
    }

    private double operate() {
        List<String> spilttedEquation = StringSplitter.split(equation.getRawEquation());
        Equation equation = EquationFilter.parseEquation(spilttedEquation);
        return equation.getResult();
    }
}
