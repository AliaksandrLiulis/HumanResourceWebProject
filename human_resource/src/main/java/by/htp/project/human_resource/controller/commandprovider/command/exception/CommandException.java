package by.htp.project.human_resource.controller.commandprovider.command.exception;

public class CommandException extends Exception{
	
	private static final long serialVersionUID = 6819509961034031182L;

	public CommandException() {
		super();
	}

	public CommandException(String message) {
		super(message);
	}

	public CommandException(Exception e) {
		super(e);
	}

	public CommandException(String message, Exception e) {
		super(message, e);
	}
}
