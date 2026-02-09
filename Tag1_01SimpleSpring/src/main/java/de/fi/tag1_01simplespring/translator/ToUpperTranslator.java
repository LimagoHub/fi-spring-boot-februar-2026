package de.fi.tag1_01simplespring.translator;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
//@Qualifier("upper")
@Profile("dev")
public class ToUpperTranslator implements Translator{
    @Override
    public String translate(final String text) {
        return text.toUpperCase()   ;
    }
}
