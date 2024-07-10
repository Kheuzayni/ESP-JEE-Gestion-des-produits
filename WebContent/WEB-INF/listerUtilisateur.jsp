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
		<h1 id="titre-principal">Liste des utilisateurs</h1>
		<c:choose>
			<c:when test="${ empty utilisateurs }">
				<p>Aucun utilisateur n'a pour le moment été ajouté</p>
			</c:when>
			<c:otherwise>
				<table>
				<tr>
					<th>ID</th>
					<th>Nom</th>
					<th>Prénom</th>
					<th>Login</th>
					<th>Password</th>
					<th colspan="2">Actions</th>
				</tr>
				<c:forEach items="${ utilisateurs }" var="utilisateur">
					<tr>
						<td><c:out value="${ utilisateur.id }"/></td>
						<td><c:out value="${ utilisateur.nom }"/></td>
						<td><c:out value="${ utilisateur.prenom }"/></td>
						<td><c:out value="${ utilisateur.login }"/></td>
						<td><c:out value="${ utilisateur.password }"/></td>
						<td><a href="update?id=${ utilisateur.id }">Modifier</a></td>
						<td><a href="delete?id=${ utilisateur.id }">Supprimer</a></td>
					</tr>
				</c:forEach>
				</table>
			</c:otherwise>
		</c:choose>
	</div>
	<jsp:include page="inc/pied.jsp"/>
</body>
</html>