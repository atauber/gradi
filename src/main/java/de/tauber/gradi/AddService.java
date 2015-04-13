package de.tauber.gradi;

/**
 * A Add Service to inject in Math Service
 * 
 * @author atauber
 *
 */
public class AddService {

    @Traced
    public int add(int a, int b) {
        return a + b;
    }

}
