package by.htp.project.human_resource.util.poolconnection;

import java.util.ResourceBundle;

public class DBResourceManager {
	
	private final static DBResourceManager instance = new DBResourceManager();
	
	private DBResourceManager() {}
	
	private ResourceBundle bundle = ResourceBundle.getBundle("sqlproperty.db");
	
	public static DBResourceManager getInstance() {
		return instance;
	}
	
	public String getValue(String key) {
		return bundle.getString(key);
	}
}
