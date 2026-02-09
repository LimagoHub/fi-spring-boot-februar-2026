package de.fi.webapp;


import de.fi.webapp.persistence.entity.PersonEntity;
import de.fi.webapp.persistence.entity.PersonenRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Demo {

    @Autowired
    private PersonenRepository personenRepository;

    public Demo() {
    }

    @PostConstruct
    public void init() {


        personenRepository.findAllTinies().forEach(System.out::println);
    }
}
