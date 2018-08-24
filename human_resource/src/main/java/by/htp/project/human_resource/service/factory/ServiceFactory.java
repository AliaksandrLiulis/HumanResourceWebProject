package by.htp.project.human_resource.service.factory;

import by.htp.project.human_resource.service.impl.ServiceAdminImpl;
import by.htp.project.human_resource.service.impl.ServiceHrImpl;
import by.htp.project.human_resource.service.impl.ServiceJobSeekerImpl;
import by.htp.project.human_resource.service.impl.ServiceUserImpl;
import by.htp.project.human_resource.service.interf.IServiceAdmin;
import by.htp.project.human_resource.service.interf.IServiceHr;
import by.htp.project.human_resource.service.interf.IServiceJobSeeker;
import by.htp.project.human_resource.service.interf.IServiceUser;

public class ServiceFactory {
	
	private static final ServiceFactory SERVICE_FACTORY = new ServiceFactory();
	
	private ServiceFactory() {
	}
	
	private IServiceUser serviceUser = new ServiceUserImpl();
	private IServiceJobSeeker serviceJobSeeker =  new ServiceJobSeekerImpl();
	private IServiceHr serviceHr = new ServiceHrImpl();
	private IServiceAdmin serviceAdmin = new ServiceAdminImpl();
	
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
	
	public static ServiceFactory getServiceFactory() {
		return SERVICE_FACTORY;
	}
}
