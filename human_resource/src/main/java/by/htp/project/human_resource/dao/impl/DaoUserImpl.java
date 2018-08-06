package by.htp.project.human_resource.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import by.htp.project.human_resource.dao.exception.DaoException;
import by.htp.project.human_resource.dao.interf.IDaoUser;
import by.htp.project.human_resource.dao.poolconnection.ConnectionPool;
import by.htp.project.human_resource.entity.User;

public class DaoUserImpl implements IDaoUser {

	private ConnectionPool connectionPool = null;
	private Map<String, Integer> allRolles = null;
	private final String ADMINROLE = "admin";
	private final String BOSSROLE = "boss";
	private final String HRROLE = "hr";
	private final String EMPLOYEEROLE = "employee";

	public DaoUserImpl() {
		if (null == connectionPool) {
			connectionPool = ConnectionPool.getInstance();
		}
	}

	public User logInUser(final String nickName, final String password) throws DaoException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		User user = null;

		try {
			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement(
					"SELECT name, surname, nickName, email, avaliable, role FROM users join userroles on users.userroles_iduserrole = userroles.iduserrole where users.nickname = ? and users.password = ?");
			preparedStatement.setString(1, nickName);
			preparedStatement.setString(2, password);
			result = preparedStatement.executeQuery();

			if (result.next()) {
				user = createUser(result.getString(1), result.getString(2), result.getString(3), result.getString(4),
						result.getInt(5), result.getString(6));
			}
		} catch (SQLException e) {

		} catch (InterruptedException e) {

		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {

				}
			}
			try {
				connection.close();
			} catch (SQLException e) {

			}
		}
		return user;
	}

	@Override
	public boolean chekUsernickName(final String nickName) throws DaoException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		String nick = null;

		try {
			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement("SELECT nickname from users  where nickname = ?");
			preparedStatement.setString(1, nickName);
			result = preparedStatement.executeQuery();

			if (result.next()) {
				nick = result.getString(1);
			}
		} catch (SQLException | InterruptedException e) {
			
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					
				}
			}
			try {
				connection.close();
			} catch (SQLException e) {
			
			}
		}
		if (null == nick) {
			return true;
		}
		return false;
	}

	@Override
	public User registerUser(final String... userParams) throws DaoException {
		List<String> allParams = new ArrayList<String>(Arrays.asList(userParams));
		if (null == allRolles) {
			allRolles = setRoles();
		}
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		User user = null;
		try {
			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement(
					"INSERT into users (nickName ,name,  surname, password , avaliable, email, userroles_iduserrole ) VALUES (?,?,?,?,?,?,?)");
			preparedStatement.setString(1, allParams.get(2));
			preparedStatement.setString(2, allParams.get(0));
			preparedStatement.setString(3, allParams.get(1));
			preparedStatement.setString(4, allParams.get(3));
			preparedStatement.setInt(5, 0);
			preparedStatement.setString(6, allParams.get(4));
			preparedStatement.setInt(7, checkRole(allParams.get(5)));
			preparedStatement.executeUpdate();

			user = new User(allParams.get(0), allParams.get(1), allParams.get(2), allParams.get(3), 0,
					allParams.get(5));

		} catch (SQLException | InterruptedException e) {
			
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
				
				}
			}
			try {
				connection.close();
			} catch (SQLException e) {
				
			}
		}

		return user;
	}

	private Map<String, Integer> setRoles() {
		allRolles = new HashMap<String, Integer>();
		allRolles.put(ADMINROLE, 1);
		allRolles.put(BOSSROLE, 2);
		allRolles.put(HRROLE, 3);
		allRolles.put(EMPLOYEEROLE, 4);
		return allRolles;
	}
	
	private int checkRole(final String role) {
		Set<Map.Entry<String, Integer>> entrySet = allRolles.entrySet();
		int numForSql = 0;
		for (Map.Entry<String, Integer> pair : entrySet) {
			if (role.equals(pair.getKey())) {
				numForSql = pair.getValue();
			}			
		}
		return numForSql;
	}
	
	private User createUser(final String name, final String surname, final String nickName, final String email, final int avaliable, final String role) {
		User user = new User(name, surname, nickName, email, avaliable, role);
		return user;
	}
}
