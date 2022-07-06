<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Restoran</title>
<link type="text/css" rel="stylesheet" href="./../../porucinavnje.css" />
</head>
<body>
	<div class="container">
		<div class="container1">
			<button class="Dodaj-artikal">Povratak</button>
			<button class="storniraj">Storniraj</button>
			<button class="button">Izdaj racun</button>
			<button class="button1">Prihvati</button>
			<ul class="list">
				<c:if test="${!empty narucenaHrana}">
					<c:forEach items="${narucenaHrana }" var="hrana">
						<li>${hrana.hrana.naziv } x ${hrana.kolicina }</li>
					</c:forEach>
				</c:if>
				<c:if test="${!empty narucenoPice}">
					<c:forEach items="${narucenoPice }" var="pice">
						<li>${pice.pice.naziv } x ${pice.kolicina }</li>
					</c:forEach>
				</c:if>
			</ul>
		</div>
		<div class="container2">
		<!-- selektovati sve iz jela i pica i prikazati -->
		<!-- dugme dodaj -->
			<ul class="list">
				<h3>Hrana</h3>
				<c:forEach items="${svaHrana }" var="hranaEntry">
					<b>${hranaEntry.key.naziv }</b>
					<c:forEach items="${hranaEntry.value }" var="hrana">
						<a href="/Restoran/stolovi/dodaj/${hrana.id }"><li>${hrana.naziv }, ${hrana.cena } dinara</li></a>
					</c:forEach>
					
				</c:forEach>
			</ul>
			<ul class="list">
				<h3>Pice</h3>
				<c:forEach items="${svoPice }" var="piceEntry">
					<b>${piceEntry.key.naziv }</b>
					<c:forEach items="${piceEntry.value }" var="pice">
						<a href="/Restoran/stolovi/dodajPice/${pice.id }"><li>${pice.naziv }, ${pice.cena } dinara</li></a>
					</c:forEach>
				</c:forEach>
			</ul>
		</div>
	</div>
</body>
</html>