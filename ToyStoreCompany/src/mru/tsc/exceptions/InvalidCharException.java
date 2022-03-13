package mru.tsc.exceptions;

/**
 * This is a custom exception that is thrown during the creation of a new Toy.
 * This exception is triggered when a char representing a type or size
 * @author Joseph Kim
 *
 */
public class InvalidCharException extends Exception{
	public InvalidCharException() {
		super("Invalid input! Please enter one of the correct options!");
	}
	
	public InvalidCharException(String message) {
		super(message);
	}
}
