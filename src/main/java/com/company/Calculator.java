package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Calculator {

    public static double calculate(String calculation) {
        List<String> infixRepresentation = translateToInfixRepresentation(calculation);
        List<String> postfixRepresentation = translateToPostfixRepresentation(infixRepresentation);
        return evaluate(postfixRepresentation);
    }

    private static List<String> translateToInfixRepresentation(String calculation) {

        List<String> inputList = Arrays.asList(calculation.split("\\s+"));
        List<String> translatedList = new ArrayList<>();

        for (String token : inputList) {
            if (Operation.isOperation(token)) {
                translatedList.add(Operation.fromName(token).toString());
            } else if (Number.isNumber(token)) {
                translatedList.add(Number.fromName(token).toString());
            } else {
                throw new IllegalArgumentException("Illegal token " + token);
            }
        }
        return translatedList;
    }

    private static List<String> translateToPostfixRepresentation(List<String> infixRepresentation) {

        ArrayList<String> output = new ArrayList<>();
        LinkedList<String> stack = new LinkedList<>();

        for (String token : infixRepresentation) {

            if (Operation.isOperation(token)) {
                Operation operator = Operation.fromName(token);
                while (!stack.isEmpty() && operator.isLowerPriority(Operation.fromName(stack.peek()))) {
                    output.add(stack.pop());
                }
                stack.push(token);
            } else {
                output.add(token);
            }
        }

        while (!stack.isEmpty()) {
            output.add(stack.pop());
        }

        return output;
    }

    private static double evaluate(List<String> postfixRepresentation) {

        LinkedList<String> stack = new LinkedList<>();

        for (String token : postfixRepresentation) {

            if (Operation.isOperation(token)) {
                Operation operator = Operation.fromName(token);
                double y = Double.parseDouble(stack.pop());
                double x = Double.parseDouble(stack.pop());
                double result = operator.calculate(x, y);
                stack.push(String.valueOf(result));
            } else {
                stack.push(token);
            }
        }
        return Double.parseDouble(stack.pop());
    }
}
