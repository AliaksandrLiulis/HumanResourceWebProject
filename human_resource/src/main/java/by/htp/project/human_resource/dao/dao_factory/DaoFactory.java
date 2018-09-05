package by.htp.project.human_resource.dao.dao_factory;

import by.htp.project.human_resource.dao.dao_implimentation.DaoAdminImpl;
import by.htp.project.human_resource.dao.dao_implimentation.DaoHrImpl;
import by.htp.project.human_resource.dao.dao_implimentation.DaoJobSeekerImpl;
import by.htp.project.human_resource.dao.dao_implimentation.DaoUserImpl;
import by.htp.project.human_resource.dao.dao_interface.IDAOJobSeeker;
import by.htp.project.human_resource.dao.dao_interface.IDaoAdmin;
import by.htp.project.human_resource.dao.dao_interface.IDaoHr;
import by.htp.project.human_resource.dao.dao_interface.IDaoUser;

/**
 * This class is singleton. Class which returns needed implimentation for work
 * with Dao layer
 */

public class DaoFactory {

	/** field new instance DaoFactory */
	private static final DaoFactory DAO_FACTORY = new DaoFactory();

	private DaoFactory() {
	}

	/** new instance for {@link DaoUserImpl} */
	private IDaoUser daoUser = new DaoUserImpl();
	/** new instance for {@link DaoJobSeekerImpl} */
	private IDAOJobSeeker daoJodSeeker = new DaoJobSeekerImpl();
	/** new instance for {@link DaoHrImpl} */
	private IDaoHr daoHr = new DaoHrImpl();
	/** new instance for {@link DaoAdminImpl} */
	private IDaoAdmin daoAdmin = new DaoAdminImpl();

	/**
	 * method gets value field {@link DaoFactory#daoUser}.
	 * 
	 * @return {@link DaoFactory#daoUser}.
	 */
	public IDaoUser getDaoUser() {
		return daoUser;
	}

	/**
	 * method gets value field {@link DaoFactory#daoJodSeeker}.
	 * 
	 * @return {@link DaoFactory#daoJodSeeker}.
	 */
	public IDAOJobSeeker getDaoJodSeeker() {
		return daoJodSeeker;
	}

	/**
	 * method gets value field {@link DaoFactory#daoHr}.
	 * 
	 * @return {@link DaoFactory#daoHr}.
	 */
	public IDaoHr getDaoHr() {
		return daoHr;
	}

	/**
	 * method gets value field {@link DaoFactory#daoAdmin}.
	 * 
	 * @return {@link DaoFactory#daoAdmin}.
	 */
	public IDaoAdmin getDaoAdmin() {
		return daoAdmin;
	}

	/**
	 * method gets value field {@link DaoFactory#DAO_FACTORY}.
	 * 
	 * @return {@link DaoFactory#DAO_FACTORY}.
	 */
	public static DaoFactory getDaoFactory() {
		return DAO_FACTORY;
	}
}
