package by.htp.project.human_resource.dao.dao_interface;

import java.util.List;

import by.htp.project.human_resource.dao.dao_exception.DaoException;
import by.htp.project.human_resource.entity.Resume;
import by.htp.project.human_resource.entity.User;
import by.htp.project.human_resource.entity.Vacancy;

/**
 * This Interface wich has metods for work with Hr on the Dao layer
 * */

public interface IDaoHr {

	/**
	 * method which adds Driver Vacansy by incoming params
	 * @return {@link Vacancy}
	 */
	Vacancy addDriverVacancy(List<String> params) throws DaoException;
	
	/**
	 * method which adds Accountant Vacansy by incoming params
	 * @return {@link Vacancy}
	 */
	Vacancy addAccountantVacancy(List<String> params) throws DaoException;
	
	/**
	 * method which gets count all rows for tables by tableName and fild avaliable 
	 * @return int value
	 */
	int getCountAllRowsForTable(String tableName) throws DaoException;
	
	/**
	 * method which searches {@link Vacancy} by incoming params
	 * @return {@link List} {@link Vacancy}
	 */
	List<Vacancy> searchVacancyByParam(String... params) throws DaoException;
	
	/**
	 * method which delete {@link Vacancy}  by {@link User#userId}
	 * @return boolean value
	 */
	boolean deleteVacancyById(int id) throws DaoException;
	
	/**
	 * method which searches Responded on vacancy
	 * @return {@link List} {@link String}  
	 */
	List<String> searchRespondedOnVacancy() throws DaoException;
	
	/**
	 * method which searches {@link Resume} by params
	 * @return {@link List} {@link Resume} 
	 */
	List<Resume> searchResumeByParam(String... params) throws DaoException;
	
	/**
	 * method which searches Respond {@link User} by {@link Vacancy#idvacancy}
	 * @return {@link List} {@link User} 
	 */
	List<User> searchRespondedUserByIdVacancy(int idVacancy) throws DaoException;

}
