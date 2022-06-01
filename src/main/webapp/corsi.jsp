<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="it.unirc.twdb.speakin.model.Corso"
	import="it.unirc.twdb.speakin.model.Docente" import="java.util.HashMap"
	import="java.util.Vector"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Corsi</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Lingua project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css"
	href="styles/bootstrap4/bootstrap.min.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css"
	href="plugins/OwlCarousel2-2.2.1/owl.carousel.css">
<link rel="stylesheet" type="text/css"
	href="plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
<link rel="stylesheet" type="text/css"
	href="plugins/OwlCarousel2-2.2.1/animate.css">
<link rel="stylesheet" type="text/css" href="styles/courses.css">
<link rel="stylesheet" type="text/css"
	href="styles/courses_responsive.css">
	
   <script type = "text/javascript">
	function filterCourse(lingua){
		var divClass =  document.getElementsByClassName("col-lg-4 course_col");
		Array.from(divClass).forEach((div) => {
		    if(div.getAttribute('name')==lingua){div.style.display="block";}else{div.style.display="none";}
		});
	}
   </script>
</head>
<body>

	<div class="super_container">

		<%@ include file="/header.jsp"%>

		<!-- Menu -->

		<div
			class="menu d-flex flex-column align-items-end justify-content-start text-right menu_mm trans_400">
			<div class="menu_close_container">
				<div class="menu_close">
					<div></div>
					<div></div>
				</div>
			</div>
			<div class="search">
				<form action="#" class="header_search_form menu_mm">
					<input type="search" class="search_input menu_mm"
						placeholder="Search" required="required">
					<button
						class="header_search_button d-flex flex-column align-items-center justify-content-center menu_mm">
						<i class="fa fa-search menu_mm" aria-hidden="true"></i>
					</button>
				</form>
			</div>
			<nav class="menu_nav">
				<ul class="menu_mm">
					<li class="menu_mm"><a href="index.html">Home</a></li>
					<li class="menu_mm"><a href="courses.html">Corsi</a></li>
					<li class="menu_mm"><a href="instructors.html">Docenti</a></li>
					<li class="menu_mm"><a href="#">Eventi</a></li>
					<li class="menu_mm"><a href="contact.html">Contatti</a></li>
				</ul>
			</nav>
			<div class="menu_extra">
				<div class="menu_phone">
					<span class="menu_title">phone:</span>+44 300 303 0266
				</div>
				<div class="menu_social">
					<span class="menu_title">follow us</span>
					<ul>
						<li><a href="#"><i class="fa fa-facebook"
								aria-hidden="true"></i></a></li>
						<li><a href="#"><i class="fa fa-instagram"
								aria-hidden="true"></i></a></li>
						<li><a href="#"><i class="fa fa-twitter"
								aria-hidden="true"></i></a></li>
					</ul>
				</div>
			</div>
		</div>
		<!-- Language -->

		<div class="language">
			<div class="container">
				<div class="row">
					<div class="col">
						<br>
						<div class="language_title">Tutti i corsi</div>
					</div>
				</div>
				<div class="row">
					<div class="col">
						<div class="language_slider_container">

							<!-- Language Slider -->

							<div class="owl-carousel owl-theme language_slider">
								<%
								Vector<String> lingue = (Vector<String>) request.getAttribute("lingue");
								for (String l : lingue) {
								%>
								<!-- Flag -->
								<div class="owl-item language_item">
									<a href="#">
										<div class="flag">
											<img src="images/Bandiere/<%=l%>.svg" alt="" onclick="filterCourse('<%=l%>');">
										</div>
										<div class="lang_name"><%=l%></div>
									</a>
								</div>
								<%
								}
								%>

							</div>

							<div class="lang_nav lang_prev">
								<i class="fa fa-angle-left" aria-hidden="true"></i>
							</div>
							<div class="lang_nav lang_next">
								<i class="fa fa-angle-right" aria-hidden="true"></i>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Courses -->

		<div class="courses">
			<div class="container">
				<div class="row courses_row">

					<%
					Vector<Corso> corsi = (Vector<Corso>) request.getAttribute("corsi");
					Vector<Integer> ids = (Vector<Integer>) request.getAttribute("id");
					HashMap<Integer, Vector<Docente>> docenti = (HashMap<Integer, Vector<Docente>>) request.getAttribute("docenti");
					HashMap<Integer, Integer> iscritti = (HashMap<Integer, Integer>) request.getAttribute("iscritti");
					int count = 0;
					for (Corso c : corsi) {
					%>
					<!-- Course -->
					<div class="col-lg-4 course_col" name="<%=c.getLingua()%>">
						<div class="course">
							<div class="course_image">
								<img src="images/Bandiere/<%=c.getLingua()%>.svg" alt="">
							</div>
							<div class="course_body">
								<div class="course_title">
									<a href="/VisualizzaCorso?id=<%=ids.get(count)%>"><%=c.getLingua()%>
										<%=c.getLivello()%></a>
								</div>
								<div class="course_info">
									<ul>
										<% if (docenti.get(ids.get(count))!=null){ %>
										<%
										for (Docente d : docenti.get(ids.get(count))) {
										%>
										<li><a href="/Docente?id=<%=d.getCodiceDocente()%>"><%=d.getNome()%>
												<%=d.getCognome()%></a></li>
										<%}%>
										<%} else { %>
										<li>Nessun docente ancora assegnato al corso</li>
										<%}%>
									</ul>
								</div>
								<div class="course_text">
									<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
										Fusce enim nulla.</p>
								</div>
							</div>
							<div
								class="course_footer d-flex flex-row align-items-center justify-content-start">
								<div class="course_students">
									<i class="fa fa-user" aria-hidden="true"></i><span><%= iscritti.get(ids.get(count)) %></span>
								</div>
								<div class="course_rating ml-auto">
									<i class="fa fa-star" aria-hidden="true"></i><span>4,5</span>
								</div>
								<div class="course_mark trans_200">
									<a href="#"><%=c.getPrezzo()%> €</a>
								</div>
							</div>
						</div>
					</div>
					<%
					count++;
					}
					%>
				</div>
			</div>
		</div>

		<!-- Footer -->

		<footer class="footer">
			<div class="footer_body">
				<div class="container">
					<div class="row">

						<!-- Newsletter -->
						<div class="col-lg-3 footer_col">
							<div
								class="newsletter_container d-flex flex-column align-items-start justify-content-end">
								<div class="footer_logo mb-auto">
									<a href="#">SpeakIn Lenguage School</a>
								</div>
								<div class="footer_title">Iscriviti</div>
								<form action="#" id="newsletter_form" class="newsletter_form">
									<input type="email" class="newsletter_input"
										placeholder="Email" required="required">
									<button class="newsletter_button">
										<i class="fa fa-long-arrow-right" aria-hidden="true"></i>
									</button>
								</form>
							</div>
						</div>

						<!-- About -->
						<div class="col-lg-2 offset-lg-3 footer_col">
							<div>
								<div class="footer_title">About Us</div>
								<ul class="footer_list">
									<li><a href="#">Courses</a></li>
									<li><a href="#">Team</a></li>
									<li><a href="#">Brand Guidelines</a></li>
									<li><a href="#">Jobs</a></li>
									<li><a href="#">Advertise with us</a></li>
									<li><a href="#">Press</a></li>
									<li><a href="#">Contact us</a></li>
								</ul>
							</div>
						</div>

						<!-- Help & Support -->
						<div class="col-lg-2 footer_col">
							<div class="footer_title">Help & Support</div>
							<ul class="footer_list">
								<li><a href="#">Discussions</a></li>
								<li><a href="#">Troubleshooting</a></li>
								<li><a href="#">Duolingo FAQs</a></li>
								<li><a href="#">Schools FAQs</a></li>
								<li><a href="#">Duolingo English Test FAQs</a></li>
								<li><a href="#">Status</a></li>
							</ul>
						</div>

						<!-- Privacy -->
						<div class="col-lg-2 footer_col clearfix">
							<div>
								<div class="footer_title">Privacy & Terms</div>
								<ul class="footer_list">
									<li><a href="#">Community Guidelines</a></li>
									<li><a href="#">Terms</a></li>
									<li><a href="#">Brand Guidelines</a></li>
									<li><a href="#">Privacy</a></li>
								</ul>
							</div>
						</div>

					</div>
				</div>
			</div>
			<div class="copyright">
				<div class="container">
					<div class="row">
						<div class="col">
							<div
								class="copyright_content d-flex flex-md-row flex-column align-items-md-center align-items-start justify-content-start">
								<div class="cr">
									<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
									Copyright &copy;
									<script>
										document
												.write(new Date().getFullYear());
									</script>
									All rights reserved | Made with <i class="fa fa-heart-o"
										aria-hidden="true"></i> by <a href="https://colorlib.com"
										target="_blank">Colorlib</a> &amp; distributed by <a
										href="https://themewagon.com" target="_blank">ThemeWagon</a>
									<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
								</div>
								<div class="cr_right ml-md-auto">
									<div class="footer_phone">
										<span class="cr_title">telefono:</span>+39 349 867 5672
									</div>
									<div class="footer_social">
										<span class="cr_social_title">follow us</span>
										<ul>
											<li><a href="#"><i class="fa fa-facebook"
													aria-hidden="true"></i></a></li>
											<li><a href="#"><i class="fa fa-instagram"
													aria-hidden="true"></i></a></li>
											<li><a href="#"><i class="fa fa-twitter"
													aria-hidden="true"></i></a></li>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</footer>
	</div>

	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="styles/bootstrap4/popper.js"></script>
	<script src="styles/bootstrap4/bootstrap.min.js"></script>
	<script src="plugins/OwlCarousel2-2.2.1/owl.carousel.js"></script>
	<script src="plugins/easing/easing.js"></script>
	<script src="js/courses.js"></script>
</body>
</html>