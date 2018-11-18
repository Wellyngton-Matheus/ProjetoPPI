<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:import url="../menu.jsp"></c:import>

	<h1>Lista de Emprestimos:</h1>

		<table border ="1">
			<tr>
				<th>Nome do aluno</th>
				<th>Nome do Livro</th>
				<th>Data de emprestimo</th>
				<th>Data de Devolução</th>
			</tr>
				<c:forEach var="emprestimo" items="${Emprestimo }">
			<tr>
					<td>${emprestimo.aluno }</td>
					<td>${emprestimo.livro.titulo }</td>
					<td><fmt:formatDate value="${emprestimo.dataEmprestimo.time}" pattern="dd/MM/yyyy" /></td>
					<td><fmt:formatDate value="${emprestimo.dataDevolucao.time}" pattern="dd/MM/yyyy" /></td>
					<td><a href="/bibliotecaspring/Emprestimo/devolucao?id=${emprestimo.id}">devolucao</a></td>
				</tr>
			</c:forEach>
		</table>
</body>
</html>