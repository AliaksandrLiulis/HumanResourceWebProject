package by.htp.project.human_resource.dao.impl;

import by.htp.project.human_resource.dao.exception.DaoException;
import by.htp.project.human_resource.dao.interf.IDaoUser;
import by.htp.project.human_resource.dao.sql.exception.SqlException;
import by.htp.project.human_resource.entity.User;

public class DaoUserImpl implements IDaoUser {

	public User logInUser(String nickName, String password) throws DaoException{
		User user = null;
		try {
			user = new SQLUser().checkUser(nickName, password);
		} catch (SqlException e) {
			throw new DaoException("DAO:method:logInUser" + e);
		}
		return user;
	}

	@Override
	public boolean chekUsernickName(String nickName) throws DaoException{
		boolean check;
		try {
			check = new SQLUser().checkNickName(nickName);
			if (check) {
				return true;
			}
		} catch (SqlException e) {
			throw new DaoException("DAO:method:chekUsernickName " + e);
		}
		return false;
	}

	@Override
	public User registerUser(String... userParams) throws DaoException {
		User user = null;
		try {
			user = new SQLUser().addUser(userParams);
		} catch (SqlException e) {
			throw new DaoException("DAO:method:registerUser " + e);
		}
		return user;
	}
}
