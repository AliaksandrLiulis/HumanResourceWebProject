package by.htp.project.human_resource;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.project.human_resource.dao.dao_exception.DaoException;
import by.htp.project.human_resource.dao.dao_implimentation.DaoUserImpl;
import by.htp.project.human_resource.entity.Profile;
import by.htp.project.human_resource.entity.ProfileBuilder;
import by.htp.project.human_resource.entity.User;
import by.htp.project.human_resource.entity.UserBuilder;
import by.htp.project.human_resource.service.impl.checker.CheckCommand;
import by.htp.project.human_resource.service.service_constant.ServiceJspPagePath;
import by.htp.project.human_resource.service.service_constant.ServiceParamConstant;
import by.htp.project.human_resource.service.service_implimentation.ServiceUserImpl;

class ServiceTest {

	@Mock
	private static DaoUserImpl daoUserImpl;
	private static HttpServletRequest request;
	private static HttpServletResponse response;
	private static HttpSession session;
	private static RequestDispatcher dispatcher;

	@InjectMocks
	private static ServiceUserImpl serviceUser;

	@BeforeAll
	public static void setup() {
		request = mock(HttpServletRequest.class);
		response = mock(HttpServletResponse.class);
		daoUserImpl = mock(DaoUserImpl.class);
		serviceUser = new ServiceUserImpl(daoUserImpl);
		session = mock(HttpSession.class);
		dispatcher = mock(RequestDispatcher.class);

	}

	@AfterEach
	public void resetMock() {
		reset(daoUserImpl);
		reset(request);
		reset(response);
		reset(session);
		reset(dispatcher);
	}

	@Test
	public void successfullyLoginUserTest() throws DaoException, ServletException, IOException {
		String nick = "nickName";
		String passw = "password";

		when(request.getParameter(ServiceParamConstant.NICKNAME_PARAM)).thenReturn(nick);
		when(request.getParameter(ServiceParamConstant.PASSWORD_PARAM)).thenReturn(passw);

		Profile profile = new ProfileBuilder().profileId(1).aboutUser("aboutUser").build();
		User user = new UserBuilder().nickName(nick).avaliable(1).profileId(1).role( ServiceParamConstant.ADMIN_ROLE).build();

		when(daoUserImpl.searchUser(nick, passw)).thenReturn(user);
		when(request.getSession()).thenReturn(session);
		when(daoUserImpl.getProfile(user.getUserId())).thenReturn(profile);
		when(request.getRequestURI()).thenReturn("path");

		serviceUser.logInUser(request, response);
		verify(request).getParameter(ServiceParamConstant.NICKNAME_PARAM);
		verify(request).getParameter(ServiceParamConstant.PASSWORD_PARAM);
		verify(daoUserImpl).searchUser(nick, passw);
		verify(request).getSession();
		verify(session).setAttribute("user", user);
		verify(daoUserImpl).getProfile(user.getUserId());
		verify(session).setAttribute(ServiceParamConstant.PROFILE_ATTRIBUTE, profile);
		verify(response)
				.sendRedirect("path" + CheckCommand.getInstance().checkRoleForCommand(user.getRole()));
	}

	@Test
	public void doThrowfullyLoginUserTest() throws DaoException, ServletException, IOException {
		String nick = "nickName";
		String passw = "password";

		when(request.getParameter(ServiceParamConstant.NICKNAME_PARAM)).thenReturn(nick);
		when(request.getParameter(ServiceParamConstant.PASSWORD_PARAM)).thenReturn(passw);
		when(request.getRequestDispatcher(ServiceJspPagePath.PATH_LOGIN_PAGE)).thenReturn(dispatcher);
		doThrow(new DaoException("errorMessage")).when(daoUserImpl).searchUser(nick, passw);

		serviceUser.logInUser(request, response);
		verify(request).getParameter(ServiceParamConstant.NICKNAME_PARAM);
		verify(request).getParameter(ServiceParamConstant.PASSWORD_PARAM);
		verify(daoUserImpl).searchUser(nick, passw);
		try {
			daoUserImpl.searchUser(nick, passw);
			Assertions.fail("expected exception");
		} catch (DaoException e) {
			Assertions.assertEquals("errorMessage", e.getMessage());
		}
	}
}
