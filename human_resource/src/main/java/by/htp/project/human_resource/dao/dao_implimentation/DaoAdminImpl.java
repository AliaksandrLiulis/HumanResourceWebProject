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
import by.htp.project.human_resource.entity.Message;
import by.htp.project.human_resource.entity.MessageBuilder;
import by.htp.project.human_resource.entity.User;
import by.htp.project.human_resource.entity.UserBuilder;
import by.htp.project.human_resource.util.poolconnection.ConnectionPool;

/**
 * Class which has methods for work with Users which have role Administrator
 */

public class DaoAdminImpl implements IDaoAdmin {

	/** Field for logging {@link LoggerFactory} */
	private static final Logger logger = LoggerFactory.getLogger(DaoAdminImpl.class);
	/** Field for ConnectionPool */
	private ConnectionPool connectionPool = ConnectionPool.getInstance();

	/** Field for searching registered {@link User} */
	private final String SEARCH_REGISTERED_USERS_BY_PARAM = "SELECT userId, name, surName, nickName, email, avaliable, profileId, resumeId, role FROM users JOIN userroles on users.roleId = userroles.rolesId WHERE avaliable = 1 LIMIT ?, ?";
	/** Field for searching unregistered {@link User} */
	private final String SEARCH_UNREGISTERED_USERS_BY_PARAM = "SELECT userId, name, surName, nickName, email, avaliable, profileId, resumeId, role FROM users JOIN userroles on users.roleId = userroles.rolesId WHERE avaliable = 0 LIMIT ?, ?";
	/** Field for searching All {@link User} */
	private final String SEARCH_ALL_USERS_BY_PARAM = "SELECT userId, name, surName, nickName, email, avaliable, profileId, resumeId, role FROM users JOIN userroles on users.roleId = userroles.rolesId LIMIT ?, ?";
	/** Field for set {@link User#available} */
	private final String SET_AVALIABLE_FIELD_FOR_USER = "UPDATE users SET avaliable=? WHERE userId=?";
	/** Field for searching all {@link Message} */
	private final String SEARCH_ALL_MESSAGE = "SELECT * FROM message";
	/** Field for delete {@link Message} by Id */
	private final String DELETE_MESSAGE_BY_ID = "DELETE FROM message where idmessage = ?";
	/** Field for delete {@link User} from base by Id */
	private final String DELETE_USER_FROM_BASE_BY_ID = "DELETE FROM users where userId = ?";
	/** Field for search profileid and resumeid by Id user */
	private final String SEARCH_PROFILEID_AND_RESUMEID_BY_IDUSER = "SELECT profileId, resumeId from users where userId = ?";
	/** Field for search profileid and resumeid by Id user */
	private final String DELETE_PROFILEID_BY_IDUSER = "DELETE FROM profile where idUser = ?";
	/** Field for delete profileid by Id user */
	private final String DELETE_RESUMEID_BY_IDUSER = "DELETE FROM resume where idUser = ?";

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

				user = new UserBuilder().userId(Integer.parseInt(result.getString(userId))).name(result.getString(name))
						.surName(result.getString(surName)).nickName(result.getString(nickName))
						.email(result.getString(email)).avaliable(result.getInt(available))
						.profileId(Integer.parseInt(result.getString(profileId))).resumeId(result.getInt(resumeId))
						.role(result.getString(role)).build();
				allUsers.add(user);
			}

		} catch (InterruptedException e) {
			logger.error("DaoAdminImpl: searchAllRegisteredUserByParams: Connection interrupted: ", e);
			throw new DaoException("searchAllRegisteredUserByParams", e);
		} catch (SQLException e) {
			logger.error("DaoAdminImpl: searchAllRegisteredUserByParams: SQL error: ", e);
			throw new DaoException("searchUser", e);
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

				user = new UserBuilder().userId(Integer.parseInt(result.getString(userId))).name(result.getString(name))
						.surName(result.getString(surName)).nickName(result.getString(nickName))
						.email(result.getString(email)).avaliable(result.getInt(available))
						.profileId(Integer.parseInt(result.getString(profileId))).resumeId(result.getInt(resumeId))
						.role(result.getString(role)).build();
				allUsers.add(user);
			}

		} catch (InterruptedException e) {
			logger.error("DaoAdminImpl: searchAllUnregisteredUserByParams: Connection interrupted: ", e);
			throw new DaoException("searchAllUnregisteredUserByParams", e);
		} catch (SQLException e) {
			logger.error("DaoAdminImpl: searchAllUnregisteredUserByParams: SQL error: ", e);
			throw new DaoException("searchAllUnregisteredUserByParams", e);
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

				user = new UserBuilder().userId(Integer.parseInt(result.getString(userId))).name(result.getString(name))
						.surName(result.getString(surName)).nickName(result.getString(nickName))
						.email(result.getString(email)).avaliable(result.getInt(available))
						.profileId(Integer.parseInt(result.getString(profileId))).resumeId(result.getInt(resumeId))
						.role(result.getString(role)).build();
				allUsers.add(user);
			}

		} catch (InterruptedException e) {
			logger.error("DaoAdminImpl: searchAllUserByParams: Connection interrupted: ", e);
			throw new DaoException("searchAllUserByParams", e);
		} catch (SQLException e) {
			logger.error("DaoAdminImpl: searchAllUserByParams: SQL error: ", e);
			throw new DaoException("searchAllUserByParams", e);
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
			logger.error("DaoAdminImpl: getCountAllRowsForTable: Connection interrupted: ", e);
			throw new DaoException("getCountAllRowsForTable", e);
		} catch (SQLException e) {
			logger.error("DaoAdminImpl: getCountAllRowsForTable: SQL error: ", e);
			throw new DaoException("getCountAllRowsForTable", e);
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
			logger.error("DaoAdminImpl: updateAvaliableFildForUser: Connection interrupted: ", e);
			throw new DaoException("updateAvaliableFildForUser", e);
		} catch (SQLException e) {
			logger.error("DaoAdminImpl: updateAvaliableFildForUser: SQL error: ", e);
			throw new DaoException("updateAvaliableFildForUser", e);
		} finally {
			closeResources(null, preparedStatement, connection, "updateAvaliableFildForUser");
		}
		return result;
	}

	@Override
	public List<Message> searchAllMessage() throws DaoException {

		List<Message> allMessage = new ArrayList<>();
		Message message = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		try {

			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement(SEARCH_ALL_MESSAGE);
			result = preparedStatement.executeQuery();

			while (result.next()) {
				message = new MessageBuilder().idmessage(result.getInt(1)).name(result.getString(2))
						.email(result.getString(3)).createdate(result.getDate(4)).content(result.getString(5)).build();
				allMessage.add(message);
			}

		} catch (InterruptedException e) {
			logger.error("DaoAdminImpl: updateAvaliableFildForUser: Connection interrupted: ", e);
			throw new DaoException("updateAvaliableFildForUser", e);
		} catch (SQLException e) {
			logger.error("DaoAdminImpl: updateAvaliableFildForUser: SQL error: ", e);
			throw new DaoException("updateAvaliableFildForUser", e);
		} finally {
			closeResources(null, preparedStatement, connection, "updateAvaliableFildForUser");
		}

		return allMessage;
	}

	@Override
	public boolean deleteMessage(int idMessage) throws DaoException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean result = false;

		try {

			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement(DELETE_MESSAGE_BY_ID);
			preparedStatement.setInt(1, idMessage);
			preparedStatement.executeUpdate();

			result = true;

		} catch (InterruptedException e) {
			logger.error("DaoAdminImpl: deleteMessage: Connection interrupted: ", e);
			throw new DaoException("deleteMessage", e);
		} catch (SQLException e) {
			logger.error("DaoAdminImpl: deleteMessage: SQL error: ", e);
			throw new DaoException("deleteMessage", e);
		} finally {
			closeResources(null, preparedStatement, connection, "deleteMessage");
		}
		return result;
	}

	@Override
	public boolean deleteUserFromBase(int idUser) throws DaoException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		boolean result = false;
		int profileId = 0;
		int resumeId = 0;

		try {
			connection = connectionPool.takeConnection();
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(SEARCH_PROFILEID_AND_RESUMEID_BY_IDUSER);
			preparedStatement.setInt(1, idUser);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				profileId = resultSet.getInt(1);
				resumeId = resultSet.getInt(2);
			}
			closePreparedStatement(preparedStatement, "deleteUserFromBase");
			
			preparedStatement = connection.prepareStatement(DELETE_USER_FROM_BASE_BY_ID);
			preparedStatement.setInt(1, idUser);
			preparedStatement.executeUpdate();
			closePreparedStatement(preparedStatement, "deleteUserFromBase");

			if (profileId != 0) {
				preparedStatement = connection.prepareStatement(DELETE_PROFILEID_BY_IDUSER);
				preparedStatement.setInt(1, idUser);
				preparedStatement.executeUpdate();
			}

			if (resumeId != 0) {
				preparedStatement = connection.prepareStatement(DELETE_RESUMEID_BY_IDUSER);
				preparedStatement.setInt(1, idUser);
				preparedStatement.executeUpdate();
			}

			result = true;
			connection.commit();
		} catch (InterruptedException | SQLException e) {
			try {
				logger.error("DaoAdminImpl: deleteUserFromBase:  transaction error: ", e);
				connection.rollback();
				throw new DaoException("deleteUserFromBase transaction error: ", e);
			} catch (SQLException e1) {
				logger.error("\"DaoAdminImpl: deleteUserFromBase: rollback error: ", e1);
				throw new DaoException("deleteUserFromBase: rollback error: ", e1);
			}
		} finally {
			closeResources(resultSet, preparedStatement, connection, "deleteUserFromBase");
		}

		return result;
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
			logger.error("DaoAdminImpl: " + methodName + " resultSetError: ", e);
		}
		try {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
		} catch (SQLException e) {
			logger.error("DaoAdminImpl: " + methodName + " preparedStatementError: ", e);
		}
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			logger.error("DaoAdminImpl: " + methodName + " connectionError: ", e);
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
			logger.error("DaoAdminImpl: " + methodName + "preparedStatementError: " + e);
			throw new DaoException(e);
		}
	}
	
	

}
