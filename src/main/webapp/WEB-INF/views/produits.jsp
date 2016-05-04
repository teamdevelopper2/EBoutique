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
	
	<div id="formProd" class="cadre">
	<f:form modelAttribute="produit" action="saveProd" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>ID Produit</td>
				<td><f:input path="idProduit"/></td>
				<td><f:errors path="idProduit" cssClass="errors"></f:errors></td>
			</tr>
			<tr>
				<td>Nom Produit</td>
				<td><f:input path="nom"/></td>
				<td><f:errors path="nom" cssClass="errors"></f:errors></td>
			</tr>
			<tr>
				<td>Designation</td>
				<td><f:textarea path="designation"/></td>
				<td><f:errors path="designation" cssClass="errors"></f:errors></td>
			</tr>
			<tr>
				<td>Catégorie</td>
				<td><f:select path="categorie.idCategorie" items="${categories}" itemValue="idCategorie" itemLabel="nomCategorie"/></td>
				<td><f:errors path="designation" cssClass="errors"></f:errors></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><f:textarea path="description"/></td>
				<td><f:errors path="description" cssClass="errors"></f:errors></td>
			</tr>
			<tr>
				<td>Prix</td>
				<td><f:input path="prix"/></td>
				<td><f:errors path="prix" cssClass="errors"></f:errors></td>
			</tr>
			<tr>
				<td>Quantite</td>
				<td><f:input path="quantite"/></td>
				<td><f:errors path="quantite" cssClass="errors"></f:errors></td>
			</tr>
			<tr>
				<td>Sélectionné ?</td>
				<td><f:checkbox path="selected"/></td>
				<td><f:errors path="selected" cssClass="errors"></f:errors></td>
			</tr>
			<tr>
				<td>Photo</td>
				<td>
					<c:if test="${produit.idProduit != null}">
						<img alt="" src="photoProd?idProd=${produit.idProduit }">
					</c:if>
					
				</td>
				<td>
					<input type="file" name="file" />
				</td>
				<td></td>
			</tr>
			<tr>
				<td><input type="submit" value="Save" ></td>
			</tr>
		</table>
	</f:form>
	</div>
	<div id="tabProduits" class="cadre">
		<table class="tab1">
			<tr>
				<th>ID</th>
				<th>Nom</th>
				<th>Désignation</th>
				<th>Description</th>
				<th>Categorie</th>
				<th>Prix</th>
				<th>Quantité</th>
				<th>Selected</th>
				<th>Photo</th>
				<th colspan="2">Actions</th>
			</tr>
			<c:forEach items="${produits}" var="prod">
				<tr>
					<td>${prod.idProduit}</td>
					<td>${prod.nom}</td>
					<td>${prod.designation}</td>
					<td>${prod.description}</td>
					<td>${prod.categorie.nomCategorie}</td>
					<td>${prod.prix}</td>
					<td>${prod.quantite}</td>
					<td>${prod.selected}</td>
					<td><img alt="" src="photoProd?idProd=${prod.idProduit}"></td>
					<td><a href="suppProd?idProd=${prod.idProduit}">Supprimer</a></td>
					<td><a href="editProd?idProd=${prod.idProduit}">Modifier</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>