<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>

<title>Main_page</title>
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
<%@ include file="include/main_include"%>

</head>
<body data-spy="scroll" data-target="#navbar-example">
	<div id="preloader"></div>

	<!-- 	Start NuvBar Area  -->

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

						<!-- 	Start Navigation by NavBur area -->

						<ul class="nav navbar-nav navbar-right">
							<li class="active"><a class="page-scroll" href="#home">${home}</a></li>
							<li><a class="page-scroll" href="#about">${aboutHR}</a></li>
							<li><a class="page-scroll" href="#services">${service}</a></li>
							<li><a class="page-scroll" href="#team">${team}</a></li>
							<li><a class="page-scroll" href="#contact">${contact}</a></li>

							<!-- 	Start area mypage button if user login -->

							<c:choose>
								<c:when test="${user != null}">
									<li><br>
										<form action="controllerServlet" method="get">
											<input type="hidden" name="command" value="cb.back_user">
											<button class="btn  btn-xs" type="submit">${mypage}</button>
										</form></li>
									<li><br>
										<form action="controllerServlet" method="get">
											<input type="hidden" name="command" value="cb.logout_user">
											<h6 align="center" style="color: orange;">${sessionScope.user.nickName}</h6>
											<button class="btn  btn-xs btn-success" type="submit">${Logout}</button>
										</form></li>
								</c:when>

								<c:otherwise>
									<li><br>
										<form action="controllerServlet" method="get">
											<input type="hidden" name="command" value="cb.login_page">
											<button class="btn  btn-xs btn-success" type="submit">${login}</button>
										</form></li>
								</c:otherwise>

							</c:choose>

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

						<!-- 	End Navigation by NavBur area -->

					</div>
					</nav>

				</div>
			</div>
		</div>
	</div>
	</header>

	<!-- 	Start NuvBar Area  -->

	<!-- 	Start Slides Area with message -->

	<div id="home" class="slider-area">
		<div>
			<div id="ensign-nivoslider" class="slides">
				<img src="img/slider/slider1.jpg" alt="" title="#slider-direction-1" />
				<img src="img/slider/slider2.jpg" alt="" title="#slider-direction-2" />
				<img src="img/slider/slider3.jpg" alt="" title="#slider-direction-3" />
			</div>
			<div id="slider-direction-1" class="slider-direction slider-one">
				<div class="container">
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="slider-content">
								<div class="layer-1-1 hidden-xs wow slideInDown"
									data-wow-duration="2s" data-wow-delay=".2s">
									<h2 class="title1">${message1}</h2>
								</div>
								<!-- layer 2 -->
								<div class="layer-1-2 wow slideInUp" data-wow-duration="2s"
									data-wow-delay=".1s">
									<h1 class="title2">${message2}</h1>
								</div>
								<c:if test="${user == null}">
									<div class="form-group">
										<div class="layer-1-3 hidden-xs wow slideInUp"
											data-wow-duration="2s" data-wow-delay=".2s">
											<form action="controllerServlet" method="get">
												<input type="hidden" name="command" value="cb.login_page">
												<button class="ready-btn right-btn page-scroll"
													type="submit">${login}</button>
											</form>
											<form action="controllerServlet" method="get">
												<input type="hidden" name="command"
													value="cb.registration_page">
												<button class="ready-btn right-btn page-scroll"
													type="submit">${registration}</button>
											</form>
										</div>
									</div>
								</c:if>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div id="slider-direction-2" class="slider-direction slider-two">
			<div class="container">
				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="slider-content text-center">
							<!-- layer 1 -->
							<div class="layer-1-1 hidden-xs wow slideInUp"
								data-wow-duration="2s" data-wow-delay=".2s">
								<h2 class="title1">${message3}</h2>
							</div>
							<!-- layer 2 -->
							<div class="layer-1-2 wow slideInUp" data-wow-duration="2s"
								data-wow-delay=".1s">
								<h1 class="title2">${message4}</h1>
							</div>
							<c:if test="${user == null}">
								<div class="form-group">
									<div class="layer-1-3 hidden-xs wow slideInUp"
										data-wow-duration="2s" data-wow-delay=".2s">
										<form action="controllerServlet" method="get">
											<input type="hidden" name="command" value="cb.login_page">
											<button class="ready-btn right-btn page-scroll" type="submit">${login}</button>
										</form>
										<form action="controllerServlet" method="get">
											<input type="hidden" name="command"
												value="cb.registration_page">
											<button class="ready-btn right-btn page-scroll" type="submit">${registration}</button>
										</form>
									</div>
								</div>
							</c:if>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div id="slider-direction-3" class="slider-direction slider-two">
			<div class="container">
				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="slider-content">
							<!-- layer 1 -->
							<div class="layer-1-1 hidden-xs wow slideInUp"
								data-wow-duration="2s" data-wow-delay=".2s">
								<h2 class="title1">${message5}</h2>
							</div>
							<!-- layer 2 -->
							<div class="layer-1-2 wow slideInUp" data-wow-duration="2s"
								data-wow-delay=".1s">
								<h1 class="title2">${message6}</h1>
							</div>
							<c:if test="${user == null}">
								<div class="form-group">
									<div class="layer-1-3 hidden-xs wow slideInUp"
										data-wow-duration="2s" data-wow-delay=".2s">
										<form action="controllerServlet" method="get">
											<input type="hidden" name="command" value="cb.login_page">
											<button class="ready-btn right-btn page-scroll" type="submit">${login}</button>
										</form>
										<form action="controllerServlet" method="get">
											<input type="hidden" name="command"
												value="cb.registration_page">
											<button class="ready-btn right-btn page-scroll" type="submit">${registration}</button>
										</form>
									</div>
								</div>
							</c:if>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- 	End Slides Area with message -->

	<!-- 	Start about us Area -->

	<div id="about" class="about-area area-padding">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-sm-12 col-xs-12">
					<div class="section-headline text-center">
						<h2>${about}</h2>
					</div>
				</div>
			</div>
			<div class="row">
				<!-- single-well start-->
				<div class="col-md-6 col-sm-6 col-xs-12">
					<div class="well-left">
						<div class="single-well">
							<a> <img src="img/about/1.jpg" alt="">
							</a>
						</div>
					</div>
				</div>
				<!-- single-well end-->
				<div class="col-md-6 col-sm-6 col-xs-12">
					<div class="well-middle">
						<div class="single-well">


							<ul>
								<li><i class="fa fa-check"></i>${found}</li>
								<li><i class="fa fa-check"></i>${employee}</li>
								<li><i class="fa fa-check"></i>${hrproject}</li>
								<li><i class="fa fa-check"></i>${leader}</li>

							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- 	End about us Area -->

	<!-- 	Start our-service Area -->

	<div id="services" class="services-area area-padding">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-sm-12 col-xs-12">
					<div class="section-headline services-head text-center">
						<h2>${ourservice}</h2>
					</div>
				</div>
			</div>
			<div class="row text-center">
				<div class="services-contents">
					<div class="col-md-4 col-sm-4 col-xs-12">
						<div class="about-move">
							<div class="services-details">
								<div class="single-services">
									<a class="services-icon"> <i
										class="glyphicon glyphicon-tag"></i>
									</a>
									<h4>Search and select</h4>
									<p>${search}</p>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-4 col-sm-4 col-xs-4">
						<div class="about-move">
							<div class="services-details">
								<div class="single-services">
									<a class="services-icon"> <i class="fa fa-camera-retro"></i>
									</a>
									<h4>Head Hunting</h4>
									<p>${headhunting}</p>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-4 col-sm-4 col-xs-4">
						<div class=" about-move">
							<div class="services-details">
								<div class="single-services">
									<a class="services-icon"> <i class="fa fa-wordpress"></i>
									</a>
									<h4>Executive Search</h4>
									<p>${executivesearch}</p>
								</div>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>

	<!-- 	End our-service Area -->

	<!-- 	Start our-skills Area -->

	<div class="our-skill-area fix hidden-sm">
		<div class="test-overly"></div>
		<div class="skill-bg area-padding-2">
			<div class="container">
				<div class="row">
					<div class="skill-text">
						<div class="col-xs-12 col-sm-4 col-md-4 text-center">
							<div class="single-skill">
								<div class="progress-circular">
									<input type="text" class="knob" value="0" data-rel="27"
										data-linecap="round" data-width="175" data-bgcolor="#fff"
										data-fgcolor="#3EC1D5" data-thickness=".20"
										data-readonly="true" disabled>
									<h3 class="progress-h4">${leaders}</h3>
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-4 col-md-4 text-center">
							<div class="single-skill">
								<div class="progress-circular">
									<input type="text" class="knob" value="0" data-rel="32"
										data-linecap="round" data-width="175" data-bgcolor="#fff"
										data-fgcolor="#3EC1D5" data-thickness=".20"
										data-readonly="true" disabled>
									<h3 class="progress-h4">${specialist}</h3>
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-4 col-md-4 text-center">
							<div class="single-skill">
								<div class="progress-circular">
									<input type="text" class="knob" value="0" data-rel="41"
										data-linecap="round" data-width="175" data-bgcolor="#fff"
										data-fgcolor="#3EC1D5" data-thickness=".20"
										data-readonly="true" disabled>
									<h3 class="progress-h4">${staff}</h3>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- 	End our-skills Area -->

	<!-- 	Start about our team Area -->

	<div id="team" class="our-team-area area-padding">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-sm-12 col-xs-12">
					<div class="section-headline text-center">
						<h2>${ourteam}</h2>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="team-top">
					<div class="col-md-3 col-sm-3 col-xs-12"></div>
					<div class="col-md-3 col-sm-3 col-xs-12">
						<div class="single-team-member">
							<div class="team-img">
								<a> <img src="img/team/1.jpg" alt="">
								</a>
								<div class="team-social-icon text-center">
									<ul>
										<li><a> <i class="fa fa-facebook"></i>
										</a></li>
										<li><a> <i class="fa fa-twitter"></i>
										</a></li>
										<li><a> <i class="fa fa-instagram"></i>
										</a></li>
									</ul>
								</div>
							</div>
							<div class="team-content text-center">
								<p>HRD</p>
							</div>
						</div>
					</div>
					<div class="col-md-3 col-sm-3 col-xs-12">
						<div class="single-team-member">
							<div class="team-img">
								<a> <img src="img/team/3.jpg" alt="">
								</a>
								<div class="team-social-icon text-center">
									<ul>
										<li><a> <i class="fa fa-facebook"></i>
										</a></li>
										<li><a> <i class="fa fa-twitter"></i>
										</a></li>
										<li><a> <i class="fa fa-instagram"></i>
										</a></li>
									</ul>
								</div>
							</div>
							<div class="team-content text-center">
								<p>HR</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- 	End about our team Area -->

	<!-- 	Start contact Area -->

	<div id="contact" class="contact-area">
		<div class="contact-inner area-padding">
			<div class="contact-overly"></div>
			<div class="container ">
				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="section-headline text-center">
							<h2>${ourcontact}</h2>
						</div>
					</div>
				</div>
				<div class="row">
					<!-- Start contact icon column -->
					<div class="col-md-4 col-sm-4 col-xs-12">
						<div class="contact-icon text-center">
							<div class="single-icon">
								<i class="fa fa-mobile"></i>
								<p>
									${phone}: +375(29) 111 11 11<br> <span>${weakday}
										(9am-5pm)</span>
								</p>
							</div>
						</div>
					</div>
					<!-- Start contact icon column -->
					<div class="col-md-4 col-sm-4 col-xs-12">
						<div class="contact-icon text-center">
							<div class="single-icon">
								<i class="fa fa-envelope-o"></i>
								<p>
									Email: HR@gmail.com<br> <span>Web:
										www.human_resource.by</span>
								</p>
							</div>
						</div>
					</div>
					<!-- Start contact icon column -->
					<div class="col-md-4 col-sm-4 col-xs-12">
						<div class="contact-icon text-center">
							<div class="single-icon">
								<i class="fa fa-map-marker"></i>
								<p>
									${location}: <br> <span>${adresshr}</span>
								</p>
							</div>
						</div>
					</div>
				</div>

				<!--Start send message form -->

				<div class="row">
					<div class="col-md-3 col-sm-3 col-xs-12"></div>
					<div class="col-md-6 col-sm-6 col-xs-12">
						<div class="form contact-form">
							<div id="errormessage"></div>
							<form action="controllerServlet" method="post"
								class="contactForm">
								<div class="form-group">
									<input type="text" name="name" oninvalid="InvalidMsg(this);"
										oninput="InvalidMsg(this);" class="form-control" id="name"
										placeholder="${name}" data-rule="minlen:4" required="required" />
									<div class="validation"></div>
									<input type="email" class="form-control"
										oninvalid="InvalidMailMsg(this);"
										oninput="InvalidMailMsg(this);" name="email" id="email"
										placeholder="${email}" data-rule="email" required="required" />
									<div class="validation"></div>
									<textarea class="form-control" name="message" rows="5"
										data-rule="required" oninvalid="InvalidforText(this);"
										oninput="InvalidforText(this);" placeholder="${message}"
										required="required"></textarea>
									<div class="validation"></div>
									<input type="hidden" name="command" value="cb.email_message">
									<div class="text-center">
										<button type="submit">${sendmessage}</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>

				<!--End send message form -->

			</div>
		</div>
	</div>

	<!-- 	End contact Area -->

	<!-- 	Modal window with information about send messages -->

	<div id="aboutmessage" class="modal fade" tabindex="-1">
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
							<c:when test="${not empty param.lettersent}">
								<h5 align="center" class="modal-title" style="color: green;">${messagesent}</h5>
							</c:when>
							<c:otherwise>
								<h5 align="center" class="modal-title" style="color: red;">${messagenotsent}</h5>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
				<div class="modal-footer">
					<input type="hidden" name="command" value="cb.employee_page">
					<button class="btn btn-success" type="button" data-dismiss="modal">${okbutton}</button>
				</div>
			</div>
		</div>
	</div>

	<!-- 	Start footer Area  -->

	<%@ include file="include/footer_include"%>

	<!-- 	End footer Area  -->

	<!-- Show message in modal window id="aboutmessage", about SENT if param.sendmess isn't EMPTY -->

	<c:if test="${not empty param.sendmess}">
		<script>
			$(document).ready(function() {
				$("#aboutmessage").modal('show');
			});
		</script>
	</c:if>

	<!-- Check params on form "send message"  and show validation message in this form -->

	<script type="text/javascript">
		function InvalidMsg(textbox) {

			if (textbox.value == '' || textbox.value.length > 15) {
				textbox.setCustomValidity("${messagefildvalidaty}");
			} else {
				textbox.setCustomValidity('');
			}
			return true;
		}
		function InvalidMailMsg(textbox) {

			if (textbox.value == '' || textbox.value.length > 30) {
				textbox.setCustomValidity("${messagemailfildvalidaty}");
			} else if (textbox.validity.typeMismatch) {
				textbox.setCustomValidity("${messageemailvalidaty}");
			} else {
				textbox.setCustomValidity('');
			}
			return true;
		}
		function InvalidforText(textbox) {

			if (textbox.value == '') {
				textbox.setCustomValidity("${messagefortextfilddvalidaty}");
			} else {
				textbox.setCustomValidity('');
			}
			return true;
		}
	</script>

</body>
</html>
