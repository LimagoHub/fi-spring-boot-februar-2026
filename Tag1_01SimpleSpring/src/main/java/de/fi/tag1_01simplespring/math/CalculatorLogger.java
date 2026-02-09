package de.fi.tag1_01simplespring.math;

public class CalculatorLogger implements Calculator{

    private final Calculator calcaulator;

    public CalculatorLogger(final Calculator calcaulator) {
        this.calcaulator = calcaulator;
    }

    public double add(final double a, final double b) {

        System.out.println( "Add wurde gerufen!");
        return calcaulator.add(a, b);
    }

    public double sub(final double a, final double b) {
        return calcaulator.sub(a, b);
    }
}
