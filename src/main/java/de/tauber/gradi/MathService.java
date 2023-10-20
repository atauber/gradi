package de.tauber.gradi;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;

/**
 * A Math Service that delegates to injected Services.
 *
 * @author atauber
 */
@Dependent
public class MathService {

    /**
     * Reference to AddService.
     */
    @Inject
    private AddService add;

    /**
     * Reference to SubstractService.
     */
    @Inject
    private SubstractService substract;

    /**
     * Adds two numbers.
     *
     * @param operand1 first number
     * @param operand2 second number
     * @return sum of the two numbers
     */
    public final int adding(final int operand1, final int operand2) {
        return add.add(operand1, operand2);
    }

    /**
     * Substracts two numbers.
     *
     * @param operand1 first number
     * @param operand2 second number
     * @return difference of the two numbers
     */
    public final int substracting(final int operand1, final int operand2) {
        return substract.substract(operand1, operand2);
    }

    /**
     * Calculates with adding and substracting.
     *
     * @param operand1 first number
     * @param operand2 second number
     * @return calculation result
     */
    public final int calculate(final int operand1, final int operand2) {
        final int step1 = add.add(operand1, operand2);
        final int step2 = substract.substract(operand1, operand2);
        return step1 + step2;
    }
}
