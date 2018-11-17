<%@page import="java.text.SimpleDateFormat"%>
<%@page import="bibliotecaspring.models.Aluno"%>
<%@page import="java.util.List"%>
<%@page import="bibliotecaspring.dao.AlunoDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<c:import url="../menu.jsp"></c:import>
	<h1>Lista de Livros</h1>

	<table border="1">
		<thead>
			<tr>
				<th>Titulo</th>
				<th>Autor</th>
				<th>Editora</th>
				<th>Ano de Publicação</th>
				<th>Edição</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="livro" items="${livro }">
				<tr>
					<td>${livro.titulo }</td>
					<td>${livro.autor }</td>
					<td>${livro.editora }</td>
					<td>${livro.anoPublicado }</td>
					<td>${livro.edicao }</td>
					<td><a href="/bibliotecaspring/Livro/remover?id=${livro.id }">Remover</a></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>

</body>
</html>




