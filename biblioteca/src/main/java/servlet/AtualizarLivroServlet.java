package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.LivroDAO;
import model.Livro;

@WebServlet("/AtualizarLivroServlet")
public class AtualizarLivroServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
    
        String titulo = request.getParameter("titulo");
        String novoTitulo = request.getParameter("novoTitulo");
        String autor = request.getParameter("novoAutor");
        String anoParam = request.getParameter("novoAno");
        String categoria = request.getParameter("novaCategoria");
        String notaParam = request.getParameter("novaNota");

        LivroDAO livroDAO = new LivroDAO();
        Livro livro = livroDAO.buscarPorTitulo(titulo);

        if (livro != null) {

            if (novoTitulo != null && !novoTitulo.isEmpty()) {
                livro.setTitulo(novoTitulo);
            }
            if (autor != null && !autor.isEmpty()) {
                livro.setAutor(autor);
            }
            if (anoParam != null && !anoParam.isEmpty()) {
                int ano = Integer.parseInt(anoParam);
                livro.setAno(ano);
            }
            if (categoria != null && !categoria.isEmpty()) {
                livro.setCategoria(categoria);
            }
            if (notaParam != null && !notaParam.isEmpty()) {
                int nota = Integer.parseInt(notaParam);
                livro.setNota(nota);
            }
        
            boolean atualizado = livroDAO.atualizarLivro(livro);

            if (atualizado) {
                out.println("<h1>Livro atualizado com sucesso!</h1>");
            } else {
                out.println("<h1>Erro ao atualizar livro. Por favor, tente novamente.</h1>");
            }
        } else {
            out.println("<h1>Livro não encontrado.</h1>");
        }
    }
}
