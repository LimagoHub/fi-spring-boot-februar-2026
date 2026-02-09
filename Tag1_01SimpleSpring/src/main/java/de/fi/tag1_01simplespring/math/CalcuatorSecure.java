package de.fi.tag1_01simplespring.math;

public class CalcuatorSecure implements Calculator{

    private final Calculator calculator;

    public CalcuatorSecure(final Calculator calculator) {
        this.calculator = calculator;
    }

    public double add(final double a, final double b) {
        System.out.println("Du kommst hier rein");
        return calculator.add(a, b);
    }

    public double sub(final double a, final double b) {
        return calculator.sub(a, b);
    }
}
