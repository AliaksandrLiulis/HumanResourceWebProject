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
<%@ include file="include/emoloyee_include"%>

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
										<c:choose>
											<c:when test="${user.profileId!='0'}">
												<h6 style="color: green">${myprofile}</h6>
											</c:when>
											<c:otherwise>
												<h6 style="color: red">${myprofile}</h6>
											</c:otherwise>
										</c:choose>
										<span class="caret"></span>
									</button>
									<c:choose>
										<c:when test="${user.profileId!='0'}">
											<ul class="dropdown-menu">
												<li><a style="color: green" href="#profileModal"
													class="btn btn-link" data-toggle="modal">${editprofile}</a></li>
											</ul>
										</c:when>
										<c:otherwise>
											<ul class="dropdown-menu">
												<li><a style="color: red" href="#profileModal"
													class="btn btn-link" data-toggle="modal">${addprofile}</a></li>
											</ul>
										</c:otherwise>
									</c:choose>
								</ul></li>
							<li><br>
								<ul class="nav navbar-nav">
									<button class="btn btn-link btn-lg" class="dropdown-toggle"
										data-toggle="dropdown" aria-haspopup="true"
										aria-expanded="false">
										<c:choose>
											<c:when test="${user.profileId!='0'}">
												<h6 style="color: green">${myresume}</h6>
											</c:when>
											<c:otherwise>
												<h6 style="color: red">${myresume}</h6>
											</c:otherwise>
										</c:choose>
										<span class="caret"></span>
									</button>
									<c:if test="${user.profileId!='0'}">
										<c:choose>
											<c:when test="${user.resumeId!='0'}">
												<ul class="dropdown-menu">
													<li><a style="color: green" href="#resumeModal"
														class="btn btn-link" data-toggle="modal">${showresume}</a></li>
												</ul>
											</c:when>
											<c:otherwise>
												<ul class="dropdown-menu">
													<li><a style="color: red" href="#resumeModal"
														class="btn btn-link" data-toggle="modal">${createresume}</a></li>
												</ul>
											</c:otherwise>
										</c:choose>
									</c:if>
								</ul></li>
							<li><a>
									<form "controllerServlet" method="get">
										<input type="hidden" name="command" value="cb.main_page">
										<button class="btn btn-link btn-lg" type="submit">
											<h6>${vacancies}</h6>
										</button>
									</form>
							</a></li>

							<c:if test="${user != null}">
								<li><br>
									<form action="controllerServlet" method="post">
										<input type="hidden" name="command" value="cb.logout_user">
										<h6 align="center" style="color: orange;">${sessionScope.user.name}</h6>
										<button class="btn  btn-xs btn-success" type="submit">${Logout}</button>
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
									<h2 style="color: white">
										${welcomtomessage}
										<h3 style="color: aqua">Human Resources</h3>
									</h2>

								</div>
								<div class="layer-1-2 wow slideInUp" data-wow-duration="2s"
									data-wow-delay=".1s">
									<h4 style="color: white">${presentationmessage}</h4>
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
						<h4 class="modal-title" style="color: orange;">${modalprofileform}</h4>
						<h4 style="color: green;">${user.name}   ${user.surName}</h4>
						<button class="close" type="button" data-dismiss="modal">
							<i class="fa fa-close"></i>
						</button>
					</div>
					<div class="modal-body">
						<div class="container">
							<div class="row">
								<div class="col-md-8 col-sm-3 col-xs-3">
									<c:choose>
										<c:when test="${user.profileId!='0'}">
											<div class="form-group">
												<c:choose>
													<c:when test="${not empty profile.photoPath}">
														<img src="img/slider/profile_photo/${profile.photoPath}"
															alt="${profile.photoPath}" class="img-circle">
													</c:when>
													<c:otherwise>
														<img src="img/slider/profile_photo/nobody.jpg"
															alt="nobody" class="img-circle">
													</c:otherwise>
												</c:choose>
												<br> <br>
												<div class="form-group">
													<input type="file" class="form-control-file" id="photopath"
														name="photopath">
												</div>
												<br> <a><label for="phone">${modalphone}</label> <br>
													<input id="phone" type="text" class="bfh-phone"
													data-format="+375 (17)dd-dd-dd" name="phone"></a> <br>
												<a><label for="dateOfBirthDay">${modaldateofbirthday}</label>
													<input id="dateOfBirthDay" type="date" class="form-control"
													name="birthdaydate"></a> <br> <a><label
													for="residence">${modalresidence}</label> <select
													class="form-control hidden-xs" id="residence"
													name="residence">
														<option selected>${profile.residence}</option>
														<option>${modalselectminsk}</option>
														<option>${modalselectminskregion}</option>
														<option>${modalselectbrest}</option>
														<option>${modalselectbrestregion}</option>
														<option>${modalselectvitebsk}</option>
														<option>${modalselectvitebskregion}</option>
														<option>${modalselectgomel}</option>
														<option>${modalselectgomelregion}</option>
														<option>${modalselectgrodno}</option>
														<option>${modalselectgrodnoregion}</option>
														<option>${modalselectmogilev}</option>
														<option>${modalselectmogilevregion}</option>
														<option>${other}</option>
												</select> </a> <a><label for="workspeciality">${modalworkingspecialty}
												</label> <select class="form-control hidden-xs" id="workspeciality"
													name="workspeciality">
														<option selected>${profile.workSpeciality}</option>
														<option>${modalselectdriver}</option>
														<option>${modalselectaccountant}</option>
												</select> </a> <a><label for="workexpirience">${modalworkexpiriance}</label>
													<select class="form-control hidden-xs" id="workexpirience"
													name="workexpirience">
														<option selected>${profile.workExpirience}</option>
														<option>${modalselectnoworkexpiriance}</option>
														<option>${modalselectupto1year}</option>
														<option>${modalselectupto2year}</option>
														<option>${modalselectupto3year}</option>
														<option>${modalselectupto4year}</option>
														<option>${modalselectupto5year}</option>
														<option>${modalselectupto6year}</option>
														<option>${modalselectupto7year}т</option>
														<option>${modalselectupto8year}</option>
														<option>${modalselectupto9year}</option>
														<option>${modalselectupto10year}</option>
														<option>${modalselectmorethan10years}</option>
												</select> </a> <a><label for="education">${modaleducation}</label> <select
													class="form-control hidden-xs" id="education"
													name="education" required>
														<option selected>${profile.education}</option>
														<option>${modalselectsecondaryeducation}</option>
														<option>${modalselectspecialyeducation}</option>
														<option>${modalselecthighereducation}</option>
												</select> </a> <a><label for="message">${modaleaboutyou}</label> <textarea
														id="message" class="form-control" name="aboutuser"
														rows="5" data-rule="required"></textarea> </a> <input
													type="hidden" name="userid" value="${user.userId}">
											</div>
										</c:when>
										<c:otherwise>
											<div class="form-group">
												<img src="img/slider/profile_photo/nobody.jpg" alt="img"
													class="img-circle"> <br> <br>
												<div class="form-group">
													<input type="file" class="form-control-file" id="photo"
														name="photopath">
												</div>
												<br> <a><label for="phone">${modalphone}</label> <br>
													<input id="phone" type="text"
													class="input-medium bfh-phone"
													data-format="+375 (17)dd-dd-dd" name="phone" required></a>
												<br> <a><label for="dateOfBirthDay">${modaldateofbirthday}</label>
													<input type="date" class="form-control" name="birthdaydate"
													required> </a> <a><label for="residence">${modalresidence}
												</label> <select class="form-control hidden-xs" id="residence"
													name="residence" required>
														<option selected>${modalselectminsk}</option>
														<option>${modalselectminskregion}</option>
														<option>${modalselectbrest}</option>
														<option>${modalselectbrestregion}</option>
														<option>${modalselectvitebsk}</option>
														<option>${modalselectvitebskregion}</option>
														<option>${modalselectgomel}</option>
														<option>${modalselectgomelregion}</option>
														<option>${modalselectgrodno}</option>
														<option>${modalselectgrodnoregion}</option>
														<option>${modalselectmogilev}</option>
														<option>${modalselectmogilevregion}</option>
														<option>${other}</option>
												</select> </a> <a><label for="workSpeciality">${modalworkingspecialty}
												</label> <select class="form-control hidden-xs" id="workSpeciality"
													name="workspeciality" required>
														<option selected>${modalselectdriver}</option>
														<option>${modalselectaccountant}</option>
												</select> </a> <a><label for="workExpirience">${modalworkexpiriance}</label>
													<select class="form-control hidden-xs" id="workExpirience"
													name="workexpirience" required>
														<option selected>${modalselectnoworkexpiriance}</option>
														<option>${modalselectnoworkexpiriance}</option>
														<option>${modalselectupto1year}</option>
														<option>${modalselectupto2year}</option>
														<option>${modalselectupto3year}</option>
														<option>${modalselectupto4year}</option>
														<option>${modalselectupto5year}</option>
														<option>${modalselectupto6year}</option>
														<option>${modalselectupto7year}т</option>
														<option>${modalselectupto8year}</option>
														<option>${modalselectupto9year}</option>
														<option>${modalselectupto10year}</option>
														<option>${modalselectmorethan10years}</option>
												</select> </a> <a><label for="education">${profile.education}
												</label> <select class="form-control hidden-xs" id="education"
													name="education" required>
														<option selected>${modalselectsecondaryeducation}</option>
														<option>${modalselectspecialyeducation}</option>
														<option>${modalselecthighereducation}</option>
												</select> </a> <a><label for="message">${modaleaboutyou} </label> <textarea
														class="form-control" name="aboutuser" rows="5"
														data-rule="required"
														placeholder="Please write something about yourSelf:"></textarea>
												</a> <input type="hidden" name="userid" value="${user.userId}">
											</div>
										</c:otherwise>
									</c:choose>
								</div>

							</div>
						</div>
						<div class="modal-footer">
							<c:choose>
								<c:when test="${not empty sessionScope.profile}">
									<div class="form-group">
										<button class="btn btn-warning" type="submit" name="command"
											value="cb.delete_profile">${deletebutton}</button>
										<button class="btn btn-success" type="submit" name="command"
											value="cb.update_profile">${updatebutton}</button>
										<button class="btn btn-danger" type="button"
											data-dismiss="modal">${closebutton}</button>
									</div>
								</c:when>
								<c:otherwise>
									<input type="hidden" name="command" value="cb.add_profile">
									<button class="btn btn-danger" type="button"
										data-dismiss="modal">${closebutton}</button>
									<button class="btn btn-success" type="submit">${applybutton}</button>
								</c:otherwise>
							</c:choose>

						</div>
					</div>
				</div>
			</div>
		</div>
	</form>


	<form action="controllerServlet" method="get">
		<div id="resumeModal" class="modal fade" tabindex="-1">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header">
						<h4 align="center" class="modal-title" style="color: orange;">${titleresume}</h4>
						<br>
						<h6 align="right" class="modal-title" style="color: black;">${created}
							${profile.registrationDate}</h6>
						<button class="close" type="button" data-dismiss="modal">
							<i class="fa fa-close"></i>
						</button>
					</div>
					<div class="modal-body">
						<div align="center">
							<img src="img/slider/profile_photo/${profile.photoPath}"
								id="imagePath" alt="img" class="img-circle">
						</div>
						<div class="form-group">
							<a><label for="name">${modalname}</label> <input type="text"
								class="form-control" id="name" name="name"></a> <a><label
								for="surname">SurName</label> <input type="text"
								class="form-control" id="surname" name="surname"></a> <a><label
								for="birthdaydate">${modaldateofbirthday}</label> <input
								type="data" class="form-control" id="birthdaydate"
								name=birthdaydate></a> <a><label for="residenc">${modalresidence}</label>
								<input type="text" class="form-control" id="residenc"
								name="residence"></a> <a><label for="tel">${modalphone}</label>
								<input type="text" class="form-control" id="tel" name="phone"></a>
							<a><label for="email">${email}</label> <input type="email"
								class="form-control" id="email" name="email"></a> <a><label
								for="educat">${modalselectsecondaryeducation}</label> <input
								type="text" class="form-control" id="educat" name="education"></a>
							<a><label for="speciality">${modalworkingspecialty}</label> <input
								type="text" class="form-control" id="speciality"
								name="workspeciality"></a> <a><label for="expirience">${modalworkexpiriance}</label>
								<input type="text" class="form-control" id="expirience"
								name="workexpirience"></a> <a><label for="about">${modaleaboutyou}</label>
								<input type="text" class="form-control" id="about"
								name="aboutuser"></a> <input type="hidden" name="userid"
								value="${user.userId}"> <input type="hidden"
								name="registrationDate" value="${profile.registrationDate}">
							<input type="hidden" name="photopath"
								value="${profile.photoPath}">

						</div>


					</div>
					<div class="modal-footer">
						<c:choose>
							<c:when test="${user.resumeId!='0'}">
								<button class="btn btn-danger" type="button"
									data-dismiss="modal">${closebutton}</button>
								<input type="hidden" name="command" value="cb.delete_resume">
								<input type="hidden" name="resumeid" value="${user.userId}">
								<button class="btn btn-success" type="submit">${deletebutton}</button>
							</c:when>
							<c:otherwise>
								<input type="hidden" name="command" value="cb.add_resume">
								<button class="btn btn-danger" type="button"
									data-dismiss="modal">${closebutton}</button>
								<button class="btn btn-success" type="submit">${buttoncreate}</button>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>
		</div>
	</form>
	
	
	
	<div id="profilemodaladd" class="modal fade" tabindex="-1">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header">
					<h5 align="center" class="modal-title" style="color: black;">${message}</h5>
						<br>
						<button class="close" type="button" data-dismiss="modal">
							<i class="fa fa-close"></i>
						</button>
					</div>
					<div class="modal-body">
						<div class="form-group">
						<c:choose>
							<c:when test="${requestScope.profile_add_message == 1}">
								<h5 align="center" class="modal-title" style="color: green;">${profileadded}</h5>
							</c:when>
							<c:otherwise>
								<h5 align="center" class="modal-title" style="color: red;">${profilenotadded}</h5>
							</c:otherwise>
						</c:choose>
							
						</div>
					</div>
					<div class="modal-footer">
						<button class="btn btn-success" type="button" data-dismiss="modal">${okbutton}</button>
					</div>
				</div>
			</div>
		</div>
		
		<div id="profilemodaldelete" class="modal fade" tabindex="-1">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header">
					<h5 align="center" class="modal-title" style="color: black;">${message}</h5>
						<br>
						<button class="close" type="button" data-dismiss="modal">
							<i class="fa fa-close"></i>
						</button>
					</div>
					<div class="modal-body">
						<div class="form-group">
						<c:choose>
							<c:when test="${requestScope.profile_delete_message == 1}">
								<h5 align="center" class="modal-title" style="color: green;">${profiledeleted}</h5>
							</c:when>
							<c:otherwise>
								<h5 align="center" class="modal-title" style="color: red;">${profilenotdeleted}</h5>
							</c:otherwise>
						</c:choose>
							
						</div>
					</div>
					<div class="modal-footer">
						<button class="btn btn-success" type="button" data-dismiss="modal">${okbutton}</button>
					</div>
				</div>
			</div>
		</div>
		
		<div id="profilemodalupdate" class="modal fade" tabindex="-1">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header">
					<h5 align="center" class="modal-title" style="color: black;">${message}</h5>
						<br>
						<button class="close" type="button" data-dismiss="modal">
							<i class="fa fa-close"></i>
						</button>
					</div>
					<div class="modal-body">
						<div class="form-group">
						<c:choose>
							<c:when test="${requestScope.profile_update_message == 1}">
								<h5 align="center" class="modal-title" style="color: green;">${profileupdate}</h5>
							</c:when>
							<c:otherwise>
								<h5 align="center" class="modal-title" style="color: red;">${profilenotupdate}</h5>
							</c:otherwise>
						</c:choose>
							
						</div>
					</div>
					<div class="modal-footer">
						<button class="btn btn-success" type="button" data-dismiss="modal">${okbutton}</button>
					</div>
				</div>
			</div>
		</div>
		
		<div id="resumemodaladd" class="modal fade" tabindex="-1">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header">
					<h5 align="center" class="modal-title" style="color: black;">${message}</h5>
						<br>
						<button class="close" type="button" data-dismiss="modal">
							<i class="fa fa-close"></i>
						</button>
					</div>
					<div class="modal-body">
						<div class="form-group">
						<c:choose>
							<c:when test="${requestScope.resume_add_message == 1}">
								<h5 align="center" class="modal-title" style="color: green;">${resumeadded}</h5>
							</c:when>
							<c:otherwise>
								<h5 align="center" class="modal-title" style="color: red;">${resumenotadded}</h5>
							</c:otherwise>
						</c:choose>
							
						</div>
					</div>
					<div class="modal-footer">
						<button class="btn btn-success" type="button" data-dismiss="modal">${okbutton}</button>
					</div>
				</div>
			</div>
		</div>
		
		<div id="resumemodaldelete" class="modal fade" tabindex="-1">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header">
					<h5 align="center" class="modal-title" style="color: black;">${message}</h5>
						<br>
						<button class="close" type="button" data-dismiss="modal">
							<i class="fa fa-close"></i>
						</button>
					</div>
					<div class="modal-body">
						<div class="form-group">
						<c:choose>
							<c:when test="${requestScope.resume_delete_message == 1}">
								<h5 align="center" class="modal-title" style="color: green;">${resumedeleted}</h5>
							</c:when>
							<c:otherwise>
								<h5 align="center" class="modal-title" style="color: red;">${resumedeleted}</h5>
							</c:otherwise>
						</c:choose>
							
						</div>
					</div>
					<div class="modal-footer">
						<button class="btn btn-success" type="button" data-dismiss="modal">${okbutton}</button>
					</div>
				</div>
			</div>
		</div>
		
	





	<%@ include file="include/footer_include"%>
	
	<c:if test="${not empty requestScope.profile_add_message}">
	<script>
		$(document).ready(function(){  
	    $("#profilemodaladd").modal('show');  });
	</script>
	</c:if>
	
	<c:if test="${not empty profile_delete_message}"> 
 	<script> 
		$(document).ready(function(){  
	    $("#profilemodaldelete").modal('show');  });
	</script>
	</c:if> 
	
	<c:if test="${not empty profile_update_message}"> 
 	<script> 
		$(document).ready(function(){  
	    $("#profilemodalupdate").modal('show');  });
	</script>
	</c:if> 
	
	<c:if test="${not empty resume_add_message}"> 
 	<script> 
		$(document).ready(function(){  
	    $("#resumemodaladd").modal('show');  });
	</script>
	</c:if> 
	<c:if test="${not empty resume_delete_message}"> 
 	<script> 
		$(document).ready(function(){  
	    $("#resumemodaldelete").modal('show');  });
	</script>
	</c:if> 
	
	<script type="text/javascript">
		document.getElementById("phone").value = "${profile.phone}";
		document.getElementById("message").value = "${profile.aboutUser}";
		document.getElementById("dateOfBirthDay").value = "${profile.birthDayDate}";
	</script>


	<script type="text/javascript">
		document.getElementById("name").value = "${user.name}";
		document.getElementById("surname").value = "${user.surName}";
		document.getElementById("residenc").value = "${profile.residence}";
		document.getElementById("email").value = "${user.email}";
		document.getElementById("birthdaydate").value = "${profile.birthDayDate}";
		document.getElementById("educat").value = "${profile.education}";
		document.getElementById("speciality").value = "${profile.workSpeciality}";
		document.getElementById("expirience").value = "${profile.workExpirience}";
		document.getElementById("tel").value = "${profile.phone}";
		document.getElementById("about").value = "${profile.aboutUser}";
	</script>





</body>
</html>
