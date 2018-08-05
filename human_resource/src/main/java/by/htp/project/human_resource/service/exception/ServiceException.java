package by.htp.project.human_resource.service.exception;

public class ServiceException extends Exception{
	
	private static final long serialVersionUID = -6071440383363990589L;

	public ServiceException() {
		super();
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Exception e) {
		super(e);
	}

	public ServiceException(String message, Exception e) {
		super(message, e);
	}
}
