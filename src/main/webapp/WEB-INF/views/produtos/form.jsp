<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Formulário</title>
</head>
<body>
	<h1>Formulário</h1>
	<form:form action="${s:mvcUrl('PC#salvar').build() }" method="POST"
		commandName="produto" enctype="multipart/form-data">
		<div>
			<label>Título:</label> <input type="text" value="" name="titulo">
			<form:errors path="titulo" />
		</div>
		<div>
			<label>Descrição: </label>
			<textarea rows=10 cols="20" name="descricao"></textarea>
			<form:errors path="descricao" />
		</div>
		<div>
			<label>Páginas: </label> <input type="text" name="paginas">
			<form:errors path="paginas" />
		</div>
		<div>
			<label>Data de Lançamento</label> <input name="dataLancamento">
			<form:errors path="dataLancamento" />
		</div>
		<c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
			<div>
				<label>${tipoPreco}</label> <input type="text"
					name="precos[${status.index}].valor"> <input type="hidden"
					name="precos[${status.index}].tipo" value="${tipoPreco}">
			</div>
		</c:forEach>
		<div>
			<label>Sumário</label> <input name="sumario" type="file" />
		</div>
		<div>
			<button type="submit">Salvar</button>
		</div>
	</form:form>
</body>
</html>