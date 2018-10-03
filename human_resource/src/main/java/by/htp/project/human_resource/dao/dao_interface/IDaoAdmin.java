package by.htp.project.human_resource.dao.dao_interface;

import java.util.List;

import by.htp.project.human_resource.dao.dao_exception.DaoException;
import by.htp.project.human_resource.entity.Message;
import by.htp.project.human_resource.entity.User;

/**
 * This Interface wich has metods for work with Administrator on the Dao layer
 * */

public interface IDaoAdmin {
	
	/**
	 * method which searches all registered {@link User} by incoming params
	 * @return {@link List} {@link User}
	 */
	List<User> searchAllRegisteredUserByParams(String... params) throws DaoException;
	
	/**
	 * method which searches all unregistered {@link User} by incoming params
	 * @return {@link List} {@link User}
	 */
	List<User> searchAllUnregisteredUserByParams(String... params) throws DaoException;
	
	/**
	 * method which searches all {@link User} by incoming params
	 * @return {@link List} {@link User}
	 */
	List<User> searchAllUserByParams(String... params) throws DaoException;
	
	/**
	 * method which gets count all rows for tables by tableName and fild avaliable 
	 * @return int value
	 */
	int getCountAllRowsForTable(String tableName, int avaliable) throws DaoException;
	
	/**
	 * method which update fild {@link User#avaliable} for users by {@link User#userId} and Installed value
	 * @return boolean value
	 */
	boolean updateAvaliableFildForUser(int idUser, int value) throws DaoException;
	/**
	 * method which delete {@link Message} by {@link Message#idmessage}
	 * @return boolean value
	 */
	boolean deleteMessage(int idMessage) throws DaoException;
	
	/**
	 * method which search All message
	 * @return List<Message>
	 */
	
	List<Message> searchAllMessage() throws DaoException;
	
}
