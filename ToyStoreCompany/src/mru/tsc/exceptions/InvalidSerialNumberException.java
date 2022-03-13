package mru.tsc.exceptions;

/**
 * This is a custom exception that is thrown during the validation of a serial number.
 * This exception is triggered when the serial number entered by the user
 * is not exactly 10 digits long.
 * @author Joseph Kim
 *
 */
public class InvalidSerialNumberException extends Exception{
	public InvalidSerialNumberException() {
		super("This is an invalid Serial Number, please double-check that the number is exactly 10 digits long!");
	}
	
	public InvalidSerialNumberException(String message) {
		super(message);
	}

}
