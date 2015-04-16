package de.tauber.gradi;

/**
 * A Substract Service to inject in Math Service.
 *
 * @author atauber
 */
public class SubstractService {

    /**
     * Adds two numbers.
     *
     * @param operand1 first number
     * @param operand2 second number
     * @return sum of the two numbers
     */
    @Traced
    public int substract(final int operand1, final int operand2) {
        return operand1 - operand2;
    }
}
