package de.tauber.gradi;

import de.tauber.gradi.categories.UnitTests;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Unit Test for MathService using Mockito mocks to configure and verify
 * dependent objects.
 *
 * @author atauber
 *
 */
@Category(UnitTests.class)
@RunWith(MockitoJUnitRunner.class)
public class MathServiceMockitoTest {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(MathServiceMockitoTest.class);

    /**
     * Mock for AddService.
     */
    @Mock
    private AddService add;

    /**
     * Mock for SubstractService.
     */
    @Mock
    private SubstractService substract;

    /**
     * Inject the Mocks into MathService.
     */
    @InjectMocks
    private MathService math;

    /**
     * 4711.
     */
    private static final int CONST4711 = 4711;


    /**
     * Setting up the test.
     */
    @BeforeClass
    public static void init() {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Setting up MathServiceMockitoTest");
        }
    }

    /**
     * We use the mock for AddService.
     */
    @Test
    public void testAdding() {
        //Setup
        when(add.add(anyInt(), anyInt())).thenReturn(CONST4711);
        //Execute
        final int result = math.adding(2, 2);
        //Verify
        assertThat(result).isEqualTo(CONST4711);
        verify(add).add(2, 2);
    }

    /**
     * We use the mock for SubstractService.
     */
    @Test
    public void testSubstract() {
        //Setup
        when(substract.substract(anyInt(), anyInt())).thenReturn(CONST4711);
        //Execute
        final int result = substract.substract(2, 2);
        //Verify
        assertThat(result).isEqualTo(CONST4711);
        verify(substract).substract(2, 2);
    }

    /**
     * We use the the MathService which uses references to mocked objects.
     */
    @Test
    public void testCalculate() {
        //Setup
        when(add.add(anyInt(), anyInt())).thenReturn(CONST4711);
        when(substract.substract(anyInt(), anyInt())).thenReturn(CONST4711);
        //4711 + 4711 = 9422
        //Execute
        final int result = math.calculate(2, 2);
        assertThat(result).isEqualTo(9422);
        //Verify
        verify(add).add(2, 2);
        verify(substract).substract(2, 2);
    }

}
