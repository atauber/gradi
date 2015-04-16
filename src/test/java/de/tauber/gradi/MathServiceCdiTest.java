package de.tauber.gradi;

import static org.assertj.core.api.Assertions.assertThat;

import javax.inject.Inject;

import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Unit Test for MathService using Deltaspike TestRunner to execute in a CDI
 * environment.
 *
 * @author atauber
 *
 */
@RunWith(CdiTestRunner.class)
public class MathServiceCdiTest {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(MathServiceMockitoTest.class);

    /**
     * Setup test.
     */
    @BeforeClass
    public static void init() {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Setting up MathServiceCdiTest");
        }
    }

    /**
     * Injects the math service.
     */
    @Inject
    private MathService math;

    /**
     * Simple test for MathService adding method.
     */
    @Test
    public void testAdding() {
        final int result = math.adding(4, 4);
        assertThat(result).isEqualTo(8);
    }

    /**
     * Simple test for MathService substracting method.
     */
    @Test
    public void testSubstracting() {
        final int result = math.substracting(4, 4);
        assertThat(result).isEqualTo(0);
    }

}
