package de.tauber.gradi.bval;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.tauber.gradi.categories.IntegrationTests;

/**
 * Unit Test using BeanValidation to test a person object.
 *
 * @author atauber
 *
 */
@Category(IntegrationTests.class)
@RunWith(CdiTestRunner.class)
public class PersonBeanValidationTest {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(PersonBeanValidationTest.class);

    /**
     * Injects the math service.
     */
    @Inject
    private Validator validator;
    
    /**
     * Setup test.
     */
    @BeforeClass
    public static void init() {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Setting up PersonBeanValidationTest");
        }
    }

    /**
     * A simple test for a person.
     */
    @Test
    public void testPersonSimple() {
        final Person andi = new Person("Andreas", "Tauber", 100);

        final Set<ConstraintViolation<Person>> violations = validator.validate(andi);
        assertThat(violations.size()).isEqualTo(1);
        for (final ConstraintViolation<Person> violation : violations) {
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("Constraint Violation Message: " + violation.getMessage());
            }
        }
    }

}
