<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>

<title>employee_page</title>
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
<%@ include file="include/login_include"%>

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
							<li><br>
								<ul class="nav navbar-nav">
									<button class="btn btn-link btn-lg" class="dropdown-toggle"
										data-toggle="dropdown" aria-haspopup="true"
										aria-expanded="false">
										<h6 style="color: white">My Profile</h6>
										<span class="caret"></span>
									</button>
									<ul class="dropdown-menu">
										<form "controllerServlet" method="get">
											<button class="btn btn-link btn-lg" type="submit">
												<h6 style="color: black">Add profile</h6>
										</form>
									</ul>
								</ul></li>

							<li><br>
								<ul class="nav navbar-nav">
									<button class="btn btn-link btn-lg" class="dropdown-toggle"
										data-toggle="dropdown" aria-haspopup="true"
										aria-expanded="false">
										<h6 style="color: white">My Resume</h6>
										<span class="caret"></span>
									</button>
									<ul class="dropdown-menu">
										<form "controllerServlet" method="get">
											<button class="btn btn-link btn-lg" type="submit">
												<h6 style="color: black">Add resume</h6>
										</form>
									</ul>
									
								</ul></li>

							<li><a>
									<form "controllerServlet" method="get">
										<input type="hidden" name="command" value="cb.main_page">
										<button class="btn btn-link btn-lg" type="submit">
											<h6>Vacantions</h6>
										</button>
									</form>
							</a></li>

							<c:if test="${user != null}">
								<li><br>
									<form action="controllerServlet" method="post">
										<input type="hidden" name="command" value="cb.logout_user">
										<h6 align="center" style="color: orange;">${sessionScope.user.nickName}</h6>
										<button class="btn  btn-xs btn-success" type="submit">LogOut</button>
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
					</nav>
				</div>
			</div>
		</div>
	</div>
	</header>
	<div id="login_area" class="slider-area">
		<div>
			<div id="ensign-nivoslider" class="slides">
				<img src="img/slider/slider7.jpg" alt="" title="#slider-direction-1" />
			</div>
			<div id="slider-direction-1" class="slider-direction slider-one">
				<div class="container">
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="slider-content">
								<div class="layer-1-1 hidden-xs wow slideInDown"
									data-wow-duration="2s" data-wow-delay=".2s">
									<h2>
										<h1 style="color: white">
											ДОБРО ПОЖАЛОВАТЬ В
											<h2 style="color: aqua">Human Resources</h2>
										</h1>
									</h2>
								</div>
								<div class="layer-1-2 wow slideInUp" data-wow-duration="2s"
									data-wow-delay=".1s">
									<h3 style="color: white">Наши пользователи – это наше
										преимущество. Именно поэтому мы активно сотрудничаем с
										будущими работодателями и оказываем особую поддержку тем, кто
										нуждается в работе.</h3>
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
