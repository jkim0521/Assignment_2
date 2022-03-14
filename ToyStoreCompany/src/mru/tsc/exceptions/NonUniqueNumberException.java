package mru.tsc.exceptions;

public class NonUniqueNumberException extends Exception{
	public NonUniqueNumberException() {
		super("A toy with this serial number already exists! Please try again.");
	}

	public NonUniqueNumberException(String message) {
		super(message);
	}
}
