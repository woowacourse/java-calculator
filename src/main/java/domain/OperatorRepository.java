package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OperatorRepository {
    private static List<Operator> operators = new ArrayList<>();

    public static void addOperator(Operator operator) {
        operators.add(operator);
    }

    public static List<Operator> getOperatorList() {
        return Collections.unmodifiableList(operators);
    }
}
