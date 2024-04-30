<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.LivroDAO" %>
<%@ page import="model.Livro" %>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Biblioteca da Beatriz - Excluir Livro</title>
    <link rel="stylesheet" href="./css/excluir.css">
    <script>
       function confirmarExclusao() {
    var titulo = document.getElementById("livro").value;
    return confirm("Tem certeza que deseja excluir esse livro?\n\n" + encodeURIComponent(titulo));
}
    </script>
</head>
<body>
    <header>
        <nav class="navbar">
            <div class="brand">Biblioteca da Beatriz</div>
            <ul class="menu">
                <li><a href="./">Início</a></li>
                <li><a href="./cadastroLivro.jsp">Cadastrar</a></li>
                <li><a href="./atualizarLivro.jsp">Atualizar</a></li>
                <li><a href="./excluirLivro.jsp">Excluir</a></li>
                <li><input type="text" placeholder="Pesquisar..."></li>
            </ul>
        </nav>
    </header>

<main>
    <h1 style="margin: 20px;">Excluir Livro</h1>
    
    <form action="ExcluirLivroServlet" method="post" onsubmit="return confirmarExclusao()">
        <label for="livro">Escolha o livro a ser excluído:</label>
        <select name="livro" id="livro">
            <% 
                LivroDAO livroDAO = new LivroDAO(); 
                List<Livro> livros = livroDAO.listarLivros(); 
                for (Livro livro : livros) {
            %>
                <option value="<%= livro.getTitulo() %>"><%= livro.getTitulo() %></option>
            <% } %>
        </select>
        <br>
        <input type="submit" value="Excluir">
    </form>
    </main>
</body>
</html>
