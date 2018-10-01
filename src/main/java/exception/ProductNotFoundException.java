package exception;

public class ProductNotFoundException extends Exception {

	private static final long serialVersionUID = 1105045175631879877L;
	
	public ProductNotFoundException(String message) {
		super(message);
	}

}
