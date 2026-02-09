package de.fi.tag1_01simplespring.demo;

import de.fi.tag1_01simplespring.translator.Translator;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_SINGLETON) // Default
//@Scope(BeanDefinition.SCOPE_PROTOTYPE)


public class Demo {



    private final String text;
    private final Translator translator;



    public Demo(final Translator translator, @Value("${Demo.text}") String text) {
        this.text = text;
        this.translator = translator;
        System.out.println(text);
        System.out.println("Contructor von Demo");
    }

    @PostConstruct
    public void foo() {
        System.out.println(text);
        System.out.println(translator.translate("Foo"));
    }
    @PreDestroy  // ACHTUNG feuert nur bei Singleton
    public void bar() {
        System.out.println("Autsch");
    }
}
