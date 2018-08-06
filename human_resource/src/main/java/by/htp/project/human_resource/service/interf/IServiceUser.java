package by.htp.project.human_resource.service.interf;

import by.htp.project.human_resource.entity.User;
import by.htp.project.human_resource.service.exception.ServiceException;

public interface IServiceUser {
	User logInUser(final String nickName, final String password) throws ServiceException;
	User registerUser(final String name, final String surname, final String nickName, final String password, final String email, final String role) throws ServiceException;

}
