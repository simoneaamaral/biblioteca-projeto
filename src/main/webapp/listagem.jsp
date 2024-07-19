<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 18/07/2024
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
  <title>Listagem de Livros</title>
  <style>
    table {
      width: 100%;
      border-collapse: collapse;
    }
    th, td {
      padding: 8px;
      text-align: left;
      border: 1px solid #ddd;
    }
    th {
      background-color: #f2f2f2;
    }
    tr:nth-child(even) {
      background-color: #f9f9f9;
    }
  </style>
</head>
<body>
<h1>Listagem de Livros</h1>
<a href="livros?action=cadastro">Cadastrar Novo Livro</a>
<table>
  <thead>
  <tr>
    <th>ISBN</th>
    <th>Título</th>
    <th>Categoria</th>
    <th>Ações</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="livro" items="${livros}">
    <tr>
      <td><c:out value="${livro.isbn}" /></td>
      <td><c:out value="${livro.titulo}" /></td>
      <td><c:out value="${livro.categoria}" /></td>
      <td>
        <a href="livros?action=editar&isbn=${livro.isbn}">Editar</a>
        <a href="livros?action=excluir&isbn=${livro.isbn}" onclick="return confirm('Tem certeza que deseja excluir este livro?');">Excluir</a>

      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
