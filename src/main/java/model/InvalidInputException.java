package model;

public class InvalidInputException extends Exception {
	private static final long serialVersionUID = 1L;
	private String reason;

	public InvalidInputException(String reason) {
		this.reason = reason;
	}
	
	public String getReason() {
		return this.reason;
	}
}
