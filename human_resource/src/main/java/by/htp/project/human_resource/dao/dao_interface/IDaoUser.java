package by.htp.project.human_resource.dao.dao_interface;

import by.htp.project.human_resource.dao.dao_exception.DaoException;
import by.htp.project.human_resource.entity.Profile;
import by.htp.project.human_resource.entity.User;

/**
 * This Interface wich has metods for work with Users on the Dao layer
 * */
public interface IDaoUser {

	/**
	 * method which searches all {@link User} by nickName and password
	 * @return {@link User}
	 */
	User searchUser(String nickName, String password) throws DaoException;
	
	/**
	 * method which searches all {@link User} by nickName
	 * @return boolean value
	 */
	boolean searchUserNickName(String nickName) throws DaoException;
	
	/**
	 * method which adds {@link User} by input params
	 * @return {@link User}
	 */
	User addUser(String... userParams) throws DaoException;
	
	/**
	 * method which search {@link Profile} by {@link User#userId}
	 * @return {@link Profile}}
	 */
	Profile getProfile(int idUser) throws DaoException;
	
	/**
	 * method which creates message by input params
	 * @return boolean value
	 */
	boolean createMessage(String... params) throws DaoException;
	
}
