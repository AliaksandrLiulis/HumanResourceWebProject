<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>

<title>admin_page</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">

<link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="lib/nivo-slider/css/nivo-slider.css" rel="stylesheet">
<link href="lib/owlcarousel/owl.carousel.css" rel="stylesheet">
<link href="lib/owlcarousel/owl.transitions.css" rel="stylesheet">
<link href="lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
<link href="lib/data-tables/css/dataTables.bootstrap.min.css"
	rel="stylesheet">
<link href="lib/animate/animate.min.css" rel="stylesheet">
<link href="lib/venobox/venobox.css" rel="stylesheet">
<link href="css/nivo-slider-theme.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<link href="css/responsive.css" rel="stylesheet">
<link href="css/responsive.css" rel="stylesheet">


<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="localization.local" var="loc" />
<%@ include file="include/administrator_include"%>

</head>
<body data-spy="scroll" data-target="#navbar-example">

	<!-- 	Start NuvBar Area  -->


	<c:if test="${sessionScope.user.role == 'admin'}">
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

						<!-- 	Start Navigation by NavBur area -->

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

								<!-- 	Start area mypage button if user login -->

								<c:if test="${user != null}">
									<li><br>
										<form action="controllerServlet" method="get">
											<input type="hidden" name="command" value="cb.logout_user">
											<h6 align="center" style="color: orange;">${sessionScope.user.nickName}</h6>
											<button class="btn  btn-xs btn-success" type="submit">${logout}</button>
										</form></li>
								</c:if>

								<!-- 	Start Buttons for Localization -->

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

								<!-- 	End Buttons for Localization -->

							</ul>
						</div>

						<!-- 	End Navigation by NavBur area --> </nav>
					</div>
				</div>
			</div>
		</div>
		</header>

		<!-- 	End NuvBar Area  -->

		<div id="admin_area" class="slider-area">
			<div>
				<div id="ensign-nivoslider">
					<img src="img/slider/slider6.jpg" alt=""
						title="#slider-direction-1" />
				</div>


				<div id="slider-direction-1" class="slider-direction slider-one">
					<div class="container-fluid">
						<div class="row">
							<div class="col-md-6 col-sm-6 col-xs-6">
								<div>
									<br> <br> <br> <br> <br>
									<div class="layer-1-1 hidden-xs  slideInUp"
										data-wow-duration="1s" data-wow-delay=".2s"
										data-wow-iteration=100s>
										<div class="row">

											<!-- 	Start choose menu area -->

											<div class="col-md-5 col-sm-5 col-xs-4">
												<form action="controllerServlet" method="get">
													<input type="hidden" name="command"
														value="cb.read_all_users"> <input type="hidden"
														name="limitLine" value="5"> <input type="hidden"
														name="offsetline" value="0"> <input type="hidden"
														name="pagenum" value="1"> <input type="submit"
														class="ready-btn" value="          ${allusers}          ">
												</form>
												<form action="controllerServlet" method="get">
													<input type="hidden" name="command"
														value="cb.read_registered_users"> <input
														type="hidden" name="limitLine" value="5"> <input
														type="hidden" name="offsetline" value="0"> <input
														type="hidden" name="pagenum" value="1"> <input
														type="submit" class="ready-btn"
														value="   ${registeredusers}   ">
												</form>
												<form action="controllerServlet" method="get">
													<input type="hidden" name="command"
														value="cb.read_unregistered_users"> <input
														type="hidden" name="limitLine" value="5"> <input
														type="hidden" name="offsetline" value="0"> <input
														type="hidden" name="pagenum" value="1"> <input
														type="submit" class="ready-btn"
														value="${unregisteredusers}">
												</form>
												<form action="controllerServlet" method="get">
													<input type="hidden" name="command" value="cb.get_messages">
													<input type="submit" class="ready-btn"
														value="          ${messages}           ">
												</form>
											</div>

											<!-- 	End choose menu area -->

											<!-- 	Start Table area -->

											<div class="col-md-5 col-sm-5 col-xs-5">

												<!-- 	Table for all users -->
												<div>
													<c:if test="${requestScope.all_message != null}">

														<div class="row">
															<br> <br>
															<div class="row">
																<div class="col-md-5 col-sm-5 col-xs-5">
																	<div class="section">
																		<div class="container">
																			<h1 style="color: yellow;">Messages</h1>
																			<table
																				class="table table-bordered table-hover table-sm">
																				<thead>
																					<tr>
																						<th style="color: orange;" scope="col">${respondedname}</th>
																						<th style="color: orange;" scope="col">${respondedemail}</th>
																						<th style="color: orange;" scope="col">${respondeddate}</th>
																						<th style="color: orange;" scope="col">${content}</th>
																						<th style="color: orange;" scope="col">${action}</th>
																					</tr>
																				</thead>
																				<tbody>

																					<c:forEach var="mess"
																						items="${requestScope.all_message}">
																						<tr>
																							<td style="color: black;">${mess.name}</td>
																							<td style="color: black;">${mess.email}</td>
																							<td style="color: black;">${mess.createdate}</td>
																							<td style="color: black;">${mess.content}</td>
																							<td><button type="button"
																									data-target="#messagewillbedeletemodal"
																									class="btn btn-danger" data-toggle="modal"
																									data-idmess="${mess.idmessage}">${deletebutton}</button></td>
																						</tr>
																					</c:forEach>
																				</tbody>

																			</table>
																		</div>
																	</div>
																</div>
															</div>
														</div>
													</c:if>
												</div>

												<c:if test="${requestScope.founded_users != null}">
													<div class="row">
														<br> <br>
														<div class="row">
															<div class="col-md-5 col-sm-5 col-xs-5">
																<div class="section">
																	<div class="container">
																		<table
																			class="table table-bordered table-hover table-sm">
																			<thead>
																				<tr>
																					<th style="color: orange;" scope="col">${number}</th>
																					<th style="color: orange;" scope="col">${name}</th>
																					<th style="color: orange;" scope="col">${surname}</th>
																					<th style="color: orange;" scope="col">${nickname}</th>
																					<th style="color: orange;" scope="col">${email}</th>
																					<th style="color: orange;" scope="col">${role}</th>
																					<th style="color: orange;" scope="col">${registered}</th>
																					<th style="color: orange;" scope="col">${action}</th>
																					<th style="color: orange;" scope="col">${deletefrombase}</th>
																				</tr>
																			</thead>
																			<tbody>
																				<c:set var="count"
																					value="${(requestScope.pagenum * 5)-4}"
																					scope="page" />
																				<c:forEach var="user"
																					items="${requestScope.founded_users}">
																					<tr>
																						<td style="color: black;">${count}</td>
																						<td style="color: black;">${user.name}</td>
																						<td style="color: black;">${user.surName}</td>
																						<td style="color: black;">${user.nickName}</td>
																						<td style="color: black;">${user.email}</td>
																						<td style="color: black;">${user.role}</td>
																						<c:if test="${user.avaliable == 1}">
																							<td style="color: black;">${yes}</td>
																						</c:if>
																						<c:if test="${user.avaliable == 0}">
																							<td style="color: black;">${no}</td>
																						</c:if>
																						<c:choose>
																							<c:when test="${user.avaliable == 1}">
																								<td><button type="button"
																										data-target="#userwillbedeletemodal"
																										class="btn btn-danger" data-toggle="modal"
																										data-iduser="${user.userId}">${deletebutton}</button></td>
																							</c:when>
																							<c:otherwise>
																								<td>
																									<form action="controllerServlet" method="get">
																										<input type="hidden" name="command"
																											value="cb.add_user"> <input
																											type="hidden" name="userid"
																											value="${user.userId}">

																										<button type="submit" class="btn btn-info">

																											${addbutton	}</button>
																									</form>
																								</td>
																							</c:otherwise>

																						</c:choose>
																						<td><button type="button"
																								data-target="#userwillbedeletefrombasemodal"
																								class="btn btn-warning" data-toggle="modal"
																								data-iduserfrombase="${user.userId}">${deletebutton}</button></td>
																						<c:set var="count" value="${count + 1}"
																							scope="page" />

																					</tr>
																				</c:forEach>
																			</tbody>
																		</table>

																		<!-- 	Start Pagination area -->

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
																								<c:choose>
																									<c:when
																										test="${not empty requestScope.registered}">
																										<li class="page-item "><a
																											class="page-link"
																											href="controllerServlet?cb.read_registered_users&limitLine=5&offsetline=${(requestScope.pagenum * 5)-10}
																				&pagenum=${requestScope.pagenum - 1}">Previous</a></li>
																									</c:when>
																									<c:when
																										test="${not empty requestScope.allusers}">
																										<li class="page-item "><a
																											class="page-link"
																											href="controllerServlet?cb.read_all_users&limitLine=5&offsetline=${(requestScope.pagenum * 5)-10}
																				&pagenum=${requestScope.pagenum - 1}">Previous</a></li>
																									</c:when>
																									<c:otherwise>
																										<li class="page-item "><a
																											class="page-link"
																											href="controllerServlet?cb.read_unregistered_users&limitLine=5&offsetline=${(requestScope.pagenum * 5)-10}
																				&pagenum=${requestScope.pagenum - 1}">Previous</a></li>
																									</c:otherwise>
																								</c:choose>
																							</c:otherwise>
																						</c:choose>

																						<c:forEach begin="1"
																							end="${requestScope.pagecount}" varStatus="loop">
																							<c:choose>
																								<c:when
																									test="${not empty requestScope.registered}">
																									<li class="page-item"><a class="page-link"
																										href="controllerServlet?command=cb.read_registered_users&limitLine=5&offsetline=${(loop.index * 5)-5 }
																				&pagenum=${loop.index}">${loop.index}</a></li>
																								</c:when>
																								<c:when
																									test="${not empty requestScope.allusers}">
																									<li class="page-item"><a class="page-link"
																										href="controllerServlet?command=cb.read_all_users&limitLine=5&offsetline=${(loop.index * 5)-5 }
																				&pagenum=${loop.index}">${loop.index}</a></li>
																								</c:when>
																								<c:otherwise>
																									<li class="page-item"><a class="page-link"
																										href="controllerServlet?command=cb.read_unregistered_users&limitLine=5&offsetline=${(loop.index * 5)-5 }
																				&pagenum=${loop.index}">${loop.index}</a></li>
																								</c:otherwise>
																							</c:choose>
																						</c:forEach>

																						<c:choose>
																							<c:when
																								test="${requestScope.pagenum == requestScope.pagecount}">
																								<li class="page-item disabled"><a
																									class="page-link" href="#">${next}</a></li>
																							</c:when>
																							<c:otherwise>
																								<c:choose>
																									<c:when
																										test="${not empty requestScope.registered}">
																										<li class="page-item "><a
																											class="page-link"
																											href="controllerServlet?command=cb.read_registered_users&limitLine=5&offsetline=${requestScope.pagenum * 5}
																				&pagenum=${requestScope.pagenum + 1}">${next}</a></li>
																									</c:when>
																									<c:when
																										test="${not empty requestScope.allusers}">
																										<li class="page-item "><a
																											class="page-link"
																											href="controllerServlet?command=cb.read_all_users&limitLine=5&offsetline=${requestScope.pagenum * 5}
																				&pagenum=${requestScope.pagenum + 1}">${next}</a></li>
																									</c:when>
																									<c:otherwise>
																										<li class="page-item "><a
																											class="page-link"
																											href="controllerServlet?command=cb.read_unregistered_users&limitLine=5&offsetline=${requestScope.pagenum * 5}
																				&pagenum=${requestScope.pagenum + 1}">${next}</a></li>
																									</c:otherwise>
																								</c:choose>
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
																								<c:choose>
																									<c:when
																										test="${not empty requestScope.registered}">
																										<li class="page-item "><a
																											class="page-link"
																											href="controllerServlet?command=cb.read_registered_users&limitLine=5&offsetline=5&pagenum=2">${next}</a>
																										</li>
																									</c:when>
																									<c:when
																										test="${not empty requestScope.allusers}">
																										<li class="page-item "><a
																											class="page-link"
																											href="controllerServlet?command=cb.read_all_users&limitLine=5&offsetline=5&pagenum=2">${next}</a>
																										</li>
																									</c:when>
																									<c:otherwise>
																										<li class="page-item "><a
																											class="page-link"
																											href="controllerServlet?command=cb.read_unregistered_users&limitLine=5&offsetline=5&pagenum=2">${next}</a>
																										</li>
																									</c:otherwise>
																								</c:choose>
																							</ul>
																							</nav>
																						</c:when>
																						<c:otherwise>
																							<nav aria-label="Page navigation"> <c:choose>
																								<c:when
																									test="${not empty requestScope.registered}">
																									<ul class="pagination justify-content-center">
																										<li class="page-item"><a
																											class="page-link"
																											href="controllerServlet?command=cb.read_registered_users&limitLine=5&offsetline=0&pagenum=1"
																											tabindex="-1">${previous}</a></li>
																										<li class="page-item disabled"><a
																											class="page-link" href="#">${next}</a></li>
																									</ul>
																								</c:when>
																								<c:when
																									test="${not empty requestScope.allusers}">
																									<ul class="pagination justify-content-center">
																										<li class="page-item"><a
																											class="page-link"
																											href="controllerServlet?command=cb.read_all_users&limitLine=5&offsetline=0&pagenum=1"
																											tabindex="-1">${previous}</a></li>
																										<li class="page-item disabled"><a
																											class="page-link" href="#">${next}</a></li>
																									</ul>
																								</c:when>
																								<c:otherwise>
																									<ul class="pagination justify-content-center">
																										<li class="page-item"><a
																											class="page-link"
																											href="controllerServlet?command=cb.read_unregistered_users&limitLine=5&offsetline=0&pagenum=1"
																											tabindex="-1">${previous}</a></li>
																										<li class="page-item disabled"><a
																											class="page-link" href="#">${next}</a></li>
																									</ul>
																								</c:otherwise>
																							</c:choose> </nav>
																						</c:otherwise>
																					</c:choose>
																				</c:otherwise>
																			</c:choose>
																		</c:if>

																		<!-- 	End Pagination area -->

																	</div>
																</div>
															</div>
														</div>
													</div>
												</c:if>
											</div>

											<!-- 	End Table area -->

										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- 	Start Modal windows with message about user will be delete  -->

		<form action="controllerServlet" method="post">
			<div id="userwillbedeletemodal" class="modal fade" tabindex="-1">
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
								<h5 align="center" class="modal-title" style="color: red;">${messageadreedeleteuser}</h5>
							</div>
						</div>
						<div class="modal-footer">
							<button class="btn btn-success" type="button"
								data-dismiss="modal">${cancelbutton}</button>
							<input type="hidden" id="userid" name="userid"> <input
								type="hidden" name="command" value="cb.delete_user">
							<button class="btn btn-danger" type="submit">${deletebutton}</button>
						</div>
					</div>
				</div>
			</div>
		</form>

		<!-- 	End Modal windows with message about user will be delete -->
		
		<!-- 	Start Modal windows with message about user will be userwillbedeletefrombasemodal  -->

		<form action="controllerServlet" method="post">
			<div id="userwillbedeletefrombasemodal" class="modal fade" tabindex="-1">
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
								<h5 align="center" class="modal-title" style="color: red;">${messageadreedeleteuser}</h5>
							</div>
						</div>
						<div class="modal-footer">
							<button class="btn btn-success" type="button"
								data-dismiss="modal">${cancelbutton}</button>
							<input type="hidden" id="useridbase" name="userid"> <input
								type="hidden" name="command" value="cb.delete_user_from_base">
							<button class="btn btn-danger" type="submit">${deletebutton}</button>
						</div>
					</div>
				</div>
			</div>
		</form>

		<!-- 	End Modal windows with message about user will be userwillbedeletefrombasemodal -->

		<!-- 	Start Modal windows with message about message will be delete  -->

		<form action="controllerServlet" method="post">
			<div id="messagewillbedeletemodal" class="modal fade" tabindex="-1">
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
								<h5 align="center" class="modal-title" style="color: red;">${messagewillbedelete}</h5>
							</div>
						</div>
						<div class="modal-footer">
							<button class="btn btn-success" type="button"
								data-dismiss="modal">${cancelbutton}</button>
							<input type="hidden" id="messid" name="messid"> <input
								type="hidden" name="command" value="cb.delete_message">
							<button class="btn btn-danger" type="submit">${deletebutton}</button>
						</div>
					</div>
				</div>
			</div>
		</form>

		<!-- 	End Modal windows with message about message will be delete -->

		<!-- 	Start Modal windows with message about delete user -->

		<form action="controllerServlet" method="get">
			<div id="usermodaldelete" class="modal fade" tabindex="-1">
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
									<c:when test="${param.user_delete_message == 1}">
										<h5 align="center" class="modal-title" style="color: green;">${userdeleted}</h5>
									</c:when>
									<c:otherwise>
										<h5 align="center" class="modal-title" style="color: red;">${usernotdeleted}</h5>
									</c:otherwise>
								</c:choose>

							</div>
						</div>
						<div class="modal-footer">
							<input type="hidden" name="command" value="cb.read_all_users">
							<input type="hidden" name="limitLine" value="5"> <input
								type="hidden" name="offsetline" value="0"> <input
								type="hidden" name="pagenum" value="1">
							<button class="btn btn-success" type="submit">${okbutton}</button>
						</div>
					</div>
				</div>
			</div>
		</form>

		<!-- 	End Modal windows with message about delete user -->

		<!-- 	Start Modal windows with message about delete message -->

		<form action="controllerServlet" method="get">
			<div id="messagemodaldelete" class="modal fade" tabindex="-1">
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
									<c:when test="${param.user_message_delete == 1}">
										<h5 align="center" class="modal-title" style="color: green;">${messagedeleted}</h5>
									</c:when>
									<c:otherwise>
										<h5 align="center" class="modal-title" style="color: red;">${messagenotdeleted}</h5>
									</c:otherwise>
								</c:choose>

							</div>
						</div>
						<div class="modal-footer">
							<input type="hidden" name="command" value="cb.get_messages">
							<button class="btn btn-success" type="submit">${okbutton}</button>
						</div>
					</div>
				</div>
			</div>
		</form>

		<!-- 	End Modal windows with message about delete user -->

		<!-- 	Start Modal windows with message about add user -->

		<form action="controllerServlet" method="get">
			<div id="usermodaladded" class="modal fade" tabindex="-1">
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
									<c:when test="${param.user_add_message == 1}">
										<h5 align="center" class="modal-title" style="color: green;">${useradded}</h5>
									</c:when>
									<c:otherwise>
										<h5 align="center" class="modal-title" style="color: red;">${usernotadded}</h5>
									</c:otherwise>
								</c:choose>

							</div>
						</div>
						<div class="modal-footer">
							<input type="hidden" name="command" value="cb.read_all_users">
							<input type="hidden" name="limitLine" value="5"> <input
								type="hidden" name="offsetline" value="0"> <input
								type="hidden" name="pagenum" value="1">
							<button class="btn btn-success" type="submit">${okbutton}</button>
						</div>
					</div>
				</div>
			</div>
		</form>

		<!-- 	End Modal windows with message about not delete user -->

		<!-- 	Start Modal windows if errorgetting -->

		<div id="errorgettinguser" class="modal fade" tabindex="-1">
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
							<h5 align="center" class="modal-title" style="color: green;">${errorgetting}</h5>
						</div>
					</div>
					<div class="modal-footer">
						<button class="btn btn-success" type="button" data-dismiss="modal">${okbutton}</button>
					</div>
				</div>
			</div>
		</div>

		<!-- 	End Modal windows if errorgetting -->

		<!-- 	Start Modal windows if errorgettingmessage -->

		<div id="errorgettingmessage" class="modal fade" tabindex="-1">
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
							<h5 align="center" class="modal-title" style="color: green;">${errorgettingmessage}</h5>
						</div>
					</div>
					<div class="modal-footer">
						<button class="btn btn-success" type="button" data-dismiss="modal">${okbutton}</button>
					</div>
				</div>
			</div>
		</div>

		<!-- 	End Modal windows if errorgettingmessage -->

		<!-- 	Start Modal windows if userEmpty -->

		<div id="userempty" class="modal fade" tabindex="-1">
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
							<h5 align="center" class="modal-title" style="color: green;">${nousers}</h5>
						</div>
					</div>
					<div class="modal-footer">
						<button class="btn btn-success" type="button" data-dismiss="modal">${okbutton}</button>
					</div>
				</div>
			</div>
		</div>

		<!-- 	End Modal windows if userEmpty -->

		<!-- 	Start Modal windows if messageEmpty -->

		<div id="messageempty" class="modal fade" tabindex="-1">
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
							<h5 align="center" class="modal-title" style="color: green;">${nomessage}</h5>
						</div>
					</div>
					<div class="modal-footer">
						<button class="btn btn-success" type="button" data-dismiss="modal">${okbutton}</button>
					</div>
				</div>
			</div>
		</div>

		<!-- 	End Modal windows if messageEmpty -->


		<!-- 	Start footer Area  -->

		<%@ include file="include/footer_include"%>

		<!-- 	End footer Area  -->

		<!-- Transfer data in modal window "userwillbedeletemodal" -->

		<script>
			$('#userwillbedeletemodal').on('show.bs.modal', function(e) {
				var $modal = $(this), iduser = e.relatedTarget.dataset.iduser;
				document.getElementById('userid').value = iduser;
			})
		</script>
		
		<!-- Transfer data in modal window "userwillbedeletemodalfrombase" -->

		<script>
			$('#userwillbedeletefrombasemodal').on('show.bs.modal', function(e) {
				var $modal = $(this), iduserfrombase = e.relatedTarget.dataset.iduserfrombase;
				document.getElementById('useridbase').value = iduserfrombase;
			})
		</script>
		

		<!-- Transfer data in modal window "messagewillbedeletemodal" -->

		<script>
			$('#messagewillbedeletemodal').on('show.bs.modal', function(e) {
				var $modal = $(this), idmess = e.relatedTarget.dataset.idmess;
				document.getElementById('messid').value = idmess;
			})
		</script>

		<!-- Open modal window with message about delete user -->

		<c:if test="${not empty param.user_delete_message}">
			<script>
				$(document).ready(function() {
					$("#usermodaldelete").modal('show');
				});
			</script>
		</c:if>

		<!-- Open modal window with message about delete message -->

		<c:if test="${not empty param.user_message_delete}">
			<script>
				$(document).ready(function() {
					$("#messagemodaldelete").modal('show');
				});
			</script>
		</c:if>

		<!-- Open modal window with message about add -->

		<c:if test="${not empty param.user_add_message}">
			<script>
				$(document).ready(function() {
					$("#usermodaladded").modal('show');
				});
			</script>
		</c:if>

		<!-- Open modal window  message if errorgetting -->

		<c:if test="${not empty param.errorgetting}">
			<script>
				$(document).ready(function() {
					$("#errorgettinguser").modal('show');
				});
			</script>
		</c:if>

		<!-- Open modal window  message if errorgettingmessage -->

		<c:if test="${not empty param.errorgettingmessage}">
			<script>
				$(document).ready(function() {
					$("#errorgettingmessage").modal('show');
				});
			</script>
		</c:if>

		<!-- Open modal window  message if emptyuser -->

		<c:if test="${not empty param.emptyuser}">
			<script>
				$(document).ready(function() {
					$("#userempty").modal('show');
				});
			</script>
		</c:if>

		<!-- Open modal window  message id="aboutvacancymessage" -->

		<!-- Open modal window  message if emptymessage -->

		<c:if test="${not empty param.emptymessage}">
			<script>
				$(document).ready(function() {
					$("#messageempty").modal('show');
				});
			</script>
		</c:if>

		<!-- Open modal window  message id="aboutvacancymessage" -->


	</c:if>

	<c:if test="${sessionScope.user.role != 'admin'}">
		<c:redirect url="/controllerServlet?command=cb.main_page" />
	</c:if>

</body>
</html>
