package by.htp.project.human_resource.dao.dao_interface;

import by.htp.project.human_resource.dao.dao_exception.DaoException;
import by.htp.project.human_resource.entity.Profile;
import by.htp.project.human_resource.entity.User;

public interface IDaoUser {

	User searchUser(String nickName, String password) throws DaoException;
	boolean searchUserNickName(String nickName) throws DaoException;
	User addUser(String... userParams) throws DaoException;
	Profile getProfile(int idUser) throws DaoException;
	boolean createMessage(String... params) throws DaoException;
	
}
