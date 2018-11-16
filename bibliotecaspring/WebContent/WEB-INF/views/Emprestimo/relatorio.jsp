<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Relatorio</title>
	<style>
		label {float:left; width:100%; text-align:center; margin-top:50px; font-size:30px; font-weight:bold; font-family:"arial"; color:#999;}
		table {float:left; width:40%; margin:30px 30%; border-collapse: collapse;}
		td {padding:15px; color:#fdfdfe; font-family:century gothic; font-size:14px;}
		thead {border:0px solid #000; background-color:#1ea059;}
		tbody {background-color:#68e8b7;}
	</style>
	</head>
	<body>
		<label>Alunos com emprestimos ativos</label>
		<table>
			<thead>
				<tr>
					<td>Matricula</td>
					<td>Aluno</td>
					<td>Livro</td>
					<td>Autor</td>
					<td>Edicao</td>
					<td>Data de emprestimo</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="aluno" items="${alunosEmprestimosAtivos}">
					<tr>
						<td>${aluno.matriculaAluno}</td>
						<td>${aluno.aluno}</td>
						<td>${aluno.tituloLivro}</td>
						<td>${aluno.autor}</td>
						<td>${aluno.edicao}</td>
						<td>${aluno.dataEmprestimo}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<label>Alunos com emprestimos atrasados</label>
		<table>
			<thead>
				<tr>
					<td>Matricula</td>
					<td>Aluno</td>
					<td>Livro</td>
					<td>Autor</td>
					<td>Edicao</td>
					<td>Data de emprestimo</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="aluno" items="${alunosEmprestimosAtrasados}">
					<tr>
						<td>${aluno.matriculaAluno}</td>
						<td>${aluno.aluno}</td>
						<td>${aluno.tituloLivro}</td>
						<td>${aluno.autor}</td>
						<td>${aluno.edicao}</td>
						<td>${aluno.dataEmprestimo}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>