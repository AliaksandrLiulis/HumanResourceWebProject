package by.htp.project.human_resource.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.htp.project.human_resource.dao.exception.DaoException;
import by.htp.project.human_resource.dao.interf.IDaoHr;
import by.htp.project.human_resource.dao.poolconnection.ConnectionPool;
import by.htp.project.human_resource.entity.Vacancy;
import by.htp.project.human_resource.entity.VacancyBuilder;

public class DaoHrImpl implements IDaoHr {

	private Logger logger = LoggerFactory.getLogger(DaoUserImpl.class);
	private ConnectionPool connectionPool = null;

	private final String ADD_DRIVER_VACANCY = "INSERT into vacancies (professionName,  companyName, experience, salary , goods, dlCategory, whoAddedId) VALUES (?,?,?,?,?,?,?)";
	private final String ADD_ACCOUNTANT_VACANCY = "INSERT into vacancies (professionName,  companyName, experience, salary, whoAddedId ) VALUES (?,?,?,?,?)";
	private final String SEARCH_BY_PARAM = "select * from vacancies where whoAddedId = ? LIMIT ?, ?";
	private final String DELETE_VACANCY_BY_ID = "DELETE from vacancies where idvacancies = ?";

	public DaoHrImpl() {
		if (null == connectionPool) {
			connectionPool = ConnectionPool.getInstance();
		}
	}

	@Override
	public Vacancy addDriverVacancy(final List<String> params) throws DaoException {

		String profession = null;
		String companyName = null;
		String experience = null;
		String salary = null;
		String goods = null;
		String dlCategory = null;
		String whoAddedId = null;
		Vacancy vacancy = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		profession = params.get(0);
		companyName = params.get(1);
		experience = params.get(2);
		salary = params.get(3);
		goods = params.get(4);
		dlCategory = params.get(5);
		whoAddedId = params.get(6);

		try {
			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement(ADD_DRIVER_VACANCY);
			preparedStatement.setString(1, profession);
			preparedStatement.setString(2, companyName);
			preparedStatement.setString(3, experience);
			preparedStatement.setString(4, salary);
			preparedStatement.setString(5, goods);
			preparedStatement.setString(6, dlCategory);
			preparedStatement.setInt(7, Integer.parseInt(whoAddedId));
			preparedStatement.executeUpdate();

			vacancy = new VacancyBuilder().professionName(profession).companyName(companyName).experience(experience)
					.salary(Integer.parseInt(salary)).goods(goods).dlCategory(dlCategory)
					.whoAddedId(Integer.parseInt(whoAddedId)).build();

		} catch (InterruptedException e) {
			logger.error("DaoUserImpl: addDriverVacancy: Connection interrupted: " + e);
			throw new DaoException("addDriverVacancy" + e);
		} catch (SQLException e) {
			logger.error("DaoUserImpl: addDriverVacancy: SQL error: " + e);
			throw new DaoException("getProfile" + e);
		} finally {
			closeResources(result, preparedStatement, connection, "getPraddDriverVacancyofile");
		}
		return vacancy;
	}

	@Override
	public Vacancy addAccountantVacancy(final List<String> params) throws DaoException {
		String profession = null;
		String companyName = null;
		String experience = null;
		String salary = null;
		String whoAddedId = null;
		Vacancy vacancy = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		profession = params.get(0);
		companyName = params.get(1);
		experience = params.get(2);
		salary = params.get(3);
		whoAddedId = params.get(4);

		try {
			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement(ADD_ACCOUNTANT_VACANCY);
			preparedStatement.setString(1, profession);
			preparedStatement.setString(2, companyName);
			preparedStatement.setString(3, experience);
			preparedStatement.setString(4, salary);
			preparedStatement.setInt(5, Integer.parseInt(whoAddedId));
			preparedStatement.executeUpdate();

			vacancy = new VacancyBuilder().professionName(profession).companyName(companyName).experience(experience)
					.salary(Integer.parseInt(salary)).whoAddedId(Integer.parseInt(whoAddedId)).build();

		} catch (InterruptedException e) {
			logger.error("DaoUserImpl: addAccountantVacancy: Connection interrupted: " + e);
			throw new DaoException("addAccountantVacancy" + e);
		} catch (SQLException e) {
			logger.error("DaoUserImpl: addAccountantVacancy: SQL error: " + e);
			throw new DaoException("addAccountantVacancy" + e);
		} finally {
			closeResources(result, preparedStatement, connection, "addAccountantVacancy");
		}
		return vacancy;
	}

	@Override
	public int getCountAllRowsForTable(String tableName) throws DaoException {
		int count = 0;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		try {
			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement("SELECT count(*) FROM " + tableName);
			result = preparedStatement.executeQuery();
			while (result.next()) {
				count = result.getInt(1);
			}
		} catch (InterruptedException e) {
			logger.error("DaoUserImpl: getCountAllRowsForTable: Connection interrupted: " + e);
			throw new DaoException("getCountAllRowsForTable" + e);
		} catch (SQLException e) {
			logger.error("DaoUserImpl: getCountAllRowsForTable: SQL error: " + e);
			throw new DaoException("getCountAllRowsForTable" + e);
		} finally {
			closeResources(result, preparedStatement, connection, "getCountAllRowsForTable");
		}

		return count;
	}

	@Override
	public List<Vacancy> searchVacancyByParam(String... params) throws DaoException {
		String limiLine = null;
		String offsetLine = null;
		String whoAddedId = null;
		List<Vacancy> allVacancy = null;
		Vacancy vacancy;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		limiLine = params[1];
		offsetLine = params[2];
		whoAddedId = params[3];
		allVacancy = new ArrayList<>();

		try {
			connection = connectionPool.takeConnection();

			preparedStatement = connection.prepareStatement(SEARCH_BY_PARAM);
			preparedStatement.setInt(1, Integer.parseInt(whoAddedId));
			preparedStatement.setInt(2, Integer.parseInt(offsetLine));
			preparedStatement.setInt(3, Integer.parseInt(limiLine));

			result = preparedStatement.executeQuery();
			while (result.next()) {
				vacancy = new VacancyBuilder().idvacancy(result.getInt(1)).professionName(result.getString(2))
						.companyName(result.getString(3)).experience(result.getString(4)).salary(result.getInt(5))
						.goods(result.getString(6)).dlCategory(result.getString(7)).whoAddedId(result.getInt(8))
						.build();
				allVacancy.add(vacancy);
			}
		} catch (InterruptedException e) {
			logger.error("DaoUserImpl: searchVacancyByParam: Connection interrupted: " + e);
			throw new DaoException("searchVacancyByParam" + e);
		} catch (SQLException e) {
			logger.error("DaoUserImpl: searchVacancyByParam: SQL error: " + e);
			throw new DaoException("searchVacancyByParam" + e);
		} finally {
			closeResources(result, preparedStatement, connection, "searchVacancyByParam");
		}
		return allVacancy;
	}
	
	

	@Override
	public boolean deleteVacancy(int id) throws DaoException {
		boolean resultDeleted = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
			
		try {
			connection = connectionPool.takeConnection();

			preparedStatement = connection.prepareStatement(DELETE_VACANCY_BY_ID);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			resultDeleted = true;
		} catch (InterruptedException e) {
			logger.error("DaoUserImpl: deleteVacancy: Connection interrupted: " + e);
			throw new DaoException("deleteVacancy" + e);
		} catch (SQLException e) {
			logger.error("DaoUserImpl: searchVacancyByParam: SQL error: " + e);
			throw new DaoException("searchVacancyByParam" + e);
		} finally {
			closeResources(null, preparedStatement, connection, "deleteVacancy");
		}		
		return resultDeleted;
	}
	
	
	private void closeResources(final ResultSet resultSet, final PreparedStatement preparedStatement,
			final Connection connection, String methodName) {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {
			logger.error("DaoHrImpl: " + methodName + ": " + e);
		}
	}

	@Override
	public List<String> searchResumeByParam(String... params) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
