package de.tauber.gradi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 * Factory for Logger.
 */
@Dependent
public class LoggerProducer {

    /**
     * CDI Procucer for the Logger.
     *
     * @param injectionPoint the injection point
     *
     * @return Logger
     */
    @Produces
    public Logger produceLogger(final InjectionPoint injectionPoint) {
        return LoggerFactory.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
    }
}
