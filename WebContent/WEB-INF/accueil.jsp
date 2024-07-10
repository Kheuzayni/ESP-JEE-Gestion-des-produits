<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Accueil</title>
	<link rel="stylesheet" href="<c:url value='/css/design.css'/>">
</head>
<body>
	<jsp:include page="inc/entete.jsp"/>
	<jsp:include page="inc/menu.jsp"/>
	<div id="corps">
		<h1 id="titre-principal">Page d'accueil</h1>
		<p>
			Bienvenue dans notre application de Gestion des utilisateurs.
			Vous pouvez faire le tour des fonctionnalités en choisissant le menu adéquat.
		</p>
	</div>
	<jsp:include page="inc/pied.jsp"/>
</body>
</html>