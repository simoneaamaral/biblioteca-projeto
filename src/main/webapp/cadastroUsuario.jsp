<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Cadastro de Usuário</title>
</head>
<link rel="stylesheet" type="text/css" href="./css/cadastroUsuario.css?v=1.0">
<link rel="stylesheet" type="text/css" href="./css/footer.css?v=1.0">

<body>

<div class="container">
    <div class="formulario">
        <h1>Cadastro de Usuário</h1>

        <form action="cadastro" method="post">
            <div class="form-group">
                <label for="nome"></label>
                <input type="text" id="nome" name="nome" placeholder="Nome" required>
            </div>

            <div class="form-group">
                <label for="email"></label>
                <input type="email" id="email" name="email" placeholder="Email" required>
            </div>

            <div class="form-group">
                <label for="senha"></label>
                <input type="password" id="senha" name="senha" placeholder="Senha" required>
            </div>

            <button type="submit" class="btn-cadastrar">Cadastrar</button>
        </form>

        <p>Já possui uma conta? <a href="login.jsp">Login</a></p>
        <a href="home.jsp">Voltar para a Página Inicial</a>
    </div>
</div>
<footer>© 2024 Todos os direitos reservados</footer>
</body>
</html>

