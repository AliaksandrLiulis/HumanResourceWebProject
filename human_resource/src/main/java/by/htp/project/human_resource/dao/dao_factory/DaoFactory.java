package by.htp.project.human_resource.dao.dao_factory;

import by.htp.project.human_resource.dao.dao_implimentation.DaoAdminImpl;
import by.htp.project.human_resource.dao.dao_implimentation.DaoHrImpl;
import by.htp.project.human_resource.dao.dao_implimentation.DaoJobSeekerImpl;
import by.htp.project.human_resource.dao.dao_implimentation.DaoUserImpl;
import by.htp.project.human_resource.dao.dao_interface.IDAOJobSeeker;
import by.htp.project.human_resource.dao.dao_interface.IDaoAdmin;
import by.htp.project.human_resource.dao.dao_interface.IDaoHr;
import by.htp.project.human_resource.dao.dao_interface.IDaoUser;

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
