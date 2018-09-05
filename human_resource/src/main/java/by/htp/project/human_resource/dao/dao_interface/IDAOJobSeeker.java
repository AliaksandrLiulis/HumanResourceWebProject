package by.htp.project.human_resource.dao.dao_interface;

import java.util.List;

import by.htp.project.human_resource.dao.dao_exception.DaoException;
import by.htp.project.human_resource.entity.Profile;
import by.htp.project.human_resource.entity.User;
import by.htp.project.human_resource.entity.Vacancy;
import by.htp.project.human_resource.entity.Resume;
import by.htp.project.human_resource.entity.RespondVacancy;

/**
 * This Interface wich has metods for work with JobSeekers on the Dao layer
 */

public interface IDAOJobSeeker {

	/**
	 * method which adds new {@link Profile} for {@link User} by incoming params
	 * 
	 * @return {@link List} {@link Object}
	 */
	List<Object> addNewProfile(String... profileParams) throws DaoException;

	/**
	 * method which removes {@link Profile} by {@link User#userId}
	 * 
	 * @return {@link User}
	 */
	User removeProfileByUserId(int userId) throws DaoException;

	/**
	 * method which update {@link Profile} by incoming profile params
	 * 
	 * @return {@link Profile}
	 */
	Profile updateOldProfileByParams(String... profileParams) throws DaoException;

	/**
	 * method which adds new {@link Resume} for {@link User} by incoming params
	 * 
	 * @return {@link User}
	 */
	User addNewResumeByParams(String... resumeParams) throws DaoException;

	/**
	 * method which delete {@link Resume} for {@link User} by {@link Resume#idUser}
	 * 
	 * @return {@link User}
	 */
	User deleteResumeByIdUser(int idUserResume) throws DaoException;

	/**
	 * method which searches {@link Vacancy} incoming by params
	 * 
	 * @return {@link List} {@link Vacancy}
	 */
	List<Vacancy> searchVacancyByParam(String... params) throws DaoException;

	/**
	 * method which searches {@link RespondVacancy} by incoming by
	 * {@link User#userId}
	 * 
	 * @return {@link List} {@link String}
	 */
	List<String> searchRespondVacancyByUserId(int userId) throws DaoException;

	/**
	 * method which gets count all rows for tables by tableName and fild avaliable
	 * 
	 * @return int value
	 */
	int getCountAllRowsForTable(String tableName) throws DaoException;

	/**
	 * method which update {@link Vacancy} when {@link User} respond and add in
	 * table by {@link User#userId} and {@link Vacancy#idvacancy}
	 * 
	 * @return int value
	 */
	boolean updateVacancyWhenRespondAndAddInTable(int userId, int vacancyId) throws DaoException;

	/**
	 * method which update {@link Vacancy} when {@link User} respond and delete from
	 * table by {@link User#userId} and {@link Vacancy#idvacancy}
	 * 
	 * @return int value
	 */
	boolean updateVacancyWhenRespondAndDeleteInTable(int userId, int vacancyId) throws DaoException;

}
