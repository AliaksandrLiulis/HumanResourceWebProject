package by.htp.project.human_resource.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.htp.project.human_resource.dao.exception.DaoException;
import by.htp.project.human_resource.dao.interf.IDaoUser;
import by.htp.project.human_resource.dao.poolconnection.ConnectionPool;
import by.htp.project.human_resource.entity.Profile;
import by.htp.project.human_resource.entity.ProfileBuilder;
import by.htp.project.human_resource.entity.User;
import by.htp.project.human_resource.entity.UserBuilder;

public class DaoUserImpl implements IDaoUser {

	private Logger logger = LoggerFactory.getLogger(DaoUserImpl.class);
	private ConnectionPool connectionPool = null;
	private Map<String, Integer> allRolles = null;

	private final String SEARCH_USER = "SELECT userId, name, surName, nickName, email, avaliable, profileId, resumeId, role FROM users JOIN userroles on users.roleId = userroles.rolesId where users.nickName = ? and users.password = ?";
	private final String SEARCH_USER_NICKNAME = "SELECT nickName from users  where nickName = ?";
	private final String ADD_USER = "INSERT into users (name,  surName, nickName, password , avaliable, email, roleId, profileId, resumeId ) VALUES (?,?,?,?,?,?,?,?,?)";
	private final String GET_EXIST_PROFILE = "SELECT * FROM profile where idUser = ?";

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

		try {
			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement(SEARCH_USER);
			preparedStatement.setString(1, nickName);
			preparedStatement.setString(2, password);
			result = preparedStatement.executeQuery();

			while (result.next()) {

				user = new UserBuilder().userId(Integer.parseInt(result.getString(1))).name(result.getString(2))
						.surName(result.getString(3)).nickName(result.getString(4)).email(result.getString(5))
						.avaliable(result.getInt(6)).profileId(Integer.parseInt(result.getString(7)))
						.resumeId(result.getInt(8)).role(result.getString(9)).build();
			}
		} catch (InterruptedException e) {
			logger.error("DaoUserImpl: searchUser: Connection interrupted: " + e);
			throw new DaoException("searchUser" + e);
		} catch (SQLException e) {
			logger.error("DaoUserImpl: searchUser: SQL error: " + e);
			throw new DaoException("searchUser" + e);
		} finally {
			closeResources(result, preparedStatement, connection, "searchUser");
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
			throw new DaoException("searchUserNickName" + e);
		} catch (SQLException e) {
			logger.error("DaoUserImpl: searchUserNickName: SQL error: " + e);
			throw  new DaoException("searchUserNickName" + e);
		} finally {
			closeResources(result, preparedStatement, connection, "searchUserNickName");
		}
		if (null == nick) {
			return true;
		}
		return false;
	}

	@Override
	public User addUser(final String... userParams) throws DaoException {
		String name = null;
		String surname = null;
		String nickName = null;
		String password = null;
		String email = null;
		String role = null;

		name = userParams[0];
		surname = userParams[1];
		nickName = userParams[2];
		password = userParams[3];
		email = userParams[4];
		role = userParams[5];

		if (null == allRolles) {
			allRolles = setRoles();
		}
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		User user = null;
		try {
			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement(ADD_USER);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, surname);
			preparedStatement.setString(3, nickName);
			preparedStatement.setString(4, password);
			preparedStatement.setInt(5, 0);
			preparedStatement.setString(6, email);
			preparedStatement.setInt(7, getNumRoleForSQL(role));
			preparedStatement.setInt(8, 0);
			preparedStatement.setInt(9, 0);
			preparedStatement.executeUpdate();

			user = new UserBuilder().name(name).surName(surname).nickName(nickName).email(email).avaliable(0).role(role)
					.build();

		} catch (InterruptedException e) {
			logger.error("DaoUserImpl: addUser: Connection interrupted: " + e);
			throw new DaoException("addUser" + e);
		} catch (SQLException e) {
			logger.error("DaoUserImpl: addUser: SQL error: " + e);
			throw new DaoException("addUser" + e);
		} finally {
			closeResources(null, preparedStatement, connection, "addUser");
		}
		return user;
	}

	public Profile getProfile(int idUser) throws DaoException {
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
				profile = new ProfileBuilder().profileId(result.getInt(1)).registrationDate(result.getDate(2))
						.birthDayDate(result.getDate(3)).phone(result.getString(4)).residence(result.getString(5))
						.workSpeciality(result.getString(6)).workExpirience(result.getString(7))
						.education(result.getString(8)).photoPath(result.getString(9)).aboutUser(result.getString(10))
						.build();
			}

		} catch (InterruptedException e) {
			logger.error("DaoUserImpl: getProfile: Connection interrupted: " + e);
			throw new DaoException("getProfile" + e);
		} catch (SQLException e) {
			logger.error("DaoUserImpl: getProfile: SQL error: " + e);
			throw new DaoException("getProfile" + e);
		} finally {
			closeResources(result, preparedStatement, connection, "getProfile");
		}
		return profile;
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

	private Map<String, Integer> setRoles() {
		allRolles = new HashMap<String, Integer>();
		allRolles.put(AllRole.ADMINISTRATOR.getValue(), AllRole.ADMINISTRATOR.getIdNumber());
		allRolles.put(AllRole.BOSS.getValue(), AllRole.BOSS.getIdNumber());
		allRolles.put(AllRole.HR.getValue(), AllRole.HR.getIdNumber());
		allRolles.put(AllRole.EMPLOYEE.getValue(), AllRole.EMPLOYEE.getIdNumber());
		return allRolles;
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
			logger.error("DaoUserImpl: " + methodName + ": " + e);
		}
	}
}
