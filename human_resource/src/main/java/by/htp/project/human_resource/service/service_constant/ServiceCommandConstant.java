package by.htp.project.human_resource.service.service_constant;

/**Class for constant value Service command*/

public final class ServiceCommandConstant {

	private ServiceCommandConstant() {
	}

	/**field for admin_page command*/
	public final static String ADMIN_COMMAND = "?command=cb.admin_page";
	/**field for boss_page command*/
	public final static String BOSS_COMMAND = "?command=cb.boss_page";
	/**field for hr_page command*/
	public final static String HR_COMMAND = "?command=cb.hr_page";
	/**field for employee_page command*/
	public final static String EMPLOYEE_COMMAND = "?command=cb.employee_page";
	/**field for main_page command*/
	public final static String PATH_MAIN_PAGE_COMMAND = "?command=cb.main_page";
	/**field for expect_page command*/
	public final static String EXPECT_COMMAND = "?command=cb.expect_page";
	/**field for error_page command*/
	public final static String ERROR_COMMAND = "?command=cb.error_page";

	/**field for previous Servlet Path*/
	public final static String PREVIOUS_PATH_FOR_LOCALIZATION = "previousServletPath";
	/**field for localization command*/
	public final static String COMMAND_FOR_LOCALIZATION = "cb.localization";

}
