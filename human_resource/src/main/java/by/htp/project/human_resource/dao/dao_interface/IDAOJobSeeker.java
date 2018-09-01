package by.htp.project.human_resource.dao.dao_interface;

import java.util.List;

import by.htp.project.human_resource.dao.dao_exception.DaoException;
import by.htp.project.human_resource.entity.Profile;
import by.htp.project.human_resource.entity.User;
import by.htp.project.human_resource.entity.Vacancy;

public interface IDAOJobSeeker {	
	
	List<Object> addNewProfile(String... profileParams) throws DaoException;
	User removeProfileByUserId(int userId) throws DaoException;
	Profile updateOldProfileByParams(String...profileParams) throws DaoException;
	User addNewResumeByParams(String... resumeParams) throws DaoException;
	User deleteResumeByIdUser(int idUserResume) throws DaoException;
	List<Vacancy> searchVacancyByParam(String... params) throws DaoException;
	List<String> searchRespondVacancyByUserId(int userId) throws DaoException;
	int getCountAllRowsForTable(String tableName) throws DaoException;
	boolean updateVacancyWhenRespondAndAddInTable(int userId, int vacancyId) throws DaoException;
	boolean updateVacancyWhenRespondAndDeleteInTable(int userId, int vacancyId) throws DaoException;

}
