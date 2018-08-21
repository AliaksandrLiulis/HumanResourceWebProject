<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>

<title>hr_page</title>
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
<%@ include file="include/hr_include"%>

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
							<li><a>
									<form "controllerServlet" method="get">
										<input type="hidden" name="command"
											value="cb.get_own_vacancy_for_hr"> <input
											type="hidden" name="limitLine" value="5"> <input
											type="hidden" name="offsetline" value="0"> <input
											type="hidden" name="vacancy" value="vacancies"> <input
											type="hidden" name="userid" value="${user.userId}"> <input
											type="hidden" name="pagenum" value="1">
										<button class="btn btn-link btn-lg" type="submit">
											<h6>${myvacancies}</h6>
										</button>
									</form>
							</a></li>

							<li><br>
								<ul class="nav navbar-nav">
									<button class="btn btn-link btn-lg" class="dropdown-toggle"
										data-toggle="dropdown" aria-haspopup="true"
										aria-expanded="false">
										<h6>${addvacancy}</h6>
										<span class="caret"></span>
									</button>

									<ul class="dropdown-menu">
										<li><a style="color: blue" href="#driverModal"
											class="btn btn-link" data-toggle="modal">${modalselectdriver}</a></li>
										<li><a style="color: blue" href="#accountantModal"
											class="btn btn-link" data-toggle="modal">${modalselectaccountant}</a></li>
									</ul>

								</ul>
							<li><a>
									<form "controllerServlet" method="get">
										<input type="hidden" name="command" value="cb.main_page">
										<button class="btn btn-link btn-lg" type="submit">
											<h6>${resume}</h6>
										</button>
									</form>
							</a></li>

							<c:if test="${user != null}">
								<li><br>
									<form action="controllerServlet" method="post">
										<input type="hidden" name="command" value="cb.logout_user">
										<h6 align="center" style="color: orange;">${sessionScope.user.name}</h6>
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
					</nav>

				</div>
			</div>
		</div>
	</div>
	</header>
	<div id="login_area" class="slider-area">
		<div>
			<div id="ensign-nivoslider" class="slides">
				<img src="img/slider/slider9.jpg" alt="" title="#slider-direction-1" />
			</div>
			<div id="slider-direction-1" class="slider-direction slider-one">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="slider-content">
								<!-- layer 1 -->
								<div class="layer-1-1 hidden-xs wow slideInDown"
									data-wow-duration="1s" data-wow-delay=".2s">
									<div class="row">
										<div class="col-md-5 col-sm-6 col-xs-6">
											<c:if test="${not empty requestScope.allVacancy}">
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
																	<th style="color: orange;" scope="col">${experience}</th>
																	<th style="color: orange;" scope="col">${salary}</th>
																	<th style="color: orange;" scope="col">${showvacancy}</th>
																	<th style="color: orange;" scope="col">${deletevacancy}</th>
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
																		<td style="color: black;">${vacancy.experience}</td>
																		<td style="color: black;">${vacancy.salary}</td>
																		<td><c:set var="count" value="${count + 1}"
																				scope="page" />
																			<form method="post" action="">
																				<button type="submit" class="btn btn-success">${showbutton}</button>
																			</form></td>
																		<td><input type="hidden" name="vacancyId"
																			value="${vacancy.idvacancy}">
																			<button type="button" class="btn btn-danger"
																				data-toggle="modal" data-target="#deleteVacancy"
																				data-idvacancy="${vacancy.idvacancy}">${deletebutton}</button>
																		</td>
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
																					class="page-link" href="#" tabindex="-1">Previous</a></li>
																			</c:when>
																			<c:otherwise>
																				<li class="page-item "><a class="page-link"
																					href="controllerServlet?command=cb.get_own_vacancy_for_hr&limitLine=5&offsetline=${(requestScope.pagenum * 5)-10}
																				&vacancy=vacancies&userid=${user.userId}&pagenum=${requestScope.pagenum - 1}">Previous</a></li>
																			</c:otherwise>
																		</c:choose>

																		<c:forEach begin="1" end="${requestScope.pagecount}"
																			varStatus="loop">
																			<li class="page-item"><a class="page-link"
																				href="controllerServlet?command=cb.get_own_vacancy_for_hr&limitLine=5&offsetline=${(loop.index * 5)-5 }
																				&vacancy=vacancies&userid=${user.userId}&pagenum=${loop.index}">${loop.index}</a></li>
																		</c:forEach>

																		<c:choose>
																			<c:when
																				test="${requestScope.pagenum == requestScope.pagecount}">
																				<li class="page-item disabled"><a
																					class="page-link" href="#">${next}</a></li>
																			</c:when>
																			<c:otherwise>
																				<li class="page-item "><a class="page-link"
																					href="controllerServlet?command=cb.get_own_vacancy_for_hr&limitLine=5&offsetline=${requestScope.pagenum * 5}
																				&vacancy=vacancies&userid=${user.userId}&pagenum=${requestScope.pagenum + 1}">${next}</a></li>
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
																					href="controllerServlet?command=cb.get_own_vacancy_for_hr&limitLine=5&offsetline=5&vacancy=vacancies&userid=${user.userId}&pagenum=2">${next}</a>
																				</li>
																			</ul>
																			</nav>
																		</c:when>
																		<c:otherwise>
																			<nav aria-label="Page navigation">
																			<ul class="pagination justify-content-center">
																				<li class="page-item"><a class="page-link"
																					href="controllerServlet?command=cb.get_own_vacancy_for_hr&limitLine=5&offsetline=0&vacancy=vacancies&userid=${user.userId}&pagenum=1"
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
											</c:if>

										</div>
									</div>
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12">
											<div class="layer-1-1 hidden-xs wow slideInDown"
												data-wow-duration="1s" data-wow-delay=".2s">
												<h3 align="center" style="color: orange;">
													<b><i> <c:if
																test="${requestScope.no_vacancies != null}">
																<c:out value="You don't have vacancy"></c:out>

															</c:if> <c:if test="${requestScope.error_get_vacancy != null}">
																<c:out value="vacancy receipt error"></c:out>
															</c:if> <c:if
																test="${requestScope.error_delete_vacancy != null}">
																<c:out value="vacancy not deleted"></c:out>
															</c:if>
													</i> </b>
												</h3>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<form action="controllerServlet" method="get">
		<div id="driverModal" class="modal fade" tabindex="-1">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header">
						<h4 align="center" class="modal-title" style="color: orange;">${modalselectdriver}</h4>
						<br>
						<h6 align="center" class="modal-title" style="color: green;">${fillformmessage}</h6>
						<button class="close" type="button" data-dismiss="modal">
							<i class="fa fa-close"></i>
						</button>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<a><label for="company_name">${companyname}</label> <input
								type="text" class="form-control" id="company_name"
								name="company_name" required></a> <a><label
								for="goodsname">${nameofgoods}</label> <input type="text"
								class="form-control" id="goodsname" name="goods_name" required></a>
							<a><label for="expirience">${experience}</label> <input
								type="text" class="form-control" id="expirience"
								name=workexpirience required></a> <a><label
								for="category">${dlcategory}</label> <input type="text"
								class="form-control" id="category" name="category" required></a>
							<a><label for="salary">${salary}</label> <input type="text"
								class="form-control" id="Salary" name="salary" required></a>
						</div>
					</div>
					<div class="modal-footer">
						<button class="btn btn-danger" type="button" data-dismiss="modal">Close</button>
						<input type="hidden" name="profession" value="driver"> <input
							type="hidden" name="userid" value="${user.userId}"> <input
							type="hidden" name="command" value="cb.add_vacancy">

						<button class="btn btn-success" type="submit">Add</button>

					</div>
				</div>
			</div>
		</div>
	</form>

	<form action="controllerServlet" method="get">
		<div id="accountantModal" class="modal fade" tabindex="-1">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header">
						<h4 align="center" class="modal-title" style="color: orange;">${modalselectaccountant}</h4>
						<br>
						<h6 align="center" class="modal-title" style="color: green;">${fillformmessage}</h6>
						<button class="close" type="button" data-dismiss="modal">
							<i class="fa fa-close"></i>
						</button>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<a><label for="company_name">${companyname}</label> <input
								type="text" class="form-control" id="company_name"
								name="company_name" required></a> <a><label
								for="expirience">${experience}</label> <input type="text"
								class="form-control" id="expirience" name=workexpirience
								required></a> <a><label for="salary">${salary}</label> <input
								type="text" class="form-control" id="Salary" name="salary"
								required></a>
						</div>
					</div>
					<div class="modal-footer">
						<button class="btn btn-danger" type="button" data-dismiss="modal">Close</button>
						<input type="hidden" name="profession" value="accountant">
						<input type="hidden" name="userid" value="${user.userId}">
						<input type="hidden" name="command" value="cb.add_vacancy">

						<button class="btn btn-success" type="submit">Add</button>

					</div>
				</div>
			</div>
		</div>
	</form>

	<form action="controllerServlet" method="get">
		<div id="deleteVacancy" class="modal fade" tabindex="-1">
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
							<h5 align="center" class="modal-title" style="color: red;">${messagedeletevacancy}</h5>
						</div>
					</div>
					<div class="modal-footer">
						<button class="btn btn-success" type="button" data-dismiss="modal">${cancelbutton}</button>
						<input type="hidden" id="vacancyId" name="vacancyId"> <input
							type="hidden" name="command" value="cb.delete_vacancy">
						<button class="btn btn-danger" type="submit">${deletebutton}</button>

					</div>
				</div>
			</div>
		</div>
	</form>

	<div id="vacancydeletemessage" class="modal fade" tabindex="-1">
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
							<c:when test="${requestScope.vacancy_delete_message == 1}">
								<h5 align="center" class="modal-title" style="color: green;">${vacancydeleted}</h5>
							</c:when>
							<c:otherwise>
								<h5 align="center" class="modal-title" style="color: red;">${vacancynotdeleted}</h5>
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
	
	<div id="vacancyaddmessage" class="modal fade" tabindex="-1">
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
							<c:when test="${requestScope.vacancy_add_message == 1}">
								<h5 align="center" class="modal-title" style="color: green;">${vacancyadded}</h5>
							</c:when>
							<c:otherwise>
								<h5 align="center" class="modal-title" style="color: red;">${vacancynotadded}</h5>
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

	<c:if test="${not empty requestScope.vacancy_deleted}">
		<script>
			$(document).ready(function() {
				$("#vacancydeleted").modal('show');
			});
		</script>
	</c:if>
	<c:if test="${not empty requestScope.vacancy_added}">
		<script>
			$(document).ready(function() {
				$("#vacancyadded").modal('show');
			});
		</script>
	</c:if>

	<script>
		$('#deleteVacancy')
				.on(
						'show.bs.modal',
						function(e) {
							var $modal = $(this), idvacancy = e.relatedTarget.dataset.idvacancy;
							document.getElementById('vacancyId').value = idvacancy;
						})
	</script>

	<c:if test="${not empty requestScope.vacancy_delete_message}">
		<script>
			$(document).ready(function() {
				$("#vacancydeletemessage").modal('show');
			});
		</script>
	</c:if>
	
	<c:if test="${not empty requestScope.vacancy_add_message}">
		<script>
			$(document).ready(function() {
				$("#vacancyaddmessage").modal('show');
			});
		</script>
	</c:if>
</body>
</html>
