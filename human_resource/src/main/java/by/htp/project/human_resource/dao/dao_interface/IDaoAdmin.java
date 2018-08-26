package by.htp.project.human_resource.dao.dao_interface;

import java.util.List;

import by.htp.project.human_resource.dao.dao_exception.DaoException;
import by.htp.project.human_resource.entity.User;

public interface IDaoAdmin {
	
	List<User> searchAllRegisteredUserByParams(final String... params) throws DaoException;
	List<User> searchAllUnregisteredUserByParams(final String... params) throws DaoException;
	List<User> searchAllUserByParams(final String... params) throws DaoException;
	int getCountAllRowsForTable(final String tableName, final int avaliable) throws DaoException;
	boolean updateAvaliableFildForUser(final int idUser, final int value) throws DaoException;
}
