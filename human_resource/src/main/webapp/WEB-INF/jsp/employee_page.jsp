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

										<h6 style="color: green">My Profile</h6>

										<span class="caret"></span>
									</button>
									<ul class="dropdown-menu">

										<li><a style="color: black" href="#profileModal"
											class="btn btn-link" data-toggle="modal">Add profile</a></li>

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
										<li><a style="color: black" href="#resumeModal"
											class="btn btn-link" data-toggle="modal">Add resume</a></li>
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
										<h6 align="center" style="color: orange;">${sessionScope.user.name}</h6>
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

									<h1 style="color: white">
										ДОБРО ПОЖАЛОВАТЬ В
										<h2 style="color: aqua">Human Resources</h2>
									</h1>

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

	<form action="controllerServlet" method="get">
		<div id="profileModal" class="modal fade" tabindex="-1">
			<div class="modal-dialog modal-lg">
				<div class="modal-content ">
					<div class="modal-header">
						<h4 class="modal-title" style="color: orange;">Profile Form</h4>
						<h4 style="color: green;">${user.name}  ${user.surname}</h4>
						<button class="close" type="button" data-dismiss="modal">
							<i class="fa fa-close"></i>
						</button>
					</div>
					<div class="modal-body">
						<div class="container">
							<div class="row">
								<div class="col-md-8 col-sm-3 col-xs-3">

									<div class="form-group">


										<img src="img/slider/nobody.jpg" alt="img" class="img-circle">
										<br> <br>
										<div class="form-group">
											<input type="file" class="form-control-file" id="foto"
												name="foto">
										</div>
										<br> <a><label for="phone">Phone: </label> <br>
											<input id="phone" type="text" class="input-medium bfh-phone"
											data-format="+375 (17)dd-dd-dd" name="phone"></a> <br>
										<a><label for="dateOfBirthDay">Date Of BirthDay:</label> <input
											type="date" class="form-control" name="dateOfBirthDay"></a>
										<a><label for="residence">Residence: </label> <select
											class="form-control hidden-xs" id="residence"
											name="residence">
												<option selected>Минск</option>
												<option>Минская область</option>
												<option>Брест</option>
												<option>Брестская область</option>
												<option>Витебск</option>
												<option>Витебская область</option>
												<option>Гомель</option>
												<option>Гомельская область</option>
												<option>Гродно</option>
												<option>Гродненская область</option>
												<option>Могилёв</option>
												<option>Могилёвская область</option>
												<option>Другое</option>
										</select> </a> <a><label for="workSpeciality">Work speciality:
										</label> <select class="form-control hidden-xs" id="workSpeciality"
											name="workSpeciality">
												<option selected>шахтер</option>
												<option>автомеханик</option>
												<option>автослесарь</option>
												<option>автоэлектрик</option>
												<option>водитель</option>
												<option>маляр-штукатур</option>
												<option>машинист крана</option>
												<option>оператор ЭВМ</option>
												<option>слесарь</option>
												<option>стропальщик</option>
												<option>штукатур</option>
										</select> </a> <a><label for="workExpirience">Work expirience:
										</label> <select class="form-control hidden-xs" id="workExpirience"
											name="workExpirience">
												<option selected>Без опыта работы</option>
												<option>до 1 года</option>
												<option>до 2 лет</option>
												<option>до 3 лет</option>
												<option>до 4 лет</option>
												<option>до 5 лет</option>
												<option>до 6 лет</option>
												<option>до 7 лет</option>
												<option>до 8 лет</option>
												<option>до 9 лет</option>
												<option>до 10 лет</option>
												<option>более 10 лет</option>
										</select> </a> <a><label for="education">Education: </label> <select
											class="form-control hidden-xs" id="education"
											name="education">
												<option selected>общее среднее</option>
												<option>специальное</option>
												<option>профессионально-техническое</option>
												<option>высшее</option>
										</select> </a> <a><label for="message">About you: </label>
											<div class="form-group">
												<textarea class="form-control" name="message" rows="5"
													data-rule="required"
													placeholder="Please write something about yourSelf:"></textarea>
											</div> </a>
									</div>
								</div>
							</div>
						</div>

						<div class="modal-footer">
							<input type="hidden" name="command" value="cb.add_profile">
							<button class="btn btn-danger" type="button" data-dismiss="modal">Close</button>
							<button class="btn btn-success" type="submit">Apply</button>
						</div>
					</div>
				</div>
			</div>
	</form>

	<form action="controllerServlet" method="get">
		<div id="resumeModal" class="modal fade" tabindex="-1">
			<div class="modal-dialog modal-lg">
				<div class="modal-content ">
					<div class="modal-header">
						<h4 class="modal-title" style="color: orange;">Resume Form</h4>
						<button class="close" type="button" data-dismiss="modal">
							<i class="fa fa-close"></i>
						</button>
					</div>
					<div class="modal-body">
						<table class="table">
							<thead>
								<tr>
									<th>Name</th>
									<th>SurName</th>
									<th>NickName</th>
									<th>e-mail</th>
									<th>Role</th>
									<th>Registered</th>
								</tr>
							</thead>
						</table>
					</div>
					<div class="modal-footer">
						<input type="hidden" name="command" value="cb.add_resume">
						<button class="btn btn-danger" type="button" data-dismiss="modal">Close</button>
						<button class="btn btn-success" type="submit">Apply</button>
					</div>
				</div>
			</div>
		</div>

	</form>


	<%@ include file="include/footer_include"%>


</body>
</html>
