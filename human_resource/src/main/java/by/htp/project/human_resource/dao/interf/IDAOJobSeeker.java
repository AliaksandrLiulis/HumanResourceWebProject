package by.htp.project.human_resource.dao.interf;

import java.util.List;

import by.htp.project.human_resource.entity.Profile;
import by.htp.project.human_resource.entity.User;

public interface IDAOJobSeeker {
	
	
	List<Object> addNewProfile(final String... profileParams);
	List<User> getAllUserBase();	
	Profile getProfile(final int idUser);
	User removeProfile(final int userId);
	Profile updateOldProfile(final String...profileParams);
	User addNewResume(final String... resumeParams);
	User deleteResume(final int idUserResume);

}
