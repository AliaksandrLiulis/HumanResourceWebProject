package by.htp.project.human_resource.controller.commandprovider.command.general_command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.project.human_resource.controller.commandprovider.interf.ICommand;

public class AddProfile implements  ICommand{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("phone " + request.getParameter("foto"));
		System.out.println("phone " + request.getParameter("phone"));
		System.out.println("dateOfBirthDay " +request.getParameter("dateOfBirthDay"));
		System.out.println("residence " +request.getParameter("residence"));
		System.out.println("workSpeciality " +request.getParameter("workSpeciality"));
		System.out.println("workExpirience " +request.getParameter("workExpirience"));
		System.out.println("education " +request.getParameter("education"));
		System.out.println("message " +request.getParameter("message"));
				
	}

}
