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
import by.htp.project.human_resource.dao.interf.IDAOJobSeeker;
import by.htp.project.human_resource.dao.poolconnection.ConnectionPool;
import by.htp.project.human_resource.entity.Profile;
import by.htp.project.human_resource.entity.ProfileBuilder;
import by.htp.project.human_resource.entity.User;
import by.htp.project.human_resource.entity.UserBuilder;

public class DaoJobSeekerImpl implements IDAOJobSeeker {

	private Logger logger = LoggerFactory.getLogger(DaoJobSeekerImpl.class);
	private ConnectionPool connectionPool = null;
	
	public DaoJobSeekerImpl() {
		if (null == connectionPool) {
			connectionPool = ConnectionPool.getInstance();
		}
	}

	private final String ADD_NEW_PROFILE = "INSERT into profile (registrationDate ,birthDayDate, phone, residence, workSpeciality, workExpirience, education, photoPath, aboutUser, idUser ) VALUES (?,?,?,?,?,?,?,?,?,?)";
	private final String SEARCH_PROFILE_ID = "SELECT idprofile from profile where profile.idUser = ?";
	private final String SET_ID_PROFILE_FOR_USER = "UPDATE users SET profileId=? where userId=?";
	private final String SEARCH_USER_BY_ID = "SELECT userId, name, surName, nickName, email, avaliable, profileId, resumeId, role FROM users JOIN userroles on users.roleId = userroles.rolesId where users.userId = ?";
	private final String SEARCH_EXIST_PROFILE = "SELECT * FROM profile where idUser = ?";
	private final String DELETE_PROFILE_BY_USER_ID = "DELETE FROM profile where idUser = ?";
	private final String UPDATE_PROFILE_ID_RESUME_ID_FROM_USER_BY_USER_ID = "UPDATE users  SET profileId=? , resumeId=? where userId=?";
	private final String UPDATE_OLD_PROFILE = "UPDATE profile SET registrationDate = ?, birthDayDate = ?,phone = ?, residence = ?, workSpeciality = ?, workExpirience = ?, education = ?, photoPath = ?, aboutUser = ? where idUser = ?";
	private final String ADD_NEW_RESUME = "INSERT into resume (name, surName, email, registrationDate, birthDayDate, phone,residence, workSpeciality, workExpirience, education, photoPath, aboutUser, idUser) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private final String SEARCH_RESUMEE_ID = "SELECT idresume from resume where resume.idUser = ?";
	private final String SET_ID_RESUME_FOR_USER = "UPDATE users SET resumeId=? where userId=?";
	private final String DELETE_RESUME_BY_USER_ID = "DELETE FROM resume where idUser = ?";
	private final String UPDATE_RESUME_ID_FROM_USER_BY_USER_ID = "UPDATE users  SET resumeId=? where userId=?";
	private final String UPDATE_OLD_RESUME = "UPDATE resume SET birthDayDate = ?, phone = ?, residence = ?, workSpeciality = ?, workExpirience = ?, education = ?, photoPath = ?, aboutUser = ? where idUser = ?";

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

			preparedStatement = connection.prepareStatement(SEARCH_PROFILE_ID);
			preparedStatement.setInt(1, userId);
			result = preparedStatement.executeQuery();

			while (result.next()) {
				profileId = (result.getInt(1));
			}

			preparedStatement = connection.prepareStatement(SET_ID_PROFILE_FOR_USER);
			preparedStatement.setInt(1, profileId);
			preparedStatement.setInt(2, userId);
			preparedStatement.executeUpdate();

			preparedStatement = connection.prepareStatement(SEARCH_USER_BY_ID);
			preparedStatement.setInt(1, userId);
			result = preparedStatement.executeQuery();

			while (result.next()) {
				user = new UserBuilder().userId(Integer.parseInt(result.getString(1))).name(result.getString(2))
						.surName(result.getString(3)).nickName(result.getString(4)).email(result.getString(5))
						.avaliable(result.getInt(6)).profileId(Integer.parseInt(result.getString(7)))
						.resumeId(result.getInt(8)).role(result.getString(9)).build();
			}

			connection.commit();
			profile = searchProfile(userId);
			resultList.add(user);
			resultList.add(profile);

		} catch (InterruptedException | SQLException e) {
			try {
				logger.error("DaoUserImpl: addNewProfile: Transaction Error: " + e);
				connection.rollback();
				throw new DaoException("addNewProfile" +e);
			} catch (SQLException e1) {
				logger.error("DaoUserImpl: addNewProfile: rollback Error: " + e1);
				throw new DaoException("addNewProfile" +e1);
			}
		} finally {
			closeResources(result, preparedStatement, connection, "addNewProfile");
		}
		return resultList;
	}

	@Override
	public User removeProfile(int userId) throws DaoException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		User user = null;
		ResultSet result = null;

		try {

			connection = connectionPool.takeConnection();
			connection.setAutoCommit(false);

			preparedStatement = connection.prepareStatement(DELETE_PROFILE_BY_USER_ID);
			preparedStatement.setInt(1, userId);
			preparedStatement.executeUpdate();

			preparedStatement = connection.prepareStatement(DELETE_RESUME_BY_USER_ID);
			preparedStatement.setInt(1, userId);
			preparedStatement.executeUpdate();

			updateFieldUser(userId);

			preparedStatement = connection.prepareStatement(SEARCH_USER_BY_ID);
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
				logger.error("DaoUserImpl: removeProfile: Transaction Error: " + e);
				connection.rollback();
				throw new DaoException("removeProfile" +e);
			} catch (SQLException e1) {
				logger.error("DaoUserImpl: removeProfile: rollback Error: " + e1);
				throw new DaoException("removeProfile" +e1);
			}
		} finally {
			closeResources(result, preparedStatement, connection, "removeProfile");
		}
		return user;
	}

	@Override
	public Profile updateOldProfile(String... profileParams) throws DaoException {

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

			preparedStatement = connection.prepareStatement(UPDATE_OLD_PROFILE);
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

			preparedStatement = connection.prepareStatement(UPDATE_OLD_RESUME);
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
			profile = searchProfile(userId);

		} catch (InterruptedException | SQLException e) {
			try {
				logger.error("DaoUserImpl: updateOldProfile: Transaction Error: " + e);
				connection.rollback();
				throw new DaoException("updateOldProfile" +e);
			} catch (SQLException e1) {
				logger.error("DaoUserImpl: updateOldProfile: rollback Error: " + e1);
				throw new DaoException("updateOldProfile" +e1);
			}
		} finally {
			closeResources(result, preparedStatement, connection, "updateOldProfile");
		}
		return profile;
	}

	@Override
	public User addNewResume(final String... resumeParams) throws DaoException {

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

			preparedStatement = connection.prepareStatement(SEARCH_RESUMEE_ID);
			preparedStatement.setInt(1, Integer.parseInt(idUser));
			result = preparedStatement.executeQuery();

			while (result.next()) {
				resumeId = (result.getInt(1));
			}

			preparedStatement = connection.prepareStatement(SET_ID_RESUME_FOR_USER);
			preparedStatement.setInt(1, resumeId);
			preparedStatement.setInt(2, Integer.parseInt(idUser));
			preparedStatement.executeUpdate();

			preparedStatement = connection.prepareStatement(SEARCH_USER_BY_ID);
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
				logger.error("DaoUserImpl: addNewResume: Transaction Error: " + e);
				connection.rollback();
				throw new DaoException("addNewResume" +e);
			} catch (SQLException e1) {
				logger.error("DaoUserImpl: addNewResume: rollback Error: " + e1);
				throw new DaoException("addNewResume" +e1);
			}
		} finally {
			closeResources(result, preparedStatement, connection, "addNewResume");
		}
		return user;

	}

	@Override
	public User deleteResume(int idUserResume) throws DaoException {

		User user = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		try {

			connection = connectionPool.takeConnection();
			connection.setAutoCommit(false);

			preparedStatement = connection.prepareStatement(DELETE_RESUME_BY_USER_ID);
			preparedStatement.setInt(1, idUserResume);
			preparedStatement.executeUpdate();

			preparedStatement = connection.prepareStatement(UPDATE_RESUME_ID_FROM_USER_BY_USER_ID);
			preparedStatement.setInt(1, 0);
			preparedStatement.setInt(2, idUserResume);
			preparedStatement.executeUpdate();

			preparedStatement = connection.prepareStatement(SEARCH_USER_BY_ID);
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
				logger.error("DaoUserImpl: deleteResume: Transaction Error: " + e);
				connection.rollback();
				throw new DaoException("deleteResume" +e);
			} catch (SQLException e1) {
				logger.error("DaoUserImpl: deleteResume: rollback Error: " + e1);
				throw new DaoException("deleteResume" +e1);
			}
		} finally {
			closeResources(result, preparedStatement, connection, "deleteResume");
		}
		return user;
	}

	private Profile searchProfile(final int idUser) throws DaoException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		Profile profile = null;

		try {
			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement(SEARCH_EXIST_PROFILE);
			preparedStatement.setInt(1, idUser);
			result = preparedStatement.executeQuery();

			while (result.next()) {
				profile = new ProfileBuilder().profileId(result.getInt(1)).registrationDate(result.getDate(2))
						.birthDayDate(result.getDate(3)).phone(result.getString(4)).residence(result.getString(5))
						.workSpeciality(result.getString(6)).workExpirience(result.getString(7))
						.education(result.getString(8)).photoPath(result.getString(9)).aboutUser(result.getString(10))
						.build();
			}

		} catch (InterruptedException | SQLException e) {
			try {
				logger.error("DaoUserImpl: searchProfile: Transaction Error: " + e);
				connection.rollback();
				throw new DaoException("searchProfile" +e);
			} catch (SQLException e1) {
				logger.error("DaoUserImpl: searchProfile: rollback Error: " + e1);
				throw new DaoException("searchProfile" +e1);
			}
		} finally {
			closeResources(result, preparedStatement, connection, "searchProfile");
		}
		return profile;
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
			logger.error("DaoJobSeekerImpl: " + methodName + ": " + e);
		}
	}

	private void updateFieldUser(final int idUser) throws DaoException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement(UPDATE_PROFILE_ID_RESUME_ID_FROM_USER_BY_USER_ID);
			preparedStatement.setInt(1, 0);
			preparedStatement.setInt(2, 0);
			preparedStatement.setInt(3, idUser);
			preparedStatement.executeUpdate();

		} catch (InterruptedException | SQLException e) {
			try {
				logger.error("DaoUserImpl: updateFieldUser: Transaction Error: " + e);
				connection.rollback();
				throw new DaoException("updateFieldUser" +e);
			} catch (SQLException e1) {
				logger.error("DaoUserImpl: updateFieldUser: rollback Error: " + e1);
				throw new DaoException("updateFieldUser" +e1);
			}
		} finally {
			closeResources(null, preparedStatement, connection, "updateFieldUser");
		}
	}

}
