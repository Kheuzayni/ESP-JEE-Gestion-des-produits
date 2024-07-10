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
		<h1 id="titre-principal">Ajout d'un utilisateur</h1>
		<form method="post">
			<fieldset>
				<legend>Ajout d'un utilisateur</legend>
				<div class="formItem">
					<label>Nom</label>
					<input type="text" name="nom" value="${form.utilisateur.nom}">
					<span class="erreur">${form.erreurs.nom}</span>
				</div>
				<div class="formItem">
					<label>Prénom</label>
					<input type="text" name="prenom" value="${form.utilisateur.prenom}">
					<span class="erreur">${form.erreurs.prenom}</span>
				</div>
				<div class="formItem">
					<label>Login</label>
					<input type="text" name="login" value="${form.utilisateur.login}">
					<span class="erreur">${form.erreurs.login}</span>
				</div>
				<div class="formItem">
					<label>Password</label>
					<input type="password" name="password">
					<span class="erreur">${form.erreurs.password}</span>
				</div>
				<div class="formItem">
					<label>Confirmation Password</label>
					<input type="password" name="passwordBis">
					<span class="erreur">${form.erreurs.passwordBis}</span>
				</div>
				<div class="formItem">
					<input type="submit" value="Ajouter">
				</div>
			</fieldset>
			<c:if test="${ !empty form }">
				<br>
				<fieldset>
					<label class="${ empty form.erreurs ? 'succes' : 'erreur' }">${form.statusMessage}</label>
				</fieldset>
			</c:if>
		</form>
	</div>
	<jsp:include page="inc/pied.jsp"/>
</body>
</html>