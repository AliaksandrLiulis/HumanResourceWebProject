package by.htp.project.human_resource.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import by.htp.project.human_resource.dao.exception.DaoException;
import by.htp.project.human_resource.dao.interf.IDaoUser;
import by.htp.project.human_resource.dao.poolconnection.ConnectionPool;
import by.htp.project.human_resource.entity.Profile;
import by.htp.project.human_resource.entity.ProfileBuilder;
import by.htp.project.human_resource.entity.User;
import by.htp.project.human_resource.entity.UserBuilder;

public class DaoUserImpl implements IDaoUser {

	private final Logger logger = LogManager.getLogger(DaoUserImpl.class);
	private ConnectionPool connectionPool = null;
	private Map<String, Integer> allRolles = null;

	private final String SEARCH_USER = "SELECT iduser, name, surname, nickName, email, avaliable, profile, role FROM users join userroles on users.userroles_iduserrole = userroles.iduserrole where users.nickname = ? and users.password = ?";
	private final String GET_USER = "SELECT iduser, name, surname, nickName, email, avaliable, profile, role FROM users join userroles on users.userroles_iduserrole = userroles.iduserrole where users.iduser = ?";
	private final String SEARCH_USER_NICKNAME = "SELECT nickname from users  where nickname = ?";
	private final String ADD_USER = "INSERT into users (nickName ,name,  surname, password , avaliable, email, userroles_iduserrole ) VALUES (?,?,?,?,?,?,?)";
	private final String GET_ALL_USER_BASE = "SELECT * FROM users join userroles on users.userroles_iduserrole = userroles.iduserrole";
	private final String ADD_NEW_PROFILE = "INSERT into profile (registration_date ,birth_date,  phone, residence , work_speciality, work_expirience, education, photo, about_user, id_user ) VALUES (?,?,?,?,?,?,?,?,?,?)";
	private final String GET_PROFILE_ID = "SELECT idprofiles from profile where profile.id_user = ?";
	private final String SET_ID_PROFILE_FOR_USER = "UPDATE users SET profile=? where iduser=?";
	private final String GET_EXIST_PROFILE = "SELECT * FROM profile where id_user = ?";
	private final String DELETE_PROFILE = "DELETE FROM profile where id_user = ?";
	private final String UPDATE_FIELD_FROM_USER = "UPDATE users  SET profile=? where iduser=?";

	public DaoUserImpl() {
		if (null == connectionPool) {
			connectionPool = ConnectionPool.getInstance();
		}
	}

	@Override
	public User searchUser(final String nickName, final String password) throws DaoException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		User user = null;
		Profile profile = null;

		try {
			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement(SEARCH_USER);
			preparedStatement.setString(1, nickName);
			preparedStatement.setString(2, password);
			result = preparedStatement.executeQuery();

			while (result.next()) {

				user = new UserBuilder().id(Integer.parseInt(result.getString(1))).name(result.getString(2))
						.surName(result.getString(3)).nickName(result.getString(4)).email(result.getString(5))
						.avaliable(result.getInt(6)).profile(Integer.parseInt(result.getString(7)))
						.role(result.getString(8)).build();
			}

		} catch (InterruptedException e) {
			logger.error("DaoUserImpl: searchUser: Connection interrupted: " + e);
			new DaoException("error");
		} catch (SQLException e) {
			logger.error("DaoUserImpl: searchUser: SQL error: " + e);
			new DaoException("error");
		} finally {
			closeResources(preparedStatement, result, connection, "searUser");
		}
		return user;
	}

	@Override
	public boolean searchUserNickName(final String nickName) throws DaoException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		String nick = null;

		try {
			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement(SEARCH_USER_NICKNAME);
			preparedStatement.setString(1, nickName);
			result = preparedStatement.executeQuery();

			while (result.next()) {
				nick = result.getString(1);
			}
		} catch (InterruptedException e) {
			logger.error("DaoUserImpl: searchUserNickName: Connection interrupted: " + e);
			new DaoException("error");
		} catch (SQLException e) {
			logger.error("DaoUserImpl: searchUserNickName: SQL error: " + e);
			new DaoException("error");
		} finally {
			closeResources(preparedStatement, result, connection, "searchUserNickName");
		}
		if (null == nick) {
			return true;
		}
		return false;
	}

	@Override
	public User addUser(final String... userParams) throws DaoException {
		List<String> allParams = new ArrayList<String>(Arrays.asList(userParams));
		if (null == allRolles) {
			allRolles = setRoles();
		}
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		User user = null;
		try {
			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement(ADD_USER);
			preparedStatement.setString(1, allParams.get(2));
			preparedStatement.setString(2, allParams.get(0));
			preparedStatement.setString(3, allParams.get(1));
			preparedStatement.setString(4, allParams.get(3));
			preparedStatement.setInt(5, 0);
			preparedStatement.setString(6, allParams.get(4));
			preparedStatement.setInt(7, getNumRoleForSQL(allParams.get(5)));
			preparedStatement.executeUpdate();

			user = new UserBuilder().name(allParams.get(0)).surName(allParams.get(1)).nickName(allParams.get(2))
					.email(allParams.get(3)).avaliable(0).role(allParams.get(5)).build();

		} catch (InterruptedException e) {
			logger.error("DaoUserImpl: addUser: Connection interrupted: " + e);
			new DaoException("error");
		} catch (SQLException e) {
			logger.error("DaoUserImpl: addUser: SQL error: " + e);
			new DaoException("error");
		} finally {
			closeResources(preparedStatement, null, connection, "addUser");
		}
		return user;
	}

	@Override
	public List<Object> addNewProfile(String... profileParams) {
		List<Object> list = new ArrayList<>();
		int userId = Integer.parseInt(profileParams[0]);
		int profileId = 0;
		User user = null;
		Profile profile = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		try {
			connection = connectionPool.takeConnection();
			connection.setAutoCommit(false);

			preparedStatement = connection.prepareStatement(ADD_NEW_PROFILE);
			preparedStatement.setString(1, profileParams[1]);
			preparedStatement.setString(2, profileParams[4]);
			preparedStatement.setString(3, profileParams[3]);
			preparedStatement.setString(4, profileParams[5]);
			preparedStatement.setString(5, profileParams[5]);
			preparedStatement.setString(6, profileParams[7]);
			preparedStatement.setString(7, profileParams[8]);
			preparedStatement.setString(8, profileParams[2]);
			preparedStatement.setString(9, profileParams[9]);
			preparedStatement.setString(10, profileParams[0]);
			preparedStatement.executeUpdate();

			preparedStatement = connection.prepareStatement(GET_PROFILE_ID);
			preparedStatement.setInt(1, userId);
			result = preparedStatement.executeQuery();
			while (result.next()) {
				profileId = (result.getInt(1));
			}

			preparedStatement = connection.prepareStatement(SET_ID_PROFILE_FOR_USER);
			preparedStatement.setInt(1, profileId);
			preparedStatement.setInt(2, userId);
			preparedStatement.executeUpdate();

			preparedStatement = connection.prepareStatement(GET_USER);
			preparedStatement.setInt(1, userId);
			result = preparedStatement.executeQuery();

			while (result.next()) {
				user = new UserBuilder().id(Integer.parseInt(result.getString(1))).name(result.getString(2))
						.surName(result.getString(3)).nickName(result.getString(4)).email(result.getString(5))
						.avaliable(result.getInt(6)).profile(Integer.parseInt(result.getString(7)))
						.role(result.getString(8)).build();

			}

			connection.commit();
			profile = getProfile(userId);

			list.add(user);
			list.add(profile);

		} catch (InterruptedException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {

			}
			logger.error("DaoUserImpl: addNewProfile: Connection interrupted: " + e);
			new DaoException("error");
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {

			}
			logger.error("DaoUserImpl: addNewProfile: SQL error: " + e);
			new DaoException("error");
		} finally {
			closeResources(preparedStatement, result, connection, "addUser");
		}
		return list;

	}

	@Override
	public List<User> getAllUserBase() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		List<User> allUser = new ArrayList<>();
		User user = null;
		try {
			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement(GET_ALL_USER_BASE);
			result = preparedStatement.executeQuery();

			while (result.next()) {
				user = new UserBuilder().nickName(result.getString(2)).name(result.getString(3))
						.surName(result.getString(4)).email(result.getString(7)).avaliable(result.getInt(6))
						.role(result.getString(10)).build();
				allUser.add(user);
			}

		} catch (InterruptedException e) {
			logger.error("DaoUserImpl: searchUser: Connection interrupted: " + e);
			new DaoException("error");
		} catch (SQLException e) {
			logger.error("DaoUserImpl: searchUser: SQL error: " + e);
			new DaoException("error");
		} finally {
			closeResources(preparedStatement, result, connection, "searUser");
		}

		return allUser;
	}

	private Map<String, Integer> setRoles() {
		allRolles = new HashMap<String, Integer>();
		allRolles.put(AllRole.ADMINISTRATOR.getValue(), AllRole.ADMINISTRATOR.getIdNumber());
		allRolles.put(AllRole.BOSS.getValue(), AllRole.BOSS.getIdNumber());
		allRolles.put(AllRole.HR.getValue(), AllRole.HR.getIdNumber());
		allRolles.put(AllRole.EMPLOYEE.getValue(), AllRole.EMPLOYEE.getIdNumber());
		return allRolles;
	}

	private int getNumRoleForSQL(final String role) {
		Set<Map.Entry<String, Integer>> entrySet = allRolles.entrySet();
		int numForSql = 0;
		for (Map.Entry<String, Integer> pair : entrySet) {
			if (role.equals(pair.getKey())) {
				numForSql = pair.getValue();
			}
		}
		return numForSql;
	}

	private void closeResources(PreparedStatement preparedStatement, ResultSet resultSet, Connection connection,
			String methodName) {
		if (preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				logger.error("DaoUserImpl: " + methodName + ": PreparedStatment Error " + e);
			}
		}
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				logger.error("DaoUserImpl: " + methodName + ": ResultSet Error " + e);
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				logger.error("DaoUserImpl: " + methodName + ": Connection Error " + e);
			}
		}
	}

	@Override
	public Profile getProfile(int idUser) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		Profile profile = null;

		try {
			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement(GET_EXIST_PROFILE);
			preparedStatement.setInt(1, idUser);
			result = preparedStatement.executeQuery();
			while (result.next()) {
				profile = new ProfileBuilder().id(result.getInt(1)).registrationDate(result.getDate(2))
						.birthDayDate(result.getDate(3)).phone(result.getString(4)).residence(result.getString(5))
						.workSpeciality(result.getString(6)).workExpirience(result.getString(7))
						.education(result.getString(8)).photoPath(result.getString(9)).abouteUser(result.getString(10))
						.build();
			}

		} catch (InterruptedException e) {
			logger.error("DaoUserImpl: getProfile: Connection interrupted: " + e);
			new DaoException("error");
		} catch (SQLException e) {
			logger.error("DaoUserImpl: getProfile: SQL error: " + e);
			new DaoException("error");
		} finally {
			closeResources(preparedStatement, result, connection, "getProfile");

		}
		return profile;
	}

	@Override
	public void removeProfile(int userId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement(DELETE_PROFILE);
			preparedStatement.setInt(1, userId);			
			updateFieldUser(userId);

		} catch (InterruptedException e) {
			logger.error("DaoUserImpl: removeProfile: Connection interrupted: " + e);
			new DaoException("error");
		} catch (SQLException e) {
			logger.error("DaoUserImpl: removeProfile: SQL error: " + e);
			new DaoException("error");
		} finally {
			closeResources(preparedStatement, null, connection, "removeProfile");

		}
	}

	private void updateFieldUser(final int idUser) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement(UPDATE_FIELD_FROM_USER);
			preparedStatement.setInt(1, 0);
			preparedStatement.setInt(2, idUser);
			
		} catch (SQLException e) {
			logger.error("DaoUserImpl: updateFieldUser: SQL error: " + e);
			new DaoException("error");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeResources(preparedStatement, null, connection, "getProfile");

		}
	}
}
