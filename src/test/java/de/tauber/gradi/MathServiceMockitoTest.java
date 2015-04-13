package de.tauber.gradi;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Unit Test for MathService using Mockito mocks to configure and verify
 * dependent objects
 * 
 * @author atauber
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class MathServiceMockitoTest {

	private static Logger logger = LoggerFactory.getLogger(MathServiceMockitoTest.class);
	
    @Mock AddService add;
            
    @Mock SubstractService substract;
    
    @InjectMocks MathService math;
    
    @BeforeClass
    public static void setup(){
    	logger.info("Setting up MathServiceMockitoTest");
    }
    
    @Test
    public void testAdding(){
    	//Setup
    	when(add.add(anyInt(), anyInt())).thenReturn(4711);
    	//Execute
    	int result = math.adding(2, 2);
    	//Verify
    	assertThat(result).isEqualTo(4711);
        verify(add).add(2, 2);
    }
    
    @Test
    public void testSubstract(){
    	//Setup
    	when(substract.substract(anyInt(), anyInt())).thenReturn(4711);
    	//Execute
    	int result = substract.substract(2, 2);
    	//Verify
    	assertThat(result).isEqualTo(4711);
    	verify(substract).substract(2,2);
    }
    
    @Test
    public void testCalculate(){
    	//Setup
    	when(add.add(anyInt(), anyInt())).thenReturn(4711);
    	when(substract.substract(anyInt(), anyInt())).thenReturn(4711);
    	//4711 + 4711 = 9422
        //Execute
    	int result = math.calculate(2, 2);
        assertThat(result).isEqualTo(9422);
        //Verify
        verify(add).add(2, 2);
        verify(substract).substract(2, 2);
    }
       
}
