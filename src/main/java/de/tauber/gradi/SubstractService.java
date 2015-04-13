package de.tauber.gradi;

/**
 * A Substract Service to inject in Math Service
 * 
 * @author atauber
 *
 */
public class SubstractService {

	@Traced
	public int substract(int a, int b) {
		return a - b;
	}
}
