package de.fi.webapp.presentation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping(value = "/hello", produces = "text/plain")
    public String sayHello() {
        return "Hello World!";
    }
}
