package by.htp.project.human_resource.service.service_factory;

import by.htp.project.human_resource.service.service_implimentation.ServiceAdminImpl;
import by.htp.project.human_resource.service.service_implimentation.ServiceHrImpl;
import by.htp.project.human_resource.service.service_implimentation.ServiceJobSeekerImpl;
import by.htp.project.human_resource.service.service_implimentation.ServiceUserImpl;
import by.htp.project.human_resource.service.service_implimentation.ServiceUtilImpl;
import by.htp.project.human_resource.service.service_interface.IServiceAdmin;
import by.htp.project.human_resource.service.service_interface.IServiceHr;
import by.htp.project.human_resource.service.service_interface.IServiceJobSeeker;
import by.htp.project.human_resource.service.service_interface.IServiceUser;
import by.htp.project.human_resource.service.service_interface.IServiceUtil;

/**
 * This class is singleton. Class which returns needed implimentation for work
 * with Service layer
 */

public class ServiceFactory {
	
	/** field new instance ServiceFactory */
	private static final ServiceFactory SERVICE_FACTORY = new ServiceFactory();
	
	private ServiceFactory() {
	}
	
	/** new instance for {@link ServiceUserImpl} */
	private IServiceUser serviceUser = new ServiceUserImpl();
	/** new instance for {@link ServiceJobSeekerImpl} */
	private IServiceJobSeeker serviceJobSeeker =  new ServiceJobSeekerImpl();
	/** new instance for {@link ServiceHrImpl} */
	private IServiceHr serviceHr = new ServiceHrImpl();
	/** new instance for {@link ServiceAdminImpl} */
	private IServiceAdmin serviceAdmin = new ServiceAdminImpl();
	/** new instance for {@link ServiceUtilImpl} */
	private IServiceUtil serviceUtil = new ServiceUtilImpl();
	
	
	/**
	 * method gets value field {@link ServiceFactory#serviceUser}.
	 * 
	 * @return {@link ServiceFactory#serviceUser}.
	 */
	public IServiceUser getServiceUser() {
		return serviceUser;
	}	

	/**
	 * method gets value field {@link ServiceFactory#getServiceJobSeeker}.
	 * 
	 * @return {@link ServiceFactory#getServiceJobSeeker}.
	 */
	public IServiceJobSeeker getServiceJobSeeker() {
		return serviceJobSeeker;
	}
	
	/**
	 * method gets value field {@link ServiceFactory#serviceHr}.
	 * 
	 * @return {@link ServiceFactory#serviceHr}.
	 */
	public IServiceHr getServiceHr() {
		return serviceHr;
	}

	/**
	 * method gets value field {@link ServiceFactory#serviceAdmin}.
	 * 
	 * @return {@link ServiceFactory#serviceAdmin}.
	 */
	public IServiceAdmin getServiceAdmin() {
		return serviceAdmin;
	}
	
	/**
	 * method gets value field {@link ServiceFactory#serviceUtil}.
	 * 
	 * @return {@link ServiceFactory#serviceUtil}.
	 */
	public IServiceUtil getServiceUtil() {
		return serviceUtil;
	}
	
	/**
	 * method gets value field {@link ServiceFactory#getServiceJobSeeker}.
	 * 
	 * @return {@link ServiceFactory#SERVICE_FACTORY}.
	 */
	public static ServiceFactory getServiceFactory() {
		return SERVICE_FACTORY;
	}
}
