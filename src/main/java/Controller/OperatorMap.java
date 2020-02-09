package Controller;

import java.util.HashMap;
import java.util.Map;

public class OperatorMap {
    private static Map<String, Operator> operatorMap = new HashMap<String, Operator>(){
        {
            put("+", Operator.PLUS);
            put("-", Operator.MINUS);
            put("*", Operator.MULTIPLY);
            put("/", Operator.DIVIDE);
        }
    };

    public static Operator getOperatorByString(String val){
        return operatorMap.get(val);
    }
}
