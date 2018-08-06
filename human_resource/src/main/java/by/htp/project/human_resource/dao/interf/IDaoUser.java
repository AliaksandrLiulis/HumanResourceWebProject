package by.htp.project.human_resource.dao.interf;




import by.htp.project.human_resource.dao.exception.DaoException;
import by.htp.project.human_resource.entity.User;

public interface IDaoUser {
	User logInUser(final String nickName, final String password) throws DaoException;
	boolean chekUsernickName(final String nickName) throws DaoException;
	User registerUser(final String... userParams) throws DaoException;

}
