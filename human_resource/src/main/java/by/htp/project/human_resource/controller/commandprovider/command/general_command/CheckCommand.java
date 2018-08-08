package by.htp.project.human_resource.controller.commandprovider.command.general_command;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import by.htp.project.human_resource.controller.commandprovider.command.command_for_page.constForJspPage.JSPPagePath;
import by.htp.project.human_resource.controller.commandprovider.command.general_command.constForCommand.CommandConst;
import by.htp.project.human_resource.controller.commandprovider.command.general_command.constForCommand.ParamConst;

public class CheckCommand {

	private final static CheckCommand instance = new CheckCommand();
	private Map<String, String> allRollesForCommand = null;
	private Map<String, String> allRollesForPath = null;

	public CheckCommand() {
		if (allRollesForCommand == null) {
			setRolesForCommand();
		}
		if (allRollesForPath == null) {
			setRolesForPath();
		}
	}

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

	public static CheckCommand getInstance() {
		return instance;
	}

	private Map<String, String> setRolesForCommand() {
		allRollesForCommand = new HashMap<String, String>();
		allRollesForCommand.put(ParamConst.ADMIN_ROLE, CommandConst.ADMIN_COMMAND);
		allRollesForCommand.put(ParamConst.BOSS_ROLE, CommandConst.BOSS_COMMAND);
		allRollesForCommand.put(ParamConst.HR_ROLE, CommandConst.HR_COMMAND);
		allRollesForCommand.put(ParamConst.EMPLOYEE_ROLE, CommandConst.EMPLOYEE_COMMAND);
		return allRollesForCommand;
	}
	
	private Map<String, String> setRolesForPath() {
		allRollesForPath = new HashMap<String, String>();
		allRollesForPath.put(ParamConst.ADMIN_ROLE, JSPPagePath.PATH_ADMIN_PAGE);
		allRollesForPath.put(ParamConst.BOSS_ROLE, JSPPagePath.PATH_BOSS_PAGE);
		allRollesForPath.put(ParamConst.HR_ROLE, JSPPagePath.PATH_HR_PAGE);
		allRollesForPath.put(ParamConst.EMPLOYEE_ROLE, JSPPagePath.PATH_EMPLOYEE_PAGE);
		return allRollesForPath;
	}
}
