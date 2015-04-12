package de.tauber.gradi;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {

    @Mock AddService add;
            
    @Spy SubstractService substract;
    
    @InjectMocks MathService math;
    
    @Test
    public void test(){
        when(add.add(anyInt(),anyInt())).thenReturn(9);
        
        int calculate = math.calculate(4, 4);
        //8 + 0
        assertThat(calculate).isEqualTo(9);
        
        verify(add).add(4, 4);
        verify(substract).substract(4, 4);
    }
}
