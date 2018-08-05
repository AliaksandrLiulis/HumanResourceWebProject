package by.htp.project.human_resource.controller.commandprovider;

import java.util.Map;
import java.util.Set;

import by.htp.project.human_resource.controller.commandprovider.interf.ICommand;

public class CommandProvider {
	
	private CommandResourceManager commandResourceManager;
	private Map<String, ICommand> allcommand = null;
	

	public CommandProvider() {
		commandResourceManager = CommandResourceManager.getInstance();
		if (allcommand == null) {
			allcommand = commandResourceManager.getAllCommand();
		}		
	}

	public ICommand getCommand(String commandRequest) {
		ICommand icommand = null;
		Set<Map.Entry<String, ICommand>> entrySet = allcommand.entrySet();
		for (Map.Entry<String, ICommand> pair : entrySet) {
			if (commandRequest.equals(pair.getKey())) {
				icommand = pair.getValue();
			}
		}
		return icommand;
	}
}
