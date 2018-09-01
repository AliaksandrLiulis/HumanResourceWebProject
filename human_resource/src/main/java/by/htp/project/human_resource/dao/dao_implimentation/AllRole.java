package by.htp.project.human_resource.dao.dao_implimentation;

public enum AllRole {
	
	ADMINISTRATOR("admin", 1), BOSS("boss", 2), HR("hr", 3), EMPLOYEE("employee", 4);

	private String value;
	private int idNumber;

	private AllRole(String value, int idNumber) {
		this.value = value;
		this.idNumber = idNumber;
	}

	public String getValue() {
		return value;
	}
	
	public int getIdNumber() {
		return idNumber;
	}
	
}
