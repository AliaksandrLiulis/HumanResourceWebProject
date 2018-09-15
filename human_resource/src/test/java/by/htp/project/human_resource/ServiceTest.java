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
import by.htp.project.human_resource.entity.Profile;
import by.htp.project.human_resource.entity.ProfileBuilder;
import by.htp.project.human_resource.entity.User;
import by.htp.project.human_resource.entity.UserBuilder;
import by.htp.project.human_resource.service.impl.checker.CheckCommand;
import by.htp.project.human_resource.service.impl.checker.CheckLoginParam;
import by.htp.project.human_resource.service.service_implimentation.ServiceUserImpl;

class ServiceTest {

	@Mock
	private static DaoUserImpl daoUserImpl;
	private static HttpSession httpSession;
	private static CheckLoginParam checkLoginParam;
	private static CheckCommand checkCommand;
	private static HttpServletRequest request;
	private static HttpServletResponse response;

	@InjectMocks
	private static ServiceUserImpl serviceUser;

	@BeforeAll
	public static void setup() {
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		daoUserImpl = Mockito.mock(DaoUserImpl.class);
		serviceUser = new ServiceUserImpl(daoUserImpl);
		httpSession = Mockito.mock(HttpSession.class);
		checkLoginParam = Mockito.mock(CheckLoginParam.class);
		checkCommand = Mockito.mock(CheckCommand.class);

	}

	@AfterEach
	public void resetMock() {
		Mockito.reset(daoUserImpl);
	}

	@Test
	public void successfullyLoginUserTest() throws DaoException {

		User user = new UserBuilder().build();
		Profile profile = new ProfileBuilder().build();
		request.setAttribute("nickName", "Alex");

		Mockito.when(request.getParameter("nickName")).thenReturn("Alex");
		String res = request.getParameter("nickName");
		Assert.assertEquals("Alex", res);

		Mockito.when(checkLoginParam.check(Mockito.anyString())).thenReturn(true);
		boolean result = checkLoginParam.check("nickName");
		Assert.assertEquals(true, result);

		Mockito.when(daoUserImpl.searchUser("Alex", "123")).thenReturn(user);
		User checkUser = daoUserImpl.searchUser("Alex", "123");
		Assert.assertEquals(user, checkUser);
		
		Mockito.when(request.getSession()).thenReturn(httpSession);
		HttpSession checkSession = request.getSession();
		Assert.assertEquals(httpSession, checkSession);
		
		Mockito.when(daoUserImpl.getProfile(1)).thenReturn(profile);
		Profile checkProfile = daoUserImpl.getProfile(1);
		Assert.assertEquals(profile, checkProfile);
		

	}
}
