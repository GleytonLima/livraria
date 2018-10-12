<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="livraria" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<livraria:template>
    <jsp:body>
        <c:set var="bindingResult" value="${requestScope['org.springframework.validation.BindingResult.livroForm']}"/>
        <h1>Novo Livro cujo autor é: ${autor.nome}</h1>
        <form action="/admin/livro-novo-para-um-autor" method="post">
            <input type="hidden" name="id" value="${form.id}">
            <input type="hidden" name="autorId" value="${form.autorId}">
            <div>
                <label for="titulo">Título:</label>
                <input id="titulo" type="text" name="titulo" value="${form.titulo}"/>
                <c:forEach items="${bindingResult.getFieldErrors('titulo')}" var="error">
                    <span>${error.defaultMessage}</span>
                </c:forEach>
            </div>
            <div>
                <label for="sumario">Sumário:</label>
                <textarea id="sumario" name="sumario" value="${form.sumario}">${form.sumario}</textarea>
                <c:forEach items="${bindingResult.getFieldErrors('sumario')}" var="error">
                    <span>${error.defaultMessage}</span>
                </c:forEach>
            </div>
            <div>
                <label for="preco">Preço:</label>
                <input id="preco"  type="number" min="0.00" max="10000.00" step="0.01" name="preco" value="${form.preco}">
                <c:forEach items="${bindingResult.getFieldErrors('preco')}" var="error">
                    <span>${error.defaultMessage}</span>
                </c:forEach>
            </div>
            <div>
                <label for="dataEstimadaPublicacao">Data Estimada Publicação:</label>
                <input id="dataEstimadaPublicacao"  type="date" name="dataEstimadaPublicacao" value="${form.dataEstimadaPublicacao}">
                <c:forEach items="${bindingResult.getFieldErrors('dataEstimadaPublicacao')}" var="error">
                    <span>${error.defaultMessage}</span>
                </c:forEach>
            </div>
            <a href="/admin/livros-do-autor?autorId=${autor.id}">Voltar</a>
            <button type="submit">Gravar</button>
        </form>
    </jsp:body>
</livraria:template>
