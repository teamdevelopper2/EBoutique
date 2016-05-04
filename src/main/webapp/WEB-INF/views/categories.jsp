<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
    <div class="errors">
		${exception}
	</div>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/style1.css" >
</head>
<body>
	
	<div id="formCat" class="cadre">
	<f:form modelAttribute="categorie" action="saveCat" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>ID categorie</td>
				<td><f:input path="idCategorie"/></td>
				<td><f:errors path="idCategorie" cssClass="errors"></f:errors></td>
			</tr>
			<tr>
				<td>Nom Categorie</td>
				<td><f:input path="nomCategorie"/></td>
				<td><f:errors path="nomCategorie" cssClass="errors"></f:errors></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><f:textarea path="description"/></td>
				<td><f:errors path="description" cssClass="errors"></f:errors></td>
			</tr>
			<tr>
				<td>Photo</td>
				<td>
					<c:if test="${categorie.idCategorie != null}">
						<img width="100" height="80" alt="" src="photoCat?idCat=${categorie.idCategorie }">
					</c:if>
					
				</td>
				<td>
					<input width="100%" type="file" name="file" />
				</td>
				<td></td>
			</tr>
			<tr>
				<td><input type="submit" value="Save" ></td>
			</tr>
		</table>
	</f:form>
	</div>
	<div id="tabCategories" class="cadre">
		<table class="tab1">
			<tr>
				<th>ID</th>
				<th>Nom</th>
				<th>Description</th>
				<th>Photo</th>
				<th colspan="2">Actions</th>
			</tr>
			<c:forEach items="${categories }" var="cat">
				<tr>
					<td>${cat.idCategorie }</td>
					<td>${cat.nomCategorie }</td>
					<td>${cat.description }</td>
					<td><img width="100" height="80" alt="" src="photoCat?idCat=${cat.idCategorie }"></td>
					<td><a href="suppCat?idCat=${cat.idCategorie }">Supprimer</a></td>
					<td><a href="editCat?idCat=${cat.idCategorie }">Modifier</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>