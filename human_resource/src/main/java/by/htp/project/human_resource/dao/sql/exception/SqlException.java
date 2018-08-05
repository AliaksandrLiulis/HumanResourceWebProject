package by.htp.project.human_resource.dao.sql.exception;

public class SqlException extends Exception{
	
	private static final long serialVersionUID = 2659554435520152759L;

	public SqlException() {
		super();
	}

	public SqlException(String message) {
		super(message);
	}

	public SqlException(Exception e) {
		super(e);
	}

	public SqlException(String message, Exception e) {
		super(message, e);
	}
}
