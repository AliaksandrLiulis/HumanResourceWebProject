package by.htp.project.human_resource.service.interf;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.project.human_resource.entity.Profile;
import by.htp.project.human_resource.entity.User;
import by.htp.project.human_resource.service.exception.ServiceException;

public interface IServiceJobSeeker {
	
	void addProfile(final HttpServletRequest request, final HttpServletResponse response);
	User deleteProfile(final int userId) throws ServiceException;
	Profile updateProfile(final String... profileParams);
	User addResume(String... resumeParams);
	User deleteResume(final int idUserResume);
}
