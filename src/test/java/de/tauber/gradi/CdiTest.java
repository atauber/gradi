package de.tauber.gradi;

import javax.inject.Inject;
import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(CdiTestRunner.class)
public class CdiTest {

    @Inject
    private MathService math;
    
    @Test
    public void testInject() {
        int add = math.adding(3, 5);
        assertThat(add).isEqualTo(8);
    }
      
}

