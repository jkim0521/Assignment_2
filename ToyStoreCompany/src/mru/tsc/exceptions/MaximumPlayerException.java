package mru.tsc.exceptions;

/**
 * This is a custom exception that is thrown during the creation of a new Toy.
 * This exception is triggered when the maximum number of players specified by
 * the user is greater than the minimum number of players.
 * @author Joseph Kim
 *
 */
public class MaximumPlayerException extends Exception{
	public MaximumPlayerException(){
		super("Invalid input! The maximum players cannot be greater than the minimum player.");
	}
	
	public MaximumPlayerException(String message){
		super(message);
	}
}
