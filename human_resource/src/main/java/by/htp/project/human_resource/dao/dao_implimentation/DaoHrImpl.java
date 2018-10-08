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
	private static final Logger logger = LoggerFactory.getLogger(DaoHrImpl.class);
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

	/** fields for userId */
	private final int userId = 1;
	/** fields for name */
	private final int name = 2;
	/** fields for surName */
	private final int surName = 3;
	/** fields for nickName */
	private final int nickName = 4;
	/** fields for email */
	private final int email = 5;
	/** fields for available */
	private final int available = 6;
	/** fields for profileId */
	private final int profileId = 7;
	/** fields for resumeId */
	private final int resumeId = 8;
	/** fields for role */
	private final int role = 9;

	/** fields for resume userId */
	private final int resumeIdResume = 1;
	/** fields for resume name */
	private final int resumeName = 2;
	/** fields for resume surName */
	private final int resumeSurName = 3;
	/** fields for resume email */
	private final int resumeEmail = 4;
	/** fields for resume registration date */
	private final int resumeRegistrationDate = 5;
	/** fields for resume birthday date */
	private final int resumeBirthDayDate = 6;
	/** fields for resume phone */
	private final int resumePhone = 7;
	/** fields for resume residence */
	private final int resumeResidence = 8;
	/** fields for resume work speciality */
	private final int resumeWorkSpeciality = 9;
	/** fields for resume work expirience */
	private final int resumeWorkExpirience = 10;
	/** fields for resume education */
	private final int resumeEducation = 11;
	/** fields for resume photoPath */
	private final int resumePhotoPath = 12;
	/** fields for resume about User */
	private final int resumeAboutUser = 13;
	/** fields for resume IdUser */
	private final int resumeIdUser = 14;

	/** fields for vacancyId vacancy */
	private final int vacancyIdvacancy = 1;
	/** fields for vacancy profession name */
	private final int vacancyProfessionName = 2;
	/** fields for vacancy company name */
	private final int vacancyCompanyName = 3;
	/** fields for vacancy experience */
	private final int vacancyExperience = 4;
	/** fields for vacancy salary */
	private final int vacancySalary = 5;
	/** fields for vacancy goods */
	private final int vacancyGoods = 6;
	/** fields for vacancy dl category */
	private final int vacancyDLCategory = 7;
	/** fields for vacancy who added */
	private final int vacancyWhoAddedId = 8;

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
			logger.error("DaoHrImpl: addDriverVacancy: Connection interrupted: ", e);
			throw new DaoException("addDriverVacancy", e);
		} catch (SQLException e) {
			logger.error("DaoHrImpl: addDriverVacancy: SQL error: ", e);
			throw new DaoException("addDriverVacancy", e);
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
			logger.error("DaoHrImpl: addAccountantVacancy: Connection interrupted: ", e);
			throw new DaoException("addAccountantVacancy", e);
		} catch (SQLException e) {
			logger.error("DaoHrImpl: addAccountantVacancy: SQL error: ", e);
			throw new DaoException("addAccountantVacancy", e);
		} finally {
			closeResources(result, preparedStatement, connection, "addAccountantVacancy");
		}

		return vacancy;
	}

	@Override
	public int getCountAllRowsForTable(final String tableName, final int whoAddeId) throws DaoException {

		int count = 0;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		try {

			connection = connectionPool.takeConnection();

			if (whoAddeId == 0) {
				preparedStatement = connection.prepareStatement("SELECT count(*) FROM " + tableName);
			} else {
				preparedStatement = connection
						.prepareStatement("SELECT count(*) FROM " + tableName + " where whoAddedId = ?");
				preparedStatement.setInt(1, whoAddeId);
			}

			result = preparedStatement.executeQuery();

			while (result.next()) {
				count = result.getInt(1);
			}

		} catch (InterruptedException e) {
			logger.error("DaoHrImpl: getCountAllRowsForTable: Connection interrupted: ", e);
			throw new DaoException("getCountAllRowsForTable", e);
		} catch (SQLException e) {
			logger.error("DaoHrImpl: getCountAllRowsForTable: SQL error: ", e);
			throw new DaoException("getCountAllRowsForTable", e);
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
				vacancy = new VacancyBuilder().idvacancy(result.getInt(vacancyIdvacancy))
						.professionName(result.getString(vacancyProfessionName))
						.companyName(result.getString(vacancyCompanyName))
						.experience(result.getString(vacancyExperience)).salary(result.getInt(vacancySalary))
						.goods(result.getString(vacancyGoods)).dlCategory(result.getString(vacancyDLCategory))
						.whoAddedId(result.getInt(vacancyWhoAddedId)).build();
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
				logger.error("DaoHrImpl: deleteVacancyById: transaction error", e);
				if (connection != null) {
					connection.rollback();
				}
				throw new DaoException("deleteVacancyById: transaction error ", e);
			} catch (SQLException e1) {
				logger.error("DaoHrImpl: deleteVacancyById: rollback error: ", e1);
				throw new DaoException("deleteVacancyById:rollback error: ", e1);
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
				resume = new ResumeBuilder().id(result.getInt(resumeIdResume)).name(result.getString(resumeName))
						.surName(result.getString(resumeSurName)).email(result.getString(resumeEmail))
						.registrationDate(result.getDate(resumeRegistrationDate))
						.birthDayDate(result.getDate(resumeBirthDayDate)).phone(result.getString(resumePhone))
						.residence(result.getString(resumeResidence))
						.workSpeciality(result.getString(resumeWorkSpeciality))
						.workExpirience(result.getString(resumeWorkExpirience))
						.education(result.getString(resumeEducation)).photoPath(result.getString(resumePhotoPath))
						.aboutUser(result.getString(resumeAboutUser)).idUser(result.getInt(resumeIdUser)).build();
				allResume.add(resume);

			}

		} catch (InterruptedException e) {
			logger.error("DaoHrImpl: searchResumeByParam: Connection interrupted: ", e);
			throw new DaoException("searchResumeByParam", e);
		} catch (SQLException e) {
			logger.error("DaoHrImpl: searchResumeByParam: SQL error: ", e);
			throw new DaoException("searchResumeByParam", e);
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
					user = new UserBuilder().userId(Integer.parseInt(result.getString(userId)))
							.name(result.getString(name)).surName(result.getString(surName))
							.nickName(result.getString(nickName)).email(result.getString(email))
							.avaliable(result.getInt(available))
							.profileId(Integer.parseInt(result.getString(profileId))).resumeId(result.getInt(resumeId))
							.role(result.getString(role)).build();
					allUsers.add(user);
				}
				closePreparedStatement(preparedStatement, "searchRespondedUserByIdVacancy");
			}

			connection.commit();
		} catch (InterruptedException | SQLException e) {
			try {
				logger.error("DaoHrImpl: searchRespondedUserByIdVacancy: transaction error", e);
				if (connection != null) {
					connection.rollback();
				}
				throw new DaoException("searchRespondedUserByIdVacancy: transaction error ", e);
			} catch (SQLException e1) {
				logger.error("DaoHrImpl: searchRespondedUserByIdVacancy: rollback error: ", e1);
				throw new DaoException("searchRespondedUserByIdVacancy error: ", e1);
			} finally {
				closeResources(result, preparedStatement, connection, "searchRespondedUserByIdVacancy");
			}
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
			logger.error("DaoHrImpl: searchRespondedOnVacancy: Connection interrupted: ", e);
			throw new DaoException("searchRespondedOnVacancy", e);
		} catch (SQLException e) {
			logger.error("DaoHrImpl: searchRespondedOnVacancy: SQL error: ", e);
			throw new DaoException("searchRespondedOnVacancy", e);
		} finally {
			closeResources(result, preparedStatement, connection, "searchRespondedOnVacancy");
		}

		return allRespondedId;
	}

	/**
	 * method which close all got resources
	 * 
	 * @throws DaoException
	 */
	private void closeResources(final ResultSet resultSet, final PreparedStatement preparedStatement,
			final Connection connection, String methodName) throws DaoException {

		try {
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException e) {
			logger.error("DaoHrImpl: " + methodName + " resultSetError: ", e);
		}
		try {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
		} catch (SQLException e) {
			logger.error("DaoHrImpl: " + methodName + " preparedStatementError: ", e);
		}
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			logger.error("DaoHrImpl: " + methodName + " connectionError: ", e);
			throw new DaoException(e);
		}
	}

	/**
	 * method which close all got resources
	 * 
	 * @throws DaoException
	 */
	private void closePreparedStatement(final PreparedStatement preparedStatement, final String methodName)
			throws DaoException {
		try {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
		} catch (SQLException e) {
			logger.error("DaoHrImpl: " + methodName + "preparedStatementError: " + e);
			throw new DaoException(e);
		}
	}
}
