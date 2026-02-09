package client;

import math.Calculator;

public class Client {

    private final Calculator calc;

    public Client(final Calculator calc) {
        this.calc = calc;
    }

    public void go() {
        System.out.println(calc.add(1, 2));
    }
}
