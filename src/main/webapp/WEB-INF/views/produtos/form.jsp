<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Formulário</title>
</head>
<body>
	<h1>Formulário</h1>
	<form action="/estoque/produtos" method="POST">
		<div>
			<label>Título:</label> <input type="text" value="" name="titulo">
		</div>
		<div>
			<label>Descrição: </label>
			<textarea rows=10 cols="20" name="descricao"></textarea>
		</div>
		<div>
			<label>Páginas: </label> <input type="text" name="paginas">
		</div>
		<c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
			<div>
				<label>${tipoPreco}</label>
				<input type="text" name="precos[${status.index}].valor">
				<input type="hidden" name="precos[${status.index}].tipo" value="${tipoPreco}">
			</div>
		</c:forEach>
		<div>
			<button type="submit">Salvar</button>
		</div>
	</form>
</body>
</html>