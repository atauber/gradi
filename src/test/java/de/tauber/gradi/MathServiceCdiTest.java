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
 * environment
 * 
 * @author atauber
 * 
 */
@RunWith(CdiTestRunner.class)
public class MathServiceCdiTest {

	private static Logger logger = LoggerFactory.getLogger(MathServiceMockitoTest.class);
	
	@BeforeClass
	public static void init(){
		logger.debug("Setting up MathServiceCdiTest");
	}
	
	@Inject
	private MathService math;

	@Test
	public void testAdding() {
		int result = math.adding(4, 4);
		assertThat(result).isEqualTo(8);
	}

	@Test
	public void testSubstracting() {
		int result = math.substracting(4, 4);
		assertThat(result).isEqualTo(0);
	}

}
