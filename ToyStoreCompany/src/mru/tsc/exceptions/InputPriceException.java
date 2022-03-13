package mru.tsc.exceptions;

/**
 * This is a custom exception that is thrown during the creation of a new Toy.
 * This exception is triggered when a price is less than or equal to zero.
 * @author Joseph Kim
 *
 */
public class InputPriceException extends Exception{
	public InputPriceException(){
		super("Invalid input! Price cannot be less than or equal to zero.");
	}
	
	public InputPriceException(String message){
		super(message);
	}

}
