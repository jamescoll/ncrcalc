package com.company;

import java.util.*;

public enum Number {
    ZERO(0, "zero", "ZERO"), ONE(1, "one", "ONE"), TWO(2, "two", "TWO"), THREE(3, "three", "THREE"),
    FOUR(4, "four", "FOUR"), FIVE(5, "five", "FIVE"), SIX(6, "six", "SIX"), SEVEN(7, "seven", "SEVEN"),
    EIGHT(8, "eight", "EIGHT"), NINE(9, "nine", "NINE");


    private final int value;
    private final Set<String> names;
    private static final Map<String, Number> nameToNumber = new HashMap<>();

    static {
        for (Number number : Number.values()) {
            for (String name : number.names) {
                nameToNumber.put(name, number);
            }
        }
    }

    Number(int value, String... names) {
        this.value = value;
        this.names = new HashSet<>();
        Collections.addAll(this.names, names);

    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static Number fromName(String numberName) {
        if (!nameToNumber.containsKey(numberName)) {
            throw new IllegalArgumentException("Unrecognized Number" + numberName);
        } else {
            return nameToNumber.get(numberName);
        }
    }


    public static boolean isNumber(String token) {
        return nameToNumber.containsKey(token);
    }
}
