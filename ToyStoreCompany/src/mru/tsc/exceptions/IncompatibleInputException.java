package mru.tsc.exceptions;

public class IncompatibleInputException extends Exception {
	public IncompatibleInputException() {
		super("Invalid input! The input is incongruent with the requirements of the question.");
	}
	
	public IncompatibleInputException(String message) {
		super(message);
	}

}
