package by.htp.project.human_resource.service.interf;


import java.util.List;

import by.htp.project.human_resource.entity.Profile;
import by.htp.project.human_resource.entity.User;
import by.htp.project.human_resource.service.exception.ServiceException;

public interface IServiceUser {
	List<Object> logInUser(final String nickName, final String password) throws ServiceException;
	User registerUser(final String name, final String surname, final String nickName, final String password, final String email, final String role) throws ServiceException;
	List<User> getAllUser() throws ServiceException;
	List<Object> addProfile(final String... params) throws ServiceException;
	User deleteProfile(final int userId) throws ServiceException;
	Profile updateProfile(final String... profileParams);
	User addResume(String... resumeParams);
	User deleteResume(final int idUserResume);
	

}
