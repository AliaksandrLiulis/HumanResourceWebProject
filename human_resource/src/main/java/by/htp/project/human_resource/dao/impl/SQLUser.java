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

import org.apache.log4j.Logger;

import by.htp.project.human_resource.controller.commandprovider.interf.ICommand;
import by.htp.project.human_resource.dao.poolconnection.ConnectionPool;
import by.htp.project.human_resource.dao.sql.exception.SqlException;
import by.htp.project.human_resource.entity.User;

public class SQLUser {

	private ConnectionPool connectionPool = null;
	private Map<String, Integer> allRolles = null;
	private final String ADMINROLE = "admin";
	private final String BOSSROLE = "boss";
	private final String HRROLE = "hr";
	private final String EMPLOYEEROLE = "employee";

	public SQLUser() {
		if (null == connectionPool) {
			connectionPool = ConnectionPool.getInstance();
		}
	}

	public User checkUser(String nickName, String password) throws SqlException {

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
			throw new SqlException("method:checkUser " + e);
		} catch (InterruptedException e) {
			throw new SqlException("method:checkUser " + e);
		}finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					throw new SqlException("method:checkUser.close_Statment " + e);
				}
			}
			try {
				connection.close();
			} catch (SQLException e) {
				throw new SqlException("method:checkUser.close_Connection " + e);
			}
		}
		return user;
	}

	public boolean checkNickName(String nickName) throws SqlException {

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
			throw new SqlException("method:checkNickName " + e);
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					throw new SqlException("method:checkNickName.close_Statment " + e);
				}
			}
			try {
				connection.close();
			} catch (SQLException e) {
				throw new SqlException("method:checkUser.close_Connection " + e);
			}
		}
		if (null == nick) {
			return true;
		}
		return false;
	}

	public User addUser(String... allParam) throws SqlException {
		List<String> allParams = new ArrayList<String>(Arrays.asList(allParam));
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
			throw new SqlException("method:addUser " + e);
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					throw new SqlException("method:addUser.close_Statment " + e);
				}
			}
			try {
				connection.close();
			} catch (SQLException e) {
				throw new SqlException("method:addUser.close_Connection " + e);
			}
		}

		return user;
	}

	private User createUser(String name, String surname, String nickName, String email, int avaliable, String role) {
		User user = new User(name, surname, nickName, email, avaliable, role);
		return user;
	}

	private int checkRole(String role) {
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
		allRolles.put(ADMINROLE, 1);
		allRolles.put(BOSSROLE, 2);
		allRolles.put(HRROLE, 3);
		allRolles.put(EMPLOYEEROLE, 4);
		return allRolles;
	}

}
