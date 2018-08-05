package by.htp.project.human_resource.controller.commandprovider.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.project.human_resource.controller.commandprovider.interf.ICommand;

public class MainPage implements ICommand{
	
	private final String PAGE_PATH = JSPPagePath.PATH;
	private final String PAGE_NAME = "main_page.jsp";

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher dispatcher = request.getRequestDispatcher(PAGE_PATH + PAGE_NAME);
		dispatcher.forward(request, response);
		
	}
}
