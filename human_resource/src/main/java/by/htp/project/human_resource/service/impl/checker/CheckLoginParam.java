package by.htp.project.human_resource.service.impl.checker;

public class CheckLoginParam {

	private final static CheckLoginParam instance = new CheckLoginParam();

	private CheckLoginParam() {
	}

	public static CheckLoginParam getCheckParam() {
		return instance;
	}

	public boolean check(final String... params) {
		for (String param : params) {
			param.trim();
			if (param.equals(null) || param.length() <= 0 || param.length() > 20) {
				return false;
			}
		}
		return true;
	}
}
