package calculator;

import calculator.domain.Equation;
import calculator.filter.EquationFilter;
import calculator.spliter.StringSplitter;
import calculator.view.OutputView;
import calculator.view.dto.RawEquationDTO;

import java.util.List;

public class Calculator {
    private RawEquationDTO equation;

    public double run(RawEquationDTO inputEquation) {
        init(inputEquation);
        return operate();
    }

    private void init(RawEquationDTO inputEquation) {
        try {
            this.equation = inputEquation;
        } catch (IllegalArgumentException e) {
            OutputView.showErrorMessage(e);
        }
    }

    private double operate() {
        List<String> spilttedEquation = StringSplitter.split(equation.getRawEquation());
        Equation equation = EquationFilter.parseEquation(spilttedEquation);
        return equation.getResult();
    }
}
