package Controller;

import View.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringCalculator {
    private List<Integer> numbers = new ArrayList<>();
    private List<Operator> operators = new ArrayList<>();
    private double result;

    public void run() {
        initializeInputs();
        OutputView.printOutputMessage(calculate());
    }

    /**
     * 입력값 예외처리 후 숫자와 연산자를 분리
     */
    public void initializeInputs() {
        String[] inputs = InputException.checkException();
        for (String val : inputs) {
            try {
                numbers.add(Integer.parseInt(val));
            } catch (Exception e) {
                operators.add(OperatorMap.getOperatorByString(val));
            }
        }
    }

    public double calculate() {
        result = numbers.remove(0);
        for (int i = 0; i < operators.size(); i++) {
            result = operators.get(i).compute(result, numbers.get(i));
        }
        return result;
    }
}
