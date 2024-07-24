<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Editar Livro</title>
</head>
<link rel="stylesheet" type="text/css" href="./css/editarLivro.css?v=1.0">
<link rel="stylesheet" type="text/css" href="./css/footer.css">
<body>

<div class="container">
    <h1>Editar Livro</h1>
    <form action="livros" method="post">
    <%--@declare id="titulo"--%><%--@declare id="categoria"--%><%--@declare id="quantidade"--%><input type="hidden" name="action" value="atualizar"/>
    <input type="hidden" name="isbn" value="${livro.isbn}"/>
        <div class="form-group">
            <label for="titulo">Título:</label>
            <input type="text" name="titulo" value="${livro.titulo}" required/>
        </div>

        <div class="form-group">
            <label for="categoria">Categoria:</label>
            <input type="text" name="categoria" value="${livro.categoria}" required/>
        </div>

        <div class="form-group">
            <label for="quantidade">Quantidade:</label>
            <input type="number" name="quantidade" value="${livro.quantidade}" required/>
        </div>

        <div class="form-group">
            <input type="submit" value="Atualizar"/>
        </div>
    </form>

    <a href="home.jsp">Voltar para a Página Inicial</a>
</div>
<footer> ©2024 Todos os direitos reservados</footer>
</body>
</html>

