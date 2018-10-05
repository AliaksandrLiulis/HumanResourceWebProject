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
import by.htp.project.human_resource.dao.dao_interface.IDAOJobSeeker;
import by.htp.project.human_resource.entity.Profile;
import by.htp.project.human_resource.entity.ProfileBuilder;
import by.htp.project.human_resource.entity.User;
import by.htp.project.human_resource.entity.UserBuilder;
import by.htp.project.human_resource.entity.Vacancy;
import by.htp.project.human_resource.entity.VacancyBuilder;
import by.htp.project.human_resource.util.poolconnection.ConnectionPool;

/**
 * Class which has methods for work with Users which have role JobSeeker
 */

public class DaoJobSeekerImpl implements IDAOJobSeeker {

	/** Field for logging {@link LoggerFactory} */
	private static final Logger logger = LoggerFactory.getLogger(DaoJobSeekerImpl.class);
	/** Field for ConnectionPool */
	private ConnectionPool connectionPool = ConnectionPool.getInstance();

	public DaoJobSeekerImpl() {
	}

	/** Field for adds new {@link Profile} */
	private final String ADD_NEW_PROFILE = "INSERT INTO profile (registrationDate ,birthDayDate, phone, residence, workSpeciality, workExpirience, education, photoPath, aboutUser, idUser ) VALUES (?,?,?,?,?,?,?,?,?,?)";
	/** Field for adds new {@link Profile#profileId} by {@link User#userId} */
	private final String SEARCH_ID_PROFILE_BY_ID_USER = "SELECT idprofile FROM profile WHERE profile.idUser = ?";
	/** Field for sets {@link Profile#profileId} by {@link User#userId} */
	private final String SET_ID_PROFILE_FOR_USER = "UPDATE users SET profileId=? WHERE userId=?";
	/** Field for searches {@link User} by {@link User#userId} */
	private final String SEARCH_USER_BY_ID_USER = "SELECT userId, name, surName, nickName, email, avaliable, profileId, resumeId, role FROM users JOIN userroles ON users.roleId = userroles.rolesId WHERE users.userId = ?";
	/** Field for searches {@link Profile} by {@link User#userId} */
	private final String SEARCH_EXIST_PROFILE_BY_ID_USER = "SELECT * FROM profile WHERE idUser = ?";
	/** Field for delete {@link Profile} by {@link User#userId} */
	private final String DELETE_PROFILE_BY_ID_USER = "DELETE FROM profile WHERE idUser = ?";
	/**
	 * Field for update {@link Profile#profileId} and {@link Resume#id} in Users by
	 * {@link User#userId}
	 */
	private final String UPDATE_ID_PROFILE_AND_ID_RESUME_FOR_USER_BY_USER_ID = "UPDATE users  SET profileId=? , resumeId=? WHERE userId=?";
	/** Field for update {@link Profile} by {@link User#userId} */
	private final String UPDATE_OLD_PROFILE_BY_ID_USER = "UPDATE profile SET registrationDate = ?, birthDayDate = ?,phone = ?, residence = ?, workSpeciality = ?, workExpirience = ?, education = ?, photoPath = ?, aboutUser = ? WHERE idUser = ?";
	/** Field for adds new {@link Resume} */
	private final String ADD_NEW_RESUME = "INSERT INTO resume (name, surName, email, registrationDate, birthDayDate, phone,residence, workSpeciality, workExpirience, education, photoPath, aboutUser, idUser) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
	/** Field for searches {@link Resume.id} by {@link User#userId} */
	private final String SEARCH_ID_RESUME_BY_ID_USER = "SELECT idresume FROM resume WHERE resume.idUser = ?";
	/** Field for searches {@link Resume.id} for Users table */
	private final String SET_ID_RESUME_FOR_USER = "UPDATE users SET resumeId=? WHERE userId=?";
	/** Field for delete {@link Resume} by {@link User#userId} */
	private final String DELETE_RESUME_BY_ID_USER = "DELETE FROM resume WHERE idUser = ?";
	/** Field for update {@link Resume#id} for users by {@link User#userId} */
	private final String UPDATE_ID_RESUME_FOR_USER_BY_ID_USER = "UPDATE users  SET resumeId=? WHERE userId=?";
	/** Field for update {@link Resume} by {@link User#userId} */
	private final String UPDATE_OLD_RESUME_BY_ID_USER = "UPDATE resume SET birthDayDate = ?, phone = ?, residence = ?, workSpeciality = ?, workExpirience = ?, education = ?, photoPath = ?, aboutUser = ? WHERE idUser = ?";
	/** Field for search all count {@link Vacancy} */
	private final String SEARCH_LIMIT_COUNT_VACANCY = "SELECT * FROM vacancies LIMIT ?, ?";
	/** Field for searches all {@link RespondVacancy} by {@link User#userId} */
	private final String SEARCH_RESPONDED_ON_VACANCY_BY_ID_USER = "SELECT * FROM vacancyresponded WHERE idResponded = ?";
	/** Field for inserts into {@link RespondVacancy} */
	private final String ADD_RESPONDED_ON_VACANCY = "INSERT INTO vacancyresponded (idVacancy, idResponded ) VALUES (?,?)";
	/**
	 * Field for delete all {@link RespondVacancy} by
	 * {@link RespondVacancy#idVacancy} and {@link RespondVacancy#idResponded}
	 */
	private final String DELETE_RESPONDED_VACANCY_BY_ID_VACANCY_AND_ID_USER = "DELETE FROM vacancyresponded WHERE idVacancy = ? AND idResponded = ?";

	@Override
	public List<Object> addNewProfile(final String... profileParams) throws DaoException {

		String registrationDate = null;
		String birthDayDate = null;
		String phone = null;
		String residence = null;
		String workSpeciality = null;
		String workExpirience = null;
		String education = null;
		String photoPath = null;
		String aboutUser = null;
		String idUser = null;
		List<Object> resultList = null;
		int profileId = 0;
		User user = null;

		Profile profile = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		idUser = profileParams[0];
		registrationDate = profileParams[1];
		photoPath = profileParams[2];
		phone = profileParams[3];
		birthDayDate = profileParams[4];
		residence = profileParams[5];
		workSpeciality = profileParams[6];
		workExpirience = profileParams[7];
		education = profileParams[8];
		aboutUser = profileParams[9];
		resultList = new ArrayList<>();
		int userId = Integer.parseInt(idUser);

		try {

			connection = connectionPool.takeConnection();
			connection.setAutoCommit(false);

			preparedStatement = connection.prepareStatement(ADD_NEW_PROFILE);
			preparedStatement.setString(1, registrationDate);
			preparedStatement.setString(2, birthDayDate);
			preparedStatement.setString(3, phone);
			preparedStatement.setString(4, residence);
			preparedStatement.setString(5, workSpeciality);
			preparedStatement.setString(6, workExpirience);
			preparedStatement.setString(7, education);
			preparedStatement.setString(8, photoPath);
			preparedStatement.setString(9, aboutUser);
			preparedStatement.setInt(10, userId);
			preparedStatement.executeUpdate();
			closePreparedStatement(preparedStatement, "addNewProfile");

			preparedStatement = connection.prepareStatement(SEARCH_ID_PROFILE_BY_ID_USER);
			preparedStatement.setInt(1, userId);
			result = preparedStatement.executeQuery();

			while (result.next()) {
				profileId = (result.getInt(1));
			}

			preparedStatement = connection.prepareStatement(SET_ID_PROFILE_FOR_USER);
			preparedStatement.setInt(1, profileId);
			preparedStatement.setInt(2, userId);
			preparedStatement.executeUpdate();
			closePreparedStatementAndResultSet(preparedStatement, result, "addNewProfile");

			preparedStatement = connection.prepareStatement(SEARCH_USER_BY_ID_USER);
			preparedStatement.setInt(1, userId);
			result = preparedStatement.executeQuery();

			while (result.next()) {
				user = new UserBuilder().userId(Integer.parseInt(result.getString(1))).name(result.getString(2))
						.surName(result.getString(3)).nickName(result.getString(4)).email(result.getString(5))
						.avaliable(result.getInt(6)).profileId(Integer.parseInt(result.getString(7)))
						.resumeId(result.getInt(8)).role(result.getString(9)).build();
			}

			connection.commit();
			profile = searchProfileByIdUser(userId);
			resultList.add(user);
			resultList.add(profile);

		} catch (InterruptedException | SQLException e) {
			try {
				logger.error("DaoJobSeekerImpl: addNewProfile: transaction error: ", e);
				connection.rollback();
				throw new DaoException("addNewProfile: transaction error: ", e);
			} catch (SQLException e1) {
				logger.error("DaoJobSeekerImpl: addNewProfile: rollback error: ", e1);
				throw new DaoException("addNewProfile: rollback error: ", e1);
			}
		} finally {
			closeResources(result, preparedStatement, connection, "addNewProfile");
		}
		return resultList;
	}

	@Override
	public User removeProfileByUserId(int userId) throws DaoException {

		User user = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		try {

			connection = connectionPool.takeConnection();
			connection.setAutoCommit(false);

			preparedStatement = connection.prepareStatement(DELETE_PROFILE_BY_ID_USER);
			preparedStatement.setInt(1, userId);
			preparedStatement.executeUpdate();
			closePreparedStatement(preparedStatement, "removeProfileByUserId");

			preparedStatement = connection.prepareStatement(DELETE_RESUME_BY_ID_USER);
			preparedStatement.setInt(1, userId);
			preparedStatement.executeUpdate();
			closePreparedStatement(preparedStatement, "removeProfileByUserId");

			updateFieldUserByIdUser(userId);

			preparedStatement = connection.prepareStatement(SEARCH_USER_BY_ID_USER);
			preparedStatement.setInt(1, userId);
			result = preparedStatement.executeQuery();

			while (result.next()) {

				user = new UserBuilder().userId(Integer.parseInt(result.getString(1))).name(result.getString(2))
						.surName(result.getString(3)).nickName(result.getString(4)).email(result.getString(5))
						.avaliable(result.getInt(6)).profileId(Integer.parseInt(result.getString(7)))
						.resumeId(result.getInt(8)).role(result.getString(9)).build();
			}

			connection.commit();

		} catch (InterruptedException | SQLException e) {
			try {
				logger.error("DaoJobSeekerImpl: removeProfileByUserId: transaction error: ", e);
				connection.rollback();
				throw new DaoException("removeProfileByUserId: transaction error: ", e);
			} catch (SQLException e1) {
				logger.error("DaoJobSeekerImpl: removeProfileByUserId: rollback error: ", e1);
				throw new DaoException("removeProfileByUserId: rollback error: ", e1);
			}
		} finally {
			closeResources(result, preparedStatement, connection, "removeProfileByUserId");
		}

		return user;
	}

	@Override
	public Profile updateOldProfileByParams(final String... profileParams) throws DaoException {

		String registrationDate = null;
		String birthDayDate = null;
		String phone = null;
		String residence = null;
		String workSpeciality = null;
		String workExpirience = null;
		String education = null;
		String photoPath = null;
		String aboutUser = null;
		String idUser = null;
		Profile profile = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		idUser = profileParams[0];
		registrationDate = profileParams[1];
		photoPath = profileParams[2];
		phone = profileParams[3];
		birthDayDate = profileParams[4];
		residence = profileParams[5];
		workSpeciality = profileParams[6];
		workExpirience = profileParams[7];
		education = profileParams[8];
		aboutUser = profileParams[9];
		int userId = Integer.parseInt(idUser);

		try {

			connection = connectionPool.takeConnection();
			connection.setAutoCommit(false);

			preparedStatement = connection.prepareStatement(UPDATE_OLD_PROFILE_BY_ID_USER);
			preparedStatement.setString(1, registrationDate);
			preparedStatement.setString(2, birthDayDate);
			preparedStatement.setString(3, phone);
			preparedStatement.setString(4, residence);
			preparedStatement.setString(5, workSpeciality);
			preparedStatement.setString(6, workExpirience);
			preparedStatement.setString(7, education);
			preparedStatement.setString(8, photoPath);
			preparedStatement.setString(9, aboutUser);
			preparedStatement.setInt(10, userId);
			preparedStatement.executeUpdate();
			closePreparedStatement(preparedStatement, "updateOldProfileByParams");

			preparedStatement = connection.prepareStatement(UPDATE_OLD_RESUME_BY_ID_USER);
			preparedStatement.setString(1, birthDayDate);
			preparedStatement.setString(2, phone);
			preparedStatement.setString(3, residence);
			preparedStatement.setString(4, workSpeciality);
			preparedStatement.setString(5, workExpirience);
			preparedStatement.setString(6, education);
			preparedStatement.setString(7, photoPath);
			preparedStatement.setString(8, aboutUser);
			preparedStatement.setInt(9, userId);
			preparedStatement.executeUpdate();

			connection.commit();
			profile = searchProfileByIdUser(userId);

		} catch (InterruptedException | SQLException e) {
			try {
				logger.error("DaoJobSeekerImpl: updateOldProfileByParams: transaction error: ", e);
				connection.rollback();
				throw new DaoException("updateOldProfileByParams: transaction error: ", e);
			} catch (SQLException e1) {
				logger.error("DaoJobSeekerImpl: updateOldProfileByParams: rollback error: ", e1);
				throw new DaoException("updateOldProfileByParams: rollback error: ", e1);
			}
		} finally {
			closeResources(result, preparedStatement, connection, "updateOldProfileByParams");
		}
		return profile;
	}

	@Override
	public User addNewResumeByParams(final String... resumeParams) throws DaoException {

		String name = null;
		String surName = null;
		String email = null;
		String registrationDate = null;
		String birthDayDate = null;
		String phone = null;
		String residence = null;
		String workSpeciality = null;
		String workExpirience = null;
		String education = null;
		String photoPath = null;
		String aboutUser = null;
		String idUser = null;
		int resumeId = 0;
		User user = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		name = resumeParams[0];
		surName = resumeParams[1];
		email = resumeParams[2];
		registrationDate = resumeParams[3];
		birthDayDate = resumeParams[4];
		phone = resumeParams[5];
		residence = resumeParams[6];
		workSpeciality = resumeParams[7];
		workExpirience = resumeParams[8];
		education = resumeParams[9];
		photoPath = resumeParams[10];
		aboutUser = resumeParams[11];
		idUser = resumeParams[12];

		try {

			connection = connectionPool.takeConnection();
			connection.setAutoCommit(false);

			preparedStatement = connection.prepareStatement(ADD_NEW_RESUME);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, surName);
			preparedStatement.setString(3, email);
			preparedStatement.setString(4, registrationDate);
			preparedStatement.setString(5, birthDayDate);
			preparedStatement.setString(6, phone);
			preparedStatement.setString(7, residence);
			preparedStatement.setString(8, workSpeciality);
			preparedStatement.setString(9, workExpirience);
			preparedStatement.setString(10, education);
			preparedStatement.setString(11, photoPath);
			preparedStatement.setString(12, aboutUser);
			preparedStatement.setInt(13, Integer.parseInt(idUser));
			preparedStatement.executeUpdate();
			closePreparedStatement(preparedStatement, "addNewResumeByParams");

			preparedStatement = connection.prepareStatement(SEARCH_ID_RESUME_BY_ID_USER);
			preparedStatement.setInt(1, Integer.parseInt(idUser));
			result = preparedStatement.executeQuery();

			while (result.next()) {
				resumeId = (result.getInt(1));
			}
			closePreparedStatementAndResultSet(preparedStatement, result, "addNewResumeByParams");

			preparedStatement = connection.prepareStatement(SET_ID_RESUME_FOR_USER);
			preparedStatement.setInt(1, resumeId);
			preparedStatement.setInt(2, Integer.parseInt(idUser));
			preparedStatement.executeUpdate();
			closePreparedStatement(preparedStatement, "addNewResumeByParams");

			preparedStatement = connection.prepareStatement(SEARCH_USER_BY_ID_USER);
			preparedStatement.setInt(1, Integer.parseInt(idUser));
			result = preparedStatement.executeQuery();

			while (result.next()) {
				user = new UserBuilder().userId(Integer.parseInt(result.getString(1))).name(result.getString(2))
						.surName(result.getString(3)).nickName(result.getString(4)).email(result.getString(5))
						.avaliable(result.getInt(6)).profileId(Integer.parseInt(result.getString(7)))
						.resumeId(result.getInt(8)).role(result.getString(9)).build();

			}

			connection.commit();

		} catch (InterruptedException | SQLException e) {
			try {
				logger.error("DaoJobSeekerImpl: addNewResumeByParams: transaction error: ", e);
				connection.rollback();
				throw new DaoException("addNewResumeByParams: transaction error: ", e);
			} catch (SQLException e1) {
				logger.error("DaoJobSeekerImpl: addNewResumeByParams: rollback error: ", e1);
				throw new DaoException("addNewResumeByParams: rollback error: ", e1);
			}
		} finally {
			closeResources(result, preparedStatement, connection, "addNewResumeByParams");
		}
		return user;

	}

	@Override
	public User deleteResumeByIdUser(final int idUserResume) throws DaoException {

		User user = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		try {

			connection = connectionPool.takeConnection();
			connection.setAutoCommit(false);

			preparedStatement = connection.prepareStatement(DELETE_RESUME_BY_ID_USER);
			preparedStatement.setInt(1, idUserResume);
			preparedStatement.executeUpdate();
			closePreparedStatement(preparedStatement, "deleteResumeByIdUser");

			preparedStatement = connection.prepareStatement(UPDATE_ID_RESUME_FOR_USER_BY_ID_USER);
			preparedStatement.setInt(1, 0);
			preparedStatement.setInt(2, idUserResume);
			preparedStatement.executeUpdate();
			closePreparedStatement(preparedStatement, "deleteResumeByIdUser");

			preparedStatement = connection.prepareStatement(SEARCH_USER_BY_ID_USER);
			preparedStatement.setInt(1, idUserResume);
			result = preparedStatement.executeQuery();

			while (result.next()) {
				user = new UserBuilder().userId(Integer.parseInt(result.getString(1))).name(result.getString(2))
						.surName(result.getString(3)).nickName(result.getString(4)).email(result.getString(5))
						.avaliable(result.getInt(6)).profileId(Integer.parseInt(result.getString(7)))
						.resumeId(result.getInt(8)).role(result.getString(9)).build();

			}

			connection.commit();

		} catch (InterruptedException | SQLException e) {
			try {
				logger.error("DaoJobSeekerImpl: deleteResumeByIdUser: transaction error: " + e);
				connection.rollback();
				throw new DaoException("deleteResumeByIdUser: transaction error: " + e);
			} catch (SQLException e1) {
				logger.error("DaoJobSeekerImpl: deleteResumeByIdUser: rollback error: " + e1);
				throw new DaoException("deleteResumeByIdUser: rollback error: " + e1);
			}
		} finally {
			closeResources(result, preparedStatement, connection, "deleteResumeByIdUser");
		}
		return user;
	}

	private Profile searchProfileByIdUser(final int idUser) throws DaoException {

		Profile profile = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		try {

			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement(SEARCH_EXIST_PROFILE_BY_ID_USER);
			preparedStatement.setInt(1, idUser);
			result = preparedStatement.executeQuery();

			while (result.next()) {

				profile = new ProfileBuilder().profileId(result.getInt(1)).registrationDate(result.getDate(2))
						.birthDayDate(result.getDate(3)).phone(result.getString(4)).residence(result.getString(5))
						.workSpeciality(result.getString(6)).workExpirience(result.getString(7))
						.education(result.getString(8)).photoPath(result.getString(9)).aboutUser(result.getString(10))
						.build();
			}

		} catch (InterruptedException e) {
			logger.error("DaoJobSeekerImpl: DaoJobSeekerImpl: Connection interrupted: ", e);
			throw new DaoException("searchProfileByIdUser", e);
		} catch (SQLException e) {
			logger.error("DaoJobSeekerImpl: DaoJobSeekerImpl: SQL error: ", e);
			throw new DaoException("searchProfileByIdUser", e);
		} finally {
			closeResources(result, preparedStatement, connection, "DaoJobSeekerImpl");
		}

		return profile;
	}

	private void updateFieldUserByIdUser(final int idUser) throws DaoException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {

			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement(UPDATE_ID_PROFILE_AND_ID_RESUME_FOR_USER_BY_USER_ID);
			preparedStatement.setInt(1, 0);
			preparedStatement.setInt(2, 0);
			preparedStatement.setInt(3, idUser);
			preparedStatement.executeUpdate();

		} catch (InterruptedException e) {
			logger.error("DaoJobSeekerImpl: updateFieldUserByIdUser: Connection interrupted: ", e);
			throw new DaoException("updateFieldUserByIdUser", e);
		} catch (SQLException e) {
			logger.error("DaoJobSeekerImpl: updateFieldUserByIdUser: SQL error: ", e);
			throw new DaoException("updateFieldUserByIdUser", e);
		} finally {
			closeResources(null, preparedStatement, connection, "updateFieldUserByIdUser");
		}
	}

	@Override
	public List<Vacancy> searchVacancyByParam(final String... params) throws DaoException {

		String limiLine = null;
		String offsetLine = null;
		List<Vacancy> allVacancy = null;
		Vacancy vacancy;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		limiLine = params[0];
		offsetLine = params[1];
		allVacancy = new ArrayList<>();

		try {

			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement(SEARCH_LIMIT_COUNT_VACANCY);
			preparedStatement.setInt(1, Integer.parseInt(offsetLine));
			preparedStatement.setInt(2, Integer.parseInt(limiLine));
			result = preparedStatement.executeQuery();

			while (result.next()) {
				vacancy = new VacancyBuilder().idvacancy(result.getInt(1)).professionName(result.getString(2))
						.companyName(result.getString(3)).experience(result.getString(4)).salary(result.getInt(5))
						.goods(result.getString(6)).dlCategory(result.getString(7)).whoAddedId(result.getInt(8))
						.build();

				allVacancy.add(vacancy);

			}
		} catch (InterruptedException e) {
			logger.error("DaoJobSeekerImpl: searchVacancyByParam: Connection interrupted: ", e);
			throw new DaoException("searchVacancyByParam", e);
		} catch (SQLException e) {
			logger.error("DaoJobSeekerImpl: searchVacancyByParam: SQL error: ", e);
			throw new DaoException("searchVacancyByParam", e);
		} finally {
			closeResources(null, preparedStatement, connection, "searchVacancyByParam");
		}
		return allVacancy;
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
			logger.error("DaoJobSeekerImpl: getCountAllRowsForTable: Connection interrupted: ", e);
			throw new DaoException("getCountAllRowsForTable", e);
		} catch (SQLException e) {
			logger.error("DaoJobSeekerImpl: getCountAllRowsForTable: SQL error: ", e);
			throw new DaoException("getCountAllRowsForTable", e);
		} finally {
			closeResources(result, preparedStatement, connection, "getCountAllRowsForTable");
		}

		return count;
	}

	@Override
	public boolean updateVacancyWhenRespondAndAddInTable(int userId, int vacancyId) throws DaoException {

		boolean result = false;

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = connectionPool.takeConnection();

			preparedStatement = connection.prepareStatement(ADD_RESPONDED_ON_VACANCY);
			preparedStatement.setInt(1, vacancyId);
			preparedStatement.setInt(2, userId);
			preparedStatement.executeUpdate();

			result = true;

		} catch (InterruptedException e) {
			logger.error("DaoJobSeekerImpl: updateVacancyWhenRespondAndAddInTable: Connection interrupted: ", e);
			throw new DaoException("updateVacancyWhenRespondAndAddInTable", e);
		} catch (SQLException e) {
			logger.error("DaoJobSeekerImpl: updateVacancyWhenRespondAndAddInTable: SQL error: ", e);
			throw new DaoException("updateVacancyWhenRespondAndAddInTable", e);
		} finally {
			closeResources(null, preparedStatement, connection, "updateVacancyWhenRespondAndAddInTable");
		}

		return result;
	}

	@Override
	public boolean updateVacancyWhenRespondAndDeleteInTable(int userId, int vacancyId) throws DaoException {

		boolean result = false;

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {

			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement(DELETE_RESPONDED_VACANCY_BY_ID_VACANCY_AND_ID_USER);
			preparedStatement.setInt(1, vacancyId);
			preparedStatement.setInt(2, userId);
			preparedStatement.executeUpdate();

			result = true;

		} catch (InterruptedException e) {
			logger.error("DaoJobSeekerImpl: updateVacancyWhenRespondAndDeleteInTable: Connection interrupted: ", e);
			throw new DaoException("updateVacancyWhenRespondAndDeleteInTable", e);
		} catch (SQLException e) {
			logger.error("DaoJobSeekerImpl: updateVacancyWhenRespondAndDeleteInTable: SQL error: ", e);
			throw new DaoException("updateVacancyWhenRespondAndDeleteInTable", e);
		} finally {
			closeResources(null, preparedStatement, connection, "updateVacancyWhenRespondAndDeleteInTable");
		}

		return result;
	}

	@Override
	public List<String> searchRespondVacancyByUserId(int userId) throws DaoException {

		List<String> respondVacancies = new ArrayList<>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = connectionPool.takeConnection();

			preparedStatement = connection.prepareStatement(SEARCH_RESPONDED_ON_VACANCY_BY_ID_USER);
			preparedStatement.setInt(1, userId);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				respondVacancies.add(resultSet.getString(2));
			}

		} catch (InterruptedException e) {
			logger.error("DaoJobSeekerImpl: searchRespondVacancyByUserId: Connection interrupted: ", e);
			throw new DaoException("searchRespondVacancyByUserId", e);
		} catch (SQLException e) {
			logger.error("DaoJobSeekerImpl: searchRespondVacancyByUserId: SQL error: ", e);
			throw new DaoException("searchRespondVacancyByUserId", e);
		} finally {
			closeResources(resultSet, preparedStatement, connection, "searchRespondVacancyByUserId");
		}

		return respondVacancies;
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
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			logger.error("DaoJobSeekerImpl: " + methodName + ": ", e);
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
			logger.error("DaoJobSeekerImpl: " + methodName + ": ", e);
			throw new DaoException(e);
		}
	}

	/**
	 * method which close all got resources
	 * 
	 * @throws DaoException
	 */
	private void closePreparedStatementAndResultSet(final PreparedStatement preparedStatement,
			final ResultSet resultSet, final String methodName) throws DaoException {

		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
		} catch (SQLException e) {
			logger.error("DaoJobSeekerImpl: " + methodName + ": ", e);
			throw new DaoException(e);
		}
	}
}
