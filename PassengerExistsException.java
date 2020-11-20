package ships;


public class PassengerExistsException extends RuntimeException{
	//create exception

	public PassengerExistsException() {
		super("Invalid: Passenger already exists.");
	}
	
	public PassengerExistsException(String message) {
		super(message);
	}
}
