package mru.tsc.exceptions;

public class MinMaxPriceException extends Exception{
	public MinMaxPriceException() {
		super("Invalid input! The maximum price cannot be lower than the minimum.");
	}
	
	public MinMaxPriceException(String message) {
		super(message);
	}

}
