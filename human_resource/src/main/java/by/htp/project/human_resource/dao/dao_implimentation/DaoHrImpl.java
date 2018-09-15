package by.htp.project.human_resource.dao.dao_implimentation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.htp.project.human_resource.dao.dao_exception.DaoException;
import by.htp.project.human_resource.dao.dao_interface.IDaoHr;
import by.htp.project.human_resource.entity.Resume;
import by.htp.project.human_resource.entity.ResumeBuilder;
import by.htp.project.human_resource.entity.User;
import by.htp.project.human_resource.entity.UserBuilder;
import by.htp.project.human_resource.entity.Vacancy;
import by.htp.project.human_resource.entity.VacancyBuilder;
import by.htp.project.human_resource.util.poolconnection.ConnectionPool;
import by.htp.project.human_resource.entity.RespondVacancy;

/**
 * Class which has methods for work with Users which have role Hr
 */

public class DaoHrImpl implements IDaoHr {

	/** Field for logging {@link LoggerFactory} */
	private Logger logger = LoggerFactory.getLogger(DaoHrImpl.class);
	/** Field for ConnectionPool */
	private ConnectionPool connectionPool = ConnectionPool.getInstance();

	/** Field for adds driver vacancy into {@link Vacancy} */
	private final String ADD_DRIVER_VACANCY = "INSERT INTO vacancies (professionName,  companyName, experience, salary , goods, dlCategory, whoAddedId) VALUES (?,?,?,?,?,?,?)";
	/** Field for adds accountant vacancy into {@link Vacancy} */
	private final String ADD_ACCOUNTANT_VACANCY = "INSERT INTO vacancies (professionName,  companyName, experience, salary, whoAddedId ) VALUES (?,?,?,?,?)";
	/**
	 * Field for searches limit count {@link Vacancy} by {@link Vacancy#whoAddedId}
	 */
	private final String SEARCH_LIMIT_COUNT_VACANCY_BY_USER_ID = "SELECT * FROM vacancies WHERE whoAddedId = ? LIMIT ?, ?";
	/** Field for searches limit count {@link Resume} */
	private final String SEARCH_LIMIT_COUNT_RESUME = "SELECT * FROM resume LIMIT ?, ?";
	/** Field for searches All from {@link RespondVacancy} */
	private final String SEARCH_ALL_RESPONDED_ON_VACANCY = "SELECT * FROM vacancyresponded";
	/** Field for delete all from {@link Vacancy} by {@link Vacancy#idvacancy} */
	private final String DELETE_VACANCY_BY_ID_VACANCY = "DELETE FROM vacancies WHERE idvacancies = ?";
	/**
	 * Field for delete all from {@link RespondVacancy} by
	 * {@link RespondVacancy#idVacancy}
	 */
	private final String DELETE_RESPONDED_BY_ID_VACANCY = "DELETE FROM vacancyresponded WHERE idVacancy = ?";
	/**
	 * Field for search all from {@link RespondVacancy} by
	 * {@link RespondVacancy#idVacancy}
	 */
	private final String SEARCH_RESPONDED_BY_ID_VACANCY = "SELECT * FROM vacancyresponded WHERE idVacancy = ?";
	/** Field for delete all from {@link User} by {@link User#userId} */
	private final String SEARCH_ALL_USERS_BY_ID_USER = "SELECT * FROM users  WHERE userId = ?";

	public DaoHrImpl() {
	}

	@Override
	public Vacancy addDriverVacancy(final List<String> params) throws DaoException {

		String professionByLocal = null;
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

		professionByLocal = params.get(0);
		companyName = params.get(1);
		experience = params.get(2);
		salary = params.get(3);
		goods = params.get(4);
		dlCategory = params.get(5);
		whoAddedId = params.get(6);

		try {

			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement(ADD_DRIVER_VACANCY);
			preparedStatement.setString(1, professionByLocal);
			preparedStatement.setString(2, companyName);
			preparedStatement.setString(3, experience);
			preparedStatement.setString(4, salary);
			preparedStatement.setString(5, goods);
			preparedStatement.setString(6, dlCategory);
			preparedStatement.setInt(7, Integer.parseInt(whoAddedId));
			preparedStatement.executeUpdate();

			vacancy = new VacancyBuilder().professionName(professionByLocal).companyName(companyName)
					.experience(experience).salary(Integer.parseInt(salary)).goods(goods).dlCategory(dlCategory)
					.whoAddedId(Integer.parseInt(whoAddedId)).build();

		} catch (InterruptedException e) {
			logger.error("DaoHrImpl: addDriverVacancy: Connection interrupted: " + e);
			throw new DaoException("addDriverVacancy" + e);
		} catch (SQLException e) {
			logger.error("DaoHrImpl: addDriverVacancy: SQL error: " + e);
			throw new DaoException("addDriverVacancy" + e);
		} finally {
			closeResources(result, preparedStatement, connection, "addDriverVacancy");
		}

		return vacancy;
	}

	@Override
	public Vacancy addAccountantVacancy(final List<String> params) throws DaoException {

		String professionByLocal = null;
		String companyName = null;
		String experience = null;
		String salary = null;
		String whoAddedId = null;
		Vacancy vacancy = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		professionByLocal = params.get(0);
		companyName = params.get(1);
		experience = params.get(2);
		salary = params.get(3);
		whoAddedId = params.get(4);

		try {

			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement(ADD_ACCOUNTANT_VACANCY);
			preparedStatement.setString(1, professionByLocal);
			preparedStatement.setString(2, companyName);
			preparedStatement.setString(3, experience);
			preparedStatement.setString(4, salary);
			preparedStatement.setInt(5, Integer.parseInt(whoAddedId));
			preparedStatement.executeUpdate();

			vacancy = new VacancyBuilder().professionName(professionByLocal).companyName(companyName)
					.experience(experience).salary(Integer.parseInt(salary)).whoAddedId(Integer.parseInt(whoAddedId))
					.build();

		} catch (InterruptedException e) {
			logger.error("DaoHrImpl: addAccountantVacancy: Connection interrupted: " + e);
			throw new DaoException("addAccountantVacancy" + e);
		} catch (SQLException e) {
			logger.error("DaoHrImpl: addAccountantVacancy: SQL error: " + e);
			throw new DaoException("addAccountantVacancy" + e);
		} finally {
			closeResources(result, preparedStatement, connection, "addAccountantVacancy");
		}

		return vacancy;
	}

	@Override
	public int getCountAllRowsForTable(final String tableName) throws DaoException {

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
			logger.error("DaoHrImpl: getCountAllRowsForTable: Connection interrupted: " + e);
			throw new DaoException("getCountAllRowsForTable" + e);
		} catch (SQLException e) {
			logger.error("DaoHrImpl: getCountAllRowsForTable: SQL error: " + e);
			throw new DaoException("getCountAllRowsForTable" + e);
		} finally {
			closeResources(result, preparedStatement, connection, "getCountAllRowsForTable");
		}

		return count;
	}

	@Override
	public List<Vacancy> searchVacancyByParam(final String... params) throws DaoException {

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
			preparedStatement = connection.prepareStatement(SEARCH_LIMIT_COUNT_VACANCY_BY_USER_ID);
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
			logger.error("DaoHrImpl: searchVacancyByParam: Connection interrupted: " + e);
			throw new DaoException("searchVacancyByParam" + e);
		} catch (SQLException e) {
			logger.error("DaoHrImpl: searchVacancyByParam: SQL error: " + e);
			throw new DaoException("searchVacancyByParam" + e);
		} finally {
			closeResources(result, preparedStatement, connection, "searchVacancyByParam");
		}

		return allVacancy;
	}

	@Override
	public boolean deleteVacancyById(final int id) throws DaoException {

		boolean result = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {

			connection = connectionPool.takeConnection();
			connection.setAutoCommit(false);

			preparedStatement = connection.prepareStatement(DELETE_VACANCY_BY_ID_VACANCY);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			closePreparedStatement(preparedStatement, "deleteVacancyById");

			preparedStatement = connection.prepareStatement(DELETE_RESPONDED_BY_ID_VACANCY);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

			connection.commit();
			result = true;
		} catch (InterruptedException | SQLException e) {
			try {
				logger.error("DaoHrImpl: deleteVacancyById: transaction error" + e);
				connection.rollback();
				throw new DaoException("deleteVacancyById: transaction error " + e);
			} catch (SQLException e1) {
				logger.error("DaoHrImpl: deleteVacancyById: rollback error: " + e);
				throw new DaoException("deleteVacancyById:rollback error: " + e1);
			}
		} finally {
			closeResources(null, preparedStatement, connection, "deleteVacancyById");
		}

		return result;
	}

	@Override
	public List<Resume> searchResumeByParam(final String... params) throws DaoException {

		String limiLine = null;
		String offsetLine = null;
		List<Resume> allResume = null;
		Resume resume = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		limiLine = params[0];
		offsetLine = params[1];
		allResume = new ArrayList<>();

		try {

			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement(SEARCH_LIMIT_COUNT_RESUME);
			preparedStatement.setInt(1, Integer.parseInt(offsetLine));
			preparedStatement.setInt(2, Integer.parseInt(limiLine));
			result = preparedStatement.executeQuery();

			while (result.next()) {
				resume = new ResumeBuilder().id(result.getInt(1)).name(result.getString(2)).surName(result.getString(3))
						.email(result.getString(4)).registrationDate(result.getDate(5)).birthDayDate(result.getDate(6))
						.phone(result.getString(7)).residence(result.getString(8)).workSpeciality(result.getString(9))
						.workExpirience(result.getString(10)).education(result.getString(11))
						.photoPath(result.getString(12)).aboutUser(result.getString(13)).idUser(result.getInt(14))
						.build();
				allResume.add(resume);
			}

		} catch (InterruptedException e) {
			logger.error("DaoHrImpl: searchResumeByParam: Connection interrupted: " + e);
			throw new DaoException("searchResumeByParam" + e);
		} catch (SQLException e) {
			logger.error("DaoHrImpl: searchResumeByParam: SQL error: " + e);
			throw new DaoException("searchResumeByParam" + e);
		} finally {
			closeResources(result, preparedStatement, connection, "searchResumeByParam");
		}

		return allResume;
	}

	@Override
	public List<User> searchRespondedUserByIdVacancy(final int idVacancy) throws DaoException {

		User user = null;
		List<User> allUsers = new ArrayList<>();
		List<Integer> allUsersID = new ArrayList<>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		try {

			connection = connectionPool.takeConnection();
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(SEARCH_RESPONDED_BY_ID_VACANCY);
			preparedStatement.setInt(1, idVacancy);
			result = preparedStatement.executeQuery();

			while (result.next()) {
				allUsersID.add(result.getInt(3));
			}
			closePreparedStatement(preparedStatement, "searchRespondedUserByIdVacancy");

			for (Integer integer : allUsersID) {
				preparedStatement = connection.prepareStatement(SEARCH_ALL_USERS_BY_ID_USER);
				preparedStatement.setInt(1, integer);
				result = preparedStatement.executeQuery();

				while (result.next()) {
					user = new UserBuilder().userId(Integer.parseInt(result.getString(1))).name(result.getString(2))
							.surName(result.getString(3)).nickName(result.getString(4)).email(result.getString(5))
							.avaliable(result.getInt(6)).profileId(Integer.parseInt(result.getString(7)))
							.resumeId(result.getInt(8)).role(result.getString(9)).build();
					allUsers.add(user);
				}
			}

			connection.commit();
		} catch (InterruptedException | SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				logger.error("DaoHrImpl: searchRespondedUserByIdVacancy: rollback error: " + e);
			}
			logger.error("DaoHrImpl: searchRespondedUserByIdVacancy: " + e);
			throw new DaoException("searchRespondedUserByIdVacancy" + e);
		} finally {
			closeResources(result, preparedStatement, connection, "searchRespondedUserByIdVacancy");
		}
		return allUsers;
	}

	@Override
	public List<String> searchRespondedOnVacancy() throws DaoException {
		List<String> allRespondedId = new ArrayList<>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		try {
			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement(SEARCH_ALL_RESPONDED_ON_VACANCY);
			result = preparedStatement.executeQuery();

			while (result.next()) {
				allRespondedId.add(result.getString(2));
			}

		} catch (InterruptedException e) {
			logger.error("DaoHrImpl: searchRespondedOnVacancy: Connection interrupted: " + e);
			throw new DaoException("searchRespondedOnVacancy" + e);
		} catch (SQLException e) {
			logger.error("DaoHrImpl: searchRespondedOnVacancy: SQL error: " + e);
			throw new DaoException("searchRespondedOnVacancy" + e);
		} finally {
			closeResources(result, preparedStatement, connection, "searchRespondedOnVacancy");
		}

		return allRespondedId;
	}

	/**
	 * method which close all got resources
	 */
	private void closeResources(final ResultSet resultSet, final PreparedStatement preparedStatement,
			final Connection connection, String methodName) {

		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			connection.close();

		} catch (Exception e) {
			logger.error("DaoHrImpl: " + methodName + ": " + e);
		}
	}

	/**
	 * method which close all got resources
	 */
	private void closePreparedStatement(final PreparedStatement preparedStatement, final String methodName) {
		try {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
		} catch (Exception e) {
			logger.error("DaoHrImpl: " + methodName + ": " + e);
		}
	}
}
