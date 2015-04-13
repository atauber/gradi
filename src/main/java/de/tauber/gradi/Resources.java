package de.tauber.gradi;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * A class with CDI producer methods to provide resources for our services :-)
 * 
 * @author atauber
 *
 */
public class Resources {

    @Produces  
    public Logger produceLogger(InjectionPoint injectionPoint) {  
        return LoggerFactory.getLogger(injectionPoint.getMember().getDeclaringClass().getName());  
    }  
}
