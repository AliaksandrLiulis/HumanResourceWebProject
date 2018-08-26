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

public class ServiceFactory {
	
	private static final ServiceFactory SERVICE_FACTORY = new ServiceFactory();
	
	private ServiceFactory() {
	}
	
	private IServiceUser serviceUser = new ServiceUserImpl();
	private IServiceJobSeeker serviceJobSeeker =  new ServiceJobSeekerImpl();
	private IServiceHr serviceHr = new ServiceHrImpl();
	private IServiceAdmin serviceAdmin = new ServiceAdminImpl();
	private IServiceUtil serviceUtil = new ServiceUtilImpl();
	
	public IServiceUser getServiceUser() {
		return serviceUser;
	}	

	public IServiceJobSeeker getServiceJobSeeker() {
		return serviceJobSeeker;
	}
	
	
	public IServiceHr getServiceHr() {
		return serviceHr;
	}

	public IServiceAdmin getServiceAdmin() {
		return serviceAdmin;
	}
	
	public IServiceUtil getServiceUtil() {
		return serviceUtil;
	}
	
	public static ServiceFactory getServiceFactory() {
		return SERVICE_FACTORY;
	}
}
