package de.fi.tag1_01simplespring.main;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Order(1000)
public class MyRunner implements CommandLineRunner {

    // Calculator Injecten und eine summe berechnen und in der Console ausgeben


    @Override
    public void run(final String... args) throws Exception {
        System.out.println( "Hello World");
    }
}
