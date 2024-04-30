<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Biblioteca da Beatriz</title>
    <link rel="stylesheet" href="./css/cadastro.css">
</head>
<body>
    <header>
        <nav class="navbar">
            <div class="brand">Biblioteca da Beatriz</div>
            <ul class="menu">
                <li><a href="./">Inicio</a></li>
                <li><a href="./cadastroLivro.jsp">Cadastrar</a></li>
                <li><a href="./atualizarLivro.jsp">Atualizar</a></li>
                <li><a href="./excluirLivro.jsp">Excluir</a></li>
                <li><input type="text" placeholder="Pesquisar..."></li>
            </ul>
        </nav>
    </header>
       <h2>Cadastrar Livro</h2>

    <form action="AdicionarLivroServlet" method="post">
        Titulo: <input type="text" name="titulo"><br>
        Autor: <input type="text" name="autor"><br>
        Ano: <input type="text" name="ano"><br>
        Nota: <input type="text" name="nota"><br>
        Categoria: <input type="text" name="categoria"><br>
        Subcategoria: <input type="text" name="subcategoria"><br>
        <input type="submit" value="Cadastrar">
    </form>
    
</body>
</html>