<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/style.css" type="text/css" />
<title>main_page</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="localization.local" var="loc" />
<fmt:message bundle="${loc}" key="local.main.locbutton.ru"
	var="ru_button" />
<fmt:message bundle="${loc}" key="local.main.locbutton.en"
	var="en_button" />
<fmt:message bundle="${loc}" key="local.main.loclink.registr"
	var="registr" />
<fmt:message bundle="${loc}" key="local.main.loclink.login" var="login" />
<fmt:message bundle="${loc}" key="local.main.locbar.main" var="main" />
<fmt:message bundle="${loc}" key="local.main.locbar.aboutUs"
	var="aboutUs" />
<fmt:message bundle="${loc}" key="local.main.locbar.phones" var="phones" />

</head>
<body>
	<div class="container-fluid">
		<div class="col-lg-10">
			<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<i class="navbar-brand" style="color: green">Human resource</i>
				</div>
				<div>
					<ul class="nav navbar-nav">
						<li class="active"><a href="main_page">${main}</a></li>
						<li><a href="#">${aboutUs}</a></li>
						<li><a href="#">${phones}</a></li>
					</ul>
				</div>
			</div>
			</nav>
		</div>
		<div class="col-lg-1">
			
				<form action="login_page">
					<input type="hidden" name="command" value="login">
					<button class="btn btn-link btn-xs" type="submit">${login}</button>
				</form>
			
			
				<form action="registration_page">
					<input type="hidden" name="command" value="registr">
					<button class="btn btn-link btn-xs" type="submit">${registr}</button>
				</form>
			


		</div>
		<div class="col-lg-1">
			<form action="controllerServlet" method="get">
				<input type="hidden" name="command" value="localization"> <input
					type="hidden" name="page" value="main_page"> <input
					type="hidden" name="local" value="ru">
				<button class="btn btn-primary btn-xs" type="submit">${ru_button}</button>
			</form>
			<form action="controllerServlet" method="get">
				<input type="hidden" name="command" value="localization"> <input
					type="hidden" name="page" value="main_page"><input
					type="hidden" name="local" value="en">
				<button class="btn btn-success btn-xs" type="submit">${en_button}</button>
			</form>
		</div>
	</div>
	
	
	
	
	
	

	<!-- <div class="container-fluid"> -->
	<!-- 	<h1>3 блока</h1> -->
	<!-- 	<div class="row"> -->
	<!-- 	<div class="col-lg-6"> -->
	<!-- 	<div class="row"> -->
	<!-- 		<div class="col-lg-8" style="background-color: #ff9999">Первый</div> -->
	<!-- 		<div class="col-lg-4" style="background-color: #ff11CC">Второй</div> -->

	<!-- 	</div> -->
	<!-- 	</div> -->
	<!-- 	<div class="col-lg-6" style="background-color: #ffCC22">Третий</div> -->
	<!-- 	</div> -->


	<!-- 	</div> -->
</body>
</html>