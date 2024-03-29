package de.tauber.gradi;

import jakarta.enterprise.inject.Produces;
import jakarta.enterprise.inject.spi.InjectionPoint;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A class with CDI producer methods to provide resources for our services.
 *
 * @author atauber
 *
 */
public class Resources {

    /**
     * Creates Loggers for dependency injection.
     *
     * @param injectionPoint point logger is injected
     * @return logger object
     */
    @Produces
    public final Logger produceLogger(final InjectionPoint injectionPoint) {
        return LoggerFactory.getLogger(
                injectionPoint.getMember().getDeclaringClass().getName());
    }

    /**
     * Creates standard BeanValidation Validator.
     *
     * @return validator object
     */
    @SuppressWarnings("PMD")
    @Produces
    public Validator produceValidator() {
        final ValidatorFactory validatorFactory = Validation.byDefaultProvider().configure().buildValidatorFactory();
        return validatorFactory.getValidator();
    }
}
