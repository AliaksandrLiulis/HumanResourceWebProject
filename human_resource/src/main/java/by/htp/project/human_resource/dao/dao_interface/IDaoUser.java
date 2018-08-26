package by.htp.project.human_resource.dao.dao_interface;

import by.htp.project.human_resource.dao.dao_exception.DaoException;
import by.htp.project.human_resource.entity.Profile;
import by.htp.project.human_resource.entity.User;

public interface IDaoUser {
	User searchUser(final String nickName, final String password) throws DaoException;	
	boolean searchUserNickName(final String nickName) throws DaoException;
	User addUser(final String... userParams) throws DaoException;
	Profile getProfile(final int idUser) throws DaoException;
	boolean createmessage(final String... params) throws DaoException;

}