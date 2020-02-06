package calculator;

import calculator.domain.Equation;
import calculator.domain.EquationFactory;
import calculator.spliter.RawEquationSplitter;
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
            init();
        }
    }

    private double operate() {
        List<String> spiltedEquation = RawEquationSplitter.split(equation.getRawEquation());
        Equation equation = EquationFactory.parseEquation(spiltedEquation);
        return equation.getResult();
    }
}
