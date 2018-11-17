<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listando Aluno</title>
</head>
<body>

	<c:import url="../menu.jsp"></c:import>
	

	<h1>Lista de Alunos</h1>

	<table border="1">
		<thead>
			<tr>
				<th>Matricula</th>
				<th>Nome</th>
				<th>Cpf</th>
				<th>Data de Nascimento</th>
				<th>Endereço</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="aluno" items="${aluno }">
				<tr>
					<td>${aluno.matricula }</td>
					<td>${aluno.nome }</td>
					<td>${aluno.cpf }</td>
					<td>${aluno.dataNascimento.time }</td>
					<td>${aluno.endereco }</td>
					<td><a href="/bibliotecaspring/Aluno/remover?id=${aluno.id }">Remover</a></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>

</body>
</html>




