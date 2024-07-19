<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 18/07/2024
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cadastro de Livro</title>
</head>
<body>
<h1>Cadastro de Livro</h1>
<form action="cadastrarLivro" method="post">
    <label for="isbn">ISBN:</label><br>
    <input type="text" id="isbn" name="isbn" required><br><br>

    <label for="titulo">Título:</label><br>
    <input type="text" id="titulo" name="titulo" required><br><br>

    <label for="categoria">Categoria:</label><br>
    <input type="text" id="categoria" name="categoria" required><br><br>

    <label for="quantidade">Quantidade:</label><br>
    <input type="number" id="quantidade" name="quantidade" required><br><br>

    <input type="submit" value="Cadastrar">
</form>
</body>
</html>

