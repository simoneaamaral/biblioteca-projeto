<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Lista de Livros</title>
  </head>
<link rel="stylesheet" type="text/css" href="./css/listagem.css">
<link rel="stylesheet" type="text/css" href="./css/footer.css">
<body>
<div class="container-menu">
  <nav class="menu">
    <ul>
      <li><a href="home.jsp">Inicio</a></li>
      <li><a href="login.jsp">Login</a></li>
      <li><a href="livros?action=cadastro">Cadastrar Livro</a></li>
      <li><a href="logout">Sair</a></li>
    </ul>
  </nav>
</div>

<div class="container">
  <h1>Livros Disponíveis</h1>

  <!-- Exibição de mensagens -->
  <c:if test="${not empty mensagem}">
    <div style="color: green;">${mensagem}</div>
  </c:if>
  <c:if test="${not empty mensagemErro}">
    <div style="color: red;">${mensagemErro}</div>
  </c:if>


  <!-- Tabela de livros -->
  <table>
    <thead>
    <tr>
      <th>ISBN</th>
      <th>Título</th>
      <th>Categoria</th>
      <th>Quantidade</th>
      <th>Ações</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="livro" items="${livros}">
      <tr>
        <td><c:out value="${livro.isbn}"/></td>
        <td><c:out value="${livro.titulo}"/></td>
        <td><c:out value="${livro.categoria}"/></td>
        <td><c:out value="${livro.quantidade}"/></td>
        <td>
         <button class="btn-edit"> <a class="text-edit" href="livros?action=editar&isbn=${livro.isbn}">Editar</a>  </button>
          <button class="btn-excluir" ><a class="text-excluir" href="livros?action=excluir&isbn=${livro.isbn}" onclick="return confirm('Tem certeza que deseja excluir este livro?');">Excluir</a></button>

        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>


</div>
<footer> ©2024 Todos os direitos reservados</footer>
</body>
</html>
