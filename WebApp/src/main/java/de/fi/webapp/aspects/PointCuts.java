package de.fi.webapp.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class PointCuts {

    @Pointcut(value = "execution(public * de.fi.webapp.presentation.controller.PersonenController.*(..))")
    public void personenControllerMethods(){}

    @Pointcut(value = "@within(de.fi.webapp.aspects.Dozent)")
    public void dozentMethods(){}

    // Alle ServiceImpl dekorieren mit loggeraspect
}
