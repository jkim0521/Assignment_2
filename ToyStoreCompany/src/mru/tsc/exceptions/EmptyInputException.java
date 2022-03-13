package mru.tsc.exceptions;

/**
 * This is a custom exception that is thrown during the creation of a new Toy.
 * This exception is triggered when the String returned by the user is blank
 * @author Joseph Kim
 *
 */
public class EmptyInputException extends Exception{
	public EmptyInputException() {
		super("Invalid input! The field cannot be blank.");
	}
	
	public EmptyInputException(String message) {
		super(message);
	}
}
