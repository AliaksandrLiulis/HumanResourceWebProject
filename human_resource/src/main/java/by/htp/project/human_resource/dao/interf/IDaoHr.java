package by.htp.project.human_resource.dao.interf;

import java.util.List;

import by.htp.project.human_resource.dao.exception.DaoException;
import by.htp.project.human_resource.entity.Vacancy;

public interface IDaoHr {
	Vacancy addDriverVacancy(final List<String> params) throws DaoException ;
	Vacancy addAccountantVacancy (final List<String> params) throws DaoException;
	int getCountAllRowsForTable(final String tableName) throws DaoException;
	List<Vacancy> searchVacancyByParam(final String... params) throws DaoException;
	boolean deleteVacancy(final int id) throws DaoException;
	List<String> searchResumeByParam(final String... params) throws DaoException;
		
	

}
