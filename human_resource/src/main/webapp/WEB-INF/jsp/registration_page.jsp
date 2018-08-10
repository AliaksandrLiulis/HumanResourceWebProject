<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>

<title>registration_page</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">

<link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="lib/nivo-slider/css/nivo-slider.css" rel="stylesheet">
<link href="lib/owlcarousel/owl.carousel.css" rel="stylesheet">
<link href="lib/owlcarousel/owl.transitions.css" rel="stylesheet">
<link href="lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
<link href="lib/animate/animate.min.css" rel="stylesheet">
<link href="lib/venobox/venobox.css" rel="stylesheet">
<link href="css/nivo-slider-theme.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<link href="css/responsive.css" rel="stylesheet">

<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="localization.local" var="loc" />
<%@ include file="include/registration_include"%>

<script type="text/javascript">
function InvalidMsg(textbox) {
	
    if (textbox.value == '' || textbox.value.length > 15) {
        textbox.setCustomValidity("${messagefildvalidaty}");
    }
    else if(textbox.validity.typeMismatch){
        textbox.setCustomValidity("${messageemailvalidaty}");
    }
    else {
        textbox.setCustomValidity('');
    }
    return true;
}
</script>

</head>
<body data-spy="scroll" data-target="#navbar-example">

	<div id="preloader"></div>

	<header>
	<div id="sticker" class="header-area">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-12 col-sm-12">

					<nav class="navbar navbar-default">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse"
							data-target=".bs-example-navbar-collapse-1" aria-expanded="false">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<!-- Brand -->
						<a class="navbar-brand page-scroll sticky-logo" href="index.jsp">
							<h1>
								<span>H</span>uman <span>R</span>esources
							</h1>
						</a>
					</div>
					<div
						class="collapse navbar-collapse main-menu bs-example-navbar-collapse-1"
						id="navbar-example">
						<ul class="nav navbar-nav navbar-right">
							<li><a>
									<form "controllerServlet" method="get">
										<input type="hidden" name="command" value="cb.main_page">
										<button class="btn btn-link btn-lg" type="submit">
											<h6>${home}</h6>
										</button>
									</form>
							</a></li>
							<li><a>
									<form "controllerServlet" method="get">
										<input type="hidden" name="command" value="cb.login_page">
										<button class="btn btn-link btn-lg" type="submit">
											<h6>${login}</h6>
										</button>
									</form>
							</a></li>
							<c:if test="${user != null}">
								<li><br>
									<form action="controllerServlet" method="post">
										<input type="hidden" name="command" value="cb.logout_user">
										<h6 align="center" style="color: orange;">${sessionScope.user.nickName}</h6>
										<button class="btn  btn-xs btn-success" type="submit">${logout}</button>
									</form></li>
							</c:if>
							<li><a>
									<form action="controllerServlet" method="get">
										<input type="hidden" name="command" value="cb.localization">
										<input type="hidden" name="local" value="ru">
										<button class="btn btn-link btn-xs" type="submit">${ru_button}</button>
									</form>
									<form action="controllerServlet" method="get">
										<input type="hidden" name="command" value="cb.localization">
										<input type="hidden" name="local" value="en">
										<button class="btn btn-link btn-xs" type="submit">${en_button}</button>
									</form>
							</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	</header>

	<div id="registration_area" class="slider-area">
		<div>
			<div id="ensign-nivoslider" class="slides">
				<img src="img/slider/slider5.jpg" alt="" title="#slider-direction-1" />
			</div>
			<div id="slider-direction-1" class="slider-direction slider-one">
				<div class="container">
					<div class="row">
						<h3 align="center" style="color: red">
							<i> <c:if
									test="${requestScope.incorrect_params_message != null}">
									<c:out value="${incorrectmessage}"></c:out>
								</c:if>
							</i>
						</h3>
						<div>
							</br> </br> </br> </br> </br>
							<h3 align="center" style="color: orange;">
								<b><i> <c:if test="${requestScope.existuser != null}">
											<c:out value="${existuser}"></c:out>
										</c:if> <c:if test="${requestScope.existuser == null}">
											<c:out value="${registrationmessage}"></c:out>
										</c:if>
								</i> </b>
							</h3>
						</div>
						<div class="container">
							<div class="row">
								<div class="col-md-3 col-sm-3 col-xs-3"></div>
								<div class="col-md-6 col-sm-6 col-xs-6">
									<div class="layer-1-1 hidden-xs wow slideInDown"
										data-wow-duration="1s" data-wow-delay=".2s">
										<form action="controllerServlet" method="post">
											<div class="form-group">
											 
												<input type="hidden" name="command" value="cb.register_user">
												<label for="nickName">${nickname}</label> <input type="text" oninvalid="InvalidMsg(this);"	oninput="InvalidMsg(this);" class="form-control hidden-xs"	name="nickName" placeholder="${yournickname}"
													required="required"> <br> 
													<label for="name">${name}</label> <input type="text" oninvalid="InvalidMsg(this);"	oninput="InvalidMsg(this);" 	class="form-control hidden-xs" name="name"	placeholder="${messageforname}" required> <br>
												<label for="surname">${surname}</label> <input type="text" oninvalid="InvalidMsg(this);"
													oninput="InvalidMsg(this);"
													class="form-control hidden-xs" name="surname"
													placeholder="${messageforsurname}" required> <br>
												<label for="email">email</label> <input type="email" oninvalid="InvalidMsg(this);"
													oninput="InvalidMsg(this);"
													class="form-control hidden-xs" name="email"
													placeholder="${messageforemail}" required> <br>
												<input type="hidden" name="command" value="login"> <label
													for="password">${password}</label> <input type="password" oninvalid="InvalidMsg(this);"
													oninput="InvalidMsg(this);"
													class="form-control hidden-xs" name="password"
													placeholder="${yourpassword}" required> </br> <label
													for="role">${yourspecialitymessage}</label> <select
													name="role" style="color: black">
													<option value="admin">${roleadmin}</option>
													<option value="boss">${roleboss}</option>
													<option value="hr">${rolehr}</option>
													<option value="employee">${roleemployee}</option>
												</select>
												<div class="layer-1-3 hidden-xs wow slideInUp"
													data-wow-duration="4s" data-wow-delay=".2s">
													<input type="submit"
														class="ready-btn right-btn page-scroll"
														value="${registration}">
												</div>
											</div>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="include/footer_include"%>
</body>
</html>
