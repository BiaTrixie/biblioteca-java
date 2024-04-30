<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.LivroDAO" %>
<%@ page import="model.Livro" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Biblioteca da Beatriz - Livros</title>
    <link rel="stylesheet" href="./css/inicio.css">
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
                <li>
                    <form action="BuscarLivroServlet" method="get">
                        <input type="text" name="titulo" placeholder="Pesquisar...">
                        <input type="submit" value="Pesquisar">
                    </form>
                </li>
            </ul>
        </nav>
    </header>


   <h1 style="margin: 20px;">Livros disponíveis</h1>
   
    <% 
    LivroDAO livroDAO = new LivroDAO(); 
    List<Livro> livros = livroDAO.listarLivros(); 

    for (Livro livro : livros) {
%>
    <div class="livro-card" style="margin: 20px; background-color: #ff0000;  padding: 10px; width: 300px; display: inline-block; color: #fff; border-radius: 20px;">
        <h2><%= livro.getTitulo() %></h2>
        <p id="nota" class="nota">Nota: <%= livro.getNota() %></p>
        <p class="autor">Autor: <%= livro.getAutor() %></p>
        <p class="ano">Ano: <%= livro.getAno() %></p>
        <p class="categoria">Categoria: <%= livro.getCategoria() %></p>
    </div>
<% 
    }
%>


</body>
</html>
