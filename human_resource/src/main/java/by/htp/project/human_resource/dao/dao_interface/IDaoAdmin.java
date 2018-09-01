package by.htp.project.human_resource.dao.dao_interface;

import java.util.List;

import by.htp.project.human_resource.dao.dao_exception.DaoException;
import by.htp.project.human_resource.entity.User;

public interface IDaoAdmin {
	
	List<User> searchAllRegisteredUserByParams(String... params) throws DaoException;
	List<User> searchAllUnregisteredUserByParams(String... params) throws DaoException;
	List<User> searchAllUserByParams(String... params) throws DaoException;
	int getCountAllRowsForTable(String tableName, int avaliable) throws DaoException;
	boolean updateAvaliableFildForUser(int idUser, int value) throws DaoException;
	
}
