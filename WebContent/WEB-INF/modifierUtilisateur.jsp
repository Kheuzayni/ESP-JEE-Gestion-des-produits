<%@page import="beans.Utilisateur"%>
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
<%
Utilisateur utilisateur = (Utilisateur) request.getAttribute("user");
%>

	<jsp:include page="inc/entete.jsp"/>
	<jsp:include page="inc/menu.jsp"/>
<div id="corps">
		
		<form method="post">
		<fieldset>
			<legend>modification  d'un utilisateur</legend>
			<input type="hidden" name="id" value="${utilisateur.id}"><br>		
			<label>Nom</label>
			<input type="text" name="nom" value="${utilisateur.nom}"><br>
			<label>Prénom</label>
			<input type="text" name="prenom"  value="${utilisateur.prenom}"><br>
			<label>Login</label>
			<input type="text" name="login" value="${utilisateur.login}"><br>
			<label>Password</label>
			<input type="password" name="password" value="${utilisateur.password}"><br><br>
			<input type="submit" value="Modifier">
		</fieldset>
			
		</form>
	</div>
</html>