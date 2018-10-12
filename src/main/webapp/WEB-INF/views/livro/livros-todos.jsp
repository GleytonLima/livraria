<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="livraria"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<livraria:template>
	<jsp:body>
		<h1>3 Últimos Lançamentos</h1>
		<table>
			<thead>
			<tr>
				<th>Titulo</th>
				<th>Autor</th>
				<th colspan="2">Ações</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach var="livro" items="${livrosRecentes}">
				<tr>
					<td>${livro.titulo}</td>
					<td>${livro.autor.nome}</td>
					<td>
						<a href="/livro-detalhe?livroId=${livro.id}">Detalhes</a>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<h1>Todos os Livros</h1>
		<table>
			<thead>
				<tr>
					<th>Titulo</th>
					<th>Autor</th>
					<th colspan="2">Ações</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="livro" items="${livros}">
					<tr>
						<td>${livro.titulo}</td>
						<td>${livro.autor.nome}</td>
						<td>
							<a href="/livro-detalhe?livroId=${livro.id}">Detalhes</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</jsp:body>
</livraria:template>
