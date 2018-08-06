package by.htp.project.human_resource.service.impl;

public class CheckRegisterParam {
	private final static CheckRegisterParam instance = new CheckRegisterParam();

	public CheckRegisterParam() {
		super();
	}

	public static CheckRegisterParam getCheckParam() {
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
