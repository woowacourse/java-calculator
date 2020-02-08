package domain;

import java.util.HashMap;
import java.util.Map;

public class Operators {
    private final Map<String, Operator> operatorMap = new HashMap<String, Operator>();

    Operators() {
        for (Operator operator : Operator.values()) {
            operatorMap.put(operator.getOperator(), operator);
        }
    }

    public Map<String, Operator> getOperatorMap() {
        return operatorMap;
    }
}
