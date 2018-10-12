<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="Overall Page template" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<div>
    <a href="/">Livraria</a>
</div>

<div>
    <ul>
        <li><a href="/home">Home</a></li>
        <li><a href="/admin/autores">Autores</a></li>
    </ul>
</div>

<jsp:doBody/>
<script type="text/javascript" src="/assets/js/jquery-3.1.1.min.js"></script>
</body>


</html>
