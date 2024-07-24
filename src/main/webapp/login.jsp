<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<link rel="stylesheet" type="text/css" href="./css/login.css?v=1.0">

<link rel="stylesheet" type="text/css" href="./css/footer.css?v=1.0">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css?v=1.0">
<body>


<div class="container">

    <div class="left">
        <img src="./img/foto1.jpg" alt="Imagem de fundo">
    </div>
    <div class="right">
        <!-- Conteúdo atual do seu formulário -->
        <h1>Login</h1>


        <form action="login" method="post">
            <label for="email">Email:</label><br>
            <input type="email" id="email" name="email" required><br><br>
            <label for="senha">Senha:</label><br>
            <input type="password" id="senha" name="senha" required>


            <input type="submit" value="Login">

        </form>
        <c:if test="${not empty sessionScope.mensagemSucessoCadastro}">
            <script>
                alert("${sessionScope.mensagemSucessoCadastro}");
            </script>
            <c:remove var="mensagemSucessoCadastro" scope="session" />
        </c:if>

        <c:if test="${not empty mensagemErro}">
            <script>
                alert("${mensagemErro}");
            </script>
        </c:if>
        <p>Ainda não possui cadastro? <a href="cadastroUsuario.jsp">Cadastre-se aqui</a> </p>
        <a href="home.jsp">Voltar para Página Inicial</a>
    </div>

</div>
<footer> ©2024 Todos os direitos reservados</footer>
</body>

</html>


