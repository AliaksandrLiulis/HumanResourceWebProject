package by.htp.project.human_resource.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import by.htp.project.human_resource.dao.exception.DaoException;
import by.htp.project.human_resource.dao.factory.DaoFactory;
import by.htp.project.human_resource.dao.interf.IDaoUser;
import by.htp.project.human_resource.entity.Profile;
import by.htp.project.human_resource.entity.User;
import by.htp.project.human_resource.service.exception.ServiceException;
import by.htp.project.human_resource.service.interf.IServiceUser;

public class ServiceUserImpl implements IServiceUser {
	private final DaoFactory daoFactory = DaoFactory.getDaoFactory();
	private final IDaoUser daoUser = daoFactory.getDaoUser();

	public List<Object> logInUser(final String nickName, final String password) throws ServiceException {
		User user = null;
		Profile profile = null;
		List<Object> list = new ArrayList<>();

		CheckLoginParam checkParam = CheckLoginParam.getCheckParam();
		if (checkParam.check(nickName, password)) {
			
			try {
				user = daoUser.searchUser(nickName, password);			
				list.add(user);
				if (user.getProfileId() != 0) {
					profile = daoUser.getProfile(user.getId());
					list.add(profile);
				}				
				return list;
			} catch (DaoException e) {
				throw new ServiceException("Service:method:logInUser" + e);
			}
		}
		return null;
	}

	@Override
	public User registerUser(final String name, final String surname, final String nickName, final String password, final String email, final String role)
			throws ServiceException {
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
		allUserBase = daoUser.getAllUserBase();
		if (allUserBase.size() == 0) {
			throw new ServiceException("Base is Empty");
		}else {
			return allUserBase;
		}		
	}

	@Override
	public List<Object> addProfile(final String... params) throws ServiceException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
		String UserId = params[0];
		String registration_date = dateFormat.format(new Date());		
		String photo = params[1];
		String phone = params[2];
		String birthDay = params[3];
		String residence = params[4];
		String workSpeciality = params[5];
		String workExpirience = params[6];
		String education = params[7];
		String message = params[8];
		User user = null;		
		List<Object> list = null;
				
		list = daoUser.addNewProfile(UserId, registration_date, photo, phone, birthDay, residence, workSpeciality, workExpirience, education, message);
		return list;
	}

	@Override
	public User deleteProfile(int userId) throws ServiceException {
		return daoUser.removeProfile(userId);
		
	}

	@Override
	public Profile updateProfile(final String... profileParams) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
		String UserId = profileParams[0];
		String registration_date = dateFormat.format(new Date());		
		String photo = profileParams[1];
		String phone = profileParams[2];
		String birthDay = profileParams[3];
		String residence = profileParams[4];
		String workSpeciality = profileParams[5];
		String workExpirience = profileParams[6];
		String education = profileParams[7];
		String message = profileParams[8];
		Profile profile = null;
		profile = daoUser.updateOldProfile(UserId, registration_date, photo, phone, birthDay, residence, workSpeciality, workExpirience, education, message);
		return profile;
	}

	@Override
	public User addResume(String... resumeParams) {
		User user = daoUser.addNewResume(resumeParams);
		return user;
		
	}


	
}
