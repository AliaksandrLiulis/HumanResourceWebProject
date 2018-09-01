package by.htp.project.human_resource.controller.commandprovider.interf;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ICommand {
	
	void execute(final HttpServletRequest request, final HttpServletResponse response)throws ServletException, IOException;
	
}
