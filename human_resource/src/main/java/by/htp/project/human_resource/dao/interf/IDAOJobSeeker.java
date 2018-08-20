package by.htp.project.human_resource.dao.interf;

import java.util.List;

import by.htp.project.human_resource.dao.exception.DaoException;
import by.htp.project.human_resource.entity.Profile;
import by.htp.project.human_resource.entity.User;

public interface IDAOJobSeeker {	
	
	List<Object> addNewProfile(final String... profileParams) throws DaoException;
	User removeProfile(final int userId) throws DaoException;
	Profile updateOldProfile(final String...profileParams) throws DaoException;
	User addNewResume(final String... resumeParams) throws DaoException;
	User deleteResume(final int idUserResume) throws DaoException;

}
