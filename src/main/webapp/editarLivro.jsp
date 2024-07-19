<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 18/07/2024
  Time: 22:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Editar Livro</title>
</head>
<body>
<h1>Editar Livro</h1>
<form action="livros" method="post">
    <%--@declare id="titulo"--%><%--@declare id="categoria"--%><%--@declare id="quantidade"--%><input type="hidden" name="action" value="atualizar"/>
    <input type="hidden" name="isbn" value="${livro.isbn}"/>
    <label for="titulo">Título:</label>
    <input type="text" name="titulo" value="${livro.titulo}"/><br/>
    <label for="categoria">Categoria:</label>
    <input type="text" name="categoria" value="${livro.categoria}"/><br/>
    <label for="quantidade">Quantidade:</label>
    <input type="number" name="quantidade" value="${livro.quantidade}"/><br/>
    <input type="submit" value="Atualizar"/>
</form>
</body>
</html>

