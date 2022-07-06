<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Restoran</title>
<link type="text/css" rel="stylesheet" href="./../stolovi.css" />
</head>
<body>
	<div class="container">
		<a href="/Restoran/stolovi/sto/1"><img alt="image" src="./../sto-slika.jpg" class="image" /></a> 
		<a href="/Restoran/stolovi/sto/2"><img alt="image" src="./../sto-slika.jpg" class="image01" /></a> 
		<a href="/Restoran/stolovi/sto/3"><img alt="image" src="./../sto-slika.jpg" class="image02" /></a> 
		<a href="/Restoran/stolovi/sto/4"><img alt="image" src="./../sto-slika.jpg" class="image03" /></a>
		<a href="/Restoran/stolovi/sto/5"><img alt="image" src="./../sto-slika.jpg" class="image04" /></a>
		<a href="/Restoran/stolovi/sto/6"><img alt="image" src="./../sto-slika.jpg" class="image05" /></a> 
		<a href="/Restoran/stolovi/sto/7"><img alt="image" src="./../sto-slika.jpg" class="image06" /></a> 
		<a href="/Restoran/stolovi/sto/8"><img alt="image" src="./../sto-slika.jpg" class="image07" /></a> 
		<a href="/Restoran/stolovi/sto/9"><img alt="image" src="./../sto-slika.jpg" class="image08" /></a> 
		<a href="/Restoran/stolovi/sto/10"><img alt="image" src="./../sto-slika.jpg" class="image09" /></a> 
		<a href="/Restoran/stolovi/sto/11"><img alt="image" src="./../sto-slika.jpg" class="image10" /></a> 
		<a href="/Restoran/stolovi/sto/12"><img alt="image" src="./../sto-slika.jpg" class="image11" /></a> 
		<a href="/Restoran/stolovi/sto/13"><img alt="image" src="./../sto-slika.jpg" class="image12" /></a> 
		<a href="/Restoran/stolovi/sto/14"><img alt="image" src="./../sto-slika.jpg" class="image13" /></a> 
		<a href="/Restoran/stolovi/sto/15"><img alt="image" src="./../sto-slika.jpg" class="image14" /></a> 
		<a href="/Restoran/stolovi/sto/16"><img alt="image" src="./../sto-slika.jpg" class="image15" /></a> 
		<a href="/Restoran/stolovi/sto/17"><img alt="image" src="./../sto-slika.jpg" class="image16" /></a> 
		<a href="/Restoran/stolovi/sto/18"><img alt="image" src="./../sto-slika.jpg" class="image17" /></a>
		<form action="/Restoran/kasa/pregled" method="get"><input type="submit" class="button1" value="Pregled kase"/></form>
		<form action="/Restoran/kasa/zaduzenja" method="get"><input type="submit" class="button2" value="Trnutno zaduzenje"></form>
		<form action="/Restoran/kasa/pregled" method="get"><input type="submit" class="button3" value="Razduzenje"/></form>
	</div>
		
	<c:if test="${!empty zaduzenja and !empty racuni}">
		<c:remove var="racuni" scope="session"/>
	</c:if>
	
	<c:if test="${!empty racuni}">
		<dialog open>
			<c:forEach items="${racuni }" var="r">
				<p>broj racuna: ${k.brojRacuna }<br/> datum: ${k.datum }<br/> iznos: ${k.iznos } </p>	
			</c:forEach>
		</dialog>
	</c:if>
	
	<c:if test="${empty racuni }">
		<dialog open>
			<p>Trenutno nema racuna</p>
		</dialog>
	</c:if>
	
	<c:if test="${!empty zaduzenja }">
		<dialog open>
			<c:forEach items="${zaduzenja }" var="z">
				<p>Sto: ${z.idStola }<br/> </p>	
			</c:forEach>
			<p>Ukupno zaduzenje: ${suma}</p>
		</dialog>
	</c:if>
	
	<c:if test="${empty zaduzenja }">
		<dialog open>
			<p>Trenutno nemate zaduzenja</p>
		</dialog>
	</c:if>
</body>
</html>