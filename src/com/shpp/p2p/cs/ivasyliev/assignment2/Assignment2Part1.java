package com.shpp.p2p.cs.ivasyliev.assignment2;

import java.util.List;
import java.util.Scanner;

public class Assignment2Part1 {

    public static void main(String[] args) {
        Assignment2Part1 assignment2Part1 = new Assignment2Part1();
        Scanner scanner = new Scanner(System.in);

        double a = assignment2Part1.getArg("a", scanner);
        double b = assignment2Part1.getArg("b", scanner);
        double c = assignment2Part1.getArg("c", scanner);

        Quadratic quadratic = new Quadratic(a, b, c);
        List<Double> roots = quadratic.getRoots();
        assignment2Part1.printRoots(roots);
    }

    private double getArg(String argTitle, Scanner scanner) {
        while (true) {
            System.out.printf("Please enter %s: ", argTitle);
            double input = Converter.toDouble(scanner.nextLine());
            if (Double.isNaN(input)) {
                System.out.println("Invalid input!");
            } else {
                return input;
            }
        }
    }

    private void printRoots(List<Double> roots) {
        if (roots.isEmpty()) {
            System.out.println("There are no real roots");
        } else {
            StringBuilder builder = new StringBuilder("Roots: ");
            for (Double r : roots) {
                builder.append(r).append(", ");
            }
            builder.delete(builder.length() - 2, builder.length() - 1);
            System.out.println(builder);
        }
    }
}
