package by.htp.project.human_resource.service.factory;

import by.htp.project.human_resource.service.impl.ServiceUserImpl;
import by.htp.project.human_resource.service.interf.IServiceUser;

public class ServiceFactory {
	
	private static final ServiceFactory SERVICE_FACTORY = new ServiceFactory();
	
	private ServiceFactory() {
	}
	
	private IServiceUser serviceUser = new ServiceUserImpl();
	
	public IServiceUser getServiceUser() {
		return serviceUser;
	}

	public static ServiceFactory getServiceFactory() {
		return SERVICE_FACTORY;
	}
}
