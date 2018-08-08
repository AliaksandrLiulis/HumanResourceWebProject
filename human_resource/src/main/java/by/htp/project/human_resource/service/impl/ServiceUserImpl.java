package by.htp.project.human_resource.service.impl;

import java.util.List;

import by.htp.project.human_resource.dao.exception.DaoException;
import by.htp.project.human_resource.dao.factory.DaoFactory;
import by.htp.project.human_resource.dao.interf.IDaoUser;
import by.htp.project.human_resource.entity.User;
import by.htp.project.human_resource.service.exception.ServiceException;
import by.htp.project.human_resource.service.interf.IServiceUser;

public class ServiceUserImpl implements IServiceUser {

	public User logInUser(final String nickName, final String password) throws ServiceException {

		CheckLoginParam checkParam = CheckLoginParam.getCheckParam();
		if (checkParam.check(nickName, password)) {
			DaoFactory daoFactory = DaoFactory.getDaoFactory();
			IDaoUser daoUser = daoFactory.getDaoUser();
			try {
				return daoUser.searchUser(nickName, password);
			} catch (DaoException e) {
				throw new ServiceException("Service:method:logInUser" + e);
			}
		}
		return null;
	}

	@Override
	public User registerUser(final String name, final String surname, final String nickName, final String password, final String email, final String role)
			throws ServiceException {
		DaoFactory daoFactory = DaoFactory.getDaoFactory();
		IDaoUser daoUser = daoFactory.getDaoUser();

		CheckRegisterParam checkRegisterParam = CheckRegisterParam.getCheckParam();
		if (checkRegisterParam.check(name, surname, nickName, password, email, role)) {

			try {
				if (daoUser.searchUserNickName(nickName)) {
					return daoUser.addUser(name, surname, nickName, password, email, role);
				}
			} catch (DaoException e) {
				throw new ServiceException("Service:method:registerUser" + e);
			}
		}
		return null;
	}

	@Override
	public List<User> getAllUser() throws ServiceException {
		List<User> allUserBase = null;
		DaoFactory daoFactory = DaoFactory.getDaoFactory();
		IDaoUser daoUser = daoFactory.getDaoUser();
		allUserBase = daoUser.getAllUserBase();
		if (allUserBase.size() == 0) {
			throw new ServiceException("Base is Empty");
		}else {
			return allUserBase;
		}		
	}
}
