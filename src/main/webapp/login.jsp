<!DOCTYPE html>
<html lang="it">
<head>
<title>Login</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Lingua project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="styles/login.css">
<link rel="stylesheet" type="text/css" href="styles/login_responsive.css">
</head>
<body>

<div class="super_container">

	<%@ include file="/header.jsp" %>

	<!-- Register -->

	<div class="register">
		<div class="container">
			<div class="row">
				
				<!-- Login Form -->

				<div class="col-lg-6">
					<div class="register_form_container">
						<div class="register_form_title">Accedi alla tua area riservata</div>
						<form action="/Login" id="register_form" class="register_form" method="post">
							<div class="row register_row">
								<div class="col-lg-6 register_col">
									<input type="email" name="email" class="form_input" placeholder="Email*" required="required">
								</div>
								<div class="col-lg-6 register_col">
									<input type="password" name="password" class="form_input" placeholder="Password*" required="required">
								</div>
								<div class="col">
									<button type="submit" class="form_button trans_200">login</button>
								</div>
							</div>
						</form>
					</div>
				</div>

				<!-- Register Form -->
                <div class="col-lg-6">
					<div class="register_form_container">
						<div class="register_form_title">Registrati se non hai un account</div>
						<form action="/Registrazione" id="register_form" class="register_form" method="post">
							<div class="row register_row">
								<div class="col-lg-6 register_col">
									<input type="text" class="form_input" name="nome" placeholder="Nome*" required="required">
								</div>
								<div class="col-lg-6 register_col">
									<input type="text" class="form_input" name="cognome" placeholder="Cognome*" required="required">
								</div>
								<div class="col-lg-6 register_col">
									<input type="date" class="form_input" name="datanascita" placeholder="Data di nascita*" required="required">
								</div>
								<div class="col-lg-6 register_col">
									<input type="text" class="form_input" name="codicefiscale" placeholder="Codice fiscale*" required="required">
								</div>
								<div class="col-lg-6 register_col">
									<input type="text" class="form_input" name="indirizzo" placeholder="Indirizzo*" required="required">
								</div>
								<div class="col-lg-6 register_col">
									<input type="email" class="form_input" name="email" placeholder="Email*" required="required">
								</div>
								<div class="col-lg-6 register_col">
									<input type="text" class="form_input" name="tel" placeholder="Telefono*" required="required">
								</div>
								<div class="col-lg-6 register_col">
									<input type="password" class="form_input" name="password" placeholder="Password*" required="required">
								</div>
								<div class="col">
									<button type="submit" class="form_button trans_200">Registrati</button>
								</div>
							</div>
						</form>
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
</div>

<script src="js/jquery-3.2.1.min.js"></script>
<script src="styles/bootstrap4/popper.js"></script>
<script src="styles/bootstrap4/bootstrap.min.js"></script>
<script src="plugins/easing/easing.js"></script>
<script src="plugins/parallax-js-master/parallax.min.js"></script>
<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&key=AIzaSyCIwF204lFZg1y4kPSIhKaHEXMLYxxuMhA"></script>
<script src="js/contact.js"></script>
</body>
</html>