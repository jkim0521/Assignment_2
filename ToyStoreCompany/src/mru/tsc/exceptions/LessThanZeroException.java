package mru.tsc.exceptions;

/**
 * This is a custom exception that is thrown during the creation of a new Toy.
 * This exception is triggered when the integer returned by a user is less than zero
 * @author Joseph Kim
 *
 */
public class LessThanZeroException extends Exception{
	public LessThanZeroException() {
		super("Invalid input! The input cannot be less than or equal to zero!");
	}
	
	public LessThanZeroException(String message) {
		super(message);
	}

}
