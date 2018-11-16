<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Cadastrando</title>
	</head>
	<body>
		<c:import url="../menu.jsp"></c:import>
		<h1>Adicionar aluno</h1>
		<form action="executarCadastro" method="post">
			<div>
				<label>Matricula:</label>
				<input type="text" name="matricula">
			</div>
			<div>
				<label>Nome:</label> 
				<input type="text" name="nome">
			</div>
			<div>
				<label>Cpf:</label> 
				<input type="text" name="cpf">
			</div>
			<div>
				<label>Endereço:</label>
				<input type="text" name="endereco">
			</div>
			<div>
				<label>Data de Nascimento:</label> 
				<input type="text" name="dataNascimento">
			</div>
				<button type="submit">Adicionar</button>
		</form>
	</body>
</html>