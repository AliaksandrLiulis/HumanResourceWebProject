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


	private final String SEARCH_USER = "SELECT iduser, name, surname, nickName, email, avaliable, profileId, resumeId, role FROM users join userroles on users.userroles_iduserrole = userroles.iduserrole where users.nickname = ? and users.password = ?";
	private final String GET_USER = "SELECT iduser, name, surname, nickName, email, avaliable, profile, resumeId, role FROM users join userroles on users.userroles_iduserrole = userroles.iduserrole where users.iduser = ?";
	private final String SEARCH_USER_NICKNAME = "SELECT nickname from users  where nickname = ?";
	private final String ADD_USER = "INSERT into users (nickName ,name,  surname, password , avaliable, email, userroles_iduserrole, profileId, resumeId ) VALUES (?,?,?,?,?,?,?,?,?)";
	private final String GET_ALL_USER_BASE = "SELECT * FROM users join userroles on users.userroles_iduserrole = userroles.iduserrole";
	private final String ADD_NEW_PROFILE = "INSERT into profile (registration_date ,birth_date,  phone, residence , work_speciality, work_expirience, education, photo, about_user, id_user ) VALUES (?,?,?,?,?,?,?,?,?,?)";
	private final String GET_PROFILE_ID = "SELECT idprofiles from profile where profile.id_user = ?";
	private final String SET_ID_PROFILE_FOR_USER = "UPDATE users SET profile=? where iduser=?";
	private final String GET_EXIST_PROFILE = "SELECT * FROM profile where id_user = ?";
	private final String DELETE_PROFILE = "DELETE FROM profile where id_user = ?";
	private final String UPDATE_FIELD_FROM_USER = "UPDATE users  SET profile=? , resumeId=? where iduser=?";
	private final String UPDATE_OLD_PROFILE = "UPDATE profile SET registration_date = ?, birth_date = ?,phone = ?, residence = ?, work_speciality = ?, work_expirience = ?, education = ?, photo = ?, about_user = ? where id_user = ?";
	private final String ADD_NEW_RESUME = "INSERT into resume (idUser ,registrationDate,  name, surName , dateOfBirthDay, residence, phone, email, education, workSpeciality, workExpirience, aboutUser, photoPath ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private final String GET_RESUMEE_ID = "SELECT idresume from resume where resume.idUser = ?";
	private final String SET_ID_RESUME_FOR_USER = "UPDATE users SET resumeId=? where iduser=?";
	private final String DELETE_RESUME = "DELETE FROM resume where idUser = ?";
	private final String UPDATE_FIELD_FROM_USER_FOR_RESUME = "UPDATE users  SET resumeId=? where iduser=?";
	private final String UPDATE_OLD_RESUME = "UPDATE resume SET dateOfBirthDay = ?, phone = ?, residence = ?, workSpeciality = ?, workExpirience = ?, education = ?, photoPath = ?, aboutUser = ? where idUser = ?";
	
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

				user = new UserBuilder().id(Integer.parseInt(result.getString(1))).name(result.getString(2))
						.surName(result.getString(3)).nickName(result.getString(4)).email(result.getString(5))
						.avaliable(result.getInt(6)).profileId(Integer.parseInt(result.getString(7))).resumeId(result.getInt(8))
						.role(result.getString(9)).build();
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
	
	private Map<String, Integer> setRoles() {
		allRolles = new HashMap<String, Integer>();
		allRolles.put(AllRole.ADMINISTRATOR.getValue(), AllRole.ADMINISTRATOR.getIdNumber());
		allRolles.put(AllRole.BOSS.getValue(), AllRole.BOSS.getIdNumber());
		allRolles.put(AllRole.HR.getValue(), AllRole.HR.getIdNumber());
		allRolles.put(AllRole.EMPLOYEE.getValue(), AllRole.EMPLOYEE.getIdNumber());
		return allRolles;
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
			preparedStatement.setInt(8, 0);
			preparedStatement.setInt(9, 0);
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
	
	
}
