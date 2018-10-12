<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="livraria"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<livraria:template>
	<jsp:body>
		<h1>${livro.titulo}</h1>
		<dl>
			<dt>Nome Autor</dt>
			<dd>${livro.autor.nome}</dd>
		</dl>
		<dl>
			<dt>Sumário</dt>
			<dd>${livro.sumario}</dd>
		</dl>
		<dl>
			<dt>Preço</dt>
			<dd>${livro.preco}</dd>
		</dl>
		<dl>
			<dt>Data Estimada Publicação</dt>
			<dd>${livro.dataEstimadaPublicacao}</dd>
		</dl>
		<div>
			<a href="/home">Home</a>
		</div>
	</jsp:body>
</livraria:template>
