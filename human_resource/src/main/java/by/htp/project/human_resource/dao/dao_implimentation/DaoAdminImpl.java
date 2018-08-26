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
import by.htp.project.human_resource.dao.poolconnection.ConnectionPool;
import by.htp.project.human_resource.entity.User;
import by.htp.project.human_resource.entity.UserBuilder;

public class DaoAdminImpl implements IDaoAdmin {
	private Logger logger = LoggerFactory.getLogger(DaoAdminImpl.class);
	private ConnectionPool connectionPool = null;

	private final String SEARCH_REGISTERED_USER_BY_PARAM = "SELECT userId, name, surName, nickName, email, avaliable, profileId, resumeId, role FROM users JOIN userroles on users.roleId = userroles.rolesId where avaliable = 1 LIMIT ?, ?";
	private final String SEARCH_UNREGISTERED_USER_BY_PARAM = "SELECT userId, name, surName, nickName, email, avaliable, profileId, resumeId, role FROM users JOIN userroles on users.roleId = userroles.rolesId where avaliable = 0 LIMIT ?, ?";
	private final String SEARCH_ALL_USER_BY_PARAM = "SELECT userId, name, surName, nickName, email, avaliable, profileId, resumeId, role FROM users JOIN userroles on users.roleId = userroles.rolesId LIMIT ?, ?";
	private final String SET_AVALIABLE_FOR_USER = "UPDATE users SET avaliable=? where userId=?";
	
	public DaoAdminImpl() {
		if (null == connectionPool) {
			connectionPool = ConnectionPool.getInstance();
		}
	}

	@Override
	public List<User> searchAllRegisteredUserByParams(final String... params) throws DaoException {

		String limiLine = null;
		String offsetLine = null;
		User user = null;
		List<User> allUsers = new ArrayList<>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		limiLine = params[0];
		offsetLine = params[1];

		try {
			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement(SEARCH_REGISTERED_USER_BY_PARAM);

			preparedStatement.setInt(1, Integer.parseInt(offsetLine));
			preparedStatement.setInt(2, Integer.parseInt(limiLine));
			result = preparedStatement.executeQuery();

			while (result.next()) {
				user = new UserBuilder().userId(Integer.parseInt(result.getString(1))).name(result.getString(2))
						.surName(result.getString(3)).nickName(result.getString(4)).email(result.getString(5))
						.avaliable(result.getInt(6)).profileId(Integer.parseInt(result.getString(7)))
						.resumeId(result.getInt(8)).role(result.getString(9)).build();
				allUsers.add(user);
			}

		} catch (InterruptedException | SQLException e) {
			try {
				logger.error("DaoAdminImpl: searchUserByParams: " + e);

				throw new DaoException("searchUserByParams" + e);

			} finally {
				closeResources(result, preparedStatement, connection, "searchUserByParams");
			}
		}
		return allUsers;
	}

	@Override
	public List<User> searchAllUnregisteredUserByParams(final String... params) throws DaoException {

		String limiLine = null;
		String offsetLine = null;
		User user = null;
		List<User> allUsers = new ArrayList<>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		limiLine = params[0];
		offsetLine = params[1];

		try {
			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement(SEARCH_UNREGISTERED_USER_BY_PARAM);

			preparedStatement.setInt(1, Integer.parseInt(offsetLine));
			preparedStatement.setInt(2, Integer.parseInt(limiLine));
			result = preparedStatement.executeQuery();

			while (result.next()) {
				user = new UserBuilder().userId(Integer.parseInt(result.getString(1))).name(result.getString(2))
						.surName(result.getString(3)).nickName(result.getString(4)).email(result.getString(5))
						.avaliable(result.getInt(6)).profileId(Integer.parseInt(result.getString(7)))
						.resumeId(result.getInt(8)).role(result.getString(9)).build();
				allUsers.add(user);
			}

		} catch (InterruptedException | SQLException e) {
			try {
				logger.error("DaoAdminImpl: searchAllUnregisteredUserByParams: " + e);

				throw new DaoException("searchAllUnregisteredUserByParams" + e);

			} finally {
				closeResources(result, preparedStatement, connection, "searchAllUnregisteredUserByParams");
			}
		}
		return allUsers;
	}

	@Override
	public List<User> searchAllUserByParams(String... params) throws DaoException {
		String limiLine = null;
		String offsetLine = null;
		User user = null;
		List<User> allUsers = new ArrayList<>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		limiLine = params[0];
		offsetLine = params[1];

		try {
			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement(SEARCH_ALL_USER_BY_PARAM);

			preparedStatement.setInt(1, Integer.parseInt(offsetLine));
			preparedStatement.setInt(2, Integer.parseInt(limiLine));
			result = preparedStatement.executeQuery();

			while (result.next()) {
				user = new UserBuilder().userId(Integer.parseInt(result.getString(1))).name(result.getString(2))
						.surName(result.getString(3)).nickName(result.getString(4)).email(result.getString(5))
						.avaliable(result.getInt(6)).profileId(Integer.parseInt(result.getString(7)))
						.resumeId(result.getInt(8)).role(result.getString(9)).build();
				allUsers.add(user);
			}

		} catch (InterruptedException | SQLException e) {
			try {
				logger.error("DaoAdminImpl: searchAllUserByParams: " + e);

				throw new DaoException("searchAllUserByParams" + e);

			} finally {
				closeResources(result, preparedStatement, connection, "searchAllUserByParams");
			}
		}
		return allUsers;
	}

	@Override
	public int getCountAllRowsForTable(String tableName, int avaliable) throws DaoException {
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
			logger.error("DaoAdminImpl: " + methodName + ": " + e);
		}
	}

	@Override
	public boolean updateAvaliableFildForUser(int idUser, int value) throws DaoException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		boolean res = false;
				
		
			try {
				connection = connectionPool.takeConnection();
				preparedStatement = connection.prepareStatement(SET_AVALIABLE_FOR_USER);
				preparedStatement.setInt(1, value);
				preparedStatement.setInt(2, idUser);
				preparedStatement.executeUpdate();
				res = true;
			} catch (InterruptedException | SQLException e) {
				logger.error("DaoUserImpl: updateAvaliableFildForUser:  " + e);
				throw new DaoException("updateAvaliableFildForUser" + e);
			}
			
		
		

		return res;
	}

}
