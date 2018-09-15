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
import by.htp.project.human_resource.dao.dao_interface.IDaoAdmin;
import by.htp.project.human_resource.entity.User;
import by.htp.project.human_resource.entity.UserBuilder;
import by.htp.project.human_resource.util.poolconnection.ConnectionPool;

/**
 * Class which has methods for work with Users which have role Administrator
 */

public class DaoAdminImpl implements IDaoAdmin {

	/** Field for logging {@link LoggerFactory} */
	private Logger logger = LoggerFactory.getLogger(DaoAdminImpl.class);
	/** Field for ConnectionPool */
	private ConnectionPool connectionPool = ConnectionPool.getInstance();

	/** Field for searching registered {@link User} */
	private final String SEARCH_REGISTERED_USERS_BY_PARAM = "SELECT userId, name, surName, nickName, email, avaliable, profileId, resumeId, role FROM users JOIN userroles on users.roleId = userroles.rolesId WHERE avaliable = 1 LIMIT ?, ?";
	/** Field for searching unregistered {@link User} */
	private final String SEARCH_UNREGISTERED_USERS_BY_PARAM = "SELECT userId, name, surName, nickName, email, avaliable, profileId, resumeId, role FROM users JOIN userroles on users.roleId = userroles.rolesId WHERE avaliable = 0 LIMIT ?, ?";
	/** Field for searching All {@link User} */
	private final String SEARCH_ALL_USERS_BY_PARAM = "SELECT userId, name, surName, nickName, email, avaliable, profileId, resumeId, role FROM users JOIN userroles on users.roleId = userroles.rolesId LIMIT ?, ?";
	/** Field for set {@link User#avaliable} */
	private final String SET_AVALIABLE_FIELD_FOR_USER = "UPDATE users SET avaliable=? WHERE userId=?";

	public DaoAdminImpl() {
	}

	@Override
	public List<User> searchAllRegisteredUserByParams(final String... params) throws DaoException {

		String limitLine = null;
		String offsetLine = null;
		User user = null;
		List<User> allUsers = new ArrayList<>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		limitLine = params[0];
		offsetLine = params[1];

		try {

			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement(SEARCH_REGISTERED_USERS_BY_PARAM);

			preparedStatement.setInt(1, Integer.parseInt(offsetLine));
			preparedStatement.setInt(2, Integer.parseInt(limitLine));
			result = preparedStatement.executeQuery();

			while (result.next()) {

				user = new UserBuilder().userId(Integer.parseInt(result.getString(1))).name(result.getString(2))
						.surName(result.getString(3)).nickName(result.getString(4)).email(result.getString(5))
						.avaliable(result.getInt(6)).profileId(Integer.parseInt(result.getString(7)))
						.resumeId(result.getInt(8)).role(result.getString(9)).build();
				allUsers.add(user);
			}

		} catch (InterruptedException e) {
			logger.error("DaoAdminImpl: searchAllRegisteredUserByParams: Connection interrupted: " + e);
			throw new DaoException("searchAllRegisteredUserByParams" + e);
		} catch (SQLException e) {
			logger.error("DaoAdminImpl: searchAllRegisteredUserByParams: SQL error: " + e);
			throw new DaoException("searchUser" + e);
		} finally {
			closeResources(result, preparedStatement, connection, "searchAllRegisteredUserByParams");
		}
		return allUsers;
	}

	@Override
	public List<User> searchAllUnregisteredUserByParams(final String... params) throws DaoException {

		String limitLine = null;
		String offsetLine = null;
		User user = null;
		List<User> allUsers = new ArrayList<>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		limitLine = params[0];
		offsetLine = params[1];

		try {

			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement(SEARCH_UNREGISTERED_USERS_BY_PARAM);

			preparedStatement.setInt(1, Integer.parseInt(offsetLine));
			preparedStatement.setInt(2, Integer.parseInt(limitLine));
			result = preparedStatement.executeQuery();

			while (result.next()) {

				user = new UserBuilder().userId(Integer.parseInt(result.getString(1))).name(result.getString(2))
						.surName(result.getString(3)).nickName(result.getString(4)).email(result.getString(5))
						.avaliable(result.getInt(6)).profileId(Integer.parseInt(result.getString(7)))
						.resumeId(result.getInt(8)).role(result.getString(9)).build();
				allUsers.add(user);
			}

		} catch (InterruptedException e) {
			logger.error("DaoAdminImpl: searchAllUnregisteredUserByParams: Connection interrupted: " + e);
			throw new DaoException("searchAllUnregisteredUserByParams" + e);
		} catch (SQLException e) {
			logger.error("DaoAdminImpl: searchAllUnregisteredUserByParams: SQL error: " + e);
			throw new DaoException("searchAllUnregisteredUserByParams" + e);
		} finally {
			closeResources(result, preparedStatement, connection, "searchAllUnregisteredUserByParams");
		}
		return allUsers;
	}

	@Override
	public List<User> searchAllUserByParams(final String... params) throws DaoException {

		String limitLine = null;
		String offsetLine = null;
		User user = null;
		List<User> allUsers = new ArrayList<>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		limitLine = params[0];
		offsetLine = params[1];

		try {

			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement(SEARCH_ALL_USERS_BY_PARAM);

			preparedStatement.setInt(1, Integer.parseInt(offsetLine));
			preparedStatement.setInt(2, Integer.parseInt(limitLine));
			result = preparedStatement.executeQuery();

			while (result.next()) {

				user = new UserBuilder().userId(Integer.parseInt(result.getString(1))).name(result.getString(2))
						.surName(result.getString(3)).nickName(result.getString(4)).email(result.getString(5))
						.avaliable(result.getInt(6)).profileId(Integer.parseInt(result.getString(7)))
						.resumeId(result.getInt(8)).role(result.getString(9)).build();
				allUsers.add(user);
			}

		} catch (InterruptedException e) {
			logger.error("DaoAdminImpl: searchAllUserByParams: Connection interrupted: " + e);
			throw new DaoException("searchAllUserByParams" + e);
		} catch (SQLException e) {
			logger.error("DaoAdminImpl: searchAllUserByParams: SQL error: " + e);
			throw new DaoException("searchAllUserByParams" + e);
		} finally {
			closeResources(result, preparedStatement, connection, "searchAllUserByParams");
		}
		return allUsers;
	}

	@Override
	public int getCountAllRowsForTable(final String tableName, final int avaliable) throws DaoException {

		int count = 0;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		try {

			connection = connectionPool.takeConnection();
			if (avaliable == -1) {
				preparedStatement = connection.prepareStatement("SELECT count(*) FROM " + tableName);
			} else {
				preparedStatement = connection
						.prepareStatement("SELECT count(*) FROM " + tableName + " where avaliable=" + avaliable);
			}
			result = preparedStatement.executeQuery();

			while (result.next()) {
				count = result.getInt(1);
			}

		} catch (InterruptedException e) {
			logger.error("DaoAdminImpl: getCountAllRowsForTable: Connection interrupted: " + e);
			throw new DaoException("getCountAllRowsForTable" + e);
		} catch (SQLException e) {
			logger.error("DaoAdminImpl: getCountAllRowsForTable: SQL error: " + e);
			throw new DaoException("getCountAllRowsForTable" + e);
		} finally {
			closeResources(result, preparedStatement, connection, "getCountAllRowsForTable");
		}
		return count;
	}

	@Override
	public boolean updateAvaliableFildForUser(final int idUser, final int value) throws DaoException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean result = false;

		try {

			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement(SET_AVALIABLE_FIELD_FOR_USER);
			preparedStatement.setInt(1, value);
			preparedStatement.setInt(2, idUser);
			preparedStatement.executeUpdate();

			result = true;

		} catch (InterruptedException e) {
			logger.error("DaoAdminImpl: updateAvaliableFildForUser: Connection interrupted: " + e);
			throw new DaoException("updateAvaliableFildForUser" + e);
		} catch (SQLException e) {
			logger.error("DaoAdminImpl: updateAvaliableFildForUser: SQL error: " + e);
			throw new DaoException("updateAvaliableFildForUser" + e);
		} finally {
			closeResources(null, preparedStatement, connection, "updateAvaliableFildForUser");
		}
		return result;
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
			logger.error("DaoAdminImpl: " + methodName + ": " + e);
		}
	}
}
