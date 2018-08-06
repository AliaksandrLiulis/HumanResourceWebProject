package by.htp.project.human_resource.controller.commandprovider.command.main_command;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import by.htp.project.human_resource.controller.commandprovider.command.main_command.constForCommand.CommandConst;

public class CheckCommand {
	
	private final static CheckCommand instance = new CheckCommand();
	private Map<String, String> allRolles = null;

	private final String ADMIN_ROLE = "admin";
	private final String BOSS_ROLE = "boss";
	private final String HR_ROLE = "hr";
	private final String EMPLOYEE_ROLE = "employee";

	
	public CheckCommand() {
		if (allRolles == null) {
			setRoles();
		}
	}

	public String check(final String role) {

		Set<Map.Entry<String, String>> entrySet = allRolles.entrySet();
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
	
	private Map<String, String> setRoles() {
		allRolles = new HashMap<String, String>();
		allRolles.put(ADMIN_ROLE, CommandConst.ADMIN_COMMAND);
		allRolles.put(BOSS_ROLE, CommandConst.BOSS_COMMAND);
		allRolles.put(HR_ROLE, CommandConst.HR_COMMAND);
		allRolles.put(EMPLOYEE_ROLE, CommandConst.EMPLOYEE_COMMAND);
		return allRolles;
	}
}
