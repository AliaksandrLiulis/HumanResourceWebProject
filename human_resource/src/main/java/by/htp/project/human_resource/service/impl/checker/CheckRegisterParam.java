package by.htp.project.human_resource.service.impl.checker;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class for check params
 */
public class CheckRegisterParam {

	/** field for CheckLoginParam instance */
	private final static CheckRegisterParam instance = new CheckRegisterParam();
	/** field for pattern */
	private final static String PATTERN = "[a-zA-Zа-яА-Я0-9\\._-]+";

	private Pattern p = Pattern.compile(PATTERN);

	private CheckRegisterParam() {
	}

	/**
	 * method for get instance CheckLoginParam
	 * 
	 * @return CheckLoginParam
	 */

	public static CheckRegisterParam getCheckParam() {
		return instance;
	}

	/**
	 * method for check params
	 * 
	 * @param {@link String[]}
	 * @return {@link Boolean}
	 */
	public boolean check(final String... params) {
		Matcher m = null;

		for (String param : params) {
			if ((param == null || param.length() > 30) || param.trim().isEmpty()) {
				return false;
			} else {
				m = p.matcher(param);
				if (m.matches()) {
					return true;
				}
			}
		}
		return false;
	}
}
