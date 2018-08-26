package by.htp.project.human_resource.dao.dao_exception;

public class DaoException extends Exception{
	
	private static final long serialVersionUID = 9112540500915025338L;

	public DaoException() {
		super();
	}

	public DaoException(final String message) {
		super(message);
	}

	public DaoException(final Exception e) {
		super(e);
	}

	public DaoException(final String message, final Exception e) {
		super(message, e);
	}
}
