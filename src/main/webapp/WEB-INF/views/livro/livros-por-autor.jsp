<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="livraria"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<livraria:template>
	<jsp:body>
		<h1>Livros do Autor: ${autor.nome}</h1>
		<table>
			<thead>
				<tr>
					<th>Titulo</th>
					<th colspan="2">Ações</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="livro" items="${livros}">
					<tr>
						<td>${livro.titulo}</td>
						<td>
							<a href="#" onclick="excluir(${livro.id})">Excluir</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<a href="/admin/livro-novo-para-um-autor?autorId=${autor.id}">Novo Livro</a>
		</div>
		<script>
			function excluir(id) {
				var url = window.location.href;
				if(confirm("Confirma Exclusão? " + id)){
                    $.ajax({
                        url:"/admin/livro/" + id,
                        type: 'DELETE',
                        success: function (result) {
                            console.log(result);
                            window.location.href = url;
                        }
                    });
				}

			}
		</script>
	</jsp:body>
</livraria:template>
