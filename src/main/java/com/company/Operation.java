package com.company;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public enum Operation {

    ADD(1, "+", "add", "plus", "ADD", "PLUS") {
        @Override
        public double calculate(double X, double Y) {
            return X + Y;
        }
    },

    SUBTRACT(2, "-", "subtract", "minus", "less", "SUBTRACT", "MINUS", "LESS") {
        @Override
        public double calculate(double X, double Y) {
            return X - Y;
        }
    },

    MULTIPLY(3, "*", "multiplied-by", "times", "MULTIPLIED-BY", "TIMES") {
        @Override
        public double calculate(double X, double Y) {
            return X * Y;
        }
    },

    DIVIDE(4, "/", "divided-by", "over", "DIVIDED-BY", "OVER") {
        @Override
        public double calculate(double X, double Y) {
            return X / Y;
        }
    };


    private final int priority;
    private final String arithmeticOperator;
    private final Set<String> names;
    private static final Map<String, Operation> nameToOperation = new HashMap<>();

    static {
        for (Operation operation : Operation.values()) {
            for (String name : operation.names) {
                nameToOperation.put(name, operation);
            }
        }
    }


    public abstract double calculate(double X, double Y);

    Operation(int priority, String arithmeticOperator, String... names) {

        this.priority = priority;
        this.arithmeticOperator = arithmeticOperator;
        this.names = new HashSet<>();
        this.names.add(arithmeticOperator);
        Collections.addAll(this.names, names);
    }

    public static Operation fromName(String operationName) {

        if (!nameToOperation.containsKey(operationName)) {
            throw new IllegalArgumentException("Unsupported Operation" + operationName);
        } else {
            return nameToOperation.get(operationName);
        }

    }

    public static boolean isOperation(String token) {
        return nameToOperation.containsKey(token);
    }

    public boolean isLowerPriority(Operation other) {
        return this.priority < other.priority;
    }

    @Override
    public String toString() {
        return arithmeticOperator;
    }

}