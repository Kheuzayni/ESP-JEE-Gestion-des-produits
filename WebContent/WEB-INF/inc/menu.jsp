<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="menu">
	<ul>
		<li><a href="<c:url value='/'/>">Accueil</a></li>
		<c:choose>
			<c:when test="${ empty sessionScope.utilisateur }">
				<li><a href="<c:url value='/login'/>">Se connecter</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="<c:url value='/users/list'/>">Lister</a></li>
				<li><a href="<c:url value='/users/add'/>">Ajouter</a></li>
				<li><a href="<c:url value='/logout'/>">Se déconnecter</a></li>
			</c:otherwise>
		</c:choose>
			
	</ul>
</div>