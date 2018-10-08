package by.htp.project.human_resource.service.impl.checker;

import java.util.HashMap;

import java.util.Map;
import java.util.Set;

import by.htp.project.human_resource.controller.commandprovider.command.command_for_page.constant_for_jsp_page.JSPPagePath;
import by.htp.project.human_resource.service.service_constant.ServiceCommandConstant;
import by.htp.project.human_resource.service.service_constant.ServiceParamConstant;

/**
 * Class for check Command
 */
public class CheckCommand {

	/** static final field CheckCommand instance */
	private final static CheckCommand instance = new CheckCommand();
	/** Map field all roles for commands */
	private Map<String, String> allRollesForCommand = null;
	/** Map field all roles for path */
	private Map<String, String> allRollesForPath = null;

	/** constructor for CheckCommand */
	private CheckCommand() {

		if (allRollesForCommand == null) {
			setRolesForCommand();
		}
		if (allRollesForPath == null) {
			setRolesForPath();
		}
	}

	public static CheckCommand getInstance() {
		return instance;
	}

	/**
	 * method which checks role by command
	 * 
	 * @param String role
	 * @return String
	 */
	public String checkRoleForCommand(final String role) {
		Set<Map.Entry<String, String>> entrySet = allRollesForCommand.entrySet();
		String chooseRole = null;
		for (Map.Entry<String, String> pair : entrySet) {
			if (role.equals(pair.getKey())) {
				chooseRole = pair.getValue();
			}
		}
		return chooseRole;
	}

	/**
	 * method which checks role by command
	 * 
	 * @param String role
	 * @return String
	 */
	public String checkRoleForPath(final String role) {
		Set<Map.Entry<String, String>> entrySet = allRollesForPath.entrySet();
		String chooseRole = null;

		for (Map.Entry<String, String> pair : entrySet) {
			if (role.equals(pair.getKey())) {
				chooseRole = pair.getValue();
			}
		}
		return chooseRole;
	}

	/**
	 * method which sets Map for command
	 * 
	 * @return Map<String, String>
	 */
	private Map<String, String> setRolesForCommand() {
		allRollesForCommand = new HashMap<String, String>();
		allRollesForCommand.put(ServiceParamConstant.ADMIN_ROLE, ServiceCommandConstant.ADMIN_COMMAND);
		allRollesForCommand.put(ServiceParamConstant.BOSS_ROLE, ServiceCommandConstant.BOSS_COMMAND);
		allRollesForCommand.put(ServiceParamConstant.HR_ROLE, ServiceCommandConstant.HR_COMMAND);
		allRollesForCommand.put(ServiceParamConstant.EMPLOYEE_ROLE, ServiceCommandConstant.EMPLOYEE_COMMAND);
		return allRollesForCommand;
	}

	/**
	 * method which sets Map for Path
	 * 
	 * @return Map<String, String>
	 */
	private Map<String, String> setRolesForPath() {
		allRollesForPath = new HashMap<String, String>();
		allRollesForPath.put(ServiceParamConstant.ADMIN_ROLE, JSPPagePath.PATH_ADMIN_PAGE);
		allRollesForPath.put(ServiceParamConstant.BOSS_ROLE, JSPPagePath.PATH_BOSS_PAGE);
		allRollesForPath.put(ServiceParamConstant.HR_ROLE, JSPPagePath.PATH_HR_PAGE);
		allRollesForPath.put(ServiceParamConstant.EMPLOYEE_ROLE, JSPPagePath.PATH_EMPLOYEE_PAGE);
		return allRollesForPath;
	}
}
