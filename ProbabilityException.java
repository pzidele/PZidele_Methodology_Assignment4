package assignment4;

public class ProbabilityException extends RuntimeException {
	public ProbabilityException() {
		super("Probability must be between 0 and 1");
	}
}
