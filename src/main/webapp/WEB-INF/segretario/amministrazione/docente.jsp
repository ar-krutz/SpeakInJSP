<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="it.unirc.twdb.speakin.model.Corso"
	import="it.unirc.twdb.speakin.model.Docente" import="java.util.Vector"%>
<!DOCTYPE html>
<html lang="it">
<head>
<title>Corso</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Lingua project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.carousel.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/animate.css">
<link rel="stylesheet" type="text/css" href="styles/segretario.css">
<link rel="stylesheet" type="text/css" href="styles/segretario_responsive.css">
<script type="text/javascript" src="js/segretario.js"></script>
</head>
<body>

<div class="super_container">

	<!-- Header -->

	<header class="header">
	<!-- Header Content -->
		<div class="header_container">
			<div class="container">
				<div class="row">
					<div class="col">
						<div class="header_content d-flex flex-row align-items-center justify-content-start">
							<div class="logo_container mr-auto">
								<a href="#">
									<div class="logo_text">SpeakIn Language School</div>
								</a>
							</div>
							<nav class="main_nav_contaner">
								<ul class="main_nav">
									<li><a href="index.html">Home</a></li>
									<li class="active"><a href="courses.html">Corsi</a></li>
									<li><a href="instructors.html">Docenti</a></li>
									<li><a href="#">Eventi</a></li>
									<li><a href="contact.html">Contatti</a></li>
								</ul>
							</nav>
							<div class="header_content_right ml-auto text-right">
								<div class="header_search">
									<div class="search_form_container">
										<form action="#" id="search_form" class="search_form trans_400">
											<input type="search" class="header_search_input trans_400" placeholder="Type for Search" required="required">
											<div class="search_button">
												<i class="fa fa-search" aria-hidden="true"></i>
											</div>
										</form>
									</div>
								</div>

								<!-- Hamburger -->

								<div class="user"><a href="login.html"><i class="fa fa-user" aria-hidden="true"></i></a></div>
								<div class="hamburger menu_mm">
									<i class="fa fa-bars menu_mm" aria-hidden="true"></i>
								</div>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>

	</header>

	<!-- Menu -->

	<div class="menu d-flex flex-column align-items-end justify-content-start text-right menu_mm trans_400">
		<div class="menu_close_container"><div class="menu_close"><div></div><div></div></div></div>
		<div class="search">
			<form action="#" class="header_search_form menu_mm">
				<input type="search" class="search_input menu_mm" placeholder="Search" required="required">
				<button class="header_search_button d-flex flex-column align-items-center justify-content-center menu_mm">
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
			<div class="menu_phone"><span class="menu_title">phone:</span>+44 300 303 0266</div>
			<div class="menu_social">
				<span class="menu_title">follow us</span>
				<ul>
					<li><a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
					<li><a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a></li>
					<li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
				</ul>
			</div>
		</div>
	</div>
   <!-- Intro -->

	<div class="intro">
		<div class="intro_background parallax-window" data-parallax="scroll" data-image-src="images/intro.jpg" data-speed="0.8"></div>
		<div class="container">
			<div class="row">
				<div class="col">
					<div class="intro_container d-flex flex-column align-items-start justify-content-end">
						<div class="intro_content">
							<div class="intro_price">Free</div>
							<div class="rating_r rating_r_4 intro_rating"><i></i><i></i><i></i><i></i><i></i></div>
							<div class="intro_title">Vocabulary. Part 1</div>
							<div class="intro_meta">
								<div class="intro_image"><img src="images/intro_user.jpg" alt=""></div>
								<div class="intro_instructors"><a href="instructors.html">Sarah Parker</a> and <span><a href="instructors.html">5 other instructors</a></span></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>		
	</div>

	<!-- Course -->

	<div class="course">
		<div class="course_top"></div>
		<div class="container">
			<div class="row row-lg-eq-height">

				<!-- Panels -->
				<div class="col-lg-9">
					<div class="tab_panels">

						<!-- Tabs -->
						<div class="course_tabs_container">
							<div class="container">
								<div class="row">
									<div class="col-lg-9">
										<div class="tabs d-flex flex-row align-items-center justify-content-start">
											<div class="tab active">descrizione</div>
											<div class="tab">curriculum</div>
											<div class="tab">recensioni</div>
											<div class="tab">membri</div>
										</div>
									</div>
								</div>
							</div>		
						</div>

						<!-- Description -->
						<div class="tab_panel description active">
								<div id="wrapper" >
									<table id="data_table">
										<tr>
											<th>Nome</th>
											<th>Cognome</th>
											<th>Data di Nascita</th>
											<th>Codice Fiscale</th>
											<th>Indirizzo</th>
											<th>Email</th>
											<th>Telefono</th>
											<th>Stipendio</th>
											<th>Lingua</th>
											<th>Descrizione</th>
											<th>Password</th>
											<th>Azione</th>
										</tr>
										<% 
										Vector<Docente> docenti = (Vector<Docente>) request.getAttribute("docenti");
										int i=1;
										for(Docente d: docenti){
										%>
										<tr id="row<%= i %>">
											<td id="nome_row<%= i %>"><%= d.getNome() %></td>
											<td id="cognome_row<%= i %>"><%= d.getCognome() %></td>
											<td id="datanascita_row<%= i %>"><%= d.getDataNascita() %></td>
											<td id="codicefiscale_row<%= i %>"><%= d.getCodiceFiscale() %></td>
											<td id="indirizzo_row<%= i %>"><%= d.getIndirizzo() %></td>
											<td id="email_row<%= i %>"><%= d.getIndirizzoEMail() %></td>
											<td id="telefono_row<%= i %>"><%= d.getNumeroTelefono() %></td>
											<td id="stipendio_row<%= i %>"><%= d.getStipendio() %></td>
											<td id="lingua_row<%= i %>"><%= d.getLingua() %></td>
											<td id="descrizione_row<%= i %>"><%= d.getNome() %></td>
											<td id="password_row<%= i %>"><%= d.getNome() %></td>
											<td>
											<input type="button" id="edit_button<%= i %>" value="Edit" class="edit" onclick="edit_row('<%= i %>')"> 
											<input type="button" id="save_button<%= i %>" value="Save" class="save" onclick="save_row('<%= i %>')"> 
											<input type="button" value="Delete" class="delete" onclick="delete_row('<%= i %>')">
											</td>
										</tr>
										<%
										i++;
										} %>


										<tr>
											<td><input type="text" id="new_nome"></td>
											<td><input type="text" id="new_cognome"></td>
											<td><input type="text" id="new_datanascita"></td>
											<td><input type="text" id="new_codicefiscale"></td>
											<td><input type="text" id="new_indirizzo"></td>
											<td><input type="text" id="new_email"></td>
											<td><input type="text" id="new_telefono"></td>
											<td><input type="text" id="new_stipendio"></td>
											<td><input type="text" id="new_lingua"></td>
											<td><input type="text" id="new_descrizione""></td>
											<td><input type="text" id="new_password""></td>
											<td><input type="button" class="add" onclick="add_row();" value="Add"></td>
										</tr>
										</table>
								</div>

							</div>

						<!-- Curriculum -->
						<div class="tab_panel curriculum">
							<div class="panel_title">Syllabus</div>
							<div class="panel_text">
								<p>Nam egestas lorem ex, sit amet commodo tortor faucibus a. Suspendisse commodo, turpis a dapibus fermentum, turpis ipsum rhoncus massa, sed commodo nisi lectus id ipsum. Sed nec elit vehicula, aliquam neque euismod, porttitor ex. Nam consequat iaculis maximus. Suspendisse potenti. In rutrum justo et diam egestas luctus. Mauris eu neque eget odio suscipit eleifend. Sed imperdiet ante quis felis tempor hendrerit. Curabitur eget fermentum ipsum. Sed efficitur eget velit eu vulputate. Duis tincidunt quam in erat dignissim consequat. Praesent tempus leo eu nisl fringilla interdum. Maecenas rutrum libero eget lacus bibendum tristique. Curabitur at felis lobortis, mollis ante ut, tempus elit. Morbi justo nisi, posuere sed augue id, iaculis tincidunt mi. Pellentesque sed dolor sed dui congue tempus a et felis.</p>
							</div>
							<div class="curriculum_items">
								<div class="cur_item">
									<div class="cur_title_container d-flex flex-row align-items-start justify-content-start">
										<div class="cur_title">Week 1</div>
										<div class="cur_num ml-auto">0/4</div>
									</div>
									<div class="cur_item_content">
										<div class="cur_item_title">Beginners Level</div>
										<div class="cur_item_text">
											<p>Nam egestas lorem ex, sit amet commodo tortor faucibus a. Suspendisse commodo, turpis a dapibus fermentum, turpis ipsum rhoncus massa, sed commodo nisi lectus id ipsum.</p>
										</div>
										<div class="cur_contents">
											<ul>
												<li>
													<i class="fa fa-folder" aria-hidden="true"></i><span>1 video, 1 audio, 1 reading</span>
													<ul>
														<li class="d-flex flex-row align-items-center justify-content-start">
															<i class="fa fa-video-camera" aria-hidden="true"></i><span>Video: <a href="#">Greetings and Introductions</a></span>
															<div class="cur_time ml-auto"><i class="fa fa-clock-o" aria-hidden="true"></i><span>15 minutes</span></div>
														</li>
														<li class="d-flex flex-row align-items-center justify-content-start">
															<i class="fa fa-file" aria-hidden="true"></i><span>Reading: <a href="#">Word Types</a></span>
															<div class="cur_time ml-auto"><i class="fa fa-clock-o" aria-hidden="true"></i><span>15 minutes</span></div>
														</li>
														<li class="d-flex flex-row align-items-center justify-content-start">
															<i class="fa fa-volume-up" aria-hidden="true"></i><span>Audio: <a href="#">Listening Exercise</a></span>
															<div class="cur_time ml-auto"><i class="fa fa-clock-o" aria-hidden="true"></i><span>15 minutes</span></div>
														</li>
													</ul>
												</li>
												<li class="d-flex flex-row align-items-center justify-content-start">
													<i class="fa fa-graduation-cap" aria-hidden="true"></i><span>Graded: Cumulative Language Quiz</span>
													<div class="cur_time ml-auto"><span>3 Questions</span></div>
												</li>
											</ul>
										</div>
									</div>
								</div>
								<div class="cur_item">
									<div class="cur_title_container d-flex flex-row align-items-start justify-content-start">
										<div class="cur_title">Week 2</div>
										<div class="cur_num ml-auto">0/5</div>
									</div>
									<div class="cur_item_content">
										<div class="cur_item_title">Intermediate Level</div>
										<div class="cur_item_text">
											<p>Nam egestas lorem ex, sit amet commodo tortor faucibus a. Suspendisse commodo, turpis a dapibus fermentum, turpis ipsum rhoncus massa, sed commodo nisi lectus id ipsum.</p>
										</div>
										<div class="cur_contents">
											<ul>
												<li>
													<i class="fa fa-folder" aria-hidden="true"></i><span>1 video, 1 audio, 1 reading</span>
													<ul>
														<li class="d-flex flex-row align-items-center justify-content-start">
															<i class="fa fa-video-camera" aria-hidden="true"></i><span>Video: <a href="#">Greetings and Introductions</a></span>
															<div class="cur_time ml-auto"><i class="fa fa-clock-o" aria-hidden="true"></i><span>15 minutes</span></div>
														</li>
														<li class="d-flex flex-row align-items-center justify-content-start">
															<i class="fa fa-file" aria-hidden="true"></i><span>Reading: <a href="#">Word Types</a></span>
															<div class="cur_time ml-auto"><i class="fa fa-clock-o" aria-hidden="true"></i><span>15 minutes</span></div>
														</li>
														<li class="d-flex flex-row align-items-center justify-content-start">
															<i class="fa fa-volume-up" aria-hidden="true"></i><span>Audio: <a href="#">Listening Exercise</a></span>
															<div class="cur_time ml-auto"><i class="fa fa-clock-o" aria-hidden="true"></i><span>15 minutes</span></div>
														</li>
													</ul>
												</li>
												<li class="d-flex flex-row align-items-center justify-content-start">
													<i class="fa fa-graduation-cap" aria-hidden="true"></i><span>Graded: Cumulative Language Quiz</span>
													<div class="cur_time ml-auto"><span>3 Questions</span></div>
												</li>
											</ul>
										</div>
									</div>
								</div>
							</div>
						</div>

						<!-- Reviews -->
						<div class="tab_panel reviews">
							<div class="panel_title">Reviews</div>
							<div class="panel_text">
								<p>Lorem ipsum dolor sit amet, te eros consulatu pro, quem labores petentium no sea, atqui posidonium interpretaris pri eu. At soleat maiorum platonem vix, no mei case fierent. Primis quidam ancillae te mei.</p>
							</div>
							<div class="cur_ratings_container clearfix">
								<div class="cur_rating d-flex flex-column align-items-center justify-content-center">
									<div class="cur_rating_num">4,5</div>
									<div class="rating_r rating_r_4 cur_stars"><i></i><i></i><i></i><i></i><i></i></div>
									<div class="cur_rating_text">Rated 5 out of 3 Ratings</div>
								</div>
								<div class="cur_rating_progress d-flex flex-column align-items-center justify-content-center">
									<div class="cur_progress d-flex flex-row align-items-center justify-content-between">
										<span>5 stars</span>
										<div id="cur_pbar_1" class="cur_pbar" data-perc="0.80"></div>
									</div>
									<div class="cur_progress d-flex flex-row align-items-center justify-content-between">
										<span>5 stars</span>
										<div id="cur_pbar_2" class="cur_pbar" data-perc="0.20"></div>
									</div>
									<div class="cur_progress d-flex flex-row align-items-center justify-content-between">
										<span>5 stars</span>
										<div id="cur_pbar_3" class="cur_pbar" data-perc="0.0"></div>
									</div>
									<div class="cur_progress d-flex flex-row align-items-center justify-content-between">
										<span>5 stars</span>
										<div id="cur_pbar_4" class="cur_pbar" data-perc="0.0"></div>
									</div>
									<div class="cur_progress d-flex flex-row align-items-center justify-content-between">
										<span>5 stars</span>
										<div id="cur_pbar_5" class="cur_pbar" data-perc="0.0"></div>
									</div>
								</div>
							</div>

							<div class="cur_reviews">

								<!-- Review -->
								<div class="review">
									<div class="review_title_container d-flex flex-row align-items-start justify-content-start">
										<div class="review_title d-flex flex-row align-items-center justify-content-center">
											<div class="review_author_image"><div><img src="images/review_1.jpg" alt=""></div></div>
											<div class="review_author">
												<div class="review_author_name"><a href="#">Sarah Parker</a></div>
												<div class="review_date">Sep 29, 2017 at 9:48 am</div>
											</div>
										</div>
										<div class="review_stars ml-auto"><div class="rating_r rating_r_4 review_rating"><i></i><i></i><i></i><i></i><i></i></div></div>
									</div>
									<div class="review_text">
										<p>Nam egestas lorem ex, sit amet commodo tortor faucibus a. Suspendisse commodo, turpis a dapibus fermentum, turpis ipsum rhoncus massa, sed commodo nisi lectus id ipsum. Sed nec elit vehicula.</p>
									</div>
								</div>

								<!-- Review -->
								<div class="review">
									<div class="review_title_container d-flex flex-row align-items-start justify-content-start">
										<div class="review_title d-flex flex-row align-items-center justify-content-center">
											<div class="review_author_image"><div><i class="fa fa-user" aria-hidden="true"></i></div></div>
											<div class="review_author">
												<div class="review_author_name"><a href="#">Sarah Parker</a></div>
												<div class="review_date">Sep 29, 2017 at 9:48 am</div>
											</div>
										</div>
										<div class="review_stars ml-auto"><div class="rating_r rating_r_4 review_rating"><i></i><i></i><i></i><i></i><i></i></div></div>
									</div>
									<div class="review_text">
										<p>Nam egestas lorem ex, sit amet commodo tortor faucibus a. Suspendisse commodo, turpis a dapibus fermentum, turpis ipsum rhoncus massa, sed commodo nisi lectus id ipsum. Sed nec elit vehicula.</p>
									</div>
								</div>

								<!-- Review -->
								<div class="review">
									<div class="review_title_container d-flex flex-row align-items-start justify-content-start">
										<div class="review_title d-flex flex-row align-items-center justify-content-center">
											<div class="review_author_image"><div><i class="fa fa-user" aria-hidden="true"></i></div></div>
											<div class="review_author">
												<div class="review_author_name"><a href="#">Sarah Parker</a></div>
												<div class="review_date">Sep 29, 2017 at 9:48 am</div>
											</div>
										</div>
										<div class="review_stars ml-auto"><div class="rating_r rating_r_4 review_rating"><i></i><i></i><i></i><i></i><i></i></div></div>
									</div>
									<div class="review_text">
										<p>Nam egestas lorem ex, sit amet commodo tortor faucibus a. Suspendisse commodo, turpis a dapibus fermentum, turpis ipsum rhoncus massa, sed commodo nisi lectus id ipsum. Sed nec elit vehicula.</p>
									</div>
								</div>

							</div>
						</div>

						<!-- Members -->
						<div class="tab_panel members">
							<div class="panel_title">Members</div>
							<div class="panel_text">
								<p>Lorem ipsum dolor sit amet, te eros consulatu pro, quem labores petentium no sea, atqui posidonium interpretaris pri eu. At soleat maiorum platonem vix, no mei case fierent. Primis quidam ancillae te mei.</p>
							</div>
							<div class="members_list d-flex flex-row flex-wrap align-items-start justify-content-start">

								<!-- Member -->
								<div class="member">
									<div class="member_image"><img src="images/member_1.jpg" alt=""></div>
									<div class="member_title"><a href="#">Sarah Parker</a></div>
								</div>

								<!-- Member -->
								<div class="member">
									<div class="member_image"><img src="images/member_0.jpg" alt=""></div>
									<div class="member_title"><a href="#">Sarah Parker</a></div>
								</div>

								<!-- Member -->
								<div class="member">
									<div class="member_image"><img src="images/member_0.jpg" alt=""></div>
									<div class="member_title"><a href="#">Sarah Parker</a></div>
								</div>

								<!-- Member -->
								<div class="member">
									<div class="member_image"><img src="images/member_2.jpg" alt=""></div>
									<div class="member_title"><a href="#">Sarah Parker</a></div>
								</div>

								<!-- Member -->
								<div class="member">
									<div class="member_image"><img src="images/member_3.jpg" alt=""></div>
									<div class="member_title"><a href="#">Sarah Parker</a></div>
								</div>

								<!-- Member -->
								<div class="member">
									<div class="member_image"><img src="images/member_4.jpg" alt=""></div>
									<div class="member_title"><a href="#">Sarah Parker</a></div>
								</div>

								<!-- Member -->
								<div class="member">
									<div class="member_image"><img src="images/member_0.jpg" alt=""></div>
									<div class="member_title"><a href="#">Sarah Parker</a></div>
								</div>

								<!-- Member -->
								<div class="member">
									<div class="member_image"><img src="images/member_5.jpg" alt=""></div>
									<div class="member_title"><a href="#">Sarah Parker</a></div>
								</div>

								<!-- Member -->
								<div class="member">
									<div class="member_image"><img src="images/member_6.jpg" alt=""></div>
									<div class="member_title"><a href="#">Sarah Parker</a></div>
								</div>

								<!-- Member -->
								<div class="member">
									<div class="member_image"><img src="images/member_0.jpg" alt=""></div>
									<div class="member_title"><a href="#">Sarah Parker</a></div>
								</div>

								<!-- Member -->
								<div class="member">
									<div class="member_image"><img src="images/member_7.jpg" alt=""></div>
									<div class="member_title"><a href="#">Sarah Parker</a></div>
								</div>

								<!-- Member -->
								<div class="member">
									<div class="member_image"><img src="images/member_8.jpg" alt=""></div>
									<div class="member_title"><a href="#">Sarah Parker</a></div>
								</div>

								<!-- Member -->
								<div class="member">
									<div class="member_image"><img src="images/member_0.jpg" alt=""></div>
									<div class="member_title"><a href="#">Sarah Parker</a></div>
								</div>

								<!-- Member -->
								<div class="member">
									<div class="member_image"><img src="images/member_9.jpg" alt=""></div>
									<div class="member_title"><a href="#">Sarah Parker</a></div>
								</div>

								<!-- Member -->
								<div class="member">
									<div class="member_image"><img src="images/member_0.jpg" alt=""></div>
									<div class="member_title"><a href="#">Sarah Parker</a></div>
								</div>
							</div>
						</div>
					</div>
				</div>
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
						<div class="newsletter_container d-flex flex-column align-items-start justify-content-end">
							<div class="footer_logo mb-auto"><a href="#">SpeakIn Lenguage School</a></div>
							<div class="footer_title">Iscriviti</div>
							<form action="#" id="newsletter_form" class="newsletter_form">
								<input type="email" class="newsletter_input" placeholder="Email" required="required">
								<button class="newsletter_button"><i class="fa fa-long-arrow-right" aria-hidden="true"></i></button>
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
						<div class="copyright_content d-flex flex-md-row flex-column align-items-md-center align-items-start justify-content-start">
							<div class="cr"><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | Made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a> &amp; distributed by <a href="https://themewagon.com" target="_blank">ThemeWagon</a>
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></div>
							<div class="cr_right ml-md-auto">
								<div class="footer_phone"><span class="cr_title">telefono:</span>+39 349 867 5672</div>
								<div class="footer_social">
									<span class="cr_social_title">follow us</span>
									<ul>
										<li><a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
										<li><a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a></li>
										<li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</footer>
<script src="js/jquery-3.2.1.min.js"></script>
<script src="styles/bootstrap4/popper.js"></script>
<script src="styles/bootstrap4/bootstrap.min.js"></script>
<script src="plugins/OwlCarousel2-2.2.1/owl.carousel.js"></script>
<script src="plugins/easing/easing.js"></script>
<script src="plugins/parallax-js-master/parallax.min.js"></script>
<script src="plugins/progressbar/progressbar.min.js"></script>
<script src="js/course.js"></script>
</body>
</html>