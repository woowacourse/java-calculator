/*
 * Copyright (c) 2019 by tiger,DDoring
 * All rights reserved.
 *
 * CalculatorMap.java
 * 사칙연산과 함수를 Mapping하는 클래스
 *
 * @author      tiger,DDoring
 * @version     1.0
 * @date        09 Feb 2020
 *
 */

package calculator;

import java.util.HashMap;

public class CalculatorMap {
    private static HashMap<String, Calculator> operator = new HashMap<>();

    {
        operator.put("+", new Plus());
        operator.put("-", new Minus());
        operator.put("*", new Multiply());
        operator.put("/", new Divide());
    }

    public Calculator getOperator(String op) {
        return operator.get(op);
    }
}
