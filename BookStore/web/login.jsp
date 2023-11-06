<%-- 
    Document   : login
    Created on : Nov 7, 2023, 1:32:37 AM
    Author     : 1112v
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>YG Library</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="css/login_css.css" />
	</head>
	<body class="is-preload">

		<!-- Header -->
			<header id="header">
				<h1>Welcome to YG Library</h1>
				<p>Where you will travel through different worlds through the pages of books<br />
				Enjoy it and have a great time!</p>
			</header>

		<!-- Signup Form -->
			<form id="signin-form" method="post" action="login">
				<input type="text" name="username" id="username" placeholder="Username" />
                                <input type="password" name="password" id="password" placeholder="Password" />
				<input type="submit" value="Sign In" />
			</form>
                        <form action ="signup.html">
                            <input type="submit" value="Sign UP" />
			</form>

		<!-- Footer -->
			<footer id="footer">
				<ul class="icons">
					<li><a href="#" class="icon brands fa-twitter"><span class="label">Twitter</span></a></li>
					<li><a href="#" class="icon brands fa-instagram"><span class="label">Instagram</span></a></li>
					<li><a href="#" class="icon brands fa-github"><span class="label">GitHub</span></a></li>
					<li><a href="#" class="icon fa-envelope"><span class="label">Email</span></a></li>
				</ul>
				<ul class="copyright">
					<li>&copy; Untitled.</li><li>Credits: <a href="https://www.facebook.com/profile.php?id=100048497731353">NXB</a></li>
				</ul>
			</footer>

		<!-- Scripts -->
			<script src="js/login_js.js"></script>

	</body>
</html>
