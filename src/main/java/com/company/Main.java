package com.company;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Please enter a calculation:");
        try (Scanner scanner = new Scanner(System.in)) {
            double result = Calculator.calculate(scanner.nextLine());
            System.out.format("Result: %s", new DecimalFormat("0.##").format(result));
        }

    }
}
