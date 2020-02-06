package Controller;

import View.InputView;
import View.OutputView;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    private List<Integer> numbers = new ArrayList<>();
    private List<Operator> operators = new ArrayList<>();
    private double result;

    public void run() {
        initializeInputs();
        OutputView.printOutputMessage(calculate());
    }

    public void initializeInputs() {
        String[] inputs = InputException.checkException();
        for (int i = 0; i < inputs.length; i++) {
            try {
                numbers.add(Integer.parseInt(inputs[i]));
            } catch (Exception e){
                operators.add(Operator.getEnumFromString(inputs[i]));
            }
        }
    }

    public double calculate() {
        result = numbers.remove(0);
        for (int i = 0; i < operators.size(); i++){
            result = operators.get(i).compute(result, numbers.get(i));
        }
        return result;
    }
}
