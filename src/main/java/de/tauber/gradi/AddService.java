package de.tauber.gradi;

import jakarta.enterprise.context.Dependent;

/**
 * A Add Service to inject in Math Service.
 *
 * @author atauber
 */
@Dependent
public class AddService {

    /**
     * Adds two numbers.
     *
     * @param operand1 first number
     * @param operand2 second number
     * @return sum of the two numbers
     */
    @Traced
    public int add(final int operand1, final int operand2) {
        return operand1 + operand2;
    }

}
