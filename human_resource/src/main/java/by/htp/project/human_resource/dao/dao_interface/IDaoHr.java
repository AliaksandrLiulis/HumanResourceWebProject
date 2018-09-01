package by.htp.project.human_resource.dao.dao_interface;

import java.util.List;

import by.htp.project.human_resource.dao.dao_exception.DaoException;
import by.htp.project.human_resource.entity.Resume;
import by.htp.project.human_resource.entity.User;
import by.htp.project.human_resource.entity.Vacancy;

public interface IDaoHr {

	Vacancy addDriverVacancy(List<String> params) throws DaoException;
	Vacancy addAccountantVacancy(List<String> params) throws DaoException;
	int getCountAllRowsForTable(String tableName) throws DaoException;
	List<Vacancy> searchVacancyByParam(String... params) throws DaoException;
	boolean deleteVacancyById(int id) throws DaoException;
	List<String> searchRespondedOnVacancy() throws DaoException;
	List<Resume> searchResumeByParam(String... params) throws DaoException;
	List<User> searchRespondedUserByIdVacancy(int idVacancy) throws DaoException;

}
