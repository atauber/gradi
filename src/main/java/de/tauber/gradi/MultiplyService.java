package de.tauber.gradi;

import jakarta.enterprise.context.Dependent;

/**
 * A Multiply Service to inject in Math Service.
 *
 * @author atauber
 */
@Dependent
public class MultiplyService {

    /**
     * Multiplies two numbers.
     *
     * @param operand1 first number
     * @param operand2 second number
     * @return product of the two numbers
     */
    @Traced
    public int multiply(final int operand1, final int operand2) {
        return operand1 * operand2;
    }

}
