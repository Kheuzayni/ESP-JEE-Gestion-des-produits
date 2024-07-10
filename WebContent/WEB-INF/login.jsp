<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Connexion</title>
	<link rel="stylesheet" href="<c:url value='/css/design.css'/>">
</head>
<body>
	<jsp:include page="inc/entete.jsp"/>
	<jsp:include page="inc/menu.jsp"/>
	<div id="corps">
		<h1 id="titre-principal">Connexion d'un utilisateur</h1>
		<form method="post">
			<fieldset>
				<legend>Authentification</legend>
				<div class="formItem">
					<label>Login</label>
					<input type="text" name="login" value="${form.login}">
				</div>
				<div class="formItem">
					<label>Password</label>
					<input type="password" name="password">
				</div>
				<div class="formItem">
					<input type="submit" value="Se connecter">
				</div>
			</fieldset>
			<c:if test="${ !empty form }">
				<br>
				<fieldset>
					<label class="erreur">${form.statusMessage}</label>
				</fieldset>
			</c:if>
		</form>
	</div>
	<jsp:include page="inc/pied.jsp"/>
</body>
</html>