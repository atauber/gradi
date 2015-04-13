package de.tauber.gradi;

import javax.inject.Inject;

/**
 * A Math Service that delegates to injected Services
 * 
 * @author atauber
 */
public class MathService {

    @Inject
    private AddService add;

    @Inject
    private SubstractService substract;

    public int adding(int a, int b) {
        return add.add(a, b);
    }

    public int substracting(int a, int b) {
        return substract.substract(a, b);
    }

    public int calculate(int a, int b){
        int c = add.add(a,b);
        int d = substract.substract(a, b);
        return c + d;
    }
}
