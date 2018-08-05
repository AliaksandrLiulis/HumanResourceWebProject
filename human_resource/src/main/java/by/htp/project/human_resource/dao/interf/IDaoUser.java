package by.htp.project.human_resource.dao.interf;




import by.htp.project.human_resource.dao.exception.DaoException;
import by.htp.project.human_resource.entity.User;

public interface IDaoUser {
	User logInUser(String nickName, String password) throws DaoException;
	boolean chekUsernickName(String nickName) throws DaoException;
	User registerUser(String... userParams) throws DaoException;

}
