package de.tauber.gradi;

import jakarta.enterprise.context.Dependent;

/**
 * A Divide Service to inject in Math Service.
 *
 * @author atauber
 */
@Dependent
public class DivideService {

    /**
     * Divides two numbers.
     *
     * @param operand1 first number
     * @param operand2 second number
     * @return quotient of the two numbers
     */
    @Traced
    public int divide(final int operand1, final int operand2) {
        return operand1 / operand2;
    }

}
