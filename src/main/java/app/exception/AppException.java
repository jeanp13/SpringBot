package app.exception;

@SuppressWarnings("serial")
public class AppException extends RuntimeException {
	
	private String message;

	public AppException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
}
