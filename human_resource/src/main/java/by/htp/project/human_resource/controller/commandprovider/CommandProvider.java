package by.htp.project.human_resource.controller.commandprovider;

import java.util.Map;
import java.util.Set;

import by.htp.project.human_resource.controller.commandprovider.interf.ICommand;

public class CommandProvider {
	
	private final CommandResourceManager commandResourceManager  = CommandResourceManager.getInstance();
	private Map<String, ICommand> allcommand = null;	

	public CommandProvider() {		
		if (allcommand == null) {
			allcommand = commandResourceManager.getAllCommand();
		}		
	}

	public ICommand getCommand(final String commandRequest) {
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
