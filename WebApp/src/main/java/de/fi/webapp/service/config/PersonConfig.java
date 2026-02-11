package de.fi.webapp.service.config;


import de.fi.webapp.persistence.entity.PersonenRepository;
import de.fi.webapp.service.PersonService;
import de.fi.webapp.service.internal.PersonServiceImpl;
import de.fi.webapp.service.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.List;

@Configuration
public class PersonConfig {

    @Bean
    @Scope("singleton")
    @Lazy
    @Qualifier("antipathen")
    public List<String> createAntipathen() {
        return List.of("Attila", "Peter","Paul", "Mary");
    }

    @Bean
    @Qualifier("fruits")
    public List<String> getFruits() {
        return List.of("Banana", "Apple","Strawberry", "Cherry");
    }

    /*
    @Bean
    public PersonService createPersonService(final PersonenRepository repository, final PersonMapper mapper, @Qualifier("antipathen") final List<String> antipathen) {
        return new PersonServiceImpl(repository, mapper, antipathen);
    }

     */
}
