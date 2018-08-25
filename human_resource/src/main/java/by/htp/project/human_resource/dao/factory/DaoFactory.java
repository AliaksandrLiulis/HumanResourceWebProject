package by.htp.project.human_resource.dao.factory;

import by.htp.project.human_resource.dao.impl.DaoAdminImpl;
import by.htp.project.human_resource.dao.impl.DaoHrImpl;
import by.htp.project.human_resource.dao.impl.DaoJobSeekerImpl;
import by.htp.project.human_resource.dao.impl.DaoUserImpl;
import by.htp.project.human_resource.dao.interf.IDAOJobSeeker;
import by.htp.project.human_resource.dao.interf.IDaoAdmin;
import by.htp.project.human_resource.dao.interf.IDaoHr;
import by.htp.project.human_resource.dao.interf.IDaoUser;

public class DaoFactory {
	
	private static final DaoFactory DAO_FACTORY = new DaoFactory();
	
	private DaoFactory() {
	}
	
	private IDaoUser daoUser = new DaoUserImpl();
	private IDAOJobSeeker daoJodSeeker = new DaoJobSeekerImpl();
	private IDaoHr daoHr = new DaoHrImpl();
	private IDaoAdmin daoAdmin = new DaoAdminImpl();
	
	public IDaoUser getDaoUser() {
		return daoUser;
	}	

	public IDAOJobSeeker getDaoJodSeeker() {
		return daoJodSeeker;
	}	

	public IDaoHr getDaoHr() {
		return daoHr;
	}
	
	public IDaoAdmin getDaoAdmin() {
		return daoAdmin;
	}

	public static DaoFactory getDaoFactory() {
		return DAO_FACTORY;
	}
}
