package by.htp.project.human_resource.service.impl.checker;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckRegisterParam {

	private final static CheckRegisterParam instance = new CheckRegisterParam();
	private Pattern p = Pattern.compile("^[a-z0-9._-]+");

	private CheckRegisterParam() {
	}

	public static CheckRegisterParam getCheckParam() {
		return instance;
	}

	public boolean check(final String... params) {
		Matcher m = null;

		for (String param : params) {
			param.trim();
			if (!param.equals(null) || param.length() > 0 || param.length() < 30) {
				m = p.matcher(param);
				if (m.matches()) {
					return true;
				}
			}
		}
		return false;
	}
}
