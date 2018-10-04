package exception;

public class CustomerNotFoundException extends Exception {

	private static final long serialVersionUID = 1069114762887415252L;

	public CustomerNotFoundException(String message) {
		super(message);
	}

}
