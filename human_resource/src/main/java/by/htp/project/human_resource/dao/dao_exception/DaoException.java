package by.htp.project.human_resource.dao.dao_exception;

/**
 * The class DaoException it's a checked exceptions which extends from
 * Exception. it has the next methods {@link DaoException#DaoException(String)},
 * {@link DaoException#DaoException(Exception)},
 * {@link DaoException#DaoException(String, Exception)},
 * {@link DaoException#DaoException()}
 */

public class DaoException extends Exception {

	private static final long serialVersionUID = 9112540500915025338L;

	/**
	 * Constructs a new exception.
	 */
	public DaoException() {
		super();
	}

	/**
	 * Constructs a new exception with the specified detail message.
	 */
	public DaoException(final String message) {
		super(message);
	}

	/**
	 * Constructs a new exception with the specified cause and a detailmessage.
	 */
	public DaoException(final Exception e) {
		super(e);
	}

	/**
	 * Constructs a new exception with the specified detail message andcause.
	 */
	public DaoException(final String message, final Exception e) {
		super(message, e);
	}
}
