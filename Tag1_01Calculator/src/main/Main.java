package main;

import client.Client;
import common.LoggerProxy;
import math.CalcuatorSecure;
import math.Calculator;
import math.CalculatorImpl;
import math.CalculatorLogger;

public class Main {

    public static void main(String[] args) {
        Calculator calc = new CalculatorImpl();

        //calc = new CalculatorLogger(calc);
        calc = (Calculator) LoggerProxy.newInstance(calc);

        calc = new CalcuatorSecure(calc);

        Client client = new Client(calc);
        client.go();
    }
}
