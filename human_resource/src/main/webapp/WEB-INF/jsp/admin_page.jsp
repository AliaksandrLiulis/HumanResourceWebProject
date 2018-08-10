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
					</nav>
				</div>
			</div>
		</div>
	</div>
	</header>
	<div id="login_area" class="slider-area">
		<div>
			<div id="ensign-nivoslider">
				<img src="img/slider/slider6.jpg" alt="" title="#slider-direction-1" />
			</div>
			<div id="slider-direction-1" class="slider-direction slider-one">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12 col-sm-6 col-xs-6">
							<div>
								<br> <br> <br> <br> <br>
								<div class="layer-1-1 hidden-xs  slideInUp"
									data-wow-duration="1s" data-wow-delay=".2s"
									data-wow-iteration=100s>
									<div class="row">
										<div class="col-md-4 col-sm-6 col-xs-6">
											<form action="controllerServlet" method="get">
												<input type="hidden" name="command"
													value="cb.get_all_users_base">
												<div class="wow " data-wow-duration="4s"
													data-wow-delay=".2s">
													<input type="submit"
														class="ready-btn right-btn page-scroll"
														value="     All User    ">
												</div>
											</form>
											<form action="controllerServlet" method="get">
												<input type="hidden" name="command" value="read_user">
												<div class="hidden-xs wow" data-wow-duration="4s"
													data-wow-delay=".2s">
													<input type="submit"
														class="ready-btn right-btn page-scroll"
														value="   Read_User  ">
												</div>
											</form>
											<form action="controllerServlet" method="get">
												<input type="hidden" name="command" value="update_user">
												<div class="hidden-xs wow" data-wow-duration="4s"
													data-wow-delay=".2s">
													<input type="submit"
														class="ready-btn right-btn page-scroll"
														value=" Update_User">
												</div>
											</form>
											<form action="controllerServlet" method="get">
												<input type="hidden" name="command" value="delite_user">
												<div class="hidden-xs wow" data-wow-duration="4s"
													data-wow-delay=".2s">
													<input type="submit"
														class="ready-btn right-btn page-scroll"
														value="  Delete_user ">
												</div>
											</form>
										</div>
											<div class="col-md-6 col-sm-6 col-xs-6">
											<c:if test="${requestScope.allUserBase != null}">
												<table 
													class="datatable table table-condensed table-bordered table-hover "
													id="myUserData">
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
													
													<tbody align="center">
														<c:forEach items="${allUserBase}" var="choosen">
															<tr>
																<td>${choosen.getName()}</td>
																<td>${choosen.getSurname()}</td>
																<td>${choosen.getNickName()}</td>
																<td>${choosen.getEmail()}</td>
																<td>${choosen.getRole()}</td>
																<td>${choosen.getAvaliable()}</td>
															</tr>
														</c:forEach>
													</tbody>
												</table>
											</c:if>
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

	<%@ include file="include/footer_include"%>






	<script type="text/javascript">
	$('#myUserData').DataTable({
		
	    "language": {
	    	  "processing": "Подождите...",
	    	  "search": "Поиск:",
	    	  "lengthMenu": "Показать _MENU_ записей",
	    	  "info": "Записи с _START_ до _END_ из _TOTAL_ записей",
	    	  "infoEmpty": "Записи с 0 до 0 из 0 записей",
	    	  "infoFiltered": "(отфильтровано из _MAX_ записей)",
	    	  "infoPostFix": "",
	    	  "loadingRecords": "Загрузка записей...",
	    	  "zeroRecords": "Записи отсутствуют.",
	    	  "emptyTable": "В таблице отсутствуют данные",
	    	  "paginate": {
	    	    "first": "Первая",
	    	    "previous": "Предыдущая",
	    	    "next": "Следующая",
	    	    "last": "Последняя"
	    	  },
	    	  "aria": {
	    	    "sortAscending": ": активировать для сортировки столбца по возрастанию",
	    	    "sortDescending": ": активировать для сортировки столбца по убыванию"
	    	  }
	    	}
	});
</script>
</body>
</html>
