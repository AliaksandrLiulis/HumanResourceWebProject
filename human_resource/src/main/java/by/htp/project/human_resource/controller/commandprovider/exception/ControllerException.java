package by.htp.project.human_resource.controller.commandprovider.exception;

/**
 * The class ControllerException it's a checkedexceptions which extends from
 * Exception. it has the next methods
 * {@link ControllerException#ControllerException(String)},
 * {@link ControllerException#ControllerException(Exception)},
 * {@link ControllerException#ControllerException(String, Exception)},
 * {@link ControllerException#ControllerException()}
 */

public class ControllerException extends Exception {

	private static final long serialVersionUID = 2046262123613436061L;

	/**
	 * Constructs a new exception.
	 */
	public ControllerException() {
		super();
	}

	/**
	 * Constructs a new exception with the specified detail message.
	 */
	public ControllerException(final String message) {
		super(message);
	}

	/**
	 * Constructs a new exception with the specified cause and a detailmessage.
	 */
	public ControllerException(final Exception e) {
		super(e);
	}

	/**
	 * Constructs a new exception with the specified detail message andcause.
	 */
	public ControllerException(final String message, final Exception e) {
		super(message, e);
	}
}
