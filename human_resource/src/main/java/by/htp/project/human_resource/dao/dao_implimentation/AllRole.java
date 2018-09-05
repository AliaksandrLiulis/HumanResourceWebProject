package by.htp.project.human_resource.dao.dao_implimentation;

/** Class with has objects for alll roles with filds value, idNumber */

public enum AllRole {

	ADMINISTRATOR("admin", 1), BOSS("boss", 2), HR("hr", 3), EMPLOYEE("employee", 4);

	/** field String value */
	private String value;
	/** field int idNumber */
	private int idNumber;

	/**
	 * constructor - which create instance AllRole and set degfault value for fields
	 * {@link AllRole#value} and {@link AllRole#idNumber}
	 */
	private AllRole(String value, int idNumber) {
		this.value = value;
		this.idNumber = idNumber;
	}

	/**
	 * method gets value field {@link AllRole#value}.
	 * 
	 * @return {@link AllRole#value}.
	 */
	public String getValue() {
		return value;
	}

	/**
	 * method gets value field {@link AllRole#idNumber}.
	 * 
	 * @return {@link AllRole#idNumber}.
	 */
	public int getIdNumber() {
		return idNumber;
	}

}
