<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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

	<c:choose>
		<c:when test="${sessionScope.user.role == 'employee'}">
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
									data-target=".bs-example-navbar-collapse-1"
									aria-expanded="false">
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
												<input type="hidden" name="command"
													value="cb.get_vacancy_for_job_seeker"> <input
													type="hidden" name="userid" value="${user.userId}">
												<input type="hidden" name="limitLine" value="5"> <input
													type="hidden" name="offsetline" value="0"> <input
													type="hidden" name="pagenum" value="1">
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
						<img src="img/slider/slider7.jpg" alt=""
							title="#slider-direction-1" />
					</div>
					<c:choose>
						<c:when test="${not empty requestScope.allVacancy}">
							<div id="slider-direction-1" class="slider-direction slider-one">
								<div class="container">
									<div class="row">
										<br> <br> <br> <br> <br> <br>
										<div class="layer-1-1 hidden-xs wow slideInDown"
											data-wow-duration="1s" data-wow-delay=".2s">
											<div class="row">
												<div class="col-md-5 col-sm-6 col-xs-6">
													<div class="section section-breadcrumbs">
														<div class="container">
															<div class="row">
																<div class="col-md-12">
																	<h4>${vacancies}</h4>
																</div>
															</div>
														</div>
													</div>
													<div class="section">
														<div class="container">
															<table class="table table-bordered table-hover table-sm">
																<thead>
																	<tr>
																		<th style="color: orange;" scope="col">${number}</th>
																		<th style="color: orange;" scope="col">${professionname}</th>
																		<th style="color: orange;" scope="col">${companyname}</th>
																		<th style="color: orange;" scope="col">${showvacancy}</th>
																		<th style="color: orange;" scope="col">${respondonvacation}</th>
																	</tr>
																</thead>
																<tbody>
																	<c:set var="count"
																		value="${(requestScope.pagenum * 5)-4}" scope="page" />
																	<c:forEach var="vacancy"
																		items="${requestScope.allVacancy}">
																		<tr>
																			<td style="color: black;">${count}</td>
																			<td style="color: black;">${vacancy.professionName}</td>
																			<td style="color: black;">${vacancy.companyName}</td>
																			<td><c:set var="count" value="${count + 1}"
																					scope="page" /> <c:choose>
																					<c:when
																						test="${vacancy.professionName eq 'Водитель' || vacancy.professionName eq 'Driver'}">
																						<a href="#vocancywievdrivermodal"
																							class="btn btn-link " data-toggle="modal"
																							data-vacancycompanynamebutton="${vacancy.companyName}"
																							data-vacancyexperiencebutton="${vacancy.experience}"
																							data-vacancydlcategorybutton="${vacancy.dlCategory}"
																							data-vacancysalarybutton="${vacancy.salary}">${showbutton}</a>
																					</c:when>
																					<c:when
																						test="${vacancy.professionName eq 'Бухгалтер' || vacancy.professionName eq 'Accountant'}">
																						<a href="#vocancywievaccountantmodal"
																							class="btn btn-link " data-toggle="modal"
																							data-vacancycompanynamebutton="${vacancy.companyName}"
																							data-vacancyexperiencebutton="${vacancy.experience}"
																							data-vacancysalarybutton="${vacancy.salary}">${showbutton}</a>

																					</c:when>
																				</c:choose></td>
																			<td><c:choose>
																					<c:when test="${user.resumeId!=0}">
																						<c:choose>
																							<c:when
																								test="${fn:contains(requestScope.allRespondVacancy,vacancy.idvacancy)}">
																								<form action="controllerServlet" method="get">
																									<input type="hidden" name="command"
																										value="cb.deleterespond_user"> <input
																										type="hidden" name="userid"
																										value="${user.userId}"> <input
																										type="hidden" name="vacancyId"
																										value="${vacancy.idvacancy}">
																									<button type="submit" class="btn btn-link"
																										style="color: green;">${deleterespond}</button>
																								</form>
																							</c:when>
																							<c:otherwise>
																								<form action="controllerServlet" method="get">
																									<input type="hidden" name="command"
																										value="cb.respond_user"> <input
																										type="hidden" name="userid"
																										value="${user.userId}"> <input
																										type="hidden" name="vacancyId"
																										value="${vacancy.idvacancy}">
																									<button type="submit" class="btn btn-link"
																										style="color: red;">${respond}</button>
																								</form>
																							</c:otherwise>
																						</c:choose>
																					</c:when>
																					<c:otherwise>
																						<c:choose>
																							<c:when test="${user.profileId!=0}">
																								<a style="color: orange" href="#resumeModal"
																									class="btn btn-link" data-toggle="modal">${createresume}</a>
																							</c:when>
																							<c:otherwise>
																								<a style="color: red" href="#profileModal"
																									class="btn btn-link" data-toggle="modal">${addprofile}</a>
																							</c:otherwise>
																						</c:choose>


																					</c:otherwise>
																				</c:choose></td>

																		</tr>
																	</c:forEach>
																</tbody>
															</table>
															<c:if test="${requestScope.pagecount > 1}">
																<c:choose>
																	<c:when test="${requestScope.pagecount > 2}">
																		<nav aria-label="Page navigation">
																		<ul class="pagination justify-content-center">
																			<c:choose>
																				<c:when test="${requestScope.pagenum == 1}">
																					<li class="page-item disabled"><a
																						class="page-link" href="#" tabindex="-1">${previous}</a></li>
																				</c:when>
																				<c:otherwise>
																					<li class="page-item "><a class="page-link"
																						href="controllerServlet?command=cb.get_vacancy_for_job_seeker&limitLine=5&offsetline=${(requestScope.pagenum * 5)-10}
																				&vacancy=vacancies&userid=${user.userId}&pagenum=${requestScope.pagenum - 1}&userid=${user.userId}">${previous}</a></li>
																				</c:otherwise>
																			</c:choose>

																			<c:forEach begin="1" end="${requestScope.pagecount}"
																				varStatus="loop">
																				<li class="page-item"><a class="page-link"
																					href="controllerServlet?command=cb.get_vacancy_for_job_seeker&limitLine=5&offsetline=${(loop.index * 5)-5 }
																				&vacancy=vacancies&userid=${user.userId}&pagenum=${loop.index}&userid=${user.userId}">${loop.index}</a></li>
																			</c:forEach>

																			<c:choose>
																				<c:when
																					test="${requestScope.pagenum == requestScope.pagecount}">
																					<li class="page-item disabled"><a
																						class="page-link" href="#">${next}</a></li>
																				</c:when>
																				<c:otherwise>
																					<li class="page-item "><a class="page-link"
																						href="controllerServlet?command=cb.get_vacancy_for_job_seeker&limitLine=5&offsetline=${requestScope.pagenum * 5}
																				&vacancy=vacancies&userid=${user.userId}&pagenum=${requestScope.pagenum + 1}&userid=${user.userId}">${next}</a></li>
																				</c:otherwise>
																			</c:choose>
																		</ul>
																		</nav>
																	</c:when>
																	<c:otherwise>
																		<c:choose>
																			<c:when test="${requestScope.pagenum == 1}">
																				<nav aria-label="Page navigation">
																				<ul class="pagination justify-content-center">
																					<li class="page-item disabled"><a
																						class="page-link" href="#" tabindex="-1">${previous}</a></li>
																					<li class="page-item "><a class="page-link"
																						href="controllerServlet?command=cb.get_vacancy_for_job_seeker&limitLine=5&offsetline=5&pagenum=2&userid=${user.userId}">${next}</a>
																					</li>
																				</ul>
																				</nav>
																			</c:when>
																			<c:otherwise>
																				<nav aria-label="Page navigation">
																				<ul class="pagination justify-content-center">
																					<li class="page-item"><a class="page-link"
																						href="controllerServlet?command=cb.get_vacancy_for_job_seeker&limitLine=5&offsetline=0&pagenum=1&userid=${user.userId}"
																						tabindex="-1">${previous}</a></li>
																					<li class="page-item disabled"><a
																						class="page-link" href="#">${next}</a></li>
																				</ul>
																				</nav>
																			</c:otherwise>
																		</c:choose>
																	</c:otherwise>
																</c:choose>
															</c:if>
														</div>
													</div>
												</div>
											</div>
										</div>

									</div>
								</div>
						</c:when>
						<c:otherwise>
							<div id="slider-direction-1" class="slider-direction slider-one">

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
						</c:otherwise>
					</c:choose>
				</div>
			</div>

			<form action="controllerServlet" method="get">
				<div id="profileModal" class="modal fade" tabindex="-1">
					<div class="modal-dialog modal-lg">
						<div class="modal-content ">
							<div class="modal-header">
								<h4 class="modal-title" style="color: orange;">${modalprofileform}</h4>
								<h4 style="color: green;">${user.name}${user.surName}</h4>
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
															<input type="file" class="form-control-file"
																id="photopath" name="photopath">
														</div>
														<br> <a><label for="phone">${modalphone}</label>
															<br> <input id="phone" type="text" class="bfh-phone"
															data-format="+375 (17)dd-dd-dd" name="phone"></a> <br>
														<a><label for="dateOfBirthDay">${modaldateofbirthday}</label>
															<input id="dateOfBirthDay" type="date"
															class="form-control" name="birthdaydate"></a> <br>
														<a><label for="residence">${modalresidence}</label> <select
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
														</label> <select class="form-control hidden-xs"
															id="workspeciality" name="workspeciality">
																<option selected>${profile.workSpeciality}</option>
																<option>${modalselectdriver}</option>
																<option>${modalselectaccountant}</option>
														</select> </a> <a><label for="workexpirience">${modalworkexpiriance}</label>
															<select class="form-control hidden-xs"
															id="workexpirience" name="workexpirience">
																<option selected>${profile.workExpirience}</option>
																<option>${modalselectnoworkexpiriance}</option>
																<option>${modalselectupto1year}</option>
																<option>${modalselectupto2year}</option>
																<option>${modalselectupto3year}</option>
																<option>${modalselectupto4year}</option>
																<option>${modalselectupto5year}</option>
																<option>${modalselectupto6year}</option>
																<option>${modalselectupto7year}</option>
																<option>${modalselectupto8year}</option>
																<option>${modalselectupto9year}</option>
																<option>${modalselectupto10year}</option>
																<option>${modalselectmorethan10years}</option>
														</select> </a> <a><label for="education">${modaleducation}</label>
															<select class="form-control hidden-xs" id="education"
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
														<br> <a><label for="phone">${modalphone}</label>
															<br> <input id="phone" type="text"
															class="input-medium bfh-phone"
															data-format="+375 (17)dd-dd-dd" name="phone" required></a>
														<br> <a><label for="dateOfBirthDay">${modaldateofbirthday}</label>
															<input type="date" class="form-control"
															name="birthdaydate" required> </a> <a><label
															for="residence">${modalresidence} </label> <select
															class="form-control hidden-xs" id="residence"
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
														</label> <select class="form-control hidden-xs"
															id="workSpeciality" name="workspeciality" required>
																<option selected>${modalselectdriver}</option>
																<option>${modalselectaccountant}</option>
														</select> </a> <a><label for="workExpirience">${modalworkexpiriance}</label>
															<select class="form-control hidden-xs"
															id="workExpirience" name="workexpirience" required>
																<option selected>${modalselectnoworkexpiriance}</option>
																<option>${modalselectnoworkexpiriance}</option>
																<option>${modalselectupto1year}</option>
																<option>${modalselectupto2year}</option>
																<option>${modalselectupto3year}</option>
																<option>${modalselectupto4year}</option>
																<option>${modalselectupto5year}</option>
																<option>${modalselectupto6year}</option>
																<option>${modalselectupto7year}</option>
																<option>${modalselectupto8year}</option>
																<option>${modalselectupto9year}</option>
																<option>${modalselectupto10year}</option>
																<option>${modalselectmorethan10years}</option>
														</select> </a> <a><label for="education">${modaleducation}
														</label> <select class="form-control hidden-xs" id="education"
															name="education" required>
																<option selected>${modalselectsecondaryeducation}</option>
																<option>${modalselectspecialyeducation}</option>
																<option>${modalselecthighereducation}</option>
														</select> </a> <a><label for="message">${modaleaboutyou} </label> <textarea
																class="form-control" name="aboutuser" rows="5"
																data-rule="required"
																placeholder="${messageaboutyourself}"></textarea> </a> <input
															type="hidden" name="userid" value="${user.userId}">
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
												<button type="button" class="btn btn-danger"
													data-toggle="modal" data-target="#profilewilbedeletedmodal"
													data-id="${user.userId}">${deletebutton}</button>
												<button class="btn btn-success" type="submit" name="command"
													value="cb.update_profile">${updatebutton}</button>
												<button class="btn btn-info" type="button"
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
									<a><label for="name">${modalname}</label> <input
										type="text" class="form-control" id="name" name="name"></a>
									<a><label for="surname">SurName</label> <input type="text"
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
									<a><label for="speciality">${modalworkingspecialty}</label>
										<input type="text" class="form-control" id="speciality"
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
										<button class="btn btn-success" type="button"
											data-dismiss="modal">${closebutton}</button>

										<button type="button" class="btn btn-danger"
											data-toggle="modal" data-target="#resumewilbedeletedmodal"
											data-idresume="${user.userId}">${deletebutton}</button>
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


			<form action="controllerServlet" method="get">
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
								<input type="hidden" name="command" value="cb.employee_page">
								<button class="btn btn-success" type="submit">${okbutton}</button>
							</div>

						</div>
					</div>
				</div>
			</form>

			<form action="controllerServlet" method="get">
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
								<input type="hidden" name="command" value="cb.employee_page">
								<button class="btn btn-success" type="submit">${okbutton}</button>
							</div>
						</div>
					</div>
				</div>
			</form>

			<form action="controllerServlet" method="get">
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
								<input type="hidden" name="command" value="cb.employee_page">
								<button class="btn btn-success" type="submit">${okbutton}</button>
							</div>
						</div>
					</div>
				</div>
			</form>

			<form action="controllerServlet" method="get">
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
								<input type="hidden" name="command" value="cb.employee_page">
								<button class="btn btn-success" type="submit">${okbutton}</button>
							</div>
						</div>
					</div>
				</div>
			</form>

			<form action="controllerServlet" method="get">
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
											<h5 align="center" class="modal-title" style="color: red;">${resumenotdeleted}</h5>
										</c:otherwise>
									</c:choose>

								</div>
							</div>
							<div class="modal-footer">
								<input type="hidden" name="command" value="cb.employee_page">
								<button class="btn btn-success" type="submit">${okbutton}</button>
							</div>
						</div>
					</div>
				</div>
			</form>

			<form action="controllerServlet" method="get">
				<div id="profilewilbedeletedmodal" class="modal fade" tabindex="-1">
					<div class="modal-dialog modal-lg">
						<div class="modal-content">
							<div class="modal-header">
								<br>
								<h3 align="center" class="modal-title" style="color: orange;">${messageverificationdelete}</h3>
								<br>
								<button class="close" type="button" data-dismiss="modal">
									<i class="fa fa-close"></i>
								</button>
							</div>
							<div class="modal-body">
								<div class="form-group">
									<h5 align="center" class="modal-title" style="color: red;">${messageadreedeleteprofile}</h5>
								</div>
							</div>
							<div class="modal-footer">
								<button class="btn btn-success" type="button"
									data-dismiss="modal">${cancelbutton}</button>
								<input type="hidden" id="userid" name="userid"> <input
									type="hidden" name="command" value="cb.delete_profile">
								<button class="btn btn-danger" type="submit">${deletebutton}</button>

							</div>
						</div>
					</div>
				</div>
			</form>

			<div id="vocancywievdrivermodal" class="modal fade" tabindex="-1">
				<div class="modal-dialog modal-lg">
					<div class="modal-content">
						<div class="modal-header">
							<br>
							<h3 align="center" class="modal-title" style="color: Blue;">${headervacancydriver}</h3>
							<br>
							<button class="close" type="button" data-dismiss="modal">
								<i class="fa fa-close"></i>
							</button>
						</div>
						<div class="modal-body">
							<div class="form-group">
								<h4>${company}
									<label id="nameOfcompany"></label> ${welcomtoworkdriver}
								</h4>

								<b><h5 style="color: red">${responsibility}</h5></b>
								<h6 style="color: black;">
									<ul align="left">
										<li>- ${transportations}</li>
										<li>- ${maintenanceservice}</li>
										<li>- ${controlofloading}</li>
										<li>- ${adherencetodelivery}</li>
										<li>- ${smallrepairs}</li>
										<li>- ${servicestandards}</li>
										<li>- ${carefulattitude}</li>
									</ul>
								</h6>
								<b><h5 style="color: red">${requirements}</h5></b>
								<h6 style="color: black;">
									<ul align="left">
										<li>- ${experienceinsimilarposition} <label
											id="vacancyexperience"></label></li>
										<li>- ${drivinglicensecategory} <label
											id="vacancydlcategory"></label></li>
										<li>- ${responsibilityorganizationpunctuality}</li>
										<li>- ${comfortabledrivingstyle}</li>
									</ul>
								</h6>
								<b><h5 style="color: red">${conditions}</h5></b>
								<h6 style="color: black;">
									<ul align="left">
										<li>- ${registration}</li>
										<li>- ${officialsalary} <label id="vacancysalary"></label></li>
										<li>- ${workingconditions}</li>
									</ul>
								</h6>
							</div>
						</div>
						<div class="modal-footer">

							<button class="btn btn-success" type="button"
								data-dismiss="modal">${okbutton}</button>
						</div>
					</div>
				</div>
			</div>

			<div id="vocancywievaccountantmodal" class="modal fade" tabindex="-1">
				<div class="modal-dialog modal-lg">
					<div class="modal-content">
						<div class="modal-header">
							<br>
							<h3 align="center" class="modal-title" style="color: Blue;">${headervacancyaccountant}</h3>
							<br>
							<button class="close" type="button" data-dismiss="modal">
								<i class="fa fa-close"></i>
							</button>
						</div>
						<div class="modal-body">
							<div class="form-group">
								<h4>${company}
									<label id="namecompany"></label> ${welcomtoworkaccountant}
								</h4>

								<b><h5 style="color: red">${responsibility}</h5></b>
								<h6 style="color: black;">
									<ul align="left">
										<li>- ${collectionofdocuments}</li>
										<li>- ${payroll}</li>
										<li>- ${creationmaintenance}</li>
										<li>- ${conductingcomparisons}</li>
									</ul>
								</h6>
								<b><h5 style="color: red">${requirements}</h5></b>
								<h6 style="color: black;">
									<ul align="left">
										<li>- ${highereducation}</li>
										<li>- ${experienceasanaccountant} <label
											id="vacancyaccountantexperience"></label></li>
										<li>- ${responsibilitydiligence}</li>
										<li>- ${knowledgeofaccounting}</li>
									</ul>
								</h6>
								<b><h5 style="color: red">${conditions}</h5></b>
								<h6 style="color: black;">
									<ul align="left">
										<li>- ${registration}</li>
										<li>- ${officialsalary} <label
											id="vacancyaccaountantsalary"></label></li>
										<li>- ${workingconditions}</li>
									</ul>
								</h6>
							</div>
						</div>
						<div class="modal-footer">

							<button class="btn btn-success" type="button"
								data-dismiss="modal">${okbutton}</button>
						</div>
					</div>
				</div>
			</div>




			<form action="controllerServlet" method="get">
				<div id="resumewilbedeletedmodal" class="modal fade" tabindex="-1">
					<div class="modal-dialog modal-lg">
						<div class="modal-content">
							<div class="modal-header">
								<br>
								<h3 align="center" class="modal-title" style="color: orange;">${messageverificationdelete}</h3>
								<br>
								<button class="close" type="button" data-dismiss="modal">
									<i class="fa fa-close"></i>
								</button>
							</div>
							<div class="modal-body">
								<div class="form-group">
									<h5 align="center" class="modal-title" style="color: red;">${messageadreedeleteresume}</h5>
								</div>
							</div>
							<div class="modal-footer">
								<button class="btn btn-success" type="button"
									data-dismiss="modal">${cancelbutton}</button>
								<input type="hidden" id="resumeid" name="resumeid"> <input
									type="hidden" name="command" value="cb.delete_resume">
								<button class="btn btn-danger" type="submit">${deletebutton}</button>


							</div>
						</div>
					</div>
				</div>
			</form>

			<div id="aboutrespond" class="modal fade" tabindex="-1">
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
									<c:when test="${not empty param.respondadded}">
										<h5 align="center" class="modal-title" style="color: green;">${sentapplication}</h5>
									</c:when>
									<c:otherwise>
										<h5 align="center" class="modal-title" style="color: red;">${applicationnotsent}</h5>
									</c:otherwise>
								</c:choose>

							</div>
						</div>
						<div class="modal-footer">
							<input type="hidden" name="command" value="cb.employee_page">
							<button class="btn btn-success" type="button"
								data-dismiss="modal">${okbutton}</button>
						</div>
					</div>
				</div>
			</div>




			<%@ include file="include/footer_include"%>

			<script>
				$('#vocancywievdrivermodal')
						.on(
								'show.bs.modal',
								function(e) {
									var $modal = $(this), vacancycompanynamebutton = e.relatedTarget.dataset.vacancycompanynamebutton;
									document.getElementById('nameOfcompany').innerHTML = vacancycompanynamebutton;
									var $modal = $(this), vacancyexperiencebutton = e.relatedTarget.dataset.vacancyexperiencebutton;
									document
											.getElementById('vacancyexperience').innerHTML = vacancyexperiencebutton;
									var $modal = $(this), vacancydlcategorybutton = e.relatedTarget.dataset.vacancydlcategorybutton;
									document
											.getElementById('vacancydlcategory').innerHTML = vacancydlcategorybutton;
									var $modal = $(this), vacancysalarybutton = e.relatedTarget.dataset.vacancysalarybutton;
									document.getElementById('vacancysalary').innerHTML = vacancysalarybutton;

								})
			</script>

			<script>
				$('#vocancywievaccountantmodal')
						.on(
								'show.bs.modal',
								function(e) {
									var $modal = $(this), vacancycompanynamebutton = e.relatedTarget.dataset.vacancycompanynamebutton;
									document.getElementById('namecompany').innerHTML = vacancycompanynamebutton;
									var $modal = $(this), vacancyexperiencebutton = e.relatedTarget.dataset.vacancyexperiencebutton;
									document
											.getElementById('vacancyaccountantexperience').innerHTML = vacancyexperiencebutton;
									var $modal = $(this), vacancysalarybutton = e.relatedTarget.dataset.vacancysalarybutton;
									document
											.getElementById('vacancyaccaountantsalary').innerHTML = vacancysalarybutton;

								})
			</script>


			<script>
				$('#profilewilbedeletedmodal').on('show.bs.modal', function(e) {
					var $modal = $(this), id = e.relatedTarget.dataset.id;
					document.getElementById('userid').value = id;
				})
			</script>

			<script>
				$('#resumewilbedeletedmodal')
						.on(
								'show.bs.modal',
								function(e) {
									var $modal = $(this), idresume = e.relatedTarget.dataset.idresume;
									document.getElementById('resumeid').value = idresume;
								})
			</script>

			<c:if test="${not empty requestScope.profile_add_message}">
				<script>
					$(document).ready(function() {
						$("#profilemodaladd").modal('show');
					});
				</script>
			</c:if>

			<c:if test="${not empty profile_delete_message}">
				<script>
					$(document).ready(function() {
						$("#profilemodaldelete").modal('show');
					});
				</script>
			</c:if>

			<c:if test="${not empty profile_update_message}">
				<script>
					$(document).ready(function() {
						$("#profilemodalupdate").modal('show');
					});
				</script>
			</c:if>

			<c:if test="${not empty resume_add_message}">
				<script>
					$(document).ready(function() {
						$("#resumemodaladd").modal('show');
					});
				</script>
			</c:if>
			<c:if test="${not empty resume_delete_message}">
				<script>
					$(document).ready(function() {
						$("#resumemodaldelete").modal('show');
					});
				</script>
			</c:if>

			<c:if test="${param.respond != ok}">
				<script>
					$(document).ready(function() {
						$("#aboutrespond").modal('show');
					});
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
		</c:when>
		<c:otherwise>
			<c:redirect url="/controllerServlet?command=cb.main_page" />
		</c:otherwise>
	</c:choose>


</body>
</html>
