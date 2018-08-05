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

<link href="img/favicon.png" rel="icon">
<link href="img/apple-touch-icon.png" rel="apple-touch-icon">

<!-- Bootstrap CSS File -->
<link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Libraries CSS Files -->
<link href="lib/nivo-slider/css/nivo-slider.css" rel="stylesheet">
<link href="lib/owlcarousel/owl.carousel.css" rel="stylesheet">
<link href="lib/owlcarousel/owl.transitions.css" rel="stylesheet">
<link href="lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
<link href="lib/animate/animate.min.css" rel="stylesheet">
<link href="lib/venobox/venobox.css" rel="stylesheet">

<!-- Nivo Slider Theme -->
<link href="css/nivo-slider-theme.css" rel="stylesheet">

<!-- Main Stylesheet File -->
<link href="css/style.css" rel="stylesheet">

<!-- Responsive Stylesheet File -->
<link href="css/responsive.css" rel="stylesheet">

<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="localization.local" var="loc" />
<%@ include file="include/main_include"%>

</head>
<body data-spy="scroll" data-target="#navbar-example">


	<div id="preloader"></div>

	<header> <!-- header-area start -->
	<div id="sticker" class="header-area">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-sm-12">

					<!-- Navigation -->
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
					<!-- Collect the nav links, forms, and other content for toggling -->
					<div
						class="collapse navbar-collapse main-menu bs-example-navbar-collapse-1"
						id="navbar-example">
						<ul class="nav navbar-nav navbar-right">
							<li class="active"><a class="page-scroll" href="#home">${home}</a></li>
							<li><a class="page-scroll" href="#about">${aboutHR}</a></li>
							<li><a class="page-scroll" href="#services">${service}</a></li>
							<li><a class="page-scroll" href="#team">${team}</a></li>
							<li><a class="page-scroll" href="#contact">${contact}</a></li>
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
					<!-- navbar-collapse --> </nav>
					<!-- END: Navigation -->
				</div>
			</div>
		</div>
	</div>
	<!-- header-area end --> </header>
	<!-- header end -->

	<!-- Start Slider Area -->
	<div id="home" class="slider-area">
		<div>
			<div id="ensign-nivoslider" class="slides">
				<img src="img/slider/slider1.jpg" alt="" title="#slider-direction-1" />
				<img src="img/slider/slider2.jpg" alt="" title="#slider-direction-2" />
				<img src="img/slider/slider3.jpg" alt="" title="#slider-direction-3" />
			</div>

			<!-- direction 1 -->
			<div id="slider-direction-1" class="slider-direction slider-one">
				<div class="container">
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="slider-content">
								<!-- layer 1 -->
								<div class="layer-1-1 hidden-xs wow slideInDown"
									data-wow-duration="2s" data-wow-delay=".2s">
									<h2 class="title1">${message1}</h2>
								</div>
								<!-- layer 2 -->
								<div class="layer-1-2 wow slideInUp" data-wow-duration="2s"
									data-wow-delay=".1s">
									<h1 class="title2">${message2}</h1>
								</div>
								<!-- layer 3 -->
								<div class="form-group">
									<div class="layer-1-3 hidden-xs wow slideInUp"
										data-wow-duration="2s" data-wow-delay=".2s">
										<form action="controllerServlet" method="get">
											<input type="hidden" name="command" value="cb.login_page">
											<button class="ready-btn right-btn page-scroll" type="submit">${login}</button>
										</form>
										<form action="controllerServlet" method="get">
											<input type="hidden" name="command" value="cb.registration_page">
											<button class="ready-btn right-btn page-scroll" type="submit">${registration}</button>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- direction 2 -->
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
							<!-- layer 3 -->
							<div class="form-group">
								<div class="layer-1-3 hidden-xs wow slideInUp"
									data-wow-duration="2s" data-wow-delay=".2s">
									<form action="controllerServlet" method="get">
										<input type="hidden" name="command" value="cb.login_page">
										<button class="ready-btn right-btn page-scroll" type="submit">${login}</button>
									</form>
									<form action="controllerServlet" method="get">
										<input type="hidden" name="command" value="cb.registration_page">
										<button class="ready-btn right-btn page-scroll" type="submit">${registration}</button>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- direction 3 -->
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
							<!-- layer 3 -->
							<div class="form-group">
								<div class="layer-1-3 hidden-xs wow slideInUp"
									data-wow-duration="2s" data-wow-delay=".2s">
									<form action="controllerServlet" method="get">
										<input type="hidden" name="command" value="cb.login_page">
										<button class="ready-btn right-btn page-scroll" type="submit">${login}</button>
									</form>
									<form action="controllerServlet" method="get">
										<input type="hidden" name="command" value="cb.registration_page">
										<button class="ready-btn right-btn page-scroll" type="submit">${registration}</button>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- End Slider Area -->

	<!-- Start About area -->
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
				<!-- End col-->
			</div>
		</div>
	</div>
	<!-- End About area -->

	<!-- Start Service area -->
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
					<!-- Start Left services -->
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
							<!-- end about-details -->
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
							<!-- end about-details -->
						</div>
					</div>
					<div class="col-md-4 col-sm-4 col-xs-4">
						<!-- end col-md-4 -->
						<div class=" about-move">
							<div class="services-details">
								<div class="single-services">
									<a class="services-icon"> <i class="fa fa-wordpress"></i>
									</a>
									<h4>Executive Search</h4>
									<p>${executivesearch}</p>
								</div>
							</div>
							<!-- end about-details -->
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
	<!-- End Service area -->

	<!-- our-skill-area start -->
	<div class="our-skill-area fix hidden-sm">
		<div class="test-overly"></div>
		<div class="skill-bg area-padding-2">
			<div class="container">
				<!-- section-heading end -->

				<div class="row">
					<div class="skill-text">
						<!-- single-skill start -->
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
						<!-- single-skill end -->
						<!-- single-skill start -->
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
						<!-- single-skill end -->
						<!-- single-skill start -->
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
	<!-- our-skill-area end -->



	<!-- Start team Area -->
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
								<h4>Друг Улыбаки</h4>
								<p>HRD</p>
							</div>
						</div>
					</div>
					<!-- End column -->

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
								<h4>Улыбака</h4>
								<p>HR</p>
							</div>
						</div>
					</div>
					<!-- End column -->

				</div>
			</div>
		</div>
	</div>
	<!-- End Team Area -->




	<!-- Start contact Area -->
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
				<div class="row">
					<!-- Start  contact -->
					<div class="col-md-3 col-sm-3 col-xs-12"></div>
					<div class="col-md-6 col-sm-6 col-xs-12">
						<div class="form contact-form">
							<div id="sendmessage">Your message has been sent. Thank
								you!</div>
							<div id="errormessage"></div>
							<form action="" method="post" role="form" class="contactForm">
								<div class="form-group">
									<input type="text" name="name" class="form-control" id="name"
										placeholder="${name}" data-rule="minlen:4"
										data-msg="Please enter at least 4 chars" />
									<div class="validation"></div>
								</div>
								<div class="form-group">
									<input type="email" class="form-control" name="email"
										id="email" placeholder="${email}" data-rule="email"
										data-msg="Please enter a valid email" />
									<div class="validation"></div>
								</div>
								<div class="form-group">
									<textarea class="form-control" name="message" rows="5"
										data-rule="required" data-msg="Please write something for us"
										placeholder="${message}"></textarea>
									<div class="validation"></div>
								</div>
								<div class="text-center">
									<button type="submit">${sendmessage}</button>
								</div>
							</form>
						</div>
					</div>
					<!-- End Left contact -->
				</div>
			</div>
		</div>
	</div>
	<!-- End Contact Area -->

	<!-- Start Footer bottom Area -->
	<%@ include file="include/footer_include"%>

	</body>

</html>
