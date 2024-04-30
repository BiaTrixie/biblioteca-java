<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.LivroDAO" %>
<%@ page import="model.Livro" %>
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
   <h1 style="margin: 20px;">Atualizar Livro</h1>

  <form action="AtualizarLivroServlet" method="post">
        <label for="livro">Escolha o livro a ser atualizado:</label>
        <select name="titulo" id="livro"> 
            <% 
                LivroDAO livroDAO = new LivroDAO(); 
                List<Livro> livros = livroDAO.listarLivros(); 
                for (Livro livro : livros) {
            %>
                <option value="<%= livro.getTitulo() %>"><%= livro.getTitulo() %></option>
            <% } %>
        </select>
        <br>

        <input type="text" name="novoTitulo" placeholder="Novo Título">
        <input type="text" name="novoAutor" placeholder="Novo Autor">
        <input type="text" name="novoAno" placeholder="Novo Ano">
        <input type="text" name="novaCategoria" placeholder="Nova Categoria">
        <input type="text" name="novaNota" placeholder="Nova Nota">
        <br>
        <input type="submit" value="Atualizar">
    </form>
</body>
</html>
