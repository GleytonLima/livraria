<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="livraria" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<livraria:template>
    <jsp:body>
        <c:set var="bindingResult" value="${requestScope['org.springframework.validation.BindingResult.autor']}"/>
        <h1>Cadastrar Novo Autor</h1>
        <form action='/admin/autor' method="post">
            <input type="hidden" name="id" value="${autor.id}">

            <div>
                <label for="nome">Nome:</label>
                <input id="nome" type="text" name="nome" value="${autor.nome}">
                <c:forEach items="${bindingResult.getFieldErrors('nome')}" var="error">
                    <span>${error.defaultMessage}</span>
                </c:forEach>
            </div>

            <div>
                <label for="email">Email:</label>
                <input id="email" type="text" name="email" value="${autor.email}">
                <c:forEach items="${bindingResult.getFieldErrors('email')}" var="error">
                    <span>${error.defaultMessage}</span>
                </c:forEach>
            </div>

            <button type="submit">Gravar</button>
        </form>
    </jsp:body>
</livraria:template>
