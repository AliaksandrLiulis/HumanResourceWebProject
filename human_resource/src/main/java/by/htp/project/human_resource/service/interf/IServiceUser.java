package by.htp.project.human_resource.service.interf;

import by.htp.project.human_resource.entity.User;
import by.htp.project.human_resource.service.exception.ServiceException;

public interface IServiceUser {
	User logInUser(String nickName, String password) throws ServiceException;
	User registerUser(String name, String surname, String nickName, String password, String email, String role) throws ServiceException;

}
