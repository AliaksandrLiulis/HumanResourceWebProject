package by.htp.project.human_resource.dao.dao_interface;

import java.util.List;

import by.htp.project.human_resource.dao.dao_exception.DaoException;
import by.htp.project.human_resource.entity.Profile;
import by.htp.project.human_resource.entity.User;
import by.htp.project.human_resource.entity.Vacancy;

public interface IDAOJobSeeker {	
	
	List<Object> addNewProfile(final String... profileParams) throws DaoException;
	User removeProfile(final int userId) throws DaoException;
	Profile updateOldProfile(final String...profileParams) throws DaoException;
	User addNewResume(final String... resumeParams) throws DaoException;
	User deleteResume(final int idUserResume) throws DaoException;
	List<Vacancy> searchVacancyByParam(final String... params) throws DaoException;
	int getCountAllRowsForTable(final String tableName) throws DaoException;
	boolean updateVacancyWhenRespond(final int userId, final int vacancyId) throws DaoException;

}
