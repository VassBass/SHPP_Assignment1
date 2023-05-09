package com.shpp.p2p.cs.ivasyliev.assignment2;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Quadratic {
    private double argA;
    private double argB;
    private double argC;

    public Quadratic(double argA, double argB, double argC) {
        this.argA = argA;
        this.argB = argB;
        this.argC = argC;
    }

    public double getArgA() {
        return argA;
    }

    public void setArgA(double argA) {
        this.argA = argA;
    }

    public double getArgB() {
        return argB;
    }

    public void setArgB(double argB) {
        this.argB = argB;
    }

    public double getArgC() {
        return argC;
    }

    public void setArgC(double argC) {
        this.argC = argC;
    }

    public List<Double> getRoots() {
        double d = Math.pow(argB, 2) - 4 * argA * argC;
        if (d > 0) {
            double x1 = (-argB + Math.sqrt(d)) / (2 * argA);
            double x2 = (-argB - Math.sqrt(d)) / (2 * argA);
            return List.of(x1, x2);
        } else if (d == 0) {
            double x = (-argB) / (2 * argA);
            return Collections.singletonList(x);
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quadratic quadratic = (Quadratic) o;
        return Double.compare(quadratic.argA, argA) == 0
                && Double.compare(quadratic.argB, argB) == 0
                && Double.compare(quadratic.argC, argC) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(argA, argB, argC);
    }

    @Override
    public String toString() {
        return String.format("(%s * (x^2)) + (%s * x) + %s = 0", argA, argB, argC);
    }
}
