package de.tauber.gradi;

public class SubstractService {

    @Traced
    public int substract(int a, int b) {
        return a - b;
    }
}
