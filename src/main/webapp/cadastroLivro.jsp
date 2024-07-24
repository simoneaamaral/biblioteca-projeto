<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Cadastro de Usuário</title>
</head>
<link rel="stylesheet" type="text/css" href="./css/cadastroLivro.css?v=1.0">
<link rel="stylesheet" type="text/css" href="./css/footer.css?v=1.0">

<body>
<div class="container">
     <div class="form-container">
        <div class="image-container">
            <img src="./img/foto4.jpeg" alt="Imagem de fundo">
        </div>
        <div class="form-content">
            <h1>Cadastre Seu Livro</h1>
            <form action="livros" method="post" class="book-form">
                <input type="hidden" name="action" value="inserir">

                <div class="form-group">
                    <label for="isbn">ISBN:</label><br>
                    <input type="text" id="isbn" name="isbn" required>
                </div>

                <div class="form-group">
                    <label for="titulo">Título:</label><br>
                    <input type="text" id="titulo" name="titulo" required>
                </div>

                <div class="form-group">
                    <label for="categoria">Categoria:</label><br>
                    <input type="text" id="categoria" name="categoria" required>
                </div>

                <div class="form-group">
                    <label for="quantidade">Quantidade:</label><br>
                    <input type="number" id="quantidade" name="quantidade" required>
                </div>

                <div class="form-group">
                    <input type="submit" value="Cadastrar">
                </div>
            </form>

            <div class="back-home">
                <a href="home.jsp">Voltar para a Página Inicial</a>
            </div>
        </div>
    </div>
</div>
<footer>© 2024 Todos os direitos reservados</footer>
</body>
</html>