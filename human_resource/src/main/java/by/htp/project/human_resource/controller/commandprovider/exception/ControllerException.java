package by.htp.project.human_resource.controller.commandprovider.exception;

public class ControllerException extends Exception{
	
	private static final long serialVersionUID = 2046262123613436061L;

	public ControllerException() {
		super();
	}

	public ControllerException(final String message) {
		super(message);
	}

	public ControllerException(final Exception e) {
		super(e);
	}

	public ControllerException(final String message, final Exception e) {
		super(message, e);
	}
}
