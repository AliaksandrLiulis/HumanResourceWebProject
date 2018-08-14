package by.htp.project.human_resource.dao.factory;

import by.htp.project.human_resource.dao.impl.DaoJobSeekerImpl;
import by.htp.project.human_resource.dao.impl.DaoUserImpl;
import by.htp.project.human_resource.dao.interf.IDAOJodSeeker;
import by.htp.project.human_resource.dao.interf.IDaoUser;

public class DaoFactory {
	
	private static final DaoFactory DAO_FACTORY = new DaoFactory();
	
	private DaoFactory() {
	}
	
	private IDaoUser daoUser = new DaoUserImpl();
	private IDAOJodSeeker daoJodSeeker = new DaoJobSeekerImpl();
	
	public IDaoUser getDaoUser() {
		return daoUser;
	}	

	public IDAOJodSeeker getDaoJodSeeker() {
		return daoJodSeeker;
	}

	public static DaoFactory getDaoFactory() {
		return DAO_FACTORY;
	}
}
