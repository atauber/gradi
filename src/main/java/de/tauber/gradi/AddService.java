package de.tauber.gradi;

public class AddService {

    @Traced
    public int add(int a, int b) {
        return a + b;
    }

}
