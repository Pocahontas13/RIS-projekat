<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log in</title>
<link type="text/css" rel="stylesheet" href="./login.css" />
</head>
<body>
	<div class="container">
		<div class="container1">
			<form action="/Restoran/login/login" method="post">
			<input type="text" name="sifra" placeholder="Unesite sifru"
				class="textinput input" />
			<button class="Button button">Log in</button>
			</form>
		</div>
	</div>
</body>
</html>