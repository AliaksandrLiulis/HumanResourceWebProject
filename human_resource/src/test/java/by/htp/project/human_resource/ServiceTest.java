package by.htp.project.human_resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import by.htp.project.human_resource.dao.dao_exception.DaoException;
import by.htp.project.human_resource.dao.dao_implimentation.DaoUserImpl;
import by.htp.project.human_resource.entity.User;
import by.htp.project.human_resource.entity.UserBuilder;
import by.htp.project.human_resource.service.service_implimentation.ServiceUserImpl;


class ServiceTest {

	@Mock		
	private static DaoUserImpl daoUserImpl;
	private static HttpSession httpSession;

	@InjectMocks
	private static ServiceUserImpl serviceUser;

	@BeforeAll
	public static void setup() {
		daoUserImpl = Mockito.mock(DaoUserImpl.class);		
		serviceUser = new ServiceUserImpl(daoUserImpl);
	}

	@AfterEach
	public void resetMock() {
		Mockito.reset(daoUserImpl);
	}

	@Test
	public void successfullySearchUserTest() throws DaoException {
		HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
		HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
		httpSession = request.getSession();
		request.setAttribute("nickName", "Alex");
		request.setAttribute("password", "123");		
		User user = new UserBuilder().nickName("Alex").build();			
		Mockito.when(daoUserImpl.searchUser("Alex", "123")).thenReturn(user);		
		Assert.assertEquals(user, httpSession.getAttribute("user"));
		Mockito.verify(serviceUser).logInUser(request, response);						
	}
}



