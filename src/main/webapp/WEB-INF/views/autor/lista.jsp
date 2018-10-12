<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="livraria"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<livraria:template>
	<jsp:body>
		<table>
			<thead>
				<tr>
					<th>Nome</th>
					<th>Email</th>
					<th colspan="2">Ações</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="autor" items="${autores}">
					<tr>
						<td>${autor.nome}</td>
						<td>${autor.email}</td>
						<td>
							<a href="#" onclick="excluir(${autor.id})">Excluir</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<a href="/admin/autor">Novo</a>
		</div>
		<script>
			function excluir(id) {
				var url = window.location.href;
				if(confirm("Confirma Exclusão? " + id)){
                    $.ajax({
                        url:"/admin/autor/" + id,
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
