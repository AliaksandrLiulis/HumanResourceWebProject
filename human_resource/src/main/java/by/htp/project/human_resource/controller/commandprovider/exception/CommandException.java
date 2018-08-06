package by.htp.project.human_resource.controller.commandprovider.exception;

public class CommandException extends Exception{
	
	private static final long serialVersionUID = 6819509961034031182L;

	public CommandException() {
		super();
	}

	public CommandException(final String message) {
		super(message);
	}

	public CommandException(final Exception e) {
		super(e);
	}

	public CommandException(final String message, final Exception e) {
		super(message, e);
	}
}
