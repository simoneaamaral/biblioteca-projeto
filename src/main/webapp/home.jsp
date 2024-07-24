<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Inicio</title>
</head>
<link rel="stylesheet" type="text/css" href="./css/home.css?v=1.0">
<link rel="stylesheet" type="text/css" href="./css/footer.css">
<body>

<div class="container">
  <nav class="menu">
    <ul>
      <li><a href="login.jsp">Login</a></li>
      <li><a href="livros?action=cadastro">Cadastrar Livro</a></li>
      <li><a href="livros">Listar Livros</a></li>
      <li><a href="logout">Sair</a></li>

    </ul>
  </nav>
  <div class="content">
    <h1 class="titulo">Coleção Literária de Forma Simples e Eficiente</h1>
    <c:if test="${not empty sessionScope.mensagemSucesso}">
         <script>
        alert("${sessionScope.mensagemSucesso}");
      </script>
    </c:if>

    <c:remove var="mensagemSucesso" scope="session" />
  </div>
</div>
<footer> ©2024 Todos os direitos reservados</footer>
</body>
</html>

