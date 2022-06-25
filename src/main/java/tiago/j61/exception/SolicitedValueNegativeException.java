package tiago.j61.exception;

public class SolicitedValueNegativeException extends Exception {
	public SolicitedValueNegativeException() {
		super("The request cannot be a negative value");
	}
}
