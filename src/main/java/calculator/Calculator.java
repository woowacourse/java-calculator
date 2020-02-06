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

    public Calculator(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        try {
            RawEquationDTO rawEquationDTO = inputEquation();
            OutputView.showResult(calculate(rawEquationDTO));
        } catch (RuntimeException e) {
            OutputView.showExceptionMessage(e);
            run();
        }
    }

    private RawEquationDTO inputEquation() {
        return inputView.inputEquation();
    }

    private double calculate(RawEquationDTO rawEquationDTO) {
        List<String> spiltEquation = RawEquationSplitter.split(rawEquationDTO.getRawEquation());
        Equation equation = EquationFactory.parseEquation(spiltEquation);
        return equation.getResult();
    }
}
