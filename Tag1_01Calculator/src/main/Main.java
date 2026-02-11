package main;

import client.Client;
import common.LoggerProxy;
import math.CalcuatorSecure;
import math.Calculator;
import math.CalculatorImpl;
import math.CalculatorLogger;

import java.time.Duration;
import java.time.Instant;

public class Main {

    public static void main(String[] args) {

        var start = Instant.now();
        //
        var end = Instant.now();
        var duration = Duration.between(start, end);
        System.out.println(duration.toMillis());


        Calculator calc = new CalculatorImpl();

        //calc = new CalculatorLogger(calc);
        calc = (Calculator) LoggerProxy.newInstance(calc);

        calc = new CalcuatorSecure(calc);

        Client client = new Client(calc);
        client.go();
    }
}
