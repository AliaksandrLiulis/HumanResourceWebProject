package by.htp.project.human_resource.service.impl;

public class CheckLoginParam {
	
	private final static CheckLoginParam instance = new CheckLoginParam();
		
	public CheckLoginParam() {
		super();
	}
	
	public static CheckLoginParam getCheckParam() {
		return instance;
	}

	public boolean check(final String... params) {
		for (String param : params) {
			param.trim();
			if (param.equals(null) || param.length() <= 0 || param.length() > 15) {
				return false;
			}
		}
		return true;
	}
}
